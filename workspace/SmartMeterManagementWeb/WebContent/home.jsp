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
		<h1> Smart Meters Management </h1>
		<h4 class="active"> Anwendungssysteme Task 2 SS 2017</h4>
		<!-- table where you can see the Smart Meters and go to their detail view via button -->
		<table style="color:grey">
			
			<tr><th>Logged in User:</th><th><% %></th><th></th></tr>
			<tr>
				<!-- this should only be possible for a logged in user -->
				<td><form method="POST" action="logout"></form></td>
				<td><p>Gerätekennung :<input type="text" value=""></p>
					<p>Maximale Belastung:<input type="text" value=""/></p></td>
					<td><form method="POST" action="addSM"><input type="submit" value="add Smart Meter" class="button"/></form></td>
			</tr>
			<tr>
			<%
			@SuppressWarnings("unchecked")
			List<SmartMeter> smmes = (List<SmartMeter>) request.getAttribute("smartmeter");
			if(smmes != null){
				for(SmartMeter smme : smmes){
					//TODO how do I know which sm I wanna see the details of ?
							//somehow we need to give some information within the request
								//as cookie thisSM with the value of the gk would be great
					%>			
					<td></td>
						<td>
							<p><%=smme.getGeraeteKennung()%></p>
							<img src="sm1.jpg" alt="Smart Meter" width="30%" style=" width : 115px;">
						</td>
					<td><form method="POST" action="details"></form><input type="submit" value="details"></td>			
				<%} 
			}%>
			</tr>
		</table>
		<div><!-- algin at the bottom -->
			<tr></tr>
			<tr></tr>
			<input type="submit" value="Logout" class="button">
			<p style="position: relativ;bottom: 0;padding: 12;">made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>