package edu.uoc.pacman.model.entities.characters;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Entity;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This abstract class represents a character in the game.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see Entity
 * @see Hitable
 * @see Movable
 */
public abstract class Character extends Entity implements Movable, Hitable {
    private boolean dead;
    private Direction direction;
    private int duration;
    private Level level;
    private Position startPosition;

    /**
     * This constructor creates an entity with the given parameters.
     *
     * @param startPosition of the entity
     * @param direction     of the entity
     * @param sprite        of the entity
     * @param sprite        of the entity
     * @param level         of the entity
     * @super (startPosition, true, sprite)
     * @see Entity
     * @see Position
     * @see Sprite
     * @see Level
     */
    protected Character(Position startPosition, Direction direction, Sprite sprite, Level level) {
        super(startPosition, true, sprite);
        setStartPosition(startPosition);
        setDirection(direction);
        setLevel(level);
        setDead(false);
    }

    /**
     * This method resets the character.
     */
    public void reset() {
        setPosition(startPosition);
        setDead(false);
    }

    /**
     * This method returns the direction of the character.
     *
     * @return direction of the character
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * This method sets the direction of the character.
     *
     * @param direction of the character
     */
    public void setDirection(Direction direction) {
        if (direction != null) {
            this.direction = direction;
        }
    }

    /**
     * This method returns the duration of the character.
     *
     * @return duration of the character
     */
    protected int getDuration() {
        return duration;
    }

    /**
     * This method sets the duration of the character.
     *
     * @param duration of the character
     */
    protected void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * This method returns the dead of the character.
     *
     * @return dead of the character
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * This method sets the dead of the character.
     *
     * @param dead of the character
     */
    private void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * This method returns the startPosition of the character.
     *
     * @return startPosition of the character
     */
    protected Position getStartPosition() {
        return startPosition;
    }

    /**
     * This method sets the startPosition of the character.
     *
     * @param startPosition of the character
     */
    private void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    /**
     * This method returns the level of the character.
     *
     * @return level of the character
     */
    public Level getLevel() {
        return level;
    }

    /**
     * This method sets the level of the character.
     *
     * @param level of the character
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * This method kill the character.
     */
    public void kill() {
        setDead(true);
    }

    /**
     * This method revive the character.
     */
    public void alive() {
        setDead(false);
    }

    /**
     * This method returns the string representation of the character.
     *
     * @return string representation of the character
     */
    @Override
    public String toString() {
        return getPosition().getX() + "," + getPosition().getY() + "," + direction.toString().toUpperCase();
    }

}
