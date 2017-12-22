<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
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
		<form action="DictionaryServletModify" method="post">
			<input type="text" placeholder="Enter word here" name="wordInput"/>
			<input type="text" placeholder="Enter definition here" name="definitionInput"/>
			<input type="text" placeholder="Enter new definition here" name="newDefinitionInput"/>
			<input type="submit" value="submit" id="submitbtn"/>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		//When the user clicks on the submit button hide the form
		//and display text "Updated dictionary."
		$(document).ready(function() {
			$('#submitbtn').on('click', function(){
				$("#myform").hide();
				$("#msg").text("Updated dictionary.");
			});
		});
	</script>
</body>
</html>