package uo.mp.newsstand.domain;

import uo.mp.util.checks.ArgumentChecks;

public abstract class Publication implements Comparable<Publication> {
	private String name;
	private int stock;
	private int sales;

	public Publication(String name, int stock, int sales) {
		ArgumentChecks.isTrue( name != null );
		ArgumentChecks.isTrue( name.trim().isEmpty() == false );
		ArgumentChecks.isTrue( stock > 0 );
		ArgumentChecks.isTrue( sales > 0 );
		this.name = name;
		this.stock = stock;
		this.sales = sales;
	}

	public abstract Order order();
	public abstract String serialize();

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}

	public int getSales() {
		return sales;
	}

	public String toString() {
		return getName() + "\t" + getStock() + "\t" + getSales();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Publication other) {
		if(this.getName().compareTo(other.getName())> 0) {
			return 1;
		}
		else {
			return -1;		
		}
	}
}
