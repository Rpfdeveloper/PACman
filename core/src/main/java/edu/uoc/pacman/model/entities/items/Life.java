package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents a life item.
 *
 * @author Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Life extends MapItem implements Pickable {
    private boolean picked;

    /**
     * Constructor of the class.
     *
     * @param position of the life
     */
    public Life(Position position) {
        super(position, true, Sprite.LIFE);
        setPicked(false);
    }

    /**
     * This method returns if the item is picked.
     *
     * @return if the life is picked
     */
    @Override
    public boolean isPicked() {
        return picked;
    }

    /**
     * override the method from Pickable interface to set the life as picked
     *
     * @param picked if the life is picked
     */
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}
