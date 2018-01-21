<?xml version="1.0" encoding="UTF-8"?>

<html>
<head>
<title>Repair & Healing</title>
</head>
<body>

	<div xmlns:jsp="http://java.sun.com/JSP/Page"
		xmlns:spring="http://www.springframework.org/tags"
		xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">


		<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"
			trimDirectiveWhitespaces="true" />
		<head>
<title>Home</title>
		</head>
		<body>
			<h1>Hello world! Here you can leave a request for repair in your
				dormitory room!</h1>
				
				${newTask}
    
	<form action="/index/form" method="POST">
		<table>
			<tr><td>CASE_TEXT</td><td><input name="description" type="text" /></td></tr>
			<tr><td>ROOM_NUMBER</td><td><input name="room" type="text" /></td></tr>			
			<tr><td></td><td><input type="submit" /></td></tr>
		</table>
		
	
		
	</form>
	</div>
</body>
</html>

