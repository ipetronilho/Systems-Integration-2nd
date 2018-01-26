package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/FollowCar")
public class FollowCar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    CarsEJBRemote carsejbremote;
    
    @EJB
    AccountEJBRemote userejbremote;
    
    private static final Logger LOGGER = Logger.getLogger(FollowCar.class.getName());
    
    String currentEmail, car_id;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowCar() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        

        if (request.getSession().getAttribute("currentEmail") != null) {
        	currentEmail = (String) request.getSession().getAttribute("currentEmail");
        	
        	if ((car_id=request.getParameter("car_id")) != null) {
        	   	String car_id = request.getParameter("car_id");
	        	userejbremote.followCar(currentEmail, Integer.parseInt(car_id));
	        	carsejbremote.addFollower(currentEmail, Integer.parseInt(car_id));
				LOGGER.info("Car added successfully.");
        	}
        }
        else {
        	LOGGER.info("User logged out.");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("MyAccount.jsp");
			dispatcher.forward(request, response);
        }
  	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}