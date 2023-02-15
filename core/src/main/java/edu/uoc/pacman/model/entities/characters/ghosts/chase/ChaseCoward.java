package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Position;

/**
 * This interface represents the chase Coward of a ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see ChaseBehaviour
 */
public class ChaseCoward implements ChaseBehaviour {
    /**
     * Amount of tiles to move away from Pacman.
     */
    private static final int TILES_TO_CHASE = 8;

    /**
     * This override method returns the chase position of a ghost.
     *
     * @param ghost object
     * @return the chase position of a ghost.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        // Get position of ghost.
        Position ghostPosition = ghost.getPosition();
        //get position of pacman.
        Position pacmanPosition = ghost.getLevel().getPacman().getPosition();

        if (ghostPosition.distance(pacmanPosition) < TILES_TO_CHASE) {
            return ghost.getScatterPosition();
        } else {
            return pacmanPosition;
        }
    }
}
