<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Display</title>
</head>
<body>
<h1>Your Result: </h1>
<br/>
<br/>
	<h3>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, selling origamis for a living.
	<br/>
	  The next time you see a <c:out value="${thingLiving}"/>, you will have good luck.
	<br/>
	  Also, <c:out value="${niceComment}"/>.</h3>
</body>
</html>