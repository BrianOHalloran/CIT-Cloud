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

	<h2 align="center">
		<i>Search results</i>
	</h2>
	<form action="secure/account" method="post">
	<table border="1" align="center">
		<tr>
			<th width="100">Performer</th>
			<th width="100">Location</th>
			<th width="100">Event Name</th>
			<th width="100">Date</th>
			<th width="100">Remaining</th>
			<th width="100">Ticket Count</th>
			<th width="100">Book</th>
			</tr>
		<c:forEach var="event" items="${events}" varStatus="index">
			<tr align="center">
				<td>${event.performer.name}</td>
				<td>${event.location.name}</td>
				<td>${event.eventName}</td>
				<td>${event.date}</td>
				<td>${event.ticketCount}</td>
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
		</c:forEach>
	</table>
	</form>
	</body>
</html>
