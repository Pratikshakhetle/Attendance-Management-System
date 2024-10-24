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

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	
		private AttendanceDAO attendanceDAO;
		
		public void init() {
				attendanceDAO=new AttendanceDAO();
		}
	      
 protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        List<Student> students = attendanceDAO.getAllAttendance();
        
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
        dispatcher.forward(request, response);

}
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
	 try{
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
     response.sendRedirect("Index.jsp");
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 
 }
 
}