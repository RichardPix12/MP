package uo.mp.minesweeper.game;



import uo.mp.minesweeper.game.actions.Action;

import uo.mp.minesweeper.util.Check;

public class Square {

	// Constantes de la clase
	public static final int EMPTY_SQUARE = 0;
	public static final int MAX_SQUARE = 8;
	public static final int MIN_SQUARE = -1;
	public static final int MINE_SQUARE = -1;
	// Atributos de la Clase
	private State state;
	private int value;
	private Action action;

	/**
	 * Constructor de la clase
	 * 
	 * @param theState  de tipo state
	 * @param theNumber de tipo int
	 */
	public Square(State theState, int theValue) {
		setState(theState);
		setValue(theValue);
	}

	public void setValue(int theValue) {
		Check.checkParams(theValue < MINE_SQUARE && theValue > MAX_SQUARE,
				"Parámetro inválido");
		this.value = theValue;

	}

	public int getValue() {
		return value;
	}

	private void setState(State theState) {
		this.state = theState;
	}

	public State getState() {
		return state;
	}

	/**
	 * Metodo que pone una casilla en open si esta CLOSED
	 */
	public void setpOn() {
		if (getState() == State.CLOSED) {
			setState(State.OPEN);
			activateAction();

		}
	}

	/**
	 * Método que devuelve el carácter que representa la casilla
	 */
	public String toString() {
		String str = "";
		if (getState() == State.CLOSED) {
			str += "#";
		} else if (getState() == State.OPEN) {
			if (getValue() == 0) {
				str += " ";
			} else if (getValue() == MINE_SQUARE) {
				str += "@";
			} else {
				str += getValue();
			}
		} else if (getState() == State.FLAGGED) {
			str += Character.toString((char) 182);
		}
		return str;
	}

	/**
	 * Metodo que si la casilla esta cerrada pasa a FLAGGED
	 */
	public void flag() {

		if (getState() == State.CLOSED) {
			setState(State.FLAGGED);
		}
	}

	/**
	 * Metodo que si la casilla esta FLAGGED para a CLOSED
	 */
	public void unFlag() {

		if (getState() == State.FLAGGED) {
			setState(State.CLOSED);
		}
	}

	/**
	 * Método que pasa la casilla a OPEN incodicionalmente
	 */
	public void open() {
		setState(State.OPEN);
	}

	/**
	 * Metodo para saber si la casilla tiene una mina
	 * 
	 * @return true si tiene mina de tipo boolean
	 * @return false si no tiene mina de tipo boolean
	 */
	public boolean hasMine() {
		if (getValue() == MINE_SQUARE) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para colocar una mina en la casilla
	 */
	public void putMine() {
		setValue(MINE_SQUARE);
	}

	/**
	 * Metodo para saber si la casilla esta FLAGGED o no
	 * 
	 * @return true si esta flagged, de tipo boolean
	 * @return flase si no esta flagged, de tipo boolean
	 */
	public boolean hasFlag() {
		if (getState() == State.FLAGGED) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para saber si la casilla esta OPEN o no
	 * 
	 * @return true si esta open, de tipo boolean
	 * @return false si no esta open, de tipo boolean
	 */
	public boolean isOpen() {
		if (getState() == State.OPEN) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	private void activateAction() {
		action.activate();
	}
	


 
	
}
