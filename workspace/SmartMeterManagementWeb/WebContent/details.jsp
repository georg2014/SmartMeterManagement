<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart Meter - details</title>
</head>
<body>
	<h1> Smart Meters </h1>
	<h2 class="active"> Anwendungssysteme Task 2 SS 2017</h2>
	<!-- table where you can see the Smart Meter and go home -->
		<table class=tableDefault>
			<tr><th>Navigation</th></tr>
			<tr>
				<td><form method="POST" action="home"><input type="submit" value="home"
					style="background-color: darkblue;
		   			color: white;
		   			padding: 15px 32px;
					margin: 4px 2px;"/></form></td>
			</tr>
			<!-- display: id volt amper and strain -->
			<tr>
				<td>id</td><td>volt</td><td>current</td><td>max strain</td>
			</tr>
			<tr>
				<td><%="AA12345678"%></td><td><%="here comes the voltage" %></td>
				<td><%="here comes the current" %></td><td><%="here comes the max strain" %></td>
			</tr>
			<!-- display: img -->
			<tr>
				<td></td>
					<td>
						<p>Smart Meter</p>
						<%="gere comes the image" %>
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
				<%="here should be all log from all users for this smart meter" %>
			</tr>
			<tr>
				<td><form method="POST" action="add"><input type="submit" value="add"
					style="background-color: darkblue;
		   			color: white;
		   			padding: 15px 32px;
					margin: 4px 2px;"/></form></td>
			</tr>
		</table>
</body>
</html>