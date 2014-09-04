package edu.nku.csc456.pizza.factory;

public class SauceFactory {

	public String create(String sauce) {
		switch (sauce) {
		case "light":
			return "light";
		case "normal":
			return "regular";
		default:
			return "extra";
		}
	}

}
