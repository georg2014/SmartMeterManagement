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
	<div style="
	  position: relative;
	  z-index: 1;
	  position: absolute;
	  top: 0; 
	  left: 0;
	  width: 100%; 
	  height: 100%;
	  z-index: -1;
	  background:  url(https://blog.nxp.com/wp-content/uploads/2017/02/01_SmartMeterblog_illustration_generic_lsv1-2-960x425.jpg);
	">
		<h1> Smart Meters Management </h1>
		<h4 class="active"> Anwendungssysteme Task 2 SS 2017</h4>
		<%//here is some weard going in in eclipse but it caused no damape yet
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) request.getAttribute("user");
		if (users != null && users.size() > 0 && users.get(users.size()-1).getName() != "" && users.get(users.size()-1).getName().chars().allMatch(Character::isLetter)) {
			%>
			<div>You are Logged In as: <%=users.get(users.size()-1).getName() %></div>
			<%
		}
		%>
		<p>Hi welcome to the Smart Meter Management Web page! <br>
			 Please enter your name to continue(just alphabetics)!</p>
		<form method="POST" action="user">
			Name: 	<input type="text" name="name" /> <input type="submit"value="continue" />
		</form>
		<hr>
			<ol>
				<%	
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
		
		<%
		if (users != null && users.size() > 0 && users.get(users.size()-1).getName() != "" && users.get(users.size()-1).getName().chars().allMatch(Character::isLetter)) {
			%>
			<form method="POST" action="home">
			<input type="submit" value="Go to the home screen"
			 	style="background-color: darkblue;color: white;padding: 15px 32px;margin: 4px 2px;" />
			</form>
			<%
		}
		%>
	</div>
</body>
</html>