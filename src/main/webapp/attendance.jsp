<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance List</title>
</head>
<body>
<table border=1>
<tr>
<th>ID</th>
<th>Student Name</th>
<th>Student ID</th>
<th>Date</th>
<th>Status</th>
</tr>
<c:forEach var="student" items="${students}">
<tr>
<td>${student.id}</td>
<td>${student.student_name}</td>
<td>${student.studentId}</td>
<td>${student.attendance_date}</td>
<td>${student.status}</td>
</tr>			
</c:forEach>
</table>
</body>
</html>