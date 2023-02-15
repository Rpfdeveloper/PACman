package edu.uoc.pacman.model.entities.characters;

import edu.uoc.pacman.model.utils.Direction;

/**
 * This interface defines the methods that a movable character must implement.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public interface Movable {
    /**
     * Abstract method that defines the movement of a character.
     */
    void move();

    /**
     * Abstract method that defines the direction of a character.
     *
     * @param direction of the character
     */
    void setDirection(Direction direction);

}
