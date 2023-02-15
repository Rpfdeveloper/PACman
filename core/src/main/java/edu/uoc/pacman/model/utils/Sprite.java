package edu.uoc.pacman.model.utils;

/**
 * This enum class represents a sprite.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public enum Sprite {
    /**
     * Sprite for Pinky Ghost whit symbol and path associated.
     */
    BLINKY('B', "images/blinky.png"),
    /**
     * Sprite for Clyde Ghost whit symbol and path associated.
     */
    CLYDE('C', "images/clyde.png"),
    /**
     * Sprite for Dot whit symbol and path associated.
     */
    DOT('.', "images/dot.png"),
    /**
     * Sprite for Energizer whit symbol and path associated.
     */
    ENERGIZER('0', "images/energizer.png"),
    /**
     * Sprite for Inky Ghost whit symbol and path associated.
     */
    INKY('I', "images/inky.png"),
    /**
     * Sprite for Life whit symbol and path associated.
     */
    LIFE('L', "images/life.png"),
    /**
     * Sprite for Pacman Down direction whit symbol and path associated.
     */
    PACMAN_DOWN('V', "images/pac_down.png"),
    /**
     * Sprite for Pacman Left direction whit symbol and path associated.
     */
    PACMAN_LEFT('>', "images/pac_left.png"),
    /**
     * Sprite for Pacman Right direction whit symbol and path associated.
     */
    PACMAN_RIGHT('<', "images/pac_right.png"),
    /**
     * Sprite for Pacman Up direction whit symbol and path associated.
     */
    PACMAN_UP('^', "images/pac_up.png"),
    /**
     * Sprite for Path piece whit symbol and path associated.
     */
    PATH(' ', "images/path.png"),
    /**
     * Sprite for Pinky Ghost whit symbol and path associated.
     */
    PINKY('P', "images/pinky.png"),
    /**
     * Sprite for Wall whit symbol and path associated.
     */
    WALL('#', "images/wall.png");
    /**
     * attribute to symbol.
     */
    private final char symbol;
    /**
     * attribute to imageSrc.
     */
    private final String imageSrc;

    /**
     * Constructor of the class.
     *
     * @param symbol   symbol
     * @param imageSrc imageSrc
     */
    Sprite(char symbol, String imageSrc) {
        this.imageSrc = imageSrc;
        this.symbol = symbol;
    }

    /**
     * getter of symbol.
     *
     * @return symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * getter of imageSrc.
     *
     * @return imageSrc
     */
    public String getImageSrc() {
        return imageSrc;
    }
}
