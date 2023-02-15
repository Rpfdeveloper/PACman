package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseBehaviour;
import edu.uoc.pacman.model.entities.characters.pacman.Pacman;
import edu.uoc.pacman.model.entities.characters.pacman.State;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

import java.util.Objects;

/**
 * This abstract class represents a ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see Character
 * @see Scorable
 */
public abstract class Ghost extends Character implements Scorable {
    /**
     * The chase behaviour of the ghost.
     */
    protected ChaseBehaviour chaseBehaviour;
    /**
     * The behaviour of the ghost.
     */
    private Behaviour behaviour;

    private Position scatterPosition;

    /**
     * Creates a new ghost.
     *
     * @param startPosition   the initial position of the ghost.
     * @param scatterPosition the scatter position of the ghost.
     * @param direction       the initial direction of the ghost.
     * @param behaviour       the behaviour of the ghost.
     * @param sprite          the sprite of the ghost.
     * @param level           the level where the ghost is.
     */
    protected Ghost(Position startPosition, Position scatterPosition, Direction direction, Behaviour behaviour, Sprite sprite, Level level) {
        super(startPosition, direction, sprite, level);
        this.behaviour = behaviour;
        setScatterPosition(scatterPosition);
    }

    /**
     * This method returns the chase behaviour of the ghost.
     *
     * @return the chase behaviour of the ghost.
     */

    public Behaviour getBehaviour() {
        return behaviour;
    }

    /**
     * This method sets the chase behaviour of the ghost.
     *
     * @param behaviour the chase behaviour of the ghost.
     */
    public void setBehaviour(Behaviour behaviour) {
        setDuration(behaviour.getDuration());
        this.behaviour = behaviour;
    }

    /**
     * This method returns the next behaviour of the ghost.
     */
    private void nextBehaviour() {
        setDuration(getDuration() - 1);
        if (getDuration() == 0) {
            switch (behaviour) {
                case CHASE -> setBehaviour(Behaviour.SCATTER);
                case SCATTER, FRIGHTENED, INACTIVE -> setBehaviour(Behaviour.CHASE);
            }
        }
    }

    /**
     * This method rest the ghost.
     */
    public void reset() {
        setBehaviour(Behaviour.INACTIVE);
        setDuration(Behaviour.INACTIVE.getDuration());
        setPosition(getStartPosition());
        setDirection(Direction.UP);
    }

    /**
     * This overridden method of class Object returns if this ghost is equal to the given object.
     *
     * @param o the object to compare.
     * @return true if this ghost is equal to the given object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ghost ghost = (Ghost) o;

        return this.isDead() == ghost.isDead() && this.getBehaviour().equals(ghost.getBehaviour()) && this.getDirection().equals(ghost.getDirection()) && this.getPosition().equals(ghost.getPosition());
    }

    /**
     * This overridden method of class Character returns a representation of this ghost.
     *
     * @return string representation of this ghost.
     */
    @Override
    public String toString() {
        return super.toString() + "," + getBehaviour().toString();
    }

    /**
     * Gets the scatter position of the ghost.
     *
     * @return the scatter position of the ghost.
     */
    public Position getScatterPosition() {
        return scatterPosition;
    }

    /**
     * Sets the scatter position of the ghost.
     *
     * @param scatterPosition the scatter position of the ghost.
     */
    private void setScatterPosition(Position scatterPosition) {
        this.scatterPosition = scatterPosition;
    }

    /**
     * This method returns the target position of the ghost.
     *
     * @return the target position of the ghost.
     */
    private Position getTargetPosition() {
        return switch (getBehaviour()) {
            case CHASE -> chaseBehaviour.getChasePosition(this);
            case SCATTER, FRIGHTENED -> getScatterPosition();
            default -> null;
        };
    }

    /**
     * This method executes a movement of the ghost.
     */
    @Override
    public void move() {
        Position targetPosition = getTargetPosition();

        if (getBehaviour() == Behaviour.INACTIVE || targetPosition == null) {
            return;
        } else {
            double minDist = Double.MAX_VALUE;
            Position newPos = null;
            Direction newDir = null;
            // iterate over all possible directions
            for (Direction direction : Direction.values()) {
                int newX = getPosition().getX() + direction.getX();
                int newY = getPosition().getY() + direction.getY();
                Position pos = new Position(newX, newY);
                // check if the position is valid
                if (getLevel().isPathable(pos) && !Objects.equals(direction.opposite(), getDirection())) {
                    double dist = pos.distance(targetPosition);
                    if (dist <= minDist) {
                        minDist = dist;
                        newPos = pos;
                        newDir = direction;
                    }
                }
            }

            if (newPos != null) {
                // move to the new position
                setPosition(newPos);
                setDirection(newDir);
                hit();
            }
        }
        nextBehaviour();
    }

    /**
     * This method executes the hit of the ghost.
     */
    public boolean hit() {
        //if the ghost behaviour is frightened and same position as pacman , the ghost die
        if (!getBehaviour().equals(Behaviour.INACTIVE)) {
            Pacman pacman = getLevel().getPacman();
            if (getPosition().equals(pacman.getPosition())) {
                if (getBehaviour().equals(Behaviour.FRIGHTENED)) {
                    kill();

                } else if (pacman.getState().equals(State.NORMAL)) {
                    //Wen the ghost is not frightened and the pacman is normal, the pacman die
                    pacman.kill();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * This override method of class character kills the ghost.
     */
    @Override
    public void kill() {
        super.kill();
        reset();
        getLevel().addPoints(getPoints());
        setBehaviour(Behaviour.INACTIVE);
        setScatterPosition(getStartPosition());
    }
}
