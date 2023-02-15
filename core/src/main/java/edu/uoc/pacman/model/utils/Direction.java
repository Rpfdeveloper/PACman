package edu.uoc.pacman.model.utils;

import java.util.Arrays;

/**
 * This class represents the direction of the Characters.
 *
 * @author UOC and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public enum Direction {
    /**
     * Right direction.
     */
    RIGHT(1, 0, 22),
    /**
     * Down direction.
     */
    DOWN(0, 1, 20),
    /**
     * Left direction.
     */
    LEFT(-1, 0, 21),
    /**
     * Up direction.
     */
    UP(0, -1, 19);
    /**
     * attribute to x coordinate.
     */
    private final int x;
    /**
     * attribute to y coordinate.
     */
    private final int y;
    /**
     * attribute to keyCode.
     */
    private final int keyCode;

    /**
     * Constructor of the class.
     *
     * @param x       coordinate
     * @param y       coordinate
     * @param keyCode keyCode
     */
    Direction(int x, int y, int keyCode) {
        this.x = x;
        this.y = y;
        this.keyCode = keyCode;
    }

    /**
     * This method returns the direction by the keyCode.
     *
     * @param keyCode keyCode
     * @return direction
     */
    public static Direction getDirectionByKeyCode(int keyCode) {
        return Arrays.stream(Direction.values()).filter(d -> d.keyCode == keyCode).findFirst().orElse(null);
    }

    /**
     * getter of the x.
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter of the y.
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * getter of the keyCode.
     *
     * @return keyCode
     */
    public int getKeyCode() {
        return keyCode;
    }

    /**
     * This method returns the opposite direction.
     *
     * @return opposite direction
     */
    public Direction opposite() {
        return switch (this) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
        };
    }
}
