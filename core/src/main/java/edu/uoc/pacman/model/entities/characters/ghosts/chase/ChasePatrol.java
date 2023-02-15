package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.entities.characters.pacman.Pacman;
import edu.uoc.pacman.model.utils.Position;

/**
 * This interface represents the chase Patrol of a ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see ChaseBehaviour
 */
public class ChasePatrol implements ChaseBehaviour {
    /**
     * Amount of tiles to move away from Pacman.
     */
    private static final int TILES_OFFSET = 2;
    /**
     * The amount which the vector equals to target position.
     */
    private static final int VECTOR_INCREASE = 2;

    /**
     * This override method returns new {@link Position} with the chase position of a ghost.
     *
     * @param ghost object
     * @return the chase position of a ghost.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        //Get the position of first Blinky ghost.
        Position firstBlinkyPosition = ghost.getLevel().getBlinky().getPosition();
        //Get pacman Object of the level.
        Pacman pacman = ghost.getLevel().getPacman();
        //Calculate the target position.
        int targetBlinkyX = pacman.getPosition().getX() + (pacman.getDirection().getX() * TILES_OFFSET);
        int targetBlinkyY = pacman.getPosition().getY() + (pacman.getDirection().getY() * TILES_OFFSET);
        Position targetBlinkyPosition = new Position(targetBlinkyX, targetBlinkyY);
        //Calculate the vector.
        int targetX = (targetBlinkyPosition.getX() - firstBlinkyPosition.getX()) * VECTOR_INCREASE;
        int targetY = (targetBlinkyPosition.getY() - firstBlinkyPosition.getY()) * VECTOR_INCREASE;

        return new Position(targetX, targetY);
    }
}
