<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style type="text/css">
		body 
		{
			background-color: #F3E2A9;
			font-family: Trebuchet MS, Verdana;
			font-size: 12px;
		}
		</style>
		<title>Event Booking Search Results</title>
	</head>
	<body>
	<h1 align="center">Ticket Slave</h1>
	<h2 align="center"><i>The Alternative Ticket and Event Booking Application</i></h2>
	<img src="springsource.png" align="middle">
	<form action="accounts/account" method="get">
		<input type="submit" value="Login">
	</form>

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



	<h2 align="center">
		<i>Search results</i>
	</h2>
	<form action="bookEvent" method="post">
		<table border="1" align="center">
			<tr>
				<th width="100">Performer</th>
				<th width="100">Location</th>
				<th width="100">Event Name</th>
				<th width="100">Date</th>
				<th width="100">Event Id</th>
				<th width="100">Number of tickets</th>
				<th width="100">Book me?</th>
			</tr>
			<c:forEach var="event" items="${events}" varStatus="index">
				<tr>
					<td>${event.performer.name}</td>
					<td>${event.location.name}</td>
					<td>${event.eventName}</td>
					<td>${event.date}</td>
					<td>${event.id}</td>
					<select name="ticketCountSelection" size="1">
						<option value="1">1</option>
						<option selected value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
					<input type="submit" value="Book Event">
				</tr>
			</c:forEach>
		</table>
	</form>
	<%-- 
	<table>
		<c:forEach var="event" items="${events}" varStatus="index">
			<p>
				<td>${event.performer.name}</td>
				<td>${event.location.name}</td>
				<td>${event.eventName}</td>
			</p>
			<br />
		</c:forEach>
	</table>
	<hr>
 --%>
	</body>
</html>
