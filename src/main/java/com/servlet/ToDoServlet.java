package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;

/**
 * Servlet implementation class ToDoServlet
 */
@WebServlet("/user/tasks")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToDoServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}

	// This method provides ...
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User owner = (User) request.getSession().getAttribute("user");
		
	}

}
