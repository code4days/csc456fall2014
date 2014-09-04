package edu.nku.csc456.pizza.model;

import java.util.Arrays;
import java.util.Optional;

public enum CrustType {

	THIN("thin"),
	HAND_TOSSED("hand tossed"),
	THICK("thick");

	protected String display;
	
	private CrustType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public static CrustType valueOfIgnoreCase(final String crust) {
		Optional<CrustType> option = Arrays.asList(values()).stream()
			.filter(c -> c.toString().equalsIgnoreCase(crust))
			.findFirst();
		
		if( option.isPresent() ) {
			return option.get();
		}
		throw new IllegalArgumentException("Could not find crust: " + crust);
		
	}
	
}
