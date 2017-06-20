<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.*,de.tub.as.smm.models.SmartMeter,de.tub.as.smm.models.Reading"%> 
    
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
        left: 25%;
        width: 50%;
	    
        /*make it transparent*/
	    opacity: 0.5;
	}
    
    .fg{
    	/*make the position absolut before the bg and no opacity*/
    	position: absolute;
	    top: 0; 
	    left: 0;
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
		<h1> Smart Meters </h1>
		<h2 class="active"> Anwendungssysteme Task 2 SS 2017</h2>
		<!-- table where you can see the Smart Meter and go home -->
		<table class=tableDefault>
			<tr><th>Navigation</th></tr>
			<tr>
				<td><form method="POST" action="home"><input type="submit" value="home" class="button"/></form></td>
				<td><form method="POST" action="logout"><input type="submit" value="Logout" class="button"/></form></td>
			</tr>
			<!-- display: id volt amper and strain -->
			<tr>
				<td>id</td><td>volt</td><td>current</td><td>max strain</td>
			</tr>
			<%
			@SuppressWarnings("unchecked")
			//info of this sm via cookie get sm if user logged in
			//look which sm is to show
			SmartMeter thisSM = null;
	        Cookie [] cookies = request.getCookies();
			if(cookies != null){
				for (Cookie cookieSM : cookies) {
				     if ("thisSM".equals(cookieSM.getName())) {
				    	String thisGK = cookieSM.getValue();
						if(thisGK != ""){
							//TODO inser servlet smart meter with smart meter dao!
							List<SmartMeter> smmes = (List<SmartMeter>) request.getAttribute("smartmeter");
							if (smmes != null) {
								for (SmartMeter smme : smmes) {
									if(smme.getGeraeteKennung() == thisGK){
										thisSM =smme;%>	
										<tr>
											<td><%=smme.getGeraeteKennung()%></td>
											<td>${volt}</td><!-- TODO edit in DetailsServlet!!! line 31 ff -->
											<td>${curr}	</td><!-- TODO edit in DetailsServlet!!! -->
											<td><%=smme.getMaxBelastung()%></td>
										</tr>
									<%}
								}
							}
						}
				     }
				}
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
				<td>kWh: </td><td>kWh:<input type="text" value="kWh"></td>
				<td><form method="POST" action="addData"><input type="submit" value="add"class="button"/></form></td>
			</tr>
			<!-- display: typed in data via reading of this sm from logged in user -->
			<tr>
				<td>name</td><td>date</td><td>kWh</td><td></td>
			</tr>
			<%
			if(thisSM != null){
				@SuppressWarnings("unchecked")
				List<Reading> smmer = thisSM.getAblesung();
				if (smmer != null) {
					for (Reading r : smmer) {
				 %>
					<tr>
						<!-- output -->
						<!-- output next -->
						<!-- TODO -->
						<td><%=r.getBenutzer() %></td>
						<td><%=r.getZp() %></td>
						<td><%=r.getKwh() %>kWh</td>
					</tr>
				<% }
				}
			}%>
		</table>
		<div><!-- algin at the bottom -->
			<p style="position: relativ;bottom: 0;padding: 12;">made by Leon, Jakob, Jonas and Georg (Gruppe E)</p>
		</div>
	</div>
</body>
</html>