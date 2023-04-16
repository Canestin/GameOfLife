package Tests;

import GOL.Coord;
import GOL.GameOfLife;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {
    @Test
    void testConstructorInvalidArguments() {
        Coord[] coords = {new Coord(0, 0)};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new GameOfLife(0, 0, coords));
        assertThrows(NegativeArraySizeException.class, () -> new GameOfLife(-1, 0, coords));
        assertThrows(NegativeArraySizeException.class, () -> new GameOfLife(0, -1, coords));
        assertThrows(NegativeArraySizeException.class, () -> new GameOfLife(-1, -1, coords));
    }

    @Test
    void testCoordsInvalidArguments() {
        Coord[] coords = {new Coord(-1, 0)};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new GameOfLife(1, 1, coords));
    }

    @Test
    void testConstructorValidArguments() {
        Coord[] coords = {new Coord(0, 0)};
        assertDoesNotThrow(() -> new GameOfLife(10, 10, coords));
    }
    @Test
    public void testSetLivingCells() {
        GameOfLife game = new GameOfLife(3, 3, new Coord[] { new Coord(0, 1), new Coord(1, 2) });
        int[][] expectedGrid = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 0, 0, 0 }
        };
        assertArrayEquals(expectedGrid, game.grid);
    }
    @Test
    public void testSetLivingCell() {
        GameOfLife game = new GameOfLife(3, 3, new Coord[] {});
        game.setLivingCell(1, 1);
        int[][] expectedGrid = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        assertArrayEquals(expectedGrid, game.grid);
    }
    @Test
    public void testCountlivingNeighbours() {
        GameOfLife game = new GameOfLife(3, 3, new Coord[] { new Coord(0, 1), new Coord(1, 2) });
        assertEquals(1, game.countlivingNeighbours(0, 0));
        assertEquals(2, game.countlivingNeighbours(1, 1));
        assertEquals(1, game.countlivingNeighbours(2, 2));
    }
    @Test
    public void testComputeNextGeneration() {
        GameOfLife game = new GameOfLife(3, 3, new Coord[] { new Coord(0, 1), new Coord(1, 2) });
        game.computeNextGeneration();
        int[][] expectedGrid = new int[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        assertArrayEquals(expectedGrid, game.grid);
    }
}
