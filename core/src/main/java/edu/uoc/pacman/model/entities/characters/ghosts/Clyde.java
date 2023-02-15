package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseCoward;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents the Clyde ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Clyde extends Ghost {
    /**
     * Points that the player gets when he eats Clyde.
     */
    private static final int POINTS = 100;

    /**
     * Creates a new Clyde ghost.
     *
     * @param startPosition the initial position of the ghost.
     * @param direction     the initial direction of the ghost.
     * @param behaviour     the behaviour of the ghost.
     * @param level         the level where the ghost is.
     */
    public Clyde(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(-1, level.getHeight()), direction, behaviour, Sprite.CLYDE, level);
        this.chaseBehaviour = new ChaseCoward();
    }

    /**
     * This override method returns the points that the player gets when he eats Clyde.
     *
     * @return the points that the player gets when he eats Clyde.
     */
    @Override
    public int getPoints() {
        return POINTS;
    }
}
