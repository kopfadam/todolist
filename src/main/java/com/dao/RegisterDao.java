package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.helpers.DBManager;
import com.entity.User;

public class RegisterDao {
	
	public int registerDB(DBManager dbm, User user) {

		
		String query ="insert into user values(?,?,?,?)";
		int success = 0;
		
		try {		
			PreparedStatement ps = dbm.getConnection().prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());			
						
			
			success = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return success;
	}
	
	public Boolean userCheckDB(DBManager dbm, User user) {

		boolean isRegistered = false;

		
		try {

			String query = "SELECT Count(*) FROM user WHERE email=?";

			PreparedStatement statement = dbm.getConnection().prepareStatement(query);
			statement.setString(1, user.getEmail());

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int numberOfRows = rs.getInt(1);
				if (numberOfRows == 1) {
					isRegistered = true;
				} else if (numberOfRows == 0) {
					isRegistered = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isRegistered;
	}
	


}
