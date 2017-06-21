<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
		<h1> Smart Meters </h1>
		<h2 class="active"> Anwendungssysteme Task 2 SS 2017</h2>
		<!-- table where you can see the Smart Meter and go home -->
		<table class=tableDefault>
			<tr><th>Navigation</th></tr>
			<tr>
				<td><form method="POST" action="home"><input type="submit" value="home" class="button"/></form></td>
			</tr>
			<!-- display: id volt amper and strain -->
			<tr>
				<td>id</td><td>volt</td><td>current</td><td>max strain</td>
			</tr>
			<%
			@SuppressWarnings("unchecked")
			List<SmartMeter> smmes = (List<SmartMeter>) request.getAttribute("smartmeter");
			if(smmes != null){
				for(SmartMeter smme : smmes){%>	
					<tr>
						<td><%=smme.getGeraeteKennung()%></td>
						<td>${volt}</td><!-- TODO edit in DetailsServlet!!! line 31 ff -->
						<td>${curr}</td><!-- TODO edit in DetailsServlet!!! -->
						<td><%=smme.getMaxBelastung()%></td>
					</tr>
			<% }
			}%>
			<!-- display: img -->
			<tr>
				<td></td>
					<td>
						<p>Smart Meter</p>
						<!-- TODO -->
						<img src="sm1.jpg">
					</td>
			</tr>
			<!-- display: option to typ in kWh -->
			<tr>
				<!-- TODO how to work with the inout??? -->
				<td>kWh: </td><td><input type="text"></td>
			</tr>
			<!-- display: typed in data -->
			<tr>
				<td>name</td><td>date</td><td>kWh</td><td></td>
			</tr>
			<tr>
				<!-- output -->
				<!-- output next -->
				<!-- TODO -->
				<td>tom</td>
				<td>15.06.2017</td>
				<td>645kWh</td>
			</tr>
			<tr>
				<td><form method="POST" action="addData"><input type="submit" value="add"class="button"/></form></td>
			</tr>
		</table>
		<div><!-- algin at the bottom -->
			<p style="position: relativ;bottom: 0;padding: 12;">made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>