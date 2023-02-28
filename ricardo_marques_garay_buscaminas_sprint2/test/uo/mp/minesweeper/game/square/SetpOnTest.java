package uo.mp.minesweeper.game.square;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;

public class SetpOnTest {

	

	
	/**
	 * GIVEN una casilla OPEN
	 * WHEN se utiliza stepOn
	 * THEN devuelve que esta en Open
	 */
	@Test
	public void testStepOnWithSquareOpen() {
		Square sq = new Square(State.OPEN,0);
		sq.setpOn();
		assertEquals(State.OPEN,sq.getState());
	}
	
	/**
	 * GIVEN una casilla CLOSED
	 * WHEN se utiliza stepOn
	 * THEN devuelve que esta Open
	 */
	@Test
	public void testStepOnWithSquareClosed() {
		Square sq = new Square(State.CLOSED,0);
		sq.setpOn();
		assertEquals(State.OPEN,sq.getState());

	}
	
	/**
	 * GIVEN una casilla FLAGGED
	 * WHEN se utiliza stepOn
	 * THEN devuelve que esta FLAGGED
	 */
	@Test
	public void testStepOnWithSquareFlagged() {
		Square sq = new Square(State.FLAGGED,0);
		sq.setpOn();
		assertEquals(State.FLAGGED,sq.getState());

	}

}
