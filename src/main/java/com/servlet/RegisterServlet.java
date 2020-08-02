package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.helpers.*;
import com.dao.RegisterDao;
import com.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String registeredMessage = "";

		if (request.getParameterMap().size() != 0) {
			
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String email = request.getParameter("email");
			DBManager dbm = (DBManager) getServletContext().getAttribute("TodoDBManager");
			
			
			if(!isValidated(email, pass)) {
				dispatcher(request, response, "Invalid password or email!!!");
				
				
			} else {
				//We encrypt the password
				String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
				User user = new User(name, hashPass, email);
				Boolean isRegistered = new RegisterDao().userCheckDB(dbm,user);
				
				//we check if there is a DB before registration.
				if (isRegistered) {
					dispatcher(request, response, "The e-mail is already exist!");
					
				} else {
					int success = new RegisterDao().registerDB(dbm,user);
					if (success == 1) {
					registeredMessage = "It was registered succesfully!";
					request.setAttribute("registeredMessage", registeredMessage);
					response.sendRedirect("login.jsp");		
										
					} else {
						dispatcher(request, response, "Something goes wrong!");
						
					}
				}
			}

		} else {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
	
	protected Boolean isValidated(String email, String pass) {
		
		//we check the suitability of the mail and the password
	
		return Validator.validateEmail(email) && Validator.validatePassword(pass);
	}

	protected void dispatcher(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
		
		request.setAttribute("registeredMessage", message);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
