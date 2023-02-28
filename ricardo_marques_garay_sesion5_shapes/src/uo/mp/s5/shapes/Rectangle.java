package uo.mp.s5.shapes;

import uo.mp.s5.check.Arguments;

/**
 * A rectangle specifies an area in a coordinate space that is enclosed by the
 * the rectangle upper-left point (x, y) in the coordinate space, its width, and
 * its height.
 */
public class Rectangle extends Shape {
	/**
	 * The width of the rectangle, in pixels.
	 */
	private int width;


	/**
	 * The height of the rectangle, in pixels.
	 */
	private int height;

	public Rectangle(int x, int y, int width, int height, Colour colour) {		
		super(x,y,colour);		
		Arguments.check(width >= 0);
		Arguments.check(height >= 0);	
		this.width = width;
		this.height = height;

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + getX() + ", y=" + getY() + ", width=" + 
				getWidth() + ", height=" + getHeight() + ", colour=" 
				+ getColour() + "]";
	}

}
