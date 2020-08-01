package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helpers.DBManager;
import com.entity.ToDo;
import com.entity.User;

public class ToDoDao {
	
	public static  ArrayList<ToDo> getAllTodo(DBManager dbm, User owner) {

		ArrayList<ToDo> todos = new ArrayList<>();

		try {
		
			String query = "select * from todo where owner=? order by date asc";

			PreparedStatement ps = dbm.getConnection().prepareStatement(query);

			ps.setString(1, owner.getEmail());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				ToDo todo = new ToDo(rs.getString("id"),rs.getString("title"),rs.getString("description"),DateConvert.getUtilDate(rs.getDate("date")),rs.getBoolean("status"));
				todos.add(todo);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return todos;
	}

}
