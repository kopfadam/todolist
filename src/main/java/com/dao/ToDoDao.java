package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helpers.DBManager;
import com.helpers.DateConvert;
import com.entity.ToDo;
import com.entity.User;

public class ToDoDao {

	public static ToDo getTodo(DBManager dbm, String id) {

		ToDo todo = null;

		try {

			String query = "select id,title,description,date,status,owner from todo where id =?";

			PreparedStatement ps = dbm.getConnection().prepareStatement(query);

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				todo = new ToDo(rs.getString("title"), rs.getString("description"),
						DateConvert.getUtilDate(rs.getDate("date")), rs.getBoolean("status"));

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return todo;
	}

	public static ArrayList<ToDo> getAllTodo(DBManager dbm, User owner) {

		ArrayList<ToDo> todos = new ArrayList<>();

		try {

			String query = "select * from todo where owner=? order by date asc";

			PreparedStatement ps = dbm.getConnection().prepareStatement(query);

			ps.setString(1, owner.getEmail());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ToDo todo = new ToDo(rs.getString("id"), rs.getString("title"), rs.getString("description"),
						DateConvert.getUtilDate(rs.getDate("date")), rs.getBoolean("status"));
				todos.add(todo);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return todos;
	}

	public static int addTodo(DBManager dbm, ToDo todo) {
		int success = 0;

		try {

			String query = "INSERT INTO todo(id,title, description, date, status, owner) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = dbm.getConnection().prepareStatement(query);

			ps.setString(1, todo.getId());
			ps.setString(2, todo.getTitle());
			ps.setString(3, todo.getDescription());
			ps.setDate(4, DateConvert.getSQLDate(todo.getTodoDate()));
			ps.setBoolean(5, todo.getTodoStatus());
			ps.setString(6, todo.getOwner().getEmail());

			success = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return success;

	}

	public static int deleteTodo(DBManager dbm, String id) {

		int success = 0;

		try {

			String query = "delete from todo where id = ?";

			PreparedStatement ps = dbm.getConnection().prepareStatement(query);

			ps.setString(1, id);

			success = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return success;
	}

	public static int editTodo(DBManager dbm, ToDo todo) {
		int success = 0;

		try {

			String query = "update todo set title = ?,description =?, date =?, status= ? where id = ?";

			PreparedStatement ps = dbm.getConnection().prepareStatement(query);

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getDescription());
			ps.setDate(3, DateConvert.getSQLDate(todo.getTodoDate()));
			ps.setBoolean(4, todo.getTodoStatus());
			ps.setString(5, todo.getId());

			success = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return success;
	}

}
