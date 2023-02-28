package uo.mp.minesweeper.util;

public class Check {
	public static void checkParams(boolean condition, String str) {
		if(condition) {
			throw new IllegalArgumentException(str);
		}
	}
}
