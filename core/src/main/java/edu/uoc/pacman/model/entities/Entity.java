package edu.uoc.pacman.model.entities;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * This abstract class represents an entity in the game.
 *
 * @author Uoc and Julio Roberto Pajuelo Ferreira
 * @version 1.0
 */
public abstract class Entity {
    /**
     * This attribute represents if the entity is pathable or not.
     */
    private boolean pathable;
    /**
     * This attribute represents the position of the entity.
     * this class is knowledge of the position class
     *
     * @see Position
     */
    private Position position;
    /**
     * This attribute represents the sprite of the entity.
     * this class is knowledge of the sprite class
     *
     * @see Sprite
     */
    private Sprite sprite;

    /**
     * This constructor creates an entity with the given parameters.
     *
     * @param position of the entity
     * @param pathable if the entity is pathable or not
     * @param sprite   of the entity
     */
    protected Entity(Position position, boolean pathable, Sprite sprite) {
        setPosition(position);
        setPathable(pathable);
        setSprite(sprite);
    }

    /**
     * This method returns the position of the entity.
     *
     * @return position object
     */
    public Position getPosition() {
        return position;
    }

    /**
     * This method sets the position of the entity.
     *
     * @param position of the entity
     */
    public void setPosition(Position position) {
        if (position != null) {
            this.position = position;
        }
    }

    /**
     * This method returns if the entity is pathable or not.
     *
     * @return true if the entity is pathable, false otherwise
     */
    public boolean isPathable() {
        return pathable;
    }

    /**
     * This method sets if the entity is pathable or not.
     *
     * @param pathable if the entity is pathable or not
     */
    public void setPathable(boolean pathable) {
        this.pathable = pathable;
    }

    /**
     * This method returns the sprite of the entity.
     *
     * @return sprite object
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * This method sets the sprite of the entity.
     *
     * @param sprite of the entity
     */
    protected void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
