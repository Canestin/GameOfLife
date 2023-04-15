package Tests;

import GOL.Cell;
import GOL.CellState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test()
    @DisplayName("test next state when alive and two neighbors alive")
    public void testNextStateWhenAliveAndTwoLivingNeighbors() {
        // ARRANGE
        Cell cell = new Cell(CellState.ALIVE, 2);
        // ACT
        int nextState = cell.NextState();
        // ASSERT
        assertEquals(CellState.ALIVE, nextState, "The next state should be 1 the cell is alive and with two alive neighbors");
    }

    @Test
    @DisplayName("test next state when alive and three neighbors alive")
    public void testNextStateWhenAliveAndThreeLivingNeighbors() {
        Cell cell = new Cell(CellState.ALIVE, 3);
        int nextState = cell.NextState();
        assertEquals(CellState.ALIVE, nextState);
    }

    @Test
    @DisplayName("test next state when dead and three neighbors alive")
    public void testNextStateWhenDeadAndThreeLivingNeighbors() {
        Cell cell = new Cell(CellState.DEAD, 3);
        int nextState = cell.NextState();
        assertEquals(CellState.ALIVE, nextState);
    }

    @Test
    @DisplayName("test next state when dead and two neighbors alive")
    public void testNextStateWhenDeadAndTwoLivingNeighbors() {
        Cell cell = new Cell(CellState.DEAD, 2);
        int nextState = cell.NextState();
        assertEquals(CellState.DEAD, nextState);
    }

    @Test
    @DisplayName("test next state when alive and zero neighbors alive")
    public void testNextStateWhenAliveAndZeroLivingNeighbors() {
        Cell cell = new Cell(CellState.ALIVE, 0);
        int nextState = cell.NextState();
        assertEquals(CellState.DEAD, nextState);
    }

}