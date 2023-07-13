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
<title>Travel Update</title>
</head>
<body>
		<h1>Update Expense</h1>
		<a href="/travel-dash">Go Home</a>
	<form:form action="/travel/${travel.id}/edit" method="put" modelAttribute="travel">
			<br/>
			<br/>
		<form:label path="expense">Expense: </form:label>
		<form:input type="text" path="expense"></form:input>
		<form:errors path="expense"/>
			<br/>
			<br/>
		<form:label path="vendor">Vendor: </form:label>
		<form:input type="text" path="vendor"></form:input>
		<form:errors path="vendor"/>
			<br/>
			<br/>
		<form:label path="amount">Amount: </form:label>
		<form:input type="number" step="0.01" path="amount"></form:input>
		<form:errors path="amount"/>
			<br/>
			<br/>
		<form:label path="description">Description: </form:label>
		<form:textarea path="description"></form:textarea>
		<form:errors path="description"/>
			<br/>
			<br/>
		<button type="submit">Edit</button>
	</form:form>
</body>
</html>