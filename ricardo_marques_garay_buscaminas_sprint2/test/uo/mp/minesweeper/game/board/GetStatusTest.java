package uo.mp.minesweeper.game.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;

public class GetStatusTest {
	
	private Board bd1;
	private Board bd2;
	private Board bd3;
	
	private Square sq1;
	private Square sq2;

	private Square sq4;
	private Square sq5;
	
	private Square[][] square1;
	private Square[][] square2;
	private Square[][] square3;
	
	private char[][] compare1;
	private char[][] compare2;
	private char[][] compare3;
	
	@Before
	public void setUp() {
		
		
		sq1 = new Square(State.CLOSED, Square.MINE_SQUARE);
		sq2 = new Square(State.FLAGGED, Square.MINE_SQUARE);

		sq4 = new Square(State.CLOSED, Square.EMPTY_SQUARE);
		sq5 = new Square(State.OPEN, Square.EMPTY_SQUARE);
		
		square1 = new Square[3][3];
		square2 = new Square[3][3];
		square3 = new Square[3][3];
		
		compare1 = new char[3][3];
		compare2 = new char[3][3];
		compare3 = new char[3][3];
		
		
		for(int i=0; i<compare3.length; i++) {
			for (int j=0; j<compare3[i].length; j++) {
				compare3[i][j] = '#';
			}
		}
		
		compare3[1][2] = '#';
		compare3[0][2] = (char) 182;
		compare3[2][1] = '#';
		compare3[1][1] = '2';
		
		for(int i=0; i<compare1.length; i++) {
			for (int j=0; j<compare1[i].length; j++) {
				compare1[i][j] = '#';
			}
		}
		for(int i=0; i<compare2.length; i++) {
			for (int j=0; j<compare2[i].length; j++) {
				compare2[i][j] = ' ';
			}
		}
	}
	
	
	/**
	 * GIVEN un tablero completamente cubierto
	 * WHEN utilizamos el método getStatus
	 * THEN devuelve la cadena
	 */
	@Test
	public void testGetStatusCovered() {
		for(int i=0; i<square1.length; i++) {
			for (int j=0; j<square1[i].length; j++) {
				square1[i][j] = new Square(State.CLOSED,Square.EMPTY_SQUARE);
			}
		}
		bd1 = new Board(0, square1);
		bd1.getStatus();
		assertArrayEquals(compare1,bd1.getStatus());
	}
	
	/**
	 * GIVEN un tablero completamente descubierto
	 * WHEN utilizamos el método getStatus
	 * THEN devuelve la cadena
	 */
	@Test
	public void testGetStatusUnCovered() {
		for(int i=0; i<square2.length; i++) {
			for (int j=0; j<square2[i].length; j++) {
				square2[i][j] = new Square(State.OPEN,Square.EMPTY_SQUARE);
			}
		}
		bd2 = new Board(0, square2);
		bd2.getStatus();
		assertArrayEquals(compare2,bd2.getStatus());
	}
	
	/**
	 * GIVEN un tablero completamente con minas, banderas, casillas cubiertas,
	 * y casillas descubiertas
	 * WHEN utilizamos el método getStatus
	 * THEN devuelve la cadena
	 */
	@Test
	public void testGetStatusWithDifferentsStates() {
		for(int i=0; i<square3.length; i++) {
			for (int j=0; j<square3[i].length; j++) {
				square3[i][j] = new Square(State.CLOSED,Square.EMPTY_SQUARE);
			}
		}		
		square3[1][2] = sq1;
		square3[0][2] = sq2;

		square3[2][1] = sq4;
		square3[1][1] = sq5;
		bd3 = new Board(0, square3);
		bd3.getStatus();
		assertArrayEquals(compare3,bd3.getStatus());

	}

}
