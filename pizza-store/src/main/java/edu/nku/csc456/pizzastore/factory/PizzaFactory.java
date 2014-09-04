package edu.nku.csc456.pizzastore.factory;

import edu.nku.csc456.pizzastore.model.CrustType;
import edu.nku.csc456.pizzastore.model.DefaultPizza;
import edu.nku.csc456.pizzastore.model.Pizza;
import edu.nku.csc456.pizzastore.model.SauceAmount;

public class PizzaFactory {

	public Pizza create(String crust, String sauce) {
		
		if( crust == null || crust.trim().isEmpty() ) {
			throw new IllegalArgumentException("Cannot create a pizza without a crust.");
		} 
		
		if( sauce == null || sauce.trim().isEmpty() ) {
			throw new IllegalArgumentException("Cannot create a pizza without a good sauce.");
		} 
		
		CrustType crustType = CrustType.valueOfIgnoreCase(crust);
		SauceAmount sauceAmount = SauceAmount.valueOfIgnoreCase(sauce);
		
		return new DefaultPizza(crustType, sauceAmount);
	}
	
}
