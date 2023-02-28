package uo.mp.s1.game.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GameCompactDownTest {
	/**
	 * Test para comprobar el funcionamiento del método que hace que los números
	 * se desplacen hacia abajo.
	 */
	@Test
	public void testCompactDown() {
		//Caso 1:Números arriba y abajo ceros.
		Game2048 game1=new Game2048(); 
		game1.setBoard(GameCodeForTest.SEMIFULL33);
		game1.compactDown();
		assertArrayEquals(GameCodeForTest.SEMIFULL3_DOWNCOMPACTED,game1.getBoard());
		
		//Caso 2:Números abajo.
		Game2048 game2=new Game2048(); 
		game2.setBoard(GameCodeForTest.SEMIFULL31);
		game2.compactDown();
		assertArrayEquals(GameCodeForTest.SEMIFULL31,game2.getBoard());
		
		//Caso 3:Números en el centro y abajo ceros.
		Game2048 game3=new Game2048(); 
		game3.setBoard(GameCodeForTest.SEMIFULL32);
		game3.compactDown();
		assertArrayEquals(GameCodeForTest.SEMIFULL3_DOWNCOMPACTED,game3.getBoard());
		
		//Caso 4:Números en cualquier sitio y abajo números.
		int[][] matrix4a={{2,0,2},{4,4,0},{0,8,8}};
		int[][] matrix4b={{0,0,0},{2,4,2},{4,8,8}};
		Game2048 game4=new Game2048(); 
		game4.setBoard(matrix4a);
		game4.compactDown();
		assertArrayEquals(matrix4b,game4.getBoard());
	}

}
