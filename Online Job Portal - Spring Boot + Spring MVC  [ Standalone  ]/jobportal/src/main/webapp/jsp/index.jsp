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

<title>Job Portal | HOME</title>
</head>

<body>
	<header>
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Online Job Portal</h1>
				<p class="lead">Working Towards Being The BEST !</p>
			</div>
		</div>
		<div class="btn-block" id="errormsg"></div>
	</header>

	<div class="container ">


		<div class="row">
			<div class="card col-sm-6 ">
				<div class="card-header">
					<nav>
						<div class="nav nav-tabs" id="nav-tab" role="tablist">
							<a class="nav-link active" id="nav-home-tab" data-toggle="tab"
								href="#nav-home" role="tab" aria-controls="nav-home"
								aria-selected="true">Freelancer Login</a> <a class="nav-link "
								id="nav-profile-tab" data-toggle="tab" href="#nav-profile"
								role="tab" aria-controls="nav-profile" aria-selected="false">Recruiter's
								Login</a>

						</div>
					</nav>

				</div>
				<div class="card-body">
					<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="nav-home"
							role="tabpanel" aria-labelledby="nav-customer-tab">
							<form action="/freelancer" method="post">

								<div class="form-group">
									<label for="exampleInputEmail1">Email</label> <input
										type="text" name="userName" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp" required>
									<small id="emailHelp" class="form-text text-muted">We'll
										never share your data with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" name="password" class="form-control"
										id="exampleInputPassword1" required>
								</div>

								<button type="submit" class="btn btn-primary">Submit</button>


							</form>
						</div>
						<div class="tab-pane fade" id="nav-profile" role="tabpanel"
							aria-labelledby="nav-profile-tab">
							<form action="/recruiter" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">Email</label> <input
										type="text" name="userName" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp" required>
									<small id="emailHelp" class="form-text text-muted">We'll
										never share your data with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" name="password" class="form-control"
										id="exampleInputPassword1" required>
								</div>

								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>

					</div>


				</div>
			</div>


			<div class="col-sm-1"></div>
			<div class="col-sm-5 ">
				<div class="card align-items-center">
					<div class="card-header active">Register Now</div>
				</div>
				<form class="form-group" action="/freelancerSignUp" method="get">
					<button type="submit" class="btn btn-primary btn-lg btn-block">As
						a Freelancer</button>

				</form>
				<form class="form-group" action="/recruiterSignUp" method="get">
					<button type="submit" class="btn btn-secondary btn-lg btn-block">As
						a Recruiter</button>
				</form>


			</div>
		</div>
	</div>


	<footer style="position: absolute; right: 0;">
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-link" data-toggle="modal"
			data-target="#exampleModal">Admin</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="/admin" method="post">
							<div class="btn-block" id="error"></div>
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" name="userName" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="password" class="form-control"
									id="exampleInputPassword1" required>
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<script type="text/javascript">
		var y = "${error}";
		if (y.length > 0) {
			console.log(y);

			document.getElementById("errormsg").innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">"
					+ y + "</div>";
		}
	</script>




</body>

</html>