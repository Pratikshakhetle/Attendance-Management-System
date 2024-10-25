package com.attendance.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.attendance.dao.AttendanceDAO;
import com.attendance.model.Student;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	
		private AttendanceDAO attendanceDAO=new AttendanceDAO();
		
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String action=request.getParameter("action");
	 try{
		 if("record".equals(action)) {
			 int id=Integer.parseInt(request.getParameter("id"));
			 int studentId = Integer.parseInt(request.getParameter("studentId"));
			 String student_name=request.getParameter("student_name");
			 String date = request.getParameter("date");
			 String status = request.getParameter("status");

			 Student student = new Student();
			     student.setId(id);
			     student.setStudentId(studentId);
			     student.setStudent_name(student_name);
			     student.setDate(date);
			     student.setStatus(status);
			 attendanceDAO.addStudent(student);
			 response.sendRedirect("attendance.jsp");
	 }
		 }
	catch (Exception e) {
		e.printStackTrace();
	}
	 
 }
 
}