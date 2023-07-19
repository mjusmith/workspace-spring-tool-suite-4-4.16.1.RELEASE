<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login & Reg</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>Register</h1>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<div class="form-inline">
				<form:label path="userName">Username: </form:label>
				<form:input type="text" path="userName"></form:input>
				<form:errors path="userName"/>
			</div>
			<br/>
			<div class="form-inline">
				<form:label path="email">Email: </form:label>
				<form:input type="text" path="email"></form:input>
				<form:errors path="email"/>
			</div>
			<br/>
			<div class="form-inline">
				<form:label path="password">Password: </form:label>
				<form:input type="password" path="password"></form:input>
				<form:errors path="password"/>
			</div>
			<br/>
			<div class="form-inline">
				<form:label path="confirm">Confirm password: </form:label>
				<form:input type="password" path="confirm"></form:input>
				<form:errors path="confirm"/>
			</div>
			<br/>
			<button type="submit" class="btn btn-primary">Submit</button>
			<br/>
			<br/>
			<br/>
			<br/>
		</form:form>

		<h1>Login</h1>
		<form:form action="/login" method="POST" modelAttribute="newLogin">
			<div class="form-inline">
				<form:label path="email">Email: </form:label>
				<form:input type="text" path="email"></form:input>
				<form:errors path="email"/>
			</div>
			<br/>
			<div class="form-inline">
				<form:label path="password">Password: </form:label>
				<form:input type="password" path="password"></form:input>
				<form:errors path="password"/>
			</div>
			<br/>
			<button type="submit" class="btn btn-primary">Login</button>
		</form:form>

	</div>
</body>
</html>