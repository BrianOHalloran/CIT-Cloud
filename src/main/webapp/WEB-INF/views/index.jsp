<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>
<head>
<title>Event Booking Application</title>
<style type="text/css">
body 
{
	background-color: #F3E2A9;
	font-family: Trebuchet MS, Verdana;
	font-size: 12px;
}
</style>
</head>
<body>
<%--
 	User: <security:authentication property="principal.username"/>
	</br>
	<a href="j_spring_security_logout">Logout</a> 
	</br>
 --%>
 	<h1 align="center">Ticket Slave</h1>
	<h2 align="center"><i>The Alternative Ticket and Event Booking Application</i></h2>
	<img src="springsource.png" align=middle>
	<form action="accounts/account" method="get">
		<input type="submit" value="Login">
	</form>

	<hr>

	<form action="doSearch" method="get">
		Performer (Available: ${fn:length(performers)}): <input type="text" name="performerSelection" />
		<br />
		Location (Available: ${fn:length(locations)}): <input type="text" name="locationSelection" /> 
		<br />
		<input type="submit" value="Search for Events">
		<br />
	</form>

<%-- 
	<form action="doSearch" method="get">
		Select event performer (Available: ${fn:length(performers)})
		<table>
			<select name="performerSelection" size="1">
				<option selected value="ALL_PERFORMERS">All</option>
				<c:forEach var="performer" items="${performers}" varStatus="index">
					<option value="${performer.name}">${performer.name}</option>
				</c:forEach>
			</select>
		</table>
		<hr>

		Select event location (Available: ${fn:length(locations)})
		<table>
			<select name="locationSelection" size="1">
				<option selected value="ALL_LOCATIONS">All</option>
				<c:forEach var="location" items="${locations}" varStatus="index">
					<option value="${location.name}">${location.name}</option>
				</c:forEach>
			</select>
		</table>
		<hr>

		<input type="submit" value="Search for Events">
	</form>
	<hr>
 --%>
</body>
</html>