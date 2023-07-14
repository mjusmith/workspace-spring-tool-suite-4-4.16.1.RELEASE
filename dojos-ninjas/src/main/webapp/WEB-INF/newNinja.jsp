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
<title>Create Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninja/new" method="POST" modelAttribute="newNinja">
	    <form:label path="dojo">Dojo: </form:label>
	        <form:select path="dojo">
	            <c:forEach var="eachDojo" items="${dojoList}">
	                <form:option value="${eachDojo.id}">
	                    <c:out value="${eachDojo.name}"/>
	                </form:option>
	            </c:forEach>
	        </form:select>
			<br/>
			<br/>
		<form:label path="firstName">First Name: </form:label>
		<form:input type="text" path="firstName"></form:input>
		<form:errors path="firstName"/>
			<br/>
			<br/>
		<form:label path="lastName">Last Name: </form:label>
		<form:input type="text" path="lastName"></form:input>
		<form:errors path="lastName"/>
			<br/>
			<br/>
		<form:label path="age">Age: </form:label>
		<form:input type="number" path="age"></form:input>
		<form:errors path="age"/>
			<br/>
			<br/>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>