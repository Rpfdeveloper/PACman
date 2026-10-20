package edu.uoc.pacman.model;

import edu.uoc.pacman.model.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Regression checks for map boundaries, added with AI assistance.
 * Existing academic tests and their attributions are preserved.
 */
@Tag("basic")
class LevelPathabilityTest {
    private Level level;

    @BeforeEach
    void setUp() throws Exception {
        level = new Level("levels/level1.txt", 3);
    }

    @Test
    void positionsOutsideTheBoardAreNotPathable() {
        Position[] outside = {
                new Position(-1, 1), new Position(1, -1),
                new Position(level.getWidth(), 1),
                new Position(1, level.getHeight()),
                new Position(Integer.MAX_VALUE, Integer.MAX_VALUE),
                new Position(Integer.MIN_VALUE, Integer.MIN_VALUE)
        };
        for (Position position : outside) {
            assertFalse(level.isPathable(position), "Outside position: " + position);
        }
    }

    @Test
    void nullIsNotPathable() {
        assertFalse(level.isPathable(null));
    }

    @Test
    void existingPathsAndWallsKeepTheirBehavior() {
        assertTrue(level.isPathable(new Position(1, 1)));
        assertTrue(level.isPathable(new Position(2, 1)));
        assertFalse(level.isPathable(new Position(0, 0)));
        assertFalse(level.isPathable(new Position(3, 2)));
    }
}
