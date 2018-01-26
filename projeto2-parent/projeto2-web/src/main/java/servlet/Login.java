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

import ejb.CarsEJBRemote;
import ejb.GeralEJBRemote;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class PlayersTallerThan
 */
// http://localhost:8080/projeto2-web/PlayersTallerThan?fill=1
// url = http://localhost:8080/projeto2-web/PlayersTallerThan?height=1.80
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    GeralEJBRemote geralejbremote;
    
    @EJB
    CarsEJBRemote ejbremote;
    
    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    
    String emailUser, password;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.info("I just reached the Login function.");

    	
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        //ejbremote.populate();
        
		if ((emailUser=request.getParameter("email")) != null && 
			(password=request.getParameter("password")) != null) {
			
			LOGGER.info("Checking user "+emailUser+" and password "+password);
		    if (geralejbremote.login(emailUser, password)) {
		    	
		    	// out.println("<h1>Login</h1> <br><h2>User: "+ emailUser +" and pass "+password+" logged in.</h2>");

		    	LOGGER.info("User logged in.");
		    	request.getSession().setAttribute("currentEmail", emailUser);
		    	
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("MyAccount.jsp");
				dispatcher.forward(request, response);
		    }
		    else {
		    	out.println("<h1>Error</h1> <br><h2>User: "+ emailUser +" and pass "+password+" NOT logged in.</h2>");
		    	LOGGER.info("Error validating login for user.");
		    }
		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}