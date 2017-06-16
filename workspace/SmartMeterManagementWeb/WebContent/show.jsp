<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- connect jsp and servlet via action and the name between "/ and " -->
<!-- in servlet: see line 13 and line 14 -->
<form method="POST" action="ShowServlet">
<!-- now we can do some with the input in the Servlet -->
	<input type="submit" value="show">
</form>

</body>
</html>