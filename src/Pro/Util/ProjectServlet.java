package Pro.Util;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pro.Bean.*;
import Pro.Dao.*;


@WebServlet("/LoginRegister")
public class ProjectServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProjectDao  dao = new ProjectDao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String introduction = request.getParameter("intro");
		String hobbies = request.getParameter("hobbies");
	    String submitType = request.getParameter("submit");
	    
	    
	    ProjectBean c = dao.getForm(username, password);
	    ProjectBean r = dao.getReg(username, introduction, hobbies);
	    
	    if(submitType.equals("login") | c!=null && c.getUserName()!=null) {
	    	request.setAttribute("username", c.getUserName());
	    	request.getRequestDispatcher("Home.jsp").forward(request, response);
	    	System.out.println(c.getUserName() + "" + c.getPassword());
	    	
	    }
	    else if (submitType.equals("register")) {
	    
	    	c.setUserName(username);
	    	c.setPassword(password);
	    	c.setFirstName(request.getParameter("firstname"));
	    	c.setLastName(request.getParameter("lastname"));
	    	c.setEmailId(request.getParameter("email"));
	    	c.setIntroduction(request.getParameter("intro"));
	    	c.setHobbies(request.getParameter("hobbies"));
	    	
	    	
	    	dao.insertForm(c);
	    	
	    	request.setAttribute("message", "Registration Complete, You Can Now Login");
	    	request.getRequestDispatcher("Login.jsp").forward(request, response);
	    	
	    }
	    else {
	    	request.setAttribute("message", "You Need To Register New User");
	    	request.getRequestDispatcher("Login.jsp").forward(request, response);
	    }
	}

}
