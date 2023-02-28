package uo.mp.s1.game.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GameCompactUpTest {
	/**
	 * Test para comprobar el funcionamiento del método que hace que los números
	 * se desplacen hacia arriba.
	 */
	@Test
	public void testCompactUp() {
		//Caso 1:Números abajo y arriba ceros.
		Game2048 game1=new Game2048(); 
		game1.setBoard(GameCodeForTest.SEMIFULL31);
		game1.compactUp();
		assertArrayEquals(GameCodeForTest.SEMIFULL3_UPCOMPACTED,game1.getBoard());
		
		//Caso 2:Números arriba.
		Game2048 game2=new Game2048(); 
		game2.setBoard(GameCodeForTest.SEMIFULL33);
		game2.compactUp();
		assertArrayEquals(GameCodeForTest.SEMIFULL33,game2.getBoard());
		
		//Caso 3:Números en el centro y a arriba ceros.
		Game2048 game3=new Game2048(); 
		game3.setBoard(GameCodeForTest.SEMIFULL32);
		game3.compactUp();
		assertArrayEquals(GameCodeForTest.SEMIFULL3_UPCOMPACTED,game3.getBoard());
		
		//Caso 4:Números en cualquier sitio y arriba números.
		int[][] matrixa={{2,0,2},{4,4,0},{0,8,8}};
		int[][] matrixb={{2,4,2},{4,8,8},{0,0,0}};
		Game2048 game4=new Game2048(); 
		game4.setBoard(matrixa);
		game4.compactUp();
		assertArrayEquals(matrixb,game4.getBoard());
	}
}
