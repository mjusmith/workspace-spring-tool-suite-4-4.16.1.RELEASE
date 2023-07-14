<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojo/new" method="POST" modelAttribute="newDojo">
		<form:label path="name">Name: </form:label>
		<form:input type="text" path="name"></form:input>
		<form:errors path="name"/>
			<br/>
			<br/>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>