package uo270160.mp.s3.dome.model;

import java.io.PrintStream;

public class Item {

	private String title;
	private int playingTime;
	private boolean gotIt;
	private String comment;

	public Item(String title, int playingTime) {
		super();
		setTitle(title);
		setPlayingTime(playingTime);
		setOwn(false);
		setComment("No comment");
	}

	protected void setTitle(String title) {
		checkParameter(title == null, "No es valido, el titulo es null");
		checkParameter(title.trim().length() == 0, "No es valido, el titulo es vacio");
		this.title = title;

	}

	protected void setPlayingTime(int playingTime) {
		if (playingTime > 0) {
			this.playingTime = playingTime;
		}
	}

	public void setOwn(boolean ownIt) {
		gotIt = ownIt;
	}

	public void setComment(String comment) {
		if (comment != null) {
			this.comment = comment;
		}
	}

	public String getComment() {
		return comment;
	}

	public boolean getOwn() {
		return gotIt;
	}

	public String getTitle() {
		return this.title;
	}

	public int getPlayingTime() {
		return this.playingTime;
	}

	protected void checkParameter(boolean condition, String str) {
		if (condition) {
			throw new IllegalArgumentException(str);
		}

	}

	public void print(PrintStream out) {
	
		
	}

}