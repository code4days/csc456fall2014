package edu.nku.csc456.pizzastore.model;

public class PizzaTopping implements Pizza {

	private Pizza pizza;
	private String topping;
	
	public PizzaTopping(Pizza pizza, String topping) {
		this.pizza = pizza;
		this.topping = topping;
	}
	

	@Override
	public String getDisplay() {
		StringBuilder sb = new StringBuilder();
		sb.append(topping);
		sb.append(", ");
		sb.append(pizza.getDisplay());
		return sb.toString();
	}
	
}
