package uo.mp.s5.shapes;

import uo.mp.s5.check.Arguments;

public class Circle extends Shape {

	private int radious;


	public Circle(int x, int y, int radious, Colour colour) {
		super(x, y, colour);
		Arguments.check(radious >= 0);
		this.radious = radious;


	}

	public int getRadious() {
		return radious;
	}

	@Override
	public String toString() {
		return "Circle [x=" + getX() + ", y=" + getY() + ", colour=" + 
					getColour() + ", radious=" + getRadious() + "]";
	}

}
