<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMM</title>
<link rel='shortcut icon' type='image/x-icon' href='./favicon.ico' />
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div class="header">
		<h1>Smart Meters Management</h1>
		<h4>Anwendungssysteme Task 2 SS 2017</h4>
	</div>
	<p></p>
	<!-- table where you can see the Smart Meters and go to their detail view via button -->



	<p>
		Logged in as: <big>${loggedInUser.name}</big>
	</p>

	<p></p>
	<!-- calls post method of the home serverlet -->
	<form method="POST" action="home">
		Example: AB12345678 <br> Gerätekennung: <input type="text"
			name="gk" /> <br> <br> Values from 50 - 100 <br>
		Max. strain in ampere: <input type="text" name="max" /> <br> <br>
		<input type="submit" value="Add Smart Meter" class="btn" /> <br>
	</form>

	<!-- Java Script for throwing alerts -->
	<script type="text/javascript">
		var Msg = '<%=session.getAttribute("isNoValidSM")%>';
		if (Msg == "1") {
			function alertName() {
				alert("Max strain must be a double value from 50-100");
			}
		}
		if (Msg == "2") {
			function alertName() {
				alert("Gerätekennung must be a combination out of two upper case letters an 8 numbers");
			}
		}
		window.onload = alertName;
	</script>

	<p></p>

	<!-- iterates over all smart meters in the db and displays them -->
	<c:forEach items="${meterList}" var="meter">
		<hr>
		<form method="GET" action="details">
			<p>
				<img src="sm1.jpg" alt="Smart Meter" width="10%">
			</p>
			<p>Geraetekennung :</p>
			<p>${meter.geraeteKennung}</p>
			<!-- sets an attribute so the details serverlet knows what device its dealing with -->
			<input type="hidden" name="thisGK" value="${meter.geraeteKennung}" />
			<!-- go to the details view of the current smart meter -->
			<input type="submit" value="Go To Details" class="btn" />
		</form>
	</c:forEach>

	<hr>
	<p></p>

	<table class="footer">
		<tr>
			<td>
				<p>made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
			</td>
			<td>
				<!-- logout button -->
				<form method="GET" action="logout">
					<input type="submit" value="Logout" class="btn" />
				</form>
			</td>
		</tr>
	</table>
</body>