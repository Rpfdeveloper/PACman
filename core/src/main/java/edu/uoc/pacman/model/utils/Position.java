package edu.uoc.pacman.model.utils;

import java.util.Objects;

/**
 * This class represents a position in the boar of the game.
 *
 * @author UOC and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Position {
    /**
     * attribute to x coordinate.
     */
    private int x;
    /**
     * attribute to y coordinate.
     */
    private int y;

    /**
     * Constructor of the class.
     *
     * @param x coordinate
     * @param y coordinate
     */
    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * this method creates a new position with two positions.
     *
     * @return new position
     */
    public static Position add(Position p1, Position p2) throws NullPointerException {
        if (p1 == null || p2 == null) {
            throw new NullPointerException();
        }
        return new Position(p1.getX() + p2.getX(), p1.getY() + p2.getY());
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
     * setter of the x.
     *
     * @param x coordinate
     */
    public void setX(int x) {
        this.x = x;
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
     * setter of the y.
     *
     * @param y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * This method returns the distance between this position and other position.
     *
     * @param other position
     * @return distance
     */
    public double distance(Position other) {
        if (other == null) {
            return 0;
        }
        return Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2));
    }

    /**
     * This method returns true if the position is equal to other position.
     *
     * @param other position
     * @return true if the position is equal to other position
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Position position = (Position) other;

        if (x != position.x) {
            return false;
        }
        return y == position.y;
    }

    /**
     * This override method returns the hashCode of the position.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * This override method returns the string representation of the position.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return getX() + "," + getY();

    }
}
