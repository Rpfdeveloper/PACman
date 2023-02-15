package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseAggressive;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents the Blinky ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Blinky extends Ghost {

    /**
     * Points that the player gets when he eats Blinky.
     */
    private static final int POINTS = 400;

    /**
     * Creates a new Blinky ghost.
     *
     * @param startPosition the initial position of the ghost.
     * @param direction     the initial direction of the ghost.
     * @param behaviour     the behaviour of the ghost.
     * @param level         the level where the ghost is.
     */
    public Blinky(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(level.getWidth(), -1), direction, behaviour, Sprite.BLINKY, level);
        this.chaseBehaviour = new ChaseAggressive();
    }

    /**
     * This override method returns the points that the player gets when he eats Blinky.
     *
     * @return the points that the player gets when he eats Blinky.
     */
    @Override
    public int getPoints() {
        return POINTS;
    }
}
