package com.attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.attendance.Database.Database;
import com.attendance.model.Student;

public class AttendanceDAO {
	public List<Student> getAllAttendance(){
		List<Student>students=new ArrayList<>();
		try(Connection conn=Database.getConnection();
				PreparedStatement ps=conn.prepareStatement("SELECT * FROM students")){
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
			String query="insert into students(id,student_name,student_id,attendance_date,status) values (?,?,?,?,?)";
			try(Connection conn=Database.getConnection();
			PreparedStatement st=conn.prepareStatement(query)){
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


