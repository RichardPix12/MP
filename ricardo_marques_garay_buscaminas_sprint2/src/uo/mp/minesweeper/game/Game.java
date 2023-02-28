package uo.mp.minesweeper.game;

import java.util.Scanner;

public class Game {

	// Constantes de la clase

	// Atributos de la clase
	private Board game;

	/**
	 * Constructor del juego
	 * 
	 * @param board2 de tipo Board, el tablero del juego
	 */
	public Game(Board theBoard) {
		this.game = theBoard;
	}

	/**
	 * Metodo que inicializa el juego
	 */
	public void play() {

		Scanner sc = new Scanner(System.in);
		do {
			long referenceTime = System.currentTimeMillis();
			System.out.println("Bienvenido al Buscaminas");
			do {

				System.out.println("Elige: destapar la casilla [S s], ponerle"
						+ "una bandera [F f], o quitarle una bandera [U u]");

				switch (sc.next()) {
				case "S":
				case "s":
					System.out.println("Introduce la posición x(1-9)");
					int x = sc.nextInt();
					System.out.println("Introduce la posición y(1-9)");
					int y = sc.nextInt();
					game.stepOn(x - 1, y - 1);
					long finalTimeS = System.currentTimeMillis();
					long totalTimeS = finalTimeS - referenceTime;
					System.out.println("Banderas que faltan:" + game.getFlagsLeft());
					System.out.println("Time: " + totalTimeS / 1000 + " segundos");
					System.out.println(game.toString());
					break;
				case "F":
				case "f":
					System.out.println("Introduce la posición x(1-9)");
					int a = sc.nextInt();
					System.out.println("Introduce la posición y(1-9)");
					int b = sc.nextInt();
					game.flag(a - 1, b - 1);
					long finalTimeF = System.currentTimeMillis();
					long totalTimeF = finalTimeF - referenceTime;
					System.out.println("Banderas que faltan:" + game.getFlagsLeft());
					System.out.println("Time: " + totalTimeF / 1000 + " segundos");
					System.out.println(game.toString());
					break;
				case "U":
				case "u":
					System.out.println("Introduce la posición x(1-9)");
					int c = sc.nextInt();
					System.out.println("Introduce la posición y(1-9)");
					int d = sc.nextInt();
					game.unFlag(c - 1, d - 1);
					long finalTimeU = System.currentTimeMillis();
					long totalTimeU = finalTimeU - referenceTime;
					System.out.println("Banderas que faltan:" + game.getFlagsLeft());
					System.out.println("Time: " + totalTimeU / 1000 + " segundos");
					System.out.println(game.toString());
					break;

				case "R":
				case "r":
					game.unveil();

				}

			} while (!game.isBoardExploded());
			long finalTime = System.currentTimeMillis();
			long totalTime = finalTime - referenceTime;
			System.out.println("BOOOOOOOOOOOM");
			System.out.println("Banderas que faltan:" + game.getFlagsLeft());
			System.out.println("Time: " + totalTime / 1000 + " segundos");
			System.out.println(game.toString());
			System.out.print("¿Quieres reintentarlo? s/n: ");

		} while (sc.next() == "s");
		sc.close();
	}

}
