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
public class ChaseAggressive implements ChaseBehaviour {
    /**
     * This override method returns the chase position of a ghost.
     *
     * @param ghost object
     * @return the chase position of a ghost.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        return ghost.getLevel().getPacman().getPosition();
    }
}
