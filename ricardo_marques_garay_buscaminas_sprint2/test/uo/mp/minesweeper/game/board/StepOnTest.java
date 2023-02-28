package uo.mp.minesweeper.game.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;

public class StepOnTest {
	
	public Square sq1;
	public Square sq2;
	public Square sq3;
	public Square sq4;
	public Square sq5;
	public Square sq6;

	public Square[][] square1;
	public Square[][] square2;
	public Square[][] square3;
	public Square[][] square4;
	public Square[][] square5;
	public Square[][] square6;
	
	public Board bd1;
	public Board bd2;
	public Board bd3;
	public Board bd4;
	public Board bd5;
	public Board bd6;
	
	@Before
	public void setUp() {
		
		sq1= new Square (State.OPEN,Square.EMPTY_SQUARE);
		sq2= new Square (State.FLAGGED, Square.MINE_SQUARE);
		sq3= new Square (State.FLAGGED, Square.EMPTY_SQUARE);
		sq4= new Square (State.CLOSED, Square.MINE_SQUARE);
		sq5= new Square (State.CLOSED, 3);
		sq6= new Square (State.CLOSED, Square.EMPTY_SQUARE);
		
		
		square1 = new Square[3][3];		
		square2 = new Square[3][3];
		square3 = new Square[3][3];
		square4 = new Square[3][3];
		square5 = new Square[3][3];
		square6 = new Square[3][3];
	}

	/**
	 * GIVEN un board entero y nuevo
	 * WHEN intentamos desmarcar sobre casilla desmarcada 
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testStepOnOpennedBoard() {
		for(int i=0; i<square1.length;i++) {
			for(int j=0; j<square1[i].length; j++) {
				square1[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square1[1][1] = sq1;
		bd1 = new Board(2,square1);
			
		bd1.stepOn(1, 1);
		assertEquals(State.OPEN, square1[1][1].getState());
	}
	/**
	 * GIVEN un board entero y nuevo
	 * WHEN intentamos desmarcar sobre casilla con bandera con mina
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testStepOnFlaggedAndMinedBoard() {
		for(int i=0; i<square2.length;i++) {
			for(int j=0; j<square2[i].length; j++) {
				square2[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square2[1][1] = sq2;
		bd2 = new Board(2,square2);
			
		bd2.stepOn(1, 1);
		assertEquals(State.FLAGGED, square2[1][1].getState());
	}
	/**
	 * GIVEN un board entero y nuevo
	 * WHEN intentamos desmarcar sobre casilla con bandera sin mina
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testStepOnFlaggedAndUnMinedBoard() {
		for(int i=0; i<square3.length;i++) {
			for(int j=0; j<square3[i].length; j++) {
				square3[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square3[1][1] = sq3;
		bd3 = new Board(2,square3);
			
		bd3.stepOn(1, 1);
		assertEquals(State.FLAGGED, square3[1][1].getState());
	}
	/**
	 * GIVEN un board entero y nuevo
	 * WHEN intentamos desmarcar sobre casilla con mina
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testStepOnMinedBoard() {
		for(int i=0; i<square4.length;i++) {
			for(int j=0; j<square4[i].length; j++) {
				square4[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square4[1][1] = sq4;
		bd4 = new Board(2,square4);
			
		bd4.stepOn(1, 1);
		assertEquals(State.OPEN, square4[1][1].getState());
	}
	/**
	 * GIVEN un board entero y nuevo
	 * WHEN intentamos desmarcar sobre casilla con pista numerica
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	public void testStepOnNumericPist() {
		for(int i=0; i<square5.length;i++) {
			for(int j=0; j<square5[i].length; j++) {
				square5[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square5[1][1] = sq5;
		bd5 = new Board(2,square5);
			
		bd5.stepOn(1, 1);
		assertEquals(State.OPEN, square5[1][1].getState());
	}
	/**
	 * GIVEN un board entero y nuevo
	 * WHEN intentamos desmarcar sobre casilla vacia
	 * THEN devuelve la casilla desmarcada
	 */
	@Test
	()
	public void testStepOnEmptySquare() {
		for(int i=0; i<square6.length;i++) {
			for(int j=0; j<square6[i].length; j++) {
				square6[i][j] =new Square (State.CLOSED, 5);
			}
		}
		square6[1][1] = sq6;
		bd6 = new Board(0,square6);
		bd6.stepOn(1, 1);
		assertEquals(State.OPEN, square6[1][1].getState());
		
	}

}
