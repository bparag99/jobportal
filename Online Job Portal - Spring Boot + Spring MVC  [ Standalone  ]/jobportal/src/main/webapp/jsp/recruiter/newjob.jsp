<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Recruiter Service Desk</title>
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
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
					tabindex="-1" aria-disabled="true"></a></li>
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
					<a class="nav-link active" id="v-pills-addnewjob-tab" data-toggle="pill"
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
			<div class="row form-group mt-5">
				<h4 class="text-monospace text-center ">Please fill up the
					below details to post a new Job !</h4>
			</div>
			<div class="row form-group">
				<div class="col-5">
					<form action="/recruiter/postjob" method="POST">
						<input type="hidden" id="recruiterUName" name="recruiterUName"
							value="${loggedUser.getUserName()}" />
						<div class="form-group">
							<label for="formGroupExampleInput">Job Title</label> <input
								type="text" class="form-control" id="formGroupExampleInput2"
								placeholder="Enter Job Title" name="jobTitle" required>
						</div>
						
						<div class="form-group">
							<label for="exampleFormControlSelect1">Skills </label> <select
								class="form-control " name="skillId">
								<c:forEach items="${skills}" var="skill">
									<option value="${skill.getId()}">${skill.getName()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="formGroupExampleInput2">Job Description</label> <input
								type="text" class="form-control" id="formGroupExampleInput2"
								placeholder="Enter Job Description" name="jobDescription"
								required>
						</div>
						<button type="submit" class="btn btn-outline-success btn-lg">Submit</button>
					</form>
				</div>
			</div>
		</div>



	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.js-example-basic-multiple').select2();
		});
	</script>


</body>

</html>