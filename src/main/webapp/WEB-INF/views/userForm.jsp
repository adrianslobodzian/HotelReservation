<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">

		<form:input path="firstname" placeholder="firstname" />
		<form:errors path="firstname" />

		<form:input path="lastname" placeholder="lastname" />
		<form:errors path="lastname" />

		<form:input path="email" placeholder="email" />
		<form:errors path="email" />

		<form:password path="password" placeholder="password" />
		<form:errors path="password" />

		<input type="submit" value="zarejestruj">
	</form:form>


</body>
</html>