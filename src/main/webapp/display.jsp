<%@page import="Student_Managment_System.dto.Student"%>
<%@page import="Student_Managment_System.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
th,td{
padding: 10px;
}

</style>
<body>

	<form action="display" method="post">
		<table border="1px">
		<%StudentDao std=new StudentDao(); %>
		<%List<Student> list=std.getAllStudent(); %>
			<thead>
				<tr> <th colspan="7">Student details</th> </tr>
				<tr>
				 <th>Id</th>
				 <th>Name</th> 
				 <th>Address</th>
				 <th>Email</th>
				 <th>Password</th>
				 <th>Delete</th>
				 <th>Update</th>
				</tr>
			</thead>
			<tbody>
				<% for(Student student:list){ %>
				<tr>
				 	<td><%=student.getId() %></td>
				 	<td><%=student.getName() %></td>
				 	<td><%=student.getAddress() %></td>
				 	<td><%=student.getEmail() %></td>
				 	<td><%=student.getPassword() %></td>
				 	<td><a href="delete?id=<%=student.getId()%>">Delete</a></td>
				 	<td><a href="update?id=<%=student.getId()%>">Update</a></td>
				</tr>
				<%} %>
			</tbody>

		</table>
	</form>
</body>
</html>