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
<title>Dojo Ninja List</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachNinja" items="${dojo.assignedNinjas}">
				<tr>
					<td><c:out value="${eachNinja.firstName}"/></td>
					<td><c:out value="${eachNinja.lastName}"/></td>
					<td><c:out value="${eachNinja.age}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>