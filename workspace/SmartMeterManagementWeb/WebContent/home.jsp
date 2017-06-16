<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMM</title>
</head>
<body>
<div style="
	  position: absolute;
	  top: 0; 
	  left: 0;
	  width: 100%; 
	  height: 100%;
	  z-index: -1;
	  background:  url(https://blog.nxp.com/wp-content/uploads/2017/02/01_SmartMeterblog_illustration_generic_lsv1-2-960x425.jpg);
	  opacity: 0.1;
	"></div>
	<div style="
	  position: absolute;
	  top: 0; 
	  left: 0;">
		<h1> Smart Meters Management </h1>
		<h4 class="active"> Anwendungssysteme Task 2 SS 2017</h4>
		<!-- table where you can see the Smart Meters and go to their detail view via button -->
		<table style="color:grey">
			<tr><th>Navigation</th></tr>
			<tr>
				<td><form method="POST" action="home"><input type="submit" value="home"
				style="background-color: darkblue;
	   			color: white;
	   			padding: 15px 32px;
				margin: 4px 2px;"/></form></td>
				<td><form method="POST" action="addSM"><input type="submit" value="add Smart Meter"
				style="background-color: darkblue;
	   			color: white;
	   			padding: 15px 32px;
				margin: 4px 2px;"/></form></td>
			</tr>
			<tr>
			<!-- TODO -->
			<%//do this for all smart meters! %>			
				<td></td>
					<td>
						<!-- TODO -->
						<p><%="here comes the id variable"%></p>
						<img src=<%="here comes the img src variable"%> alt="Smart Meter" width="30%">
					</td>
				<td><form method="POST" action="details"><input type="submit" value="details"/></form></td>			
			<%//close %>
			</tr>
		</table>
		<div><!-- algin at the bottom -->
			<p style="position: absolute;bottom: 0;padding: 12;">made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>