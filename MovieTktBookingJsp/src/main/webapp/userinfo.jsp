<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.jos.dao.UserDAO" %>
  <%@ page import="com.jos.model.UserModel" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserForm</title>
</head>
<body>
<form action="UserServlet" method="post">
<table>
<tr>
<td>FirstName:<input type="text" name="fname"/></td>
</tr>
<tr>
<td>LastName:<input type="text" name="lname"/></td>
</tr>
<tr>
<td>Phone:<input type="text" name="pnum"/></td>
</tr>
<tr>
<td>Email:<input type="email" name="email"/></td>
</tr>
<tr>
<td><input type="submit" value="ADD"/></td>
</tr>

</table>
</form>
<table border="1">
<tr>
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>PhoneNumber</th>
<th>Email</th>
</tr>
<tr>
<% 
UserDAO dao = new UserDAO(); 
List<UserModel> users = dao.getAllUsers(); 
if(users!=null){
	for(UserModel u:users){
		
	
%>
<td><%=u.getId() %></td>
<td><%=u.getFname() %></td>
<td><%=u.getLname() %></td>
<td><%=u.getPhno() %></td>
<td><%=u.getEmail() %></td>
</tr>
<%}
	}%>
</table>

</body>
</html>