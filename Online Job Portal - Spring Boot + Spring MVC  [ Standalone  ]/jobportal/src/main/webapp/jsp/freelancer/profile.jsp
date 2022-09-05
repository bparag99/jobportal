<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Freelancer Service Desk</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
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
			<h2>${loggedUser.getFirstName()}</h2>


		</div>
	</nav>

	<div class="container-fluid"></div>

	<div class="row">
		<div class="col-2">
			<div class="nav flex-column nav-pills" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<form id="myapplicationss" action="/freelancer/myapplications" method="get">
					<a class="nav-link" id="v-pills-myapplications-tab" data-toggle="pill"
						href="#v-pills-myapplications"
						onclick="document.getElementById('myapplicationss').submit();"
						role="tab" aria-controls="v-pills-myapplications" aria-selected="true">My
						Applications</a>
				</form>
				<form id="jobsearch" action="/freelancer/jobsearch" method="get">
					<a class="nav-link" id="v-pills-jobsearch-tab"
						data-toggle="pill" href="#v-pills-jobsearch"
						onclick="document.getElementById('jobsearch').submit();"
						role="tab" aria-controls="v-pills-mybookings"
						aria-selected="false">Job Search</a>
				</form>
				
				<form id="profile" action="/freelancer/profile" method="get">
					<a class="nav-link active" id="v-pills-profile-tab" data-toggle="pill"
						href="#v-pills-profile" role="tab"
						onclick="document.getElementById('profile').submit();"
						aria-controls="v-pills-profile" aria-selected="false">Profile</a>
				</form>
				<form id="logout" action="/home" method="get">
					<button class="btn btn-outline-danger btn-block" type="submit">Log
						Out</button>
				</form>
			</div>
		</div>
		<div class="col-10">
			<div id="message"></div>
			<form action="/freelancer/updatepassword" method="post">

				<div class="form-group">
					<label for="exampleInputPassword1">Current Password</label> <input
						type="password" class="form-control col-6" name="currentPassword"
						id="exampleInputPassword1" required>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">New Password</label> <input
						type="password" class="form-control col-6" name="nPassword"
						onChange="onChange()" id="nPassword" required>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1"> Confirm New Password</label> <input
						type="password" class="form-control col-6" name="cPpassword"
						onChange="onChange()" id="cPassword" required>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var password = document.getElementById("nPassword"), confirm_password = document
				.getElementById("cPassword");

		function validatePassword() {
			if (password.value != confirm_password.value) {
				confirm_password.setCustomValidity("Passwords Don't Match");
			} else {
				confirm_password.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>
	<script type="text/javascript">
		var x = "";
		var y = "${message}";
		var e = "${error}";
		if (y.length > 1) {
			x = x
					+ "<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">"
					+ y + "</div>";
			document.getElementById("message").innerHTML = x;
		} else if (e.length > 1) {
			x = x
					+ "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">"
					+ e + "</div>";
			document.getElementById("error").innerHTML = x;
		}
	</script>

</body>

</html>