<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.*,de.tub.as.smm.models.User"%>	

<!-- the first page you see as user -->
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMM</title>
</head>

<body>
	<h1> Smart Meters Management </h1>
	<h4 class="active"> Anwendungssysteme Task 2 SS 2017</h4>
	<form method="POST" action="user">
		Name: 	<input type="text" name="name" /> <input type="submit"value="Add" />
	</form>
	<hr>
	<ol>
		<%	
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) request.getAttribute("user");
			if (users != null) {
				for (User user : users) {
					%>
					<li><%=user%></li>
					<%
				}
			}
		%>
	</ol>
	<hr>
	<form method="POST" action="home">
		 <input type="submit" value="Go to the home screen"
		 	style="background-color: darkblue;color: white;padding: 15px 32px;margin: 4px 2px;" />
	</form>
</body>
</html>