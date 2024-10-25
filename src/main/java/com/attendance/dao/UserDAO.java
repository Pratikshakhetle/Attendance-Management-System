package com.attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.attendance.Database.Database;
import com.attendance.model.User;

public class UserDAO {

	public User validateUser(String username, String password) throws SQLException{
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (Connection conn = Database.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setUsername(rs.getString("username"));
	                return user;
	            }
	        }
		return null;
	}

}
