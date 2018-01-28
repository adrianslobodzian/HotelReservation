<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Select a Date Range</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#from").datepicker({
			defaultDate : "+1w",
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			numberOfMonths : 3,
			onClose : function(selectedDate) {
				$("#to").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#to").datepicker({
			defaultDate : "+1w",
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			numberOfMonths : 3,
			onClose : function(selectedDate) {
				$("#from").datepicker("option", "maxDate", selectedDate);
			}
		});
	});
</script>
</head>
<body>
	<h1>${info}</h1>
	<br>
	<h2>Wybierz datę zameldowania i wymeldowania</h2>

	<form:form method="post" modelAttribute="reservation">

		<label for="from">Data zameldowania:</label>
		<form:input id="from" path="starts" />
		<form:errors path="starts" />
		<br>
		<label for="to">Data wymeldowania:</label>
		<form:input id="to" path="ends" />
		<form:errors path="ends" />
		<br>
		<input type="submit" value="sprawdź dostępność pokojów">
	</form:form>
</body>
</html>