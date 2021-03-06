<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

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

		<div class="header">
			<h1>Smart Meters Management</h1>
			<h4>Anwendungssysteme Task 2 SS 2017</h4>
		</div>


		<p>
			Hi welcome to the Smart Meter Management Web page! <br> Please
			enter your name to continue(just alphabetics)! <br>
			(If you are not logged in you can't create new readings)
		</p>
		
		<form method="POST" action="user">
			Name: <input type="text" name="name" /> <input type="submit"
				value="Sign in"  class="btn"/>
		</form>
		
		<%-- ${ } reference to a attribute from request --%>
		<p>
			You are logged in as : <b>${loggedInUser.name}</b>
		</p>
		
		<form method="GET" action="home">
			<input type="submit" value="Go to Smart Meter Overview" class="btn">
		</form>
		
		<!-- Java Script for throwing alerts -->
		<script type="text/javascript">
			var Msg = '<%=session.getAttribute("isWrongName")%>' ;
			if(Msg == "1"){
				function alertName(){
					alert("Please enter name like tom(only letters) to log in.");
				}
			}
			if(Msg == "2"){
				function alertName(){
					alert("This is the Admin version where you are allready logged in and some SM are there!");
				}
			}
			window.onload = alertName;
		</script>
		<hr>
		<p>Signed in users:</p>
		
		<!-- c: tag is from jstl library, we imported it for better functionallity -->
		<!-- prints out all users that have signed in -->
		<c:forEach items="${userList}" var="user">

			<p>${user}</p>
		</c:forEach>

		<hr>

		<p></p>

		<table class="footer">
			<tr>
				<td>
					<p>made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
				</td>
				<td>
					<form method="GET" action="logout">
						<input type="submit" value="Logout"  class="btn"/>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>