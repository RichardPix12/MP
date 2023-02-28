package uo.mp.minesweeper.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uo.mp.minesweeper.game.actions.Action;
import uo.mp.minesweeper.game.actions.BlowUpAction;
import uo.mp.minesweeper.game.actions.ClearAction;
import uo.mp.minesweeper.game.actions.NullAction;

public class Board {
	// Constantes de la clase

	// Atributos de la clase

	private Square[][] squares;
	private int percentage;

	public Board(int width, int height, int percentage) {
		squares = new Square[width][height];
		initializeBoard();
		int mines = numberOfMines(percentage);
		putMines(mines);
		putNumbers();
		this.percentage = percentage;
	}

	public Board(int mines, Square[][] theSquares) {
		squares = theSquares;
		putMines(mines);
		putNumbers();
	}

	/**
	 * Metodo que devuelve si ha explotado o no alguna mina
	 * 
	 * @return true de tipo boolean si ha explotado alguna mina
	 * @return false de tipo boolean si no ha explotado ninguna mina
	 */
	public boolean isExploded() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (squares[i][j].getState() == State.OPEN && squares[i][j].getValue() == Square.MINE_SQUARE) {
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * Metodo que si no esta descubierta descubre la casilla pasada como parámetro
	 * 
	 * @param x de tipo int, posicion x dentro del tablero
	 * @param y de tipo int, posicion y dentro del tablero
	 */
	public void stepOn(int x, int y) {
		if (squares[x][y].getState() == State.CLOSED) {
			selectAction();
			squares[x][y].setpOn();
		}

	}

	/**
	 * Metodo que si no hay una bandera, y la casilla no está descubiera la coloca
	 * en la casilla pasada como parámetro
	 * 
	 * @param x de tipo int, posicion x dentro del tablero
	 * @param y de tipo int, posicion y dentro del tablero
	 */

	public void flag(int x, int y) {
		if (squares[x][y].getState() == State.CLOSED) {
			squares[x][y].flag();
		}
	}

	/**
	 * Metodo que si hay una bandera en la casilla pasada como parámetro, la quita
	 * 
	 * @param x de tipo int, poxicion x dentro del tablero
	 * @param y de tipo int, posicion y dentro del tablero
	 */

	public void unFlag(int x, int y) {
		if (squares[x][y].getState() == State.FLAGGED) {
			squares[x][y].unFlag();
		}
	}

	/**
	 * Metodo que descubre todas las casillas del tablero
	 */
	public void unveil() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (squares[i][j].getState() == State.CLOSED || squares[i][j].getState() == State.FLAGGED) {
					squares[i][j].open();
				}
			}
		}
	}

	/**
	 * Metodo que devuelve el número de banderas que aún no han sido colocadas
	 * 
	 * @return número de banderas sin colocar, de tipo int
	 */
	public int getFlagsLeft() {

		int flags = numberOfMines(percentage);

		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (squares[i][j].getState() == State.FLAGGED) {
					flags--;
				}
			}
		}
		return flags;
	}

	/**
	 * Metodo que devuelve el número de minas que aún no ha sido cubierto con una
	 * bandera
	 * 
	 * @return numero de minas sin marcar, de tipo int
	 */
	public int getMinesLeft() {
		int minesLeft = 0;
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (squares[i][j].getState() == State.CLOSED && squares[i][j].getValue() == Square.MINE_SQUARE) {
					minesLeft++;
				}
			}
		}
		return minesLeft;
	}

	/**
	 * Situa todo el tablero como explotado
	 */
	public void markAsExploded() {
		if (isExploded() == true) {
			unveil();
		}
	}

	/**
	 * Devuelve un array de caracteres que representa el estado del tablero del
	 * juego La posicion en ese array sera el mismo que en el tablero
	 * 
	 * @return un tablero de caracteres de tipo char[][]
	 */
	public char[][] getStatus() {
		char[][] tablero = new char[squares.length][squares[0].length];
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				tablero[i][j] = squares[i][j].toString().charAt(0);
			}
		}
		return tablero;
	}

	public String toString() {
		String str = "";

		for (int i = 0; i < squares.length; i++) {
			str += "\n";
			str += "[";
			for (int j = 0; j < squares[i].length; j++) {
				str += squares[i][j].toString();
				if (j != squares[i].length - 1) {
					str += ", ";
				}
			}
			str += "]";
		}
		return str;
	}

	/**
	 * Devuelve una referencia al array de Square manejado internamente
	 * 
	 * @return un array de tipo Square[][]
	 */
	public Square[][] getSquaresForTest() {
		Square[][] squaresForTest = squares;
		return squaresForTest;
	}
	
	private void selectAction() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
		if(squares[i][j].getValue() == Square.EMPTY_SQUARE) {
			Action action1 = new ClearAction(list(i,j));	
			squares[i][j].setAction(action1);
		}
		else if(squares[i][j].getValue() == Square.MINE_SQUARE) {

			Action action2 = new BlowUpAction(this);
			squares[i][j].setAction(action2);
		}
		else {
			Action action3 = new NullAction();
			squares[i][j].setAction(action3);
		}
			}
		}
	}

	// Metodos privados

	private List<Square> list(int x, int y) {
		List<Square> squareToOpen = new ArrayList<Square>();
		for(int i = x - 1; i<= x + 1; i++) {
			for (int j = y - 1; j<= y+1; j++) {
				if(i >= 0 && j >= 0 && i<squares.length && j<squares.length) {
					squareToOpen.add(squares[i][j]);
				}
			}
		}
		
		
		return squareToOpen;
	}

	private int numberOfMines(int percentage) {
		int casillasTablero = 0;
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				casillasTablero++;
			}
		}
		int minas = casillasTablero * percentage / 100;
		return minas;

	}

	private void putMines(int mines) {
		int minas = mines;
		Random r = new Random();
		Random s = new Random();
		int i = r.nextInt(squares.length);
		int j = s.nextInt(squares.length);

		while (minas != 0) {
			if (squares[i][j].getValue() != Square.MINE_SQUARE) {
				minas--;
				squares[i][j].putMine();
			}
			i = r.nextInt(squares.length);
			j = s.nextInt(squares.length);

		}

	}
	
	private void initializeBoard() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				squares[i][j] = new Square(State.CLOSED, Square.EMPTY_SQUARE);
			}
		}
	}

	public boolean isBoardExploded() {
		if (isExploded()) {
			return true;
		} else if (isFinished()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isFinished() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				if (squares[i][j].getState() == State.CLOSED) {
					return false;
				}
			}
		}
		return true;
	}

	private void putNumbers() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				squares[i][j].setValue(AdyacentNumber(i, j));
			}
		}
	}

	private int AdyacentNumber(int x, int y) {
		int valor = 0;
		if (squares[x][y].getValue() == Square.MINE_SQUARE) {
			valor = -1;
		} else {
			if (x == 0 && y == 0) {
				valor = AdyacentNumberTopLeft(x,y);
			}
			else if(x == 0 && y > 0 && y < squares.length-1 ) {
				valor = AdyacentNumberTop(x,y);
			}
			else if(x > 0 && y == 0 && x < squares.length-1) {
				valor = AdyacentNumberLeft(x,y);
			}
			else if(x == 0 && y == squares.length-1) {
				valor = AdyacentNumberTopRight(x,y);
			}
			else if(x > 0 && y == squares.length-1 && x < squares.length-1 ) {
				valor = AdyacentNumberRight(x,y);
			}
			else if(x == squares.length-1 && y == squares.length-1) {
				valor = AdyacentNumberRightBottom(x,y);
			}
			else if(x == squares.length-1 && y == 0) {
				valor = AdyacentNumberLeftBottom(x,y);
			}
			else if(x == squares.length-1 && y > 0 && y < 0) {
				valor = AdyacentNumberBottom(x,y);
			}
			else if(x > 0 && x < squares.length-1 && y>0 && y <squares.length-1){
				valor = coloqueNumbers(x,y);
			}
		}
		return valor;
	}

	private int coloqueNumbers(int x, int y) {
	int valor = 0;
		for(int i= x-1; i<= x+1; i++) {
			for(int j= y-1; j<=y+1; j++) {
				if(squares[i][j].hasMine()) {
					valor++;
				}
			}
		}
		return valor;
	}
	private int AdyacentNumberTopLeft(int x, int y) {
	int valor = 0;
		for(int i= x; i<= x+1; i++) {
			for(int j= y; j<=y+1; j++) {
				if(squares[i][j].hasMine()) {
					valor++;
				}
			}
		}
		return valor;
	}
	private int AdyacentNumberTopRight(int x, int y) {
		int valor = 0;
			for(int i= x; i<= x+1; i++) {
				for(int j= y; j<=y-1; j--) {
					if(squares[i][j].hasMine()) {
						valor++;
					}
				}
			}
			return valor;
		}
	private int AdyacentNumberTop(int x, int y) {
		int valor = 0;
			for(int i= x; i<=x+1; i++) {
				for(int j= y-1; j<=y+1; j++) {
					if(squares[i][j].hasMine()) {
						valor++;
					}
				}
			}
			return valor;
		}

	private int AdyacentNumberLeft(int x, int y) {
	int valor = 0;
		for(int i= x-1; i<= x+1; i++) {
			for(int j= y; j<=y+1; j++) {
				if(squares[i][j].hasMine()) {
					valor++;
				}
			}
		}
		return valor;
}
	private int AdyacentNumberRight(int x, int y) {
		int valor = 0;
			for(int i= x-1; i<= x+1; i++) {
				for(int j= y; j>=y-1; j--) {
					if(squares[i][j].hasMine()) {
						valor++;
					}
				}
			}
			return valor;
		}
	private int AdyacentNumberRightBottom(int x, int y) {
		int valor = 0;
			for(int i= x; i>= x-1; i--) {
				for(int j=y; j>=y-1; j--) {
					if(squares[i][j].hasMine()) {
						valor++;
					}
				}
			}
			return valor;
		}
	private int AdyacentNumberLeftBottom(int x, int y) {
		int valor = 0;
			for(int i= x; i>= x-1; i--) {
				for(int j=y; j<=y+1; j++) {
					if(squares[i][j].hasMine()) {
						valor++;
					}
				}
			}
			return valor;
		}
	private int AdyacentNumberBottom(int x, int y) {
		int valor = 0;
			for(int i= x-1; i<= x+1; i++) {
				for(int j= y; j>=y-1; j--) {
					if(squares[i][j].hasMine()) {
						valor++;
					}
				}
			}
			return valor;
		}
}
