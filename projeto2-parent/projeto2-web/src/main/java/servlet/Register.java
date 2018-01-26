package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejb.GeralEJBRemote;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class PlayersTallerThan
 */
// http://localhost:8080/projeto2-web/PlayersTallerThan?fill=1
// url = http://localhost:8080/projeto2-web/PlayersTallerThan?height=1.80
@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    GeralEJBRemote geralejbremote;
    
    private static final Logger LOGGER = Logger.getLogger(Register.class.getName());
    
    String email, password, username;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");                                                                        
        
		if ((email=request.getParameter("email")) != null && 
			(password=request.getParameter("password")) != null &&
			(username=request.getParameter("username")) != null) {
			
			//LOGGER.info("User: "+ email +" and pass "+password+" logged in.");
		    if (geralejbremote.addAccount(username, password, email)) {
		    	
		    	request.getSession().setAttribute("currentEmail", email);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("MyAccount.jsp");
				dispatcher.forward(request, response);
		    	
		    	//out.println("<h1>Login</h1> <br><h2>User: "+ email +" registered.</h2>");
		    	LOGGER.info("User" + email +" successfully registered.");
		    }
		    else {
		    	out.println("<h1>Error</h1> <br><h2>User: "+ email +" and pass "+password+" NOT logged in.</h2>");
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