<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<html>
<head>
<spring:url value="/resources/css/employeeEvent.css" var="mainCss" />
<spring:url value="/resources/js/jquery-1.8.3.min.js" var="jqueryJs" />
<spring:url value="/resources/js/employeeEvent.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${mainJs}"></script>
<title>Home</title>
</head>
<body>
	<c:if test="${not empty registerEmployeeEventSuccess}">
		<div class="errorblock">
			<c:out value="${registerEmployeeEventSuccess}"></c:out>
		</div>
	</c:if>
	<div>
		<h1 align="center">Event Registration System</h1>
	</div>
	<div class="homepage">
		<a id="registerEmployeeForEvents" href="<c:url value='/event/registerEmployeeForEvents'/>">Register employee for events</a><br />
		<a id="registerEmployeeForEvents" href="<c:url value='/event/displayAllEmployeeEvents'/>">Display all Employee's Events</a><br />
		<a id="registerEmployeeForEvents" href="<c:url value='/event/displayAllEmployees'/>">Display all Employee's</a><br />
		<a id="registerEmployeeForEvents" href="<c:url value='/event/displayAllEvents'/>">Display all Events</a><br />
	</div>
</body>
</html>