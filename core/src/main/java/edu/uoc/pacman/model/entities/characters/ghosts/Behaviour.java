package edu.uoc.pacman.model.entities.characters.ghosts;

/**
 * This class defines the behaviour of a ghost.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public enum Behaviour {
    /**
     * the ghost is chasing the player.
     */
    CHASE(20),
    /**
     * the ghost is frightened.
     */
    FRIGHTENED(30),
    /**
     * the ghost is inactive.
     */
    INACTIVE(5),
    /**
     * the ghost is scattering.
     */
    SCATTER(10);
    /**
     * the duration of the behaviour.
     */
    private final int duration;

    /**
     * Constructor.
     *
     * @param duration the duration of the behaviour.
     */
    Behaviour(int duration) {
        this.duration = duration;
    }

    /**
     * Returns the duration of the behaviour.
     *
     * @return the duration of the behaviour.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the string representation of the behaviour.
     *
     * @return the string representation of the behaviour.
     */
    @Override
    public String toString() {
        return name() + ":" + duration;
    }
}
