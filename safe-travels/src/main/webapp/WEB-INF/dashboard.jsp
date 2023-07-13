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
<title>Travel Dashboard</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachTravel" items="${travelList}">
				<tr>
					<td><a href="/travel/${eachTravel.id }"><c:out value="${eachTravel.expense}"/></a></td>
					<td><c:out value="${eachTravel.vendor}"/></td>
					<td><c:out value="${eachTravel.amount}"/></td>
					<td><a href="/travel/${eachTravel.id}/edit">edit</a></td>
					<form action="/travel/${eachTravel.id }" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<td><button type="submit">DELETE</button></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<h1>Add Expense</h1>
	<form:form action="/travel-dash" method="post" modelAttribute="newTravel">
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
		<button type="submit">Add</button>
	</form:form>
</body>
</html>