package Pro.Dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Pro.Bean.*;
import Pro.Conn.*;

public class ProjectDao {
	
	static Connection con;
	static PreparedStatement ps;
	
	public int insertForm(ProjectBean c) {
		
		 int status = 0;
		try {
			con = DBConnection.CreateConnection();
			
            ps = con.prepareStatement("insert into user_details(username, firstName, lastName, emailId, password) values (?,?,?,?,?)"); //insert into user_registration(Introduction, Hobbies) values (?,?);");
			ps.setString(1, c.getUserName());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getlastName());
			ps.setString(4, c.getEmailId());
			ps.setString(5, c.getPassword());
			//ps.setString(6, c.getIntroduction());
			//ps.setString(7, c.getHobbies());
			System.out.println(c.getUserName() + " added");
			
			status = ps.executeUpdate();
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			con = DBConnection.CreateConnection();
			
            ps = con.prepareStatement("insert into user_registration(username,introduction, hobbies) values (?,?,?)");
			ps.setString(1, c.getUserName());
            ps.setString(2, c.getIntroduction());
			ps.setString(3, c.getHobbies());
			
			status = ps.executeUpdate();
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
		
	}
	
    public ProjectBean getForm(String username, String password) {
		
		ProjectBean c = new ProjectBean();
	
		try {
				con = DBConnection.CreateConnection();
				ps = con.prepareStatement("SELECT * FROM user_details where username=? and password=?;");
				ps.setString(1, username);
				ps.setString(2, password);
				System.out.println("Password: " + password);
				
				ResultSet result = ps.executeQuery();
				
				while(result.next()) {
					c.setUserName(result.getString(1));
					c.setPassword(result.getString(2));
				}
				con.close();
			} catch(Exception e) {
				System.out.println(e);
			}
		return c;
		
	}	
	
    public ProjectBean getReg(String username, String introduction, String hobbies) {
		
		ProjectBean c = new ProjectBean();
	
		try {
				con = DBConnection.CreateConnection();
				ps = con.prepareStatement("SELECT * FROM user_registration where introduction=? and hobbies=?;");
				ps.setString(1, introduction);
				ps.setString(2, hobbies);

				ResultSet result = ps.executeQuery();
				
				while(result.next()) {
					c.setIntroduction(result.getString(1));
					c.setHobbies(result.getString(2));
				}
				con.close();
			} catch(Exception e) {
				System.out.println(e);
			}
		return c;
   }
}