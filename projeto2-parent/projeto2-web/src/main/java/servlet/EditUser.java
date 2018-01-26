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
import ejb.GeralEJBRemote;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class PlayersTallerThan
 */
// http://localhost:8080/projeto2-web/PlayersTallerThan?fill=1
// url = http://localhost:8080/projeto2-web/PlayersTallerThan?height=1.80
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    AccountEJBRemote accountejbremote;
    
    @EJB
    GeralEJBRemote geralejbremote;
    
    private static final Logger LOGGER = Logger.getLogger(EditUser.class.getName());
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String email, password, username, currentEmail="";
        
        if (request.getSession().getAttribute("currentEmail") != null) {
        	currentEmail = (String) request.getSession().getAttribute("currentEmail");
        
  	  		
			if ((email=request.getParameter("email")) != null && 
				(password=request.getParameter("password")) != null &&
				(username=request.getParameter("username")) != null) {
				
			    if (accountejbremote.editProfile(email, username, password)) {
			    	LOGGER.info("Edited user info.");
			    	RequestDispatcher dispatcher = request.getRequestDispatcher("MyAccount.jsp");
					dispatcher.forward(request, response);
			    }
			}
  	  	}
        else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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