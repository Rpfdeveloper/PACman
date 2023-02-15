package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChasePatrol;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents the Inky ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see Ghost
 */
public class Inky extends Ghost {
    /**
     * Points of Inky when it is eaten.
     */
    private static final int POINTS = 200;

    /**
     * Creates a new Inky ghost.
     *
     * @param startPosition the initial position of the ghost.
     * @param direction     the initial direction of the ghost.
     * @param behaviour     the behaviour of the ghost.
     * @param level         the level where the ghost is.
     */
    public Inky(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(level.getWidth(), level.getHeight()), direction, behaviour, Sprite.INKY, level);
        chaseBehaviour = new ChasePatrol();
    }

    /**
     * This override method returns the points that the player gets when he eats Inky.
     *
     * @return the points that the player gets when he eats Inky.
     */
    @Override
    public int getPoints() {
        return POINTS;
    }
}
