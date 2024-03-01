<%@page import="Student_Managment_System.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Student student=(Student)request.getAttribute("student");%>

	<form action="edit">
		<label>ID</label>
		<input type="number" name="id" readonly="readonly" value=<%=student.getId()%>><br>
		<label>Enter Name</label>
		<input name="name" type="text" placeholder="enter your name"><br>
		<label>Enter Address</label>
		<input name="address" type="text" placeholder="enter your address"><br>
		<label>Enter email</label>
		<input name="email" type="email" placeholder="enter your email"><br>
		<label>Enter password</label>
		<input name="password" type="password" placeholder="enter your password"><br><br>
		<input type="submit" value="update">
	</form>
</body>
</html>