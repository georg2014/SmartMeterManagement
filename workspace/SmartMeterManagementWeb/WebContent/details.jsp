<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart Meter - details</title>
</head>
<body>

	<h1>Smart Meter 1</h1>

	<!-- Navigation view  upper right hand-->
	<div>
			<a href="index.html">Übersicht</a>
			<a href="">> Detailansicht</a>
	</div>

		<!-- Box for the picture of the Smart Meters -->
		<div class="imageBox">
			<img src="Bilder von Smart Metern\Smart Meter 1.jpg" alt="" width="300" height="500">
			<!-- Text which should be shown in the field of the Smart Meter-->
			<p id="imgtxt1">
				Voltage: <span id="spannung">  </span> <br />
				Current: <span id="stromstärke"> </span>
			</p>
		</div>
		<!-- ID and max Current -->
		<p>
			ID: <span id="gk">RV32165245</span>
		</p>
		<p>
			Max. Current: <span id= "maxA">89</span>A
		</p>

	<!-- Formula that takes two input values and start with the submit button a script to add the data into a table-->
	<form id="ablesen" onsubmit="submiter(); return false">
		Count: <input type="text" id="data">
		<input type="submit" value="Submit">
	</form>

	<!-- Table which is filled with values-->
	<table id="ablesungen">
		<tr>
			<th>User</th>
			<th>Count</th>
			<th>Date</th>
		</tr>
	</table>

	<!-- footer with usefull infos -->
	<p>Anwendungssysteme 2. Task made by Leon Winkelmann, Jakob Feldmann, Jonas Schicke and Georg Stahn (Gruppe E)</p>

</body>
</html>