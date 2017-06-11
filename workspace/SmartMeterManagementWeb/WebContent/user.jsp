<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.*,de.tub.as.smm.models.User"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management</title>
</head>

<body>
	<form method="POST" action="user">
		Name: <input type="text" name="name" /> <input type="submit"
			value="Add" />
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

</body>
</html>