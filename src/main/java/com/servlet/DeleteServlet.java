package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helpers.*;
import com.dao.ToDoDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/user/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DBManager dbm = (DBManager) getServletContext().getAttribute("TodoDBManager");
		int isDelete = ToDoDao.deleteTodo(dbm, id);
		
		if(isDelete == 1) {
			response.sendRedirect("tasks");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
