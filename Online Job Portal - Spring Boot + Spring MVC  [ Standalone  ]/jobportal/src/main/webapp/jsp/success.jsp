<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>

<title>Home</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Online Job Portal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">Home</a></li>
			</ul>

			<small class="disabled">Welcome ! </small>
			<h2>${loggedUser.firstName}</h2>


		</div>
	</nav>
	<div class="container font-weight-normal text-monospcae">
		<h1 class="text-center font-weight-normal text-monospcae">Registration
			Successful !</h1>
		<h3 class="text-center font-weight-normal text-monospcae">"Your are now registered as ${loggedUser.getUserName()} "</h3>
		<p class="text-center font-weight-normal text-monospcae">
		
		<button type="button" class="btn btn-outline-primary"><a href="/home">Click Here ! to go to Login Page.</a></button>
		 
		</p>
	</div>

</body>

</html>