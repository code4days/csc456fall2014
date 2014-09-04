package edu.nku.csc456.pizzastore.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CrustType {

	THIN("thin crust"),
	HAND_TOSSED("hand tossed crust"),
	THICK("thick crust");
	
	private String display;
	
	private CrustType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public static CrustType valueOfIgnoreCase(String crust) {
		List<CrustType> possibleTypes = Arrays.asList(values()).stream()
			.filter(type -> type.toString().equalsIgnoreCase(crust) )
			.collect(Collectors.toList());
		if( possibleTypes.isEmpty() ) {
			throw new IllegalArgumentException("Not a recognized crust type: " + crust);
		} else {
			return possibleTypes.get(0);
		}
	}
}
