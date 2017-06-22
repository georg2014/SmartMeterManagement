<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*,de.tub.as.smm.models.SmartMeter"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMM</title>
<link rel='shortcut icon' type='image/x-icon' href='./favicon.ico' />
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="bg"></div>
	<div class="fg">
		<div class="header">
			<h1>Smart Meters Management</h1>
			<h4 class="active">Anwendungssysteme Task 2 SS 2017</h4>
		</div>
		<p></p>
		<!-- table where you can see the Smart Meters and go to their detail view via button -->


			
				<th>Logged in as: <big>${loggedInUser}</big></th>
				
				<p></p>



				<form method="POST" action="home">
						Has to be like => AB12345678 <br>
						Gerätekennung: <input type="text" name="gk" />
						<br>
						<br>
						Between 50A and 100A <br>
						Max strain in Ampere: <input type="text" name="max"/>
						<br>
						<br>
						<input type="submit" value="Add Smart Meter"/>
						<br>
				</form>

			<c:forEach items="${meterList}" var="meter">
				<hr>
					<form method="POST" action="details">
						<p><img src="sm1.jpg" alt="Smart Meter" width="20%"></p>
						<p>Gerätekennung :</p>
						<p>${meter.geraeteKennung}</p>
						<input type="hidden" name="thisGK" value="${meter.geraeteKennung}"/>						
						<!-- to go to the details view of the yirrent smaer meter -->
						<input type="submit" value="Go To Details"/>
					</form>
				<hr>
			</c:forEach>
			<tr>

			</tr>
		<table>
			<tr>

				<td>
					<form method="GET" action="logout">
						<input type="submit" value="Logout" />
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