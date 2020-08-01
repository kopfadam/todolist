package com.dao;

import java.sql.PreparedStatement;

import com.DBHelpers.DBManager;
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


}
