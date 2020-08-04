package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helpers.DBManager;
import com.dao.ToDoDao;
import com.entity.ToDo;
import com.entity.User;

/**
 * This servlet retrieves list of todo tasks from the database and sets list as an attribute to request scope if any task is exist
 */
@WebServlet("/user/tasks")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToDoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// This method provides ...
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User owner = (User) request.getSession().getAttribute("user");

		DBManager dbm = (DBManager) getServletContext().getAttribute("TodoDBManager");

		ArrayList<ToDo> todos = ToDoDao.getAllTodo(dbm, owner);
		
		if(todos.size()==0) {
			String messageTask = "You don't have any task.";
			request.setAttribute("messageTask",messageTask);
		
		}else {
			request.setAttribute("todos", todos);
					
		}
		request.getRequestDispatcher("tasks.jsp").forward(request, response);	
	}

}
