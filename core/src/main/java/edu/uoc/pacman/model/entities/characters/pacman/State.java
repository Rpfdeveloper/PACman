package edu.uoc.pacman.model.entities.characters.pacman;

/**
 * This enum represents the different states of the Pacman.
 */
public enum State {
    /**
     * This state represents the normal state of the Pacman.
     */
    NORMAL(Integer.MAX_VALUE),
    /**
     * This state represents the state of the Pacman when it is eating.
     */
    EATER(30),
    /**
     * This state represents the state of the Pacman when it is invincible.
     */
    INVINCIBLE(5);
    /**
     * This attribute represents the duration of the state.
     */
    private final int duration;

    /**
     * This constructor initializes the duration of the state.
     *
     * @param duration The duration of the state.
     */
    State(int duration) {
        this.duration = duration;
    }

    /**
     * This method returns the duration of the state.
     *
     * @return The duration of the state.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * This method returns the string representation of the state.
     *
     * @return The string representation of the state.
     */
    @Override
    public String toString() {
        return name() + ":" + duration;
    }
}
