<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%> 
    
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
		<h1> Smart Meters </h1>
		<h2 class="active"> Anwendungssysteme Task 2 SS 2017</h2>
		<!-- table where you can see the Smart Meter and go home -->
		<table class=tableDefault>
			<tr><th>Navigation</th></tr>
			<tr>
				<td><form method="POST" action="home"><input type="submit" value="home" class="button"/></form></td>
				<td><form method="GET" action="logout"><input type="submit" value="Logout" /></form></td>
			</tr>
			<!-- display: id volt amper and strain -->
			<tr>
				<th>id</th><th>volt</th><th>current</th><th>max strain</th>
			</tr>
			<tr>
				<td>${deviceNumber}</td>
				<td>${volt}</td>
				<td>${curr}</td>
				<td>${max}</td>
			</tr>
			<!-- display: img -->
			<tr>
				<td></td>
					<td>
						<p>Smart Meter</p>
						<img src="sm1.jpg">
					</td>
			</tr>
		</table>
			<!-- display: option to typ in kWh -->
		<form method="POST" action="addData">
			<table>
				<tr>
					<!-- TODO how to work with the inout??? -->
					<td>kWh: </td><td><input type="text" name="value"></td>
					<td><form method="GET" action="details"><input type="submit" value="add" class="button"/></form></td>
				</tr>
				<!-- display: typed in data -->
				<tr>
					<td>name</td><td>date</td><td>kWh</td><td></td>
				</tr>
				<!-- show all readings -->
				<c:forEach items="${readings}" var="reading">
					<tr>
						<!-- output -->
						<td>${reading.benutzer}</td>
						<td>${reading.zp}</td>
						<td>${reading.kwh}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<div><!-- algin at the bottom -->
			<p style="position: relativ;bottom: 0;padding: 12;">made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>