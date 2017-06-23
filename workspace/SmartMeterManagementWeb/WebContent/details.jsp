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
	
		<div class="header">
			<h1>Smart Meters Management</h1>
			<h4>Anwendungssysteme Task 2 SS 2017</h4>
		</div>
		
		<p></p>
		
		<!-- smart meter values -->
		<div id="imgtxt2">${volt} volt</div>
		<div id="imgtxt1">${curr} amper</div>
		
		<!-- table where you can see the Smart Meter and go home -->
		<table class="tbl">
			<tr>
				<td><form method="get" action="home">
						<input type="submit" value="Smart Meter Overview" class="btn"/>
					</form>
				</td>
				<td>
				</td>
				<td>
					<form method="GET" action="logout">
						<input type="submit" value="Logout"  class="btn"/>
					</form>
				</td>
			</tr>
			<!-- display: id volt amper and strain -->
			<tr>
				<th>id</th>
				<th>volt</th>
				<th>current</th>
				<th>max strain</th>
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
					<p>Smart Meter</p> <img src="sm1.jpg" width=50%>
				</td>
			</tr>
		</table>
		<form method="POST" action="details">
			kWh:<input type="text" name="value" style="width: 20%; algin: center;">
			<input type="submit" value="Add" class="btn" style="width: 20%; algin:center;"/>
		</form>
		<script type="text/javascript">
			var Msg = '<%=session.getAttribute("isWrongValue")%>' ;
			if(Msg == "1"){
				function alertName(){
					alert("Please enter value like 1000(only numbers) to add reading.");
				}
			}
			Msg = '<%=session.getAttribute("isToHigh")%>';
			if(Msg == "1"){
				function alertName(){
					alert("Alert: Voltage is to high!");
				}
			}
			window.onload = alertName;
		</script>
		
		<table>
				<!-- display: typed in data -->
				<tr>
					<th>name</th>
					<th>date</th>
					<th>kWh</th>
				</tr>
				<!-- show all readings -->
				<c:forEach items="${readingList}" var="reading">
					<tr>
						<!-- output -->
						<td>${reading.benutzer}</td>
						<td>${reading.zp}</td>
						<td>${reading.kwh}</td>
					</tr>
				</c:forEach>
		</table>
			
			
		<p></p>
			
		<table class="footer">
			<tr>
				<td>
					<p>made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>