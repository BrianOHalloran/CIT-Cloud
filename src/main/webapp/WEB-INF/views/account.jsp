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

 	User: <security:authentication property="principal.username"/> : <a href="j_spring_security_logout">Logout</a> 
 
	<br />

 	<h1 align="center">Ticket Slave Account Section</h1>
	<hr>
<%-- 
	<h2 align="center">
		<i>Account details for <security:authentication property="principal.username"/></i>
	</h2>
	
	<table border="1" align="center">
		<tr>
			<th width="100">Customer Name</th>
			<th width="100">Phone</th>
			<th width="100">Credit Card</th>
		</tr>
		<tr>
			<td>${customerName}</td>
			<td>${customerPhone}</td>
			<td>${customerCreditCard}</td>
		</tr>
	</table>
	<hr>
 --%>
	<h2 align="center">
		<i>Booking history for <security:authentication property="principal.username"/></i>
	</h2>

	<table border="1" align="center">
		<tr>
			<th width="100">Performer</th>
			<th width="100">Location</th>
			<th width="100">Event Name</th>
			<th width="100">Number of tickets</th>
		</tr>
		<c:forEach var="booking" items="${bookings}" varStatus="index">
			<tr>
				<td>${booking.event.performer.name}</td>
				<td>${booking.event.location.name}</td>
				<td>${booking.event.eventName}</td>
				<td>${booking.numTickets}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	
	Booking complete.  Booking id is ${bookingId}

<%-- 
	<form action="createBooking" method="post">
		Book event: ${eventName} with ${ticketCountSelection} tickets? <input type="submit" value="Book tickets">
	</form>
 --%>	
<!-- 	
	<form action="customerCreateDetails" method="post">
		<b>Book Event</b>
		<table>
			<tr>
				<td>Performer</td>
				<td></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="customerPhone" /></td>
			</tr>
			<tr>
				<td>Credit Card</td>
				<td><input type="text" name="customerCreditCard" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="customerUsername" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="customerPassword" /></td>
			</tr>
		</table>

		<input type="submit" value="Create Account">
	</form>
 -->	
	
</body>
</html>