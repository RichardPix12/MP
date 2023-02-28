package uo.mp.minesweeper.game.actions;

import uo.mp.minesweeper.game.Board;


public class BlowUpAction implements Action{
	
	//Constantes de la clase
	
	
	//Atributos de la clase
	private Board board;
	

	/**
	 * Constructor.
	 * @param board de tipo Board, instancia del tablero a la que se asiocia la
	 * acción
	 */
	public BlowUpAction(Board board) {
		this.board = board;
	}
	
	/**
	 * Pone el tablero como explotado
	 */
	@Override
	public void activate() {
		board.markAsExploded();
	}
}
