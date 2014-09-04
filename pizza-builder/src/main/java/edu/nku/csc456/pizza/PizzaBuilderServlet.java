package edu.nku.csc456.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nku.csc456.pizza.factory.SauceFactory;
import edu.nku.csc456.pizza.model.BasicPizza;
import edu.nku.csc456.pizza.model.CrustType;
import edu.nku.csc456.pizza.model.Pizza;

public class PizzaBuilderServlet 
	extends HttpServlet {

	private static final long 
		serialVersionUID = 1L;

	SauceFactory factory;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		factory = new SauceFactory();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String value = config.getInitParameter("hello");
		System.out.println(value);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		factory = null;
	}

	@Override
	protected void doPost(
			HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, 
					IOException {
		
		CrustType crust = CrustType.valueOfIgnoreCase(req.getParameter("crust"));
		String sauce = req.getParameter("sauce");
		
		Pizza pizza = new BasicPizza(crust, factory.create(sauce));
		
		String[] toppings = req.getParameterValues("toppings");
		
		PrintWriter out = resp.getWriter();

		out.append("You ordered ");
		String tops = Arrays.asList(toppings)
			.stream()
			.collect(Collectors.joining(", "));
		out.append(tops);
		out.append(", " + " " + pizza.getDisplay());
	}
	
}
