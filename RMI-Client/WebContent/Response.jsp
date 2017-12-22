<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dictionary Service</title>
</head>
<body>
	<h1>Dictionary Service</h1>
	<!-- Output the word & definition -->
	<%
		String word = (String)request.getAttribute("word");
		String definition = (String)request.getAttribute("definition");
		out.print(word + ": " + definition);
	%>
	<br/>
	<!-- Link to make another query -->
	<form action="http://localhost:8080/RMI-Client">
    	<input type="submit" value="Make another query" />
	</form>
</body>
</html>