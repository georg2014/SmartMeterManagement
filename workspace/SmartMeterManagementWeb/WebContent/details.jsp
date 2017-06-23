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


		<form method="get" action="home">
			<input type="submit" value="Smart Meter Overview" class="btn" />
		</form>

		<!-- display: id volt amper and strain -->
		
		<p></p>
		
	

		<img src="sm1.jpg" width=30%> <br>
		
		<!-- Permanente Kennung und Max Belastung -->
		<p>
			Gerätekennung: <span id="gk">${deviceNumber}</span>
		</p>
		<p>
			Max. Belastung: <span id="maxA">${max}</span>A
		</p>
		<p>Letzte Messung:</p>
		Spannung: <span>${volt}</span> <br /> Stromstärke: <span>${curr}</span>
		
		
		<p></p>
		
		<form method="POST" action="details">
			Ablesung in kWh:<input type="text" name="value"
				style="width: 20%; algin: center;"> <input type="submit"
				value="Add" class="btn" style="width: 20%; algin: center;" />
		</form>
		
		<p></p>
		
		<script type="text/javascript">
			var Msg = '<%=session.getAttribute("isWrongValue")%>' ;
			if(Msg == "1"){
				function alertName(){
					alert("Please enter only numbers");
				}
			}
			Msg = '<%=session.getAttribute("isToHigh")%>
			';
			if (Msg == "1") {
				function alertName() {
					alert("Alert: Current is to high!");
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
				<td>
					<form method="GET" action="logout">
						<input type="submit" value="Logout" class="btn" />
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>