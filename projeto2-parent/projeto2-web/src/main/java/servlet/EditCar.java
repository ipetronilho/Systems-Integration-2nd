package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
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
@WebServlet("/EditCar")
public class EditCar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    CarsEJBRemote carsejbremote;
    
    @EJB
    GeralEJBRemote geralejbremote;
    
    private static final Logger LOGGER = Logger.getLogger(CreateCar.class.getName());
    
    String arg1, arg2, searchMode, order;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCar() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        // TODO: tirar esta inicialização
        String currentEmail="joaoc@gmail.com", currentPassword="";
        
        Cookie[] cookies = request.getCookies();
        String email, password;
        String paramType="", newParam="";

        if (request.getSession().getAttribute("currentEmail") != null) {
        	currentEmail = (String) request.getSession().getAttribute("currentEmail");
        
	    	
        	String id = request.getParameter("id");
        
  	  		if 	((newParam=request.getParameter("brand")) != null) {
  	  			paramType="brand";
  	  		}
  	  		else if ((newParam=request.getParameter("price")) != null) {
  	  			paramType="price";
	  		}
  	  		else if ((newParam=request.getParameter("date")) != null) {
	  			paramType="date";
  	  		}
  	  		else if ((newParam=request.getParameter("kilometers")) != null) {
  	  			paramType="kilometers";
  	  		}
  	  		
  			LOGGER.info("Updating car...");
  			carsejbremote.editCar(paramType, newParam, id);
  			LOGGER.info("Done!");
  	  	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}