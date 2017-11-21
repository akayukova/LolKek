<?xml version="1.0" encoding="UTF-8"?>

<html>
<head>
	<title>Repair & Healing</title>
</head>
<body>

<div
	xmlns:jsp="http://java.sun.com/JSP/Page" 
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	version="2.0"
>
	
	
    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" />
	
    
	${newTask}
    
	<form action="/index/form" method="POST">
		<table>
			<tr><td>CASE_TEXT</td><td><input name="caseText" type="text" /></td></tr>
			<tr><td>CASE_STATUS</td><td><input name="caseStatus" type="text" /></td></tr>
			<tr><td>CASE_DURING_TIME</td><td><input name="caseExecuteBefore" type="text" /></td></tr>
			<tr><td>ROOM_NUMBER</td><td><input name="roomNumber" type="text" /></td></tr>
			<tr><td>USER_EMAIL</td><td><input name="userEmail" type="text" /></td></tr>
			<tr><td>USER_NAME</td><td><input name="userFirstName" type="text" /></td></tr>
			<tr><td>USER_SONAME</td><td><input name="userLastName" type="text" /></td></tr>
			<tr><td></td><td><input type="submit" /></td></tr>
		</table>
		
	
		
	</form>
</div>

</body>
</html>