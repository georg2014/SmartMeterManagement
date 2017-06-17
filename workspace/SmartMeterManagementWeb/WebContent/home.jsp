<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMM</title>
<link rel='shortcut icon' type='image/x-icon' href='./favicon.ico' />
</head>
<style>
	body, html {
	    height: 100%;
	    margin: center;
	}
	
	.bg {
	    /* The image used */
	    background-image: url(https://blog.nxp.com/wp-content/uploads/2017/02/01_SmartMeterblog_illustration_generic_lsv1-2-960x425.jpg);
	
	    /* Full height and width */
	    height: 100%;
        width: 100%; 
	
	    /* Center and scale the image nicely */
	    background-position: center;
	    background-repeat: repeat;
	    background-size: cover;
        
        /*make the position absolut*/
        position: absolute;
	    top: 0; 
	    left: 0;
	    
        /*make it transparent*/
	    opacity: 0.5;
	}
    
    .fg{
    	/*make the position absolut before the bg and no opacity*/
    	position: absolute;
	    top: 0;
        left: 25%;
        width: 50%;
    }
    
    .button{
    	background-color: darkblue;
    	color: white;
    	padding: 15px 32px;
    	margin: 4px 2px;
    }
</style>

<body>
	<div class="bg"></div>
	<div class="fg">
		<h1> Smart Meters Management </h1>
		<h4 class="active"> Anwendungssysteme Task 2 SS 2017</h4>
		<!-- table where you can see the Smart Meters and go to their detail view via button -->
		<table style="color:grey">
			
			<tr><th>User:</th><th><% %></th><th></th><form method="POST" action="logout"><input type="submit" value="logout"/></tr>
			<tr><th>Navigation</th></tr>
			<tr>
				<td><form method="POST" action="home"><input type="submit" value="home" class="button"/></form></td>
				<td><form method="POST" action="addSM"><input type="submit" value="add Smart Meter" class="button"/></form></td>
				<td><form method="POST" action="logout"><input type="submit" value="Logout" class="button"/></form></td>
			</tr>
			<tr>
			<!-- TODO -->
			<% 
			//getUserByName(String name)
			//getGeraeteKennung()
			//getMeterByGk(String gk)
			//SmartMeter(String gk, Double max)
			//getAllMeters()
			//smartmeter = (List<User>) request.getAttribute("user");
			//do this for all smart meters! %>			
				<td></td>
					<td>
						<!-- TODO -->
						<p><%="here comes the id variable"%></p>
						<img src="sm1.jpg" alt="Smart Meter" width="30%">
					</td>
				<td><form method="POST" action="details"><input type="submit" value="details"/></form></td>			
			<%//close %>
			</tr>
		</table>
		<div><!-- algin at the bottom -->
			<p style="position: relativ;bottom: 0;padding: 12;">made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>