<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<spring:url value="/resources/css/displayEmployeeEvents.css"
	var="mainCss" />
<spring:url value="/resources/js/jquery-1.8.3.min.js" var="jqueryJs" />
<spring:url value="/resources/js/employeeEvent.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${mainJs}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h2 align="center">Employee - Event List</h2>
	<table align="center" class="zonaltable">
		<tr>
			<th>MID</th>
			<th>Name</th>
			<th>Event Title</th>
		</tr>
		<c:forEach items="${employeeEvents}" var="employeeEvent">
			<tr>
				<td align="left">${employeeEvent.pk.employee.mid}</td>
				<td align="left">${employeeEvent.pk.employee.name}</td>
				<td align="left">${employeeEvent.pk.event.eventTitle}</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		<a id="cancel" class="btn cancel"
			href="<c:url value='/event/cancel'/>">cancel</a>
	</p>
</body>
</html>