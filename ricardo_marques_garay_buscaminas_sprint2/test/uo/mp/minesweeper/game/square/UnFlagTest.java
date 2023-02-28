package uo.mp.minesweeper.game.square;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;

public class UnFlagTest {

	
	
	
	/**
	 * GIVEN una casilla FLAGGED
	 * WHEN utilizamos unFlag
	 * THEN devuelve la casilla CLOSED
	 */
	@Test
	public void testUnFlagWithMineAndFlaggedSquare() {
		Square sq = new Square(State.FLAGGED,0);
		sq.unFlag();
		assertEquals(State.CLOSED,sq.getState());
		
	}
	
	/**
	 * GIVEN una casilla CLOSED
	 * WHEN utilizamos unFlag
	 * THEN devuelve la casilla igual que estaba antes
	 */
	public void testUnFlagWithMineAndClosedSquare() {
		Square sq = new Square(State.CLOSED,0);
		sq.unFlag();
		assertEquals(State.CLOSED,sq.getState());
		

	}
	/**
	 * GIVEN una casilla OPEN
	 * WHEN utilizamos unFlag
	 * THEN devuelve la casilla igual que antes
	 */
	public void testUnFlagWithClosedSquare() {
		Square sq = new Square(State.OPEN,0);
		sq.unFlag();
		assertEquals(State.OPEN,sq.getState());
	}
	

}
