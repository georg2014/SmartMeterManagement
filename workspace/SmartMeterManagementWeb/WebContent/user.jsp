<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*,de.tub.as.smm.models.User"%>

<!-- the first page you see as user -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMM</title>
<link rel='shortcut icon' type='image/x-icon' href='./favicon.ico' />
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="bg"></div>
	<div class="fg">
	
	<div class="header"><h1>Smart Meters Management</h1>
		<h4 class="active">Anwendungssysteme Task 2 SS 2017</h4></div>
		
		

		<p>
			Hi welcome to the Smart Meter Management Web page! <br> Please
			enter your name to continue(just alphabetics)! <br> (Otherwise
			you can just see the Smart Meter Management but don't have access!)
		</p>
		<form method="POST" action="user">
			Name: <input type="text" name="name" /> <input type="submit"
				value="Sign in" />
		</form>
		<hr>
			<p>Signed in users:</p>
			<c:forEach items="${userList}" var="user">
				
				<p>${user}</p>
			</c:forEach>
	
		<hr>

		<table>
			<tr>

				<td>
					<form method="POST" action="logout">
						<input type="submit" value="Logout" />
					</form>
				</td>
				<td>
					<form method="GET" action="home">
						<input type="submit" value="Go to Smart Meter Overview" />
					</form>
				</td>
			</tr>
		</table>
		<div>
			<p style="position: relativ; bottom: 0; padding: 12;">made by
				Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>