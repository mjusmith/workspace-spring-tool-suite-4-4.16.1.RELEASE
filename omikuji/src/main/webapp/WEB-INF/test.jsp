<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
<h1>Send an Omikuji!</h1>
<form action="/omikuji" method="POST">
	<label for="number">Pick a number 5 to 25:</label>
	<input type="number" name="number" min="5" max="25" value="5">
	<br/>
	<br/>
	<label for="city">City Name: </label>
	<input type="text" name="city">
	<br/>
	<br/>
	<label for="person">Person's Name: </label>
	<input type="text" name="person">
	<br/>
	<br/>
	<label for="hobby">Your Hobby: </label>
	<input type="text" name="hobby">
	<br/>
	<br/>
	<label for="thingLiving">Name of any living thing: </label>
	<input type="text" name="thingLiving">
	<br/>
	<br/>
	<label for="niceComment">Say something nice!</label>
	<textarea name="niceComment"></textarea>
	<br/>
	<br/>
	<p>Send it out!</p>
	<input type="submit" value="Submit">
</form>
</body>
</html>