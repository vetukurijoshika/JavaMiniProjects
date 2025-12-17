package com.jos.dao;
import java.util.*;

import com.jos.model.UserModel;

import java.sql.*; 

public class UserDAO {
	public void addUser(UserModel user) {
		String sql = "insert into user (firstname, lastname, phoneno,email) values(?,?,?,?)"; 
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getPhno());
			ps.setString(4, user.getEmail()); 
			ps.executeUpdate(); 
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
		
	}
	public List<UserModel> getAllUsers() {

        List<UserModel> list = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {

                UserModel u = new UserModel(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneno"),
                        rs.getString("email")
                );
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	

}
