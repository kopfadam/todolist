package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

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
 * This servlet adds new todo task to Database
 */
@WebServlet("/user/todo")
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTodoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = UUID.randomUUID().toString();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String sdate = request.getParameter("date");
		Boolean status = request.getParameter("status").equals("complete") ? true : false;
		User owner = (User) request.getSession().getAttribute("user");

		ToDo todo = new ToDo(id, title, description, LocalDate.parse(sdate), status, owner);
		DBManager dbm = (DBManager) getServletContext().getAttribute("TodoDBManager");
		int succes = ToDoDao.addTodo(dbm, todo);

		if (succes < 1) {
			String message = "Something goes wrong";
			request.setAttribute("message", message);
			request.getRequestDispatcher("tasks").forward(request, response);
		} else {
			String message = "Added succesfull";
			request.setAttribute("message", message);
			request.getRequestDispatcher("tasks").forward(request, response);
		}
	}

}
