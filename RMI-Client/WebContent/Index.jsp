<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dictionary Service</title>
</head>
<body>
	<h1>Dictionary Service</h1>
	<p id="msg"></p>
	<div id="myform">
		<form action="DictionaryServlet" method="post">
			<input type="text" placeholder="Enter query here" name="wordInput"/>
			<input type="submit" value="submit" id="submitbtn"/>
		</form>
	</div>
	
	<br/>
	<h2>Other Features</h2>
	<!-- Link to add a word -->
	<form action="http://localhost:8080/RMI-Client/AddWord.jsp">
    	<input type="submit" value="Add a word" />
	</form>
	<br/>
	<!-- Link to delete a word -->
	<form action="http://localhost:8080/RMI-Client/DeleteWord.jsp">
    	<input type="submit" value="Delete a word" />
	</form>
	<br/>
	<!-- Link to modify a word -->
	<form action="http://localhost:8080/RMI-Client/ModifyWord.jsp">
    	<input type="submit" value="Modify a word" />
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		//When the user clicks on the submit button hide the form
		//and display text "Waiting for response..."
		$(document).ready(function() {
			$('#submitbtn').on('click', function(){
				$("#myform").hide();
				$("#msg").text("Waiting for response...");
			});
		});
	</script>
</body>
</html>