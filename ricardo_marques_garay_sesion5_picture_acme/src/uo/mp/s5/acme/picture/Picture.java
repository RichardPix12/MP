package uo.mp.s5.acme.picture;

import java.io.PrintStream;

import uo.mp.s5.check.Arguments;
import uo.mp.s5.figure.drawable.Drawable;

public class Picture implements Drawable {
	private int x;
	private int y;
	private int width;
	private int height;
	private String fileName;
	
	public Picture(int x, int y, int width, int heigt, String fileName) {
		Arguments.check(x >= 0);
		Arguments.check(y >= 0);
		Arguments.check(width >= 0);
		Arguments.check(heigt >= 0);
		Arguments.check(fileName != null);
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = heigt;
		this.fileName = fileName;
		
	}
	
	@Override
	public void draw(PrintStream out) {
		out.println(toString());
	}

	@Override
	public String toString() {
		return "Picture [x=" + x + ", y=" + y + ", width=" + width + ", height="
				+ height + ", fileName=" + fileName + "]";
	}
	
	
}
