package edu.uoc.pacman.model.entities.characters;


/**
 * This interface represents a character that can be hit.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public interface Hitable {
    /**
     * This abstract method returns if the character was hit.
     */
    boolean hit();

}
