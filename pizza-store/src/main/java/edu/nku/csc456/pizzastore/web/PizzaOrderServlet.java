
package edu.nku.csc456.pizzastore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nku.csc456.pizzastore.factory.PizzaFactory;
import edu.nku.csc456.pizzastore.model.Pizza;
import edu.nku.csc456.pizzastore.model.PizzaTopping;

public class PizzaOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = -9026575645772230413L;

	private PizzaFactory factory;
	
	@Override
	public void init() throws ServletException {
		super.init();
		factory = new PizzaFactory();
	}
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("order.html");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException {
		
		String crust = request.getParameter("crust");
		String sauce = request.getParameter("sauce");
		
		Pizza pizza = factory.create(crust, sauce);
		
		if( request.getParameterValues("toppings") != null ) {
			 String toppings = Arrays
				.asList(request.getParameterValues("toppings"))
				.stream()
				.collect(Collectors.joining(", "));
			 
			 //decorate pizza with toppings
			 pizza = new PizzaTopping(pizza, toppings);
		}
		
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html><head><title>Pizza Store</title><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!-- Latest compiled and minified CSS -->");
		out.append("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		out.append("<!-- Optional theme -->	<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\">");
		out.append("<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->    <!-- WARNING: Respond.js doesn't work if you view the page via file:// --><!--[if lt IE 9]>");
		out.append("<script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script><script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>");
		out.append("<![endif]--></head><body><div class=\"container\"><nav class=\"navbar navbar-default\" role=\"navigation\">");
		out.append("<div class=\"container-fluid\"><!-- Brand and toggle get grouped for better mobile display --><div class=\"navbar-header\">");
		out.append("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"><span class=\"sr-only\">Toggle navigation</span><span class=\"icon-bar\"></span>");
		out.append("<span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a class=\"navbar-brand\" href=\"place-order\">Pizza Store</a></div>");
		out.append("<!-- Collect the nav links, forms, and other content for toggling --><div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\"><ul class=\"nav navbar-nav\"><li><a href=\"place-order\">Home</a></li></ul>");
		out.append("</div><!-- /.navbar-collapse --></div><!-- /.container-fluid --></nav><div>");
		out.append("<h1><div class=\"row\"><div class=\"col-lg-4\">Receipt</div></div></h1></div>");
		out.append("<div class=\"row\"><div class=\"col-lg-12\">Thank you for order!<br><br>Here is your pizza: ");

		out.append(pizza.getDisplay());
		
		out.append("</div></div><br><!-- Site footer --><div class=\"footer\"><p>&copy; Company 2014</p></div>    </div> <!-- /container -->");
		out.append("<!-- Bootstrap core JavaScript ================================================== --><!-- Placed at the end of the document so the pages load faster --><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->");
		out.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script><!-- Latest compiled and minified JavaScript --><script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script></body></html>");
	}
}