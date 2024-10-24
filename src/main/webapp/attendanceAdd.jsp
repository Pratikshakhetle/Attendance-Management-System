<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Attendance</title>
</head>
<body>
<h2>Attendance List</h2>
    <form action="AttendanceServlet" method="POST">
    	ID: <input type="text" name="id"><br>
        Student ID: <input type="text" name="studentId"><br>
        Student Name : <input type="text" name="student_name"><br>
        Date: <input type="date" name="date"><br>
        Status: <input type="text" name="status"><br>
        <button type="submit">Add</button>
    </form>
</body>
</html>