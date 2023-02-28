package uo.mp.newsstand.domain;

public class NewsPaper extends Publication {

	public NewsPaper(String name, int stock, int sales) {
		super(name, stock, sales);
	}

	@Override
	public Order order() {
		return new Order(getName(), getSales() + (getStock() * 2));
	}

	@Override
	public String serialize() {
		return "newspaper" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales(); 
	}
}
