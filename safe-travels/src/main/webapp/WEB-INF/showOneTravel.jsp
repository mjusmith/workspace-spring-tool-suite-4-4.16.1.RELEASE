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
<title>Travel Details</title>
</head>
<body>
	<h1>Details!</h1>
	<a href="/travel-dash">Go Home</a>
	<br/>
	<br/>
	<p>Expense Name: <c:out value="${oneTravel.expense }"/></p>
	<br/>
	<br/>
	<p>Description: <c:out value="${oneTravel.description }"/></p>
	<br/>
	<br/>
	<p>Vendor: <c:out value="${oneTravel.vendor }"/></p>
	<br/>
	<br/>
	<p>Amount: <c:out value="${oneTravel.amount }"/></p>
</body>
</html>