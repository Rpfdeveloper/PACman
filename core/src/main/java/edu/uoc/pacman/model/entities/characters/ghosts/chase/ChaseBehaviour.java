package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Position;

/**
 * This interface represents the chase behaviour of a ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see ChaseBehaviour
 */

public interface ChaseBehaviour {
    /**
     * This abstract method returns the chase position of a ghost.
     *
     * @param ghost object
     * @return the chase position of a ghost.
     */
    default Position getChasePosition(Ghost ghost) {
        return null;
    }

}
