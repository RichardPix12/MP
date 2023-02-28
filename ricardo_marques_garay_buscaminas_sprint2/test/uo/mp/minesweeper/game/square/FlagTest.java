package uo.mp.minesweeper.game.square;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;

public class FlagTest {
	
	
	/**
	 * GIVEN una casilla OPEN
	 * WHEN le pasamos el metodo flag
	 * THEN devuelve la casilla OPEN
	 */
	@Test
	public void testFlagWithSquareOpen() {
		Square sq = new Square(State.OPEN,0);
		sq.flag();
		assertEquals(State.OPEN,sq.getState());
	}
	
	/**
	 * GIVEN una casilla CLOSED
	 * WHEN le pasamos el metodo flag
	 * THEN devuelve la casilla FLAGGED
	 */
	@Test
	public void testFlagWithSquareClosed() {
		Square sq = new Square(State.CLOSED,0);
		sq.flag();
		assertEquals(State.FLAGGED,sq.getState());
	}
	
	/**
	 * GIVEN una casilla FLAGGED
	 * WHEN le pasamos el metodo flag
	 * THEN devuelve la casilla FLAGGED
	 */
	@Test
	public void testFlagWithSquareFlagged() {
		Square sq = new Square(State.FLAGGED,0);
		sq.flag();
		assertEquals(State.FLAGGED,sq.getState());
	}
}
