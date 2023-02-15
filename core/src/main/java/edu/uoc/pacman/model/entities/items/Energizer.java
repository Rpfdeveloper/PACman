package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This class represents an energizer item.
 *
 * @author Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Energizer extends MapItem implements Pickable, Scorable {
    private static final int POINTS = 5;
    private boolean picked;

    /**
     * Constructor of the class.
     *
     * @param position of the item
     */
    public Energizer(Position position) {
        super(position, true, Sprite.ENERGIZER);
        this.picked = false;
    }

    /**
     * This method returns the points of the item.
     *
     * @return the points of the item
     */
    @Override
    public int getPoints() {
        return POINTS;
    }

    /**
     * This method returns if the item is picked.
     *
     * @return if the item is picked
     */
    @Override
    public boolean isPicked() {
        return picked;
    }

    /**
     * This method sets the item as picked.
     *
     * @param picked if the item is picked
     */
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}
