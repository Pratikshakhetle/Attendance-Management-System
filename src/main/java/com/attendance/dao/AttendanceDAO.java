package com.attendance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.attendance.model.*;

public class AttendanceDAO {
	private String URL = "jdbc:mysql://localhost:3306/attendance_management";
    private String User = "root";
    private String Password = "pratikshaK@23";
	private Connection conn;
	
	public AttendanceDAO() {
	
	 try {
         conn = DriverManager.getConnection(URL,User,Password);
     } catch (SQLException e) {
         e.printStackTrace();
     }
	}
	
	public List<Student> getAllAttendance(){
		 
		List<Student>students=new ArrayList<>();
		try(PreparedStatement ps=conn.prepareStatement("SELECT * FROM students")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudentId(rs.getInt("student_id"));
				student.setDate(rs.getString("attendance_date"));
				student.setStatus(rs.getString("status"));
				students.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public void addStudent(Student student)throws Exception{
		try(PreparedStatement st=conn.prepareStatement("Insert into students(id,student_name,student_id,attendance_date,status) values (?,?,?,?,?)")){
		st.setInt(1,student.getId());
		st.setString(2, student.getStudent_name());
		st.setInt(3, student.getStudentId());
		st.setString(4,student.getDate());
		st.setString(5, student.getStatus());
		st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
}
}

