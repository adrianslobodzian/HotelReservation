<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Jumbotron Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="../../../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="jumbotron.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
	integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
	crossorigin="anonymous"></script>
</head>

<body>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">


		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item"><a class="nav-link" href=/login>zaloguj
						się</a></li>
				<li class="nav-item"><a class="nav-link" href=/logout>wyloguj
						się</a></li>
				<li class="nav-item"><a class="nav-link" href=/register>zarejestruj
						się</a></li>
				<li class="nav-item" style="color: red">${succes}</li>
			</ul>
			<p class="form-inline my-2 my-lg-0" style="color: red">
				${infoLoged}</p>


		</div>
	</nav>

	<main role="main"> <!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">Schronisko Górskie PTTK w Dolinie Pięciu
				Stawów Polskich</h1>
			<p>Witamy w najwyżej położonym schronisku w Polsce (1670 m
				n.p.m.).</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Czytaj
					więcej &raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Baza hotelowa</h2>
				<p>Posiadamy 67 miejsc noclegowych w pokojach 2, 4, 7, 8, 10 -
					osobowych. W schronisku znajduje się duża, ale bardzo przytulna
					sala jadalna. Tu można zjeść dania oferowane przez naszą kuchnię,
					jak i własny przyniesiony w plecaku prowiant. Miejsce to służy
					również wieczornym spotkaniom.</p>
				<p>
					<a class="btn btn-secondary" href=/reservation/serch role="button">zarezerwuj
						pokój &raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Coś tam</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-secondary" href="#" role="button">Czytaj
						więcej &raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Inne coś tam</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</p>
				<p>
					<a class="btn btn-secondary" href="#" role="button">Czytaj
						więcej &raquo;</a>
				</p>
			</div>
		</div>

		<hr>

	</div>
	<!-- /container --> </main>

	<footer class="container">
		<p>&copy; Company 2017</p>
	</footer>

</body>
</html>