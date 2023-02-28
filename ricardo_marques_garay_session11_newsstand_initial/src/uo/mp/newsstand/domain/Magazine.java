package uo.mp.newsstand.domain;

import uo.mp.util.checks.ArgumentChecks;

public class Magazine extends Publication {
	public static int WEEK = 7;
	public static int MIN_STOCK = 5;
	public static int MIN_ORDER = 20;

	private int periodicity;

	public Magazine(String name, int stock, int sales, int regularity) {
		super(name, stock, sales);
		ArgumentChecks.isTrue( regularity > 0);
		this.periodicity = regularity;
	}

	public int getPeriodicity() {
		return periodicity;
	}

	public String toString() {
		return super.toString() + "\t" + getPeriodicity();
	}

	@Override
	public String serialize() {
		return "magazine" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales() 
				+ "\t" + getPeriodicity();
	}

	@Override
	public Order order() {
		if (getStock() < MIN_STOCK) {
			return new Order(this.getName(), MIN_ORDER);
		} else {
			if (getPeriodicity() == WEEK) {
				return new Order(this.getName(), getSales());
			} else {
				return new Order(this.getName(), getSales() + getStock());
			}
		}
	}

}
