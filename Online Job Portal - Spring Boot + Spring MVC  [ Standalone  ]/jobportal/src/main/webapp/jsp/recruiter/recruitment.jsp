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
								<th scope="col">Applicant Id</th>
								<th scope="col">Name</th>
								<th scope="col">Email</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${applicants}" var="applicant">
								<tr>
									<td>${applicant.getFreelancerId()}</td>
									<td>${applicant.getFreelancerName()}</td>
									<td>${applicant.getFreelancerUName()}</td>
									<td><button type="button" class="btn btn-warning"
											data-toggle="modal"
											data-target="#modal-${applicant.getFreelancerId()}">
											View</button> <!-- Modal -->
										<div class="modal fade"
											id="modal-${applicant.getFreelancerId()}" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Cover
															Letter</h5>

														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">
														<p>${applicant.getCoverLetter()}</p>
													</div>
													<div class="modal-footer">
														<form
															action="/recruiter/awardjob/${applicant.getFreelancerUName()}/${applicant.getJobId()}"
															method="GET">
															<button type="submit" class="btn btn-success">Confirm
																Recruitment</button>
														</form>
														<form
															action="/recruiter/email/${applicant.getFreelancerUName()}/${applicant.getJobId()}"
															method="GET">
															<button type="submit" class="btn btn-success">Schedule
																Interview</button>
														</form>
													</div>

												</div>
											</div>
										</div></td>

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