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
<spring:url value="/resources/css/employeeEvent.css" var="mainCss" />
<spring:url value="/resources/js/jquery-1.8.3.min.js" var="jqueryJs" />
<spring:url value="/resources/js/employeeEvent.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${mainJs}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div class="selfAssesemtnForm">
		<div>
			<h1 align="center">Employee - Event Registration Form</h1>
		</div>
		<div id="mainContent" class="shadow">
			<form:form id="registerEmployeeEventForm"
				action="/EventRegistrationSystem/event/submitRegisterEmployeeEventForm" commandName="registerEmployeeEventForm">

				<form:errors path="*" cssClass="errorblock" element="div" />
				<table align="center" style="with: 50%">
					<tr>
						<td>Employee Name :</td>
						<td><form:select path="mid" id="mid" class="selectMenu">
								<form:option value="" label="Select" />
								<c:forEach var="employee" items="${listEmployee}">
									<form:option value="${employee.mid}" label="${employee.name}" />
								</c:forEach>
							</form:select></td>
						<td><form:errors path="mid" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Event Title :</td>
						<td><form:select path="eventId" id="eventId" class="selectMenu">
								<form:option value="" label="Select" />
								<c:forEach var="event" items="${listEvent}">
									<form:option value="${event.eventId}" label="${event.eventTitle}" />
								</c:forEach>
							</form:select></td>
						<td><form:errors path="eventId" cssClass="error" /></td>
					</tr>
					<tr>
						<td><a  id="cancel" class="btn cancel" href="<c:url value='/event/cancel'/>">cancel</a></td>
						<td><input type="button" id="register" class="register btn" value="Register"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>