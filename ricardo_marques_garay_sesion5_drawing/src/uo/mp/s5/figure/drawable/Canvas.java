package uo.mp.s5.figure.drawable;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;




public class Canvas {
	private List< Drawable > drawables = new ArrayList<>();

	public void add(Drawable drawable) {
		drawables.add(drawable);
	}

	public void draw(PrintStream out) {
		for (Drawable shape: drawables) {
			shape.draw(out);
		}
	}
}
