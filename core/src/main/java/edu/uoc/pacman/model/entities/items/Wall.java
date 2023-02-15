package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents a wall in the game.
 *
 * @author Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Wall extends MapItem {
    /**
     * Constructor of the class.
     *
     * @param position of the wall
     */
    public Wall(Position position) {
        super(position, false, Sprite.WALL);
    }
}
