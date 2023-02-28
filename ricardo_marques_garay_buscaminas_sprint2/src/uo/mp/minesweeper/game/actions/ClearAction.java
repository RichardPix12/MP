 package uo.mp.minesweeper.game.actions;

import java.util.List;

import uo.mp.minesweeper.game.Square;

public class ClearAction implements Action {
	
	private List<Square> listSquares;
	
	
	
	/**
	 * Constructor. 

	 * @param ls de tipo List<Square>
	 */
	public ClearAction(List<Square> ls) {
		this.listSquares = ls;
	}

	@Override
	public void activate() {
		for(Square sq: listSquares) {
			sq.open();
		}
	
		
	}

}
