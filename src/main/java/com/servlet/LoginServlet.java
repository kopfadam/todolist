package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.entity.User;
import com.helpers.DBManager;
import com.helpers.Validator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// get DBManager instance from servlet context
		DBManager dbm = (DBManager) getServletContext().getAttribute("TodoDBManager");
		User user = null;

		// 1.if the user send his/her email and password as parameters via form, assign them to String variables
		//   if a request comes without parameter send user to login page.
		// 2.check if the email and password are both valid
		// 3.call dao class' getUser() method that returns a user object after querying from the database.
		// 4.if there is a registered user, set this object to session in order to make session operations easily.
		// 5.redirect to tasks servlet.
		if (!request.getParameterMap().isEmpty()) {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			if (Validator.validateEmail(email) && Validator.validatePassword(pass)) {
				user = LoginDao.getUser(dbm, email, pass);
				if (user != null) {
					request.getSession().setAttribute("user", user);
					response.sendRedirect("user/tasks");
				} else {
					dispatcher(request, response, "Wrong email or password");
				}
			} else {
				dispatcher(request, response, "Invalid email or password");
			}
		} else if (request.getSession().getAttribute("user") != null)
			response.sendRedirect("index.jsp");
		else
			request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	//a helper method to use for increasing readability
	private void dispatcher(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("message", message);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
