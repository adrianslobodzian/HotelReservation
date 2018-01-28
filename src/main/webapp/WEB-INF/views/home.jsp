<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<a href=register>zarejestruj</a>
	<br>
	<a href=login>przejdz do logowania</a>
	<br>
	<a href=logout>wyloguj</a>
	<br> ${infoLoged}
	<br>
	<h1>${succes}</h1>
	<h2>Witaj w Schronisku Morskie Oko</h2>
	<a href=reservation/serch>zarezerwuj pokój</a>
	<br>

</body>
</html>
