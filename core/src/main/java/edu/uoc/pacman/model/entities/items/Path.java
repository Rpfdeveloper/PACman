package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents a path in the board.
 *
 * @author Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Path extends MapItem {
    /**
     * Constructor of the class.
     *
     * @param position of the path
     */
    public Path(Position position) {
        super(position, true, Sprite.PATH);
    }
}
