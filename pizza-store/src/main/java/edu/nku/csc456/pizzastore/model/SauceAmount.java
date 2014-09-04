package edu.nku.csc456.pizzastore.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SauceAmount {

	LIGHT("light sauce"),
	NORMAL("regular sauce"),
	EXTRA("extra sauce");
	
	private String display;
	
	private SauceAmount(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public static SauceAmount valueOfIgnoreCase(String sauce) {
		List<SauceAmount> possibleTypes = Arrays.asList(values()).stream()
			.filter(type -> type.toString().equalsIgnoreCase(sauce) )
			.collect(Collectors.toList());
		if( possibleTypes.isEmpty() ) {
			throw new IllegalArgumentException("Not a recognized sauce: " + sauce);
		} else {
			return possibleTypes.get(0);
		}
	}

}
