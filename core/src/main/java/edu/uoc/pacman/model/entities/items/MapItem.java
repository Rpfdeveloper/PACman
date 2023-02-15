package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.entities.Entity;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * MapItem is an abstract class that represents an item in the map.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public abstract class MapItem extends Entity {
    /**
     * Constructor of the class.
     *
     * @param position of the item
     * @param pathable if the item is pathable
     * @param sprite   of the item
     */
    protected MapItem(Position position, boolean pathable, Sprite sprite) {
        super(position, pathable, sprite);
    }
}
