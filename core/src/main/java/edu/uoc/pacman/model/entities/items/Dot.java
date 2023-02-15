package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * A Dot is a MapItem that can be eaten by the Pacman.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public class Dot extends MapItem implements Pickable, Scorable {
    /**
     * Points of the dot.
     */
    private static final int POINTS = 1;
    /**
     * If the dot is picked.
     */
    private boolean picked;

    /**
     * Constructor of the class.
     *
     * @param position of the item
     */
    public Dot(Position position) {
        super(position, true, Sprite.DOT);
        this.picked = false;
    }

    /**
     * Getter of the points of the item.
     *
     * @return the points of the item
     */
    @Override
    public int getPoints() {
        return POINTS;
    }

    /**
     * Getter for picked
     *
     * @return if the item is picked
     */
    @Override
    public boolean isPicked() {
        return picked;
    }

    /**
     * Setter for picked
     *
     * @param picked State: true if the item was picked. Otherwise, false.
     */
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}
