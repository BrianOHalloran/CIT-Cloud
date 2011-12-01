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

 	<h1 align="center">New Ticket Slave Account</h1>
	<hr>

	<form action="customerCreateDetails" method="post">
		Name:        <input type="text" name="customerName" />
		Phone:       <input type="text" name="customerPhone" />
		Credit Card: <input type="text" name="customerCreditCard" />
		Username:    <input type="text" name="customerUsername" />
		Password:    <input type="text" name="customerPassword" />
		<input type="submit" value="Create Account">
	</form>

</body>
</html>