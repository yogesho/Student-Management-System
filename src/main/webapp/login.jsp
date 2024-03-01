<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<%String message=(String) request.getAttribute("message"); %>
		<% if(message!=null){ %>
		<h1><%=message%></h1>
		<%} %>

		Email:<input type="text" name="email" placeholder="enter the mail"><br>
		Password:<input type="password" name="password" placeholder="enter the password"><br>
		<input type="submit" value="login">
	</form>
	
</body>
</html>