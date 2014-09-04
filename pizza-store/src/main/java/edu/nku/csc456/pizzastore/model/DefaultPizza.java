package edu.nku.csc456.pizzastore.model;

public class DefaultPizza implements Pizza {

	private CrustType crustType;
	private SauceAmount sauceAmount;
	
	public DefaultPizza(CrustType crustType, SauceAmount sauceAmount) {
		this.crustType = crustType;
		this.sauceAmount = sauceAmount;
	}

	/**
	 * 
	 * default pizza display looks like: 
	 * 		"light sauce on a thin crust"
	 * 
	 */
	@Override
	public String getDisplay() {
		StringBuilder sb = new StringBuilder();
		sb.append(sauceAmount.getDisplay());
		sb.append(" on a ");
		sb.append(crustType.getDisplay());
		return sb.toString();
	}
	
}
