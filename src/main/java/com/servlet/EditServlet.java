package com.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ToDoDao;
import com.entity.ToDo;
import com.helpers.DBManager;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/user/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DBManager dbm = (DBManager) getServletContext().getAttribute("TodoDBManager");
				
		if(request.getParameterMap().size() == 1) {				
			ToDo todo = ToDoDao.getTodo(dbm, id);
			request.setAttribute("todo", todo);
			request.getSession().setAttribute("id", id);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} else {
			String id2 = (String) request.getSession().getAttribute("id");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String sdate = request.getParameter("date");
			Boolean status = request.getParameter("status").equals("complete")?true:false;
		
			ToDo todo = new ToDo(id2,title,description,LocalDate.parse(sdate),status);
			int success = ToDoDao.editTodo(dbm, todo);
					
			if(success == 1) {
				response.sendRedirect("tasks");
			} else {
				String updateMessage = "Something is wrong!!";
				request.setAttribute("updateMessage", updateMessage);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
		}
	}

}
