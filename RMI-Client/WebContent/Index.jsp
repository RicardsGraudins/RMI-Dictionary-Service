<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dictionary Service</title>
</head>
<body>
	<form action="DictionaryServlet" method="post">
		<p>Enter a word:</p>
		<input type="text" name="wordInput"/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>