<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="reservation">
		Wybierz ilu osobowy chcesz pokój<form:radiobuttons items="${serchRooms}" itemLabel="roomSize"
			itemValue="id" path="room.id" />
		<form:hidden path="starts" value= "${reservation.starts}" />
		<form:hidden path="ends" value= "${reservation.ends}" />
		<br>
		<input type="submit" value="zapisz rezerwację">
		<a href=/reservation/serch>wróć do wyszukiwania</a>
	</form:form>
</body>
</html>