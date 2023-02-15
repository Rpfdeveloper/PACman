package edu.uoc.pacman.model.entities.characters.pacman;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.Behaviour;
import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.entities.items.Energizer;
import edu.uoc.pacman.model.entities.items.Life;
import edu.uoc.pacman.model.entities.items.Path;
import edu.uoc.pacman.model.entities.items.Pickable;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Pacman is the main character of the game. It can move in the map and eat
 * This class extends the Character class.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see Character
 */
public class Pacman extends Character {
    /**
     * State of Pacman
     */
    private State state;

    /**
     * Constructor of the class.
     *
     * @param startPosition of Pacman
     * @param direction     of Pacman
     * @param state         of Pacman
     * @param level         of Pacman
     */
    public Pacman(Position startPosition, Direction direction, State state, Level level) {
        super(startPosition, direction, Sprite.PACMAN_RIGHT, level);
        setState(state);
    }

    /**
     * Getter of State
     *
     * @return state of Pacman
     */
    public State getState() {
        return state;
    }

    /**
     * Setter of State
     *
     * @param state of Pacman
     */
    public void setState(State state) {
        //set duration of state
        setDuration(state.getDuration());
        this.state = state;
    }

    /**
     * This method defines the nex State of Pacman
     */
    private void nextState() {
        if (getDuration() == 0) {
            if (state == State.EATER || state == State.INVINCIBLE) {
                setState(State.NORMAL);
            }

        }
    }

    /**
     * This override method of class reset the character Pacman
     */
    @Override
    public void reset() {
        super.reset();
        state = State.INVINCIBLE;
        setDirection(Direction.UP);
        setPosition(getStartPosition());
    }

    /**
     * This override method of class Character defines the movement of Pacman
     */
    @Override
    public void move() {
        Position newPosition = new Position(getPosition().getX() + getDirection().getX(), getPosition().getY() + getDirection().getY());

        if (getLevel().isPathable(newPosition)) {
            setPosition(newPosition);
            eat();
            hit();
        }

        nextState();
    }

    /**
     * This method set the direction of Pacman
     *
     * @param direction of the character
     */
    public void setDirection(Direction direction) {
        if (direction != null) {
            super.setDirection(direction);
            switch (direction) {
                case UP -> setSprite(Sprite.PACMAN_UP);
                case DOWN -> setSprite(Sprite.PACMAN_DOWN);
                case LEFT -> setSprite(Sprite.PACMAN_LEFT);
                case RIGHT -> setSprite(Sprite.PACMAN_RIGHT);
            }
        }
    }

    /**
     * This method executes the action of Pacman when it eats an item or ghost
     */
    private void eat() {

        if (getLevel().getMapItem(getPosition()) instanceof Pickable pickable) {
            //if the item is a Pickable, it is eaten
            if (pickable instanceof Scorable scorable) {
                
                getLevel().addPoints(scorable.getPoints());
            }
            //if the item is a life, increase the number of lives
            if (pickable instanceof Life) {
                getLevel().increaseLives();
            }
            //if pacman eats an Energizer, it changes its state to Eater and the ghosts change their state to Invincible
            if (pickable instanceof Energizer) {
                setState(State.EATER);
                getLevel().setGhostsFrightened();
            }
            //delete the item from the map
            getLevel().removeMapItem(getLevel().getMapItem(getPosition()));
            //add new path item to the map.
            getLevel().addMapItem(new Path(getPosition()));
        }
    }


    /**
     * This method executes the action of Pacman when it hits a ghost
     */
    @Override
    public boolean hit() {
        for (Ghost ghost : getLevel().getGhostList()) {
            //if pacman and a ghost are in the same position
            if (ghost.getPosition().equals(getPosition())) {
                //if Pacman is invincible or the ghost is inactive, return false
                if (state == State.INVINCIBLE || ghost.getBehaviour().equals(Behaviour.INACTIVE)) {
                    return false;
                } else if (ghost.getBehaviour().equals(Behaviour.FRIGHTENED)) {
                    //the ghost is eaten
                    ghost.kill();
                    return true;
                } else if (ghost.getBehaviour().equals(Behaviour.SCATTER) || ghost.getBehaviour().equals(Behaviour.CHASE)) {
                    kill();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This override method of class Character executes the action of Pacman when it is killed
     */
    @Override
    public void kill() {
        super.kill();
        getLevel().decreaseLives();
        setState(State.INVINCIBLE);
    }

}
