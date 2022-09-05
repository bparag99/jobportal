<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Recruiter Service Desk</title>
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
			<h2>${loggedUser.firstName}</h2>


		</div>
	</nav>

	<div class="container-fluid"></div>

	<div class="row">
		<div class="col-2">
			<div class="nav flex-column nav-pills" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<form id="viewpostedjobs" action="/recruiter/viewpostedjobs" method="get">
					<a class="nav-link" id="v-pills-viewpostedjobstab" data-toggle="pill"
						href="#v-pills-viewpostedjobs"
						onclick="document.getElementById('viewpostedjobs').submit();" role="tab"
						aria-controls="v-pills-viewpostedjobs" aria-selected="true">View Posted Jobs</a>
				</form>
				<form id="addnewjob" action="/recruiter/addnewjob" method="get">
					<a class="nav-link" id="v-pills-addnewjob-tab" data-toggle="pill"
						href="#v-pills-addnewjob"
						onclick="document.getElementById('addnewjob').submit();"
						role="tab" aria-controls="v-pills-addnewjob"
						aria-selected="false">Post a New Job</a>
				</form>
				<form id="profile" action="/recruiter/profile" method="get">
					<a class="nav-link" id="v-pills-profile-tab" data-toggle="pill"
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
			<div id="error"></div>
			<h1 class=" text-monospace text-center">DASHBOARD : Recruiter Services</h1>
		</div>
	</div>
	<script type="text/javascript">
		var x = "";
		var y = "${message}";
		var e ="${error}";
		if (y.length > 1) {
			x = x
					+ "<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">"
					+ y + "</div>";
			document.getElementById("message").innerHTML = x;
		} else if (e.length > 1){
			x = x
			+ "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">"
			+ e + "</div>";
			document.getElementById("error").innerHTML = x;
		}
	</script>

</body>

</html>