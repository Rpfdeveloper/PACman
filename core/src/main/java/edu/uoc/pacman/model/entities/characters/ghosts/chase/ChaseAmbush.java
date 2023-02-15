package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;

/**
 * This interface represents the chase behaviour of a ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see ChaseBehaviour
 */
public class ChaseAmbush implements ChaseBehaviour {
    /**
     * the amount of tiles to move away from pacman.
     */
    private static final int TILES_OFFSET = 4;

    /**
     * This override method returns the chase position of a ghost.
     *
     * @param ghost object
     * @return the chase position of a ghost.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        // Get the position and direction of pacman.
        Position pacmanPosition = ghost.getLevel().getPacman().getPosition();
        Direction pacmanDirection = ghost.getLevel().getPacman().getDirection();
        // Calculate the position of the tile that pacman is going to move to.
        int targetX = pacmanPosition.getX() + (pacmanDirection.getX() * TILES_OFFSET);
        int targetY = pacmanPosition.getY() + (pacmanDirection.getY() * TILES_OFFSET);

        return new Position(targetX, targetY);
    }
}
