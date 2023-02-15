package edu.uoc.pacman.model.entities.items;

/**
 * This interface represents a pickable item.
 *
 * @author Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public interface Pickable {
    /**
     * This abstract method returns if the item is picked.
     *
     * @return boolean true if the item is picked. Otherwise, false.
     */
    boolean isPicked();

    /**
     * This abstract method sets the item as picked/unpicked.
     *
     * @param picked State: true if the item was picked. Otherwise, false.
     */
    void setPicked(boolean picked);
}
