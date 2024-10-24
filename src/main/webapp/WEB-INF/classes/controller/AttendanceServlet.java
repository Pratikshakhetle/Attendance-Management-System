package com.attendance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.attendance.dao.AttendanceDAO;
import com.attendance.model.Student;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
	
		private AttendanceDAO attendanceDAO;
		
		public void init() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				attendanceDAO=new AttendanceDAO();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	      
 protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        List<Student> students = attendanceDAO.getAllAttendance();
        
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("attendance.jsp");
        dispatcher.forward(request, response);

}
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     doGet(request, response);
 }
 
}