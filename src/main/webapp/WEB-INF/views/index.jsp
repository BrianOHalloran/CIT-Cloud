<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>
<head>
<title>Event Booking Application</title>
<style type="text/css">
body
{
	font-family: Trebuchet MS, Verdana;
	font-size: 12px;
}
</style>
</head>
<body>
	<h1>Event Booking Application</h1>
	<img src="springsource.png">
	<form method="post">
		TODO text:<br>
		<textarea name="text" cols="50" rows="5"></textarea>
		<br> <input type="submit">
	</form>
	<hr>

	List of current performers (total: ${fn:length(performers)}) : 
	<table>
		<select name="performerList" size="1">
			<c:forEach var="performer" items="${performers}" varStatus="index">
				<option selected value="${performer.name}">${performer.name}</option>
<%--
 				<tr>
					<td>${index.count}.</td>
					<td>${performer.name}</td>
				</tr>
 --%>
 			</c:forEach>
		</select>
	</table>
	<hr>
	
	List of current locations (total: ${fn:length(locations)}) :
	<table>
		<c:forEach var="location" items="${locations}" varStatus="index">
			<tr>
				<td>${index.count}.</td>
				<td>${location.name}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>

</body>
</html>