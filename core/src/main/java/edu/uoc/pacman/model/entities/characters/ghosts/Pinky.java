package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseAmbush;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents the Pinky ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 * @see Ghost
 */
public class Pinky extends Ghost {
    /**
     * Points of Pinky when it is eaten.
     */
    private static final int POINTS = 300;

    /**
     * Creates a new Pinky ghost.
     *
     * @param startPosition the initial position of the ghost.
     * @param direction     the initial direction of the ghost.
     * @param behaviour     the behaviour of the ghost.
     * @param level         the level where the ghost is.
     */
    public Pinky(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(-1, -1), direction, behaviour, Sprite.PINKY, level);
        chaseBehaviour = new ChaseAmbush();
    }

    /**
     * This override method returns the points that the player gets when he eats Pinky.
     *
     * @return the points that the player gets when he eats Pinky.
     */
    @Override
    public int getPoints() {
        return POINTS;
    }
}
