<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-myapplications"
					role="tabpanel" aria-labelledby="v-pills-myapplications-tab">
					<table class="table table-hover">
						<thead class="table-dark">
							<tr>
								<th scope="col">Job Id</th>
								<th scope="col">Job Title</th>
								<th scope="col">Job Description</th>
								<th scope="col">Skill</th>
								<th scope="col">Date</th>
								<th scope="col">Status</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${applicationslist}" var="applicationslist">
								<tr>
									<td>${applicationslist.getJobId()}</td>
									<td>${applicationslist.getJobTitle()}</td>
									<td>${applicationslist.getJobDescription()}</td>
									<td>${applicationslist.getSkillName()}</td>
									<td>${applicationslist.getPostedDate()}</td>
									<td>${applicationslist.isJobStatus()}</td>
									<td><c:if test="${applicationslist.isJobStatus()}">
											<form
												action="/recruiter/recruit/${applicationslist.getJobId()}"
												method="GET">
												<button type="submit" class="btn btn-warning">
													Recruit</button>
											</form>
										</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

</html>