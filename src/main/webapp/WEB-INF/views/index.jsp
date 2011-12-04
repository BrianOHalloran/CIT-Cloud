<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
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
 	<h1 align="center">Ticket Slave</h1>
	<h2 align="center"><i>The Alternative Ticket and Event Booking Application</i></h2>
	<img src="springsource.png" align=middle>
	<br />
	<br />
	
	<c:choose>
		<c:when test="${loggedIn != 'anonymousUser'}">
		 	User: <security:authentication property="principal.username"/> - <a href="j_spring_security_logout">Logout</a>
		 	<br />
		 	<a href="secure/account.html">My Account</a> 
		 	<br />
		</c:when>
		<c:otherwise>
			<form action="secure/account" method="get">
				<input type="submit" value="Login">
			</form>
		</c:otherwise>	
	</c:choose>
 
	<hr>

	<form action="createCustomer" method="get">
		<input type="submit" value="Create Account">
	</form>

	<hr>

	<h3 align="center"><i>Event Search</i></h3>
	<form action="secure/account" method="post">
		<table border="1" align="center">
			<tr>
				<th width="100">Performer</th>
				<th width="100">Location</th>
				<th width="100">Ticket Count</th>
				<th width="100">Book</th>
			</tr>
			<tr align="center">
				<td>
					<select name="performerName" size="1">
						<c:forEach var="performer" items="${performers}" varStatus="index">
							<option>${performer.name}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="locationName" size="1">
						<c:forEach var="location" items="${locations}" varStatus="index">
							<option>${location.name}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="ticketCountSelection" size="1">
						<option value="1">1</option>
						<option selected value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
				<td><input type="submit" value="Book Event" /></td>
			</tr>
		</table>
	</form>

	<hr>

	<h3 align="center"><i>Current Event Listings</i></h3>
	<table border="1" align="center">
		<tr>
			<th width="100">Performer</th>
			<th width="100">Location</th>
			<th width="100">Event Name</th>
			<th width="100">Tickets Remaining</th>
		</tr>
		<c:forEach var="event" items="${events}" varStatus="index">
			<tr align="center">
				<td>${event.performer.name}</td>
				<td>${event.location.name}</td>
				<td>${event.eventName}</td>
				<td>${event.ticketCount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>