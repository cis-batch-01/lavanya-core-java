package com.technocis.corejava;

public class Movie {

	private String name;
	private double boxoffice;
	private double budget;
	private double rating;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBoxoffice() {
		return boxoffice;
	}
	public void setBoxoffice(double boxoffice) {
		this.boxoffice = boxoffice;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	public Movie() {
		super();

	}
	
	
	public Movie(String name, double boxoffice, double budget, double rating) {
		super();
		this.name = name;
		this.boxoffice = boxoffice;
		this.budget = budget;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "name=" + name + "\n boxoffice=" + boxoffice + "\nbudget=" + budget + "\nrating=" + rating;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Movie other = (Movie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}
	
	
}
