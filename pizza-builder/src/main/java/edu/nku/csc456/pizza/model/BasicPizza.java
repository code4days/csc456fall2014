package edu.nku.csc456.pizza.model;

public class BasicPizza 
	implements Pizza {

	CrustType crust;
	String sauce;
	
	public BasicPizza(CrustType crust, String sauce) {
		this.crust = crust;
		this.sauce = sauce;
	}
	
	/**
	 * returns a string of the following format:
	 * 	<sauce> on a <crust type> crust
	 * 	example: light sauce on a thin crust
	 */
	@Override
	public String getDisplay() {
		StringBuilder sb = new StringBuilder();
		sb.append(sauce);
		sb.append(" sauce on a ");
		sb.append(crust.getDisplay());
		sb.append(" crust");
		return sb.toString();
	}
	
}
