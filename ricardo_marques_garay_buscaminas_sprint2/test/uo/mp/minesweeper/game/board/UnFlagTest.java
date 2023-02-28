package uo.mp.minesweeper.game.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;


public class UnFlagTest {
	

	public Square sq1;
	public Square sq2;
	public Square sq3;
	public Square sq4;

	public Square[][] square1;
	public Square[][] square2;
	public Square[][] square3;
	public Square[][] square4;
	public Board bd1;
	public Board bd2;
	public Board bd3;
	public Board bd4;
	
	
	
	@Before
	public void setUp() {

		sq1= new Square (State.FLAGGED,Square.MINE_SQUARE);
		sq2= new Square (State.CLOSED, Square.MINE_SQUARE);
		sq3= new Square (State.CLOSED, Square.EMPTY_SQUARE);
		sq4= new Square (State.CLOSED, Square.EMPTY_SQUARE);

		square1 = new Square[3][3];		
		square2 = new Square[3][3];
		square3 = new Square[3][3];
		square4 = new Square[3][3];

	}
	
	/**
	 * GIVEN un tablero entero y nuevo
	 * WHEN desmarcamos una casilla de mina con bandera
	 * THEN devuelve la casilla  desmarcada
	 */
	@Test
	public void testUnFlagWithMineAndFlag() {
		for(int i=0; i<square1.length;i++) {
			for(int j=0; j<square1[i].length; j++) {
				square1[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square1[1][1] = sq1;
		bd1 = new Board(2,square1);
			
		bd1.unFlag(1, 1);
		assertEquals(State.CLOSED, square1[1][1].getState());

	}
	
	

	/**
	 * GIVEN un tablero entero y nuevo
	 * WHEN desmarcamos una casilla de mina sin bandera
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testUnFlagWithMineAndNotFlag() {
		for(int i=0; i<square2.length;i++) {
			for(int j=0; j<square2[i].length; j++) {
				square2[i][j] = new Square (State.CLOSED, 5);
			}
		}
		square2[1][1] = sq2;
		bd2 = new Board(2,square2);
			
		bd2.unFlag(1, 1);
		assertEquals(State.CLOSED, square2[1][1].getState());

	}
	
	/**
	 * GIVEN un tablero entero y nuevo
	 * WHEN desmarcamos una casilla sin bandera
	 * THEN devuelve la casilla como estaba
	 */
	@Test
	public void testUnFlagWithOutFlag() {
		for(int i=0; i<square3.length;i++) {
			for(int j=0; j<square3[i].length; j++) {
				square3[i][j] = new Square (State.CLOSED, 5);
			}
		}
		square3[1][1] = sq3;
		bd3 = new Board(2,square3);
			
		bd3.unFlag(1, 1);
		assertEquals(State.CLOSED, square3[1][1].getState());

	}
	
	/**
	 * GIVEN un tablero entero y nuevo
	 * WHEN desmarcamos una casilla dos veces 
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testUnFlagTwoTimes() {
		for(int i=0; i<square4.length;i++) {
			for(int j=0; j<square4[i].length; j++) {
				square4[i][j] = new Square (State.CLOSED, 5);
			}
		}
		square4[1][1] = sq4;
		bd4 = new Board(2,square4);
		bd4.unFlag(1, 1);	
		bd4.unFlag(1, 1);
		assertEquals(State.CLOSED, square4[1][1].getState());
	}
}
