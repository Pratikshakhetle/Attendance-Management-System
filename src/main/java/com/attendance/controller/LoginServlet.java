package com.attendance.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.attendance.dao.UserDAO;
import com.attendance.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO= new UserDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			User user=userDAO.validateUser(username,password);
			if(user!=null) {
				HttpSession session =request.getSession();
				session.setAttribute("user", user);
				
			}
			else {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
		}catch(Exception e) {
			throw new ServletException("Login failed", e);
		}
	}

}
