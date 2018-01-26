package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.AccountEJBRemote;
import ejb.CarsEJBRemote;
import ejb.GeralEJBRemote;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class PlayersTallerThan
 */
// http://localhost:8080/projeto2-web/PlayersTallerThan?fill=1
// url = http://localhost:8080/projeto2-web/PlayersTallerThan?height=1.80
@WebServlet("/SearchCars")
public class SearchCars extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    CarsEJBRemote carsejbremote;
    
    @EJB
    GeralEJBRemote geralejbremote;
    
    private static final Logger LOGGER = Logger.getLogger(EditUser.class.getName());
    
    String arg1, arg2, searchMode, order, currentEmail;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCars() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("currentEmail") != null) {
        	currentEmail = (String) request.getSession().getAttribute("currentEmail");
	    	PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	       
	  		// search brand + model
	  		if ((arg1=request.getParameter("brand")) != null) {
	  	  		arg2=request.getParameter("model");
	  	  		searchMode="BRAND";
	  		}
	  		// search by kms
	  		else if ((arg1=request.getParameter("kmI")) != null) {
	  	  		arg2=request.getParameter("kmF");
	  	  		searchMode="KILOMETERS";
	  		}
	  		
	  		// search by price
	  		else if ((arg1=request.getParameter("priceI")) != null) {
	  	  		arg2=request.getParameter("priceF");
	  	  		searchMode="PRICE";
	  		}
	  		
	  		// search by date
	  		else if ((arg1=request.getParameter("date")) != null) {
	  	  		searchMode="DATE";
	  		}
	  		
	  		else if ((arg1=request.getParameter("user")) != null) {
	  	  		searchMode="USER";
	  		}
	  		
	  		else {
	  			searchMode="ALL";
	  		}
	  		
	  		order = request.getParameter("order");
	  		
	  		out.println(carsejbremote.listCars(arg1, arg2, searchMode, order));
    	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    	if (request.getAttribute("currentEmail")!=null) {
	    	ArrayList <String> listCars = carsejbremote.listCars(null, null, "ALL", "");
	    	request.setAttribute("cars", listCars);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("SearchCars.jsp");
			dispatcher.forward(request, response);
    	}
    }

}