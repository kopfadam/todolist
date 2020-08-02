package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.entity.User;
import com.helpers.DBManager;

public class LoginDao {
	
	//A method to check if a user is in the database. If finds a user, returns the user name and email. 
	public static User getUser(DBManager dbm, String email, String pass) {
		User user = null;
		
		String query = "select * from user where email=?";
		
		try {
			PreparedStatement ps = dbm.getConnection().prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//use BCrypt checkpw() method to check if hash values are same
				if(BCrypt.checkpw(pass, rs.getString("password"))) {
					user = new User(rs.getNString("name"), rs.getString("email"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
