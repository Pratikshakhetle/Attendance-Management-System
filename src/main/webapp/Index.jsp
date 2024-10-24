<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Management System</title>
<style>
.navbar{
overflow:	hidden;
background-color: #333;
}
.navbar a {
float: left;
display: block;
color: white;
text-align: center;
padding: 14px 20px;
text-decoration: none;
}
.navbar a:hover {
background-color: #ddd;
color: black;
}
.navbar a.active {
background-color: #04AA6D;
color: white;
}
</style>
</head>
<body>
<div class="navbar">
<a href="/">Attendance Management System</a>
<a href="attendance.jsp">Attendance List</a>
<a href="attendanceAdd.jsp">Attendance Add</a>
</div>
</body>
</html>