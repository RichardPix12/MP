package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp.s5.check.Arguments;
import uo.mp.s5.figure.drawable.Drawable;

public class Shape implements Drawable {

	private int x;
	private int y;
	private Colour colour;


	public Shape(int x, int y, Colour colour) {
		Arguments.check(x >= 0);
		Arguments.check(y >= 0);
		Arguments.check(colour != null);
		this.x = x;
		this.y = y;
		this.colour = colour;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Colour getColour() {
		return colour;
	}


	public void draw(PrintStream out) {
		out.println(this.toString());
		
	}

}