<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Admin Home</title>
</head>

<body>
	<header>
		<nav class="navbar navbar-light bg-light">
			<span class="navbar-brand mb-0 h1">Online Job Portal |
				Administrator Desk</span>
			<p class="text-right navbar-brand h1">${loggedUser}</p>
			<form id="logout" action="/home" method="get">
				<button class="btn btn-outline-danger btn-block" type="submit">Log
					Out</button>
			</form>
		</nav>
	</header>
	<div class="container-fluid">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active btn-outline-info" id="home-tab"
				data-toggle="tab" href="#home" role="tab" aria-controls="home"
				aria-selected="true">Home</a></li>
			<li class="nav-item" role="presentation"><a
				class="nav-link btn-outline-info" id="freelancer-tab"
				data-toggle="tab" href="#freelancer" role="tab"
				aria-controls="freelancer" aria-selected="false">Freelancers</a></li>
			<li class="nav-item" role="presentation"><a
				class="nav-link btn-outline-info" id="recruiter-tab"
				data-toggle="tab" href="#recruiter" role="tab"
				aria-controls="recruiter" aria-selected="false">Recruiters</a></li>
			<li class="nav-item" role="presentation"><a
				class="nav-link btn-outline-info" id="job-tab" data-toggle="tab"
				href="#job" role="tab" aria-controls="job" aria-selected="false">Jobs</a></li>
			<li class="nav-item" role="presentation"><a
				class="nav-link btn-outline-info" id="jobapplication-tab"
				data-toggle="tab" href="#jobapplication" role="tab"
				aria-controls="jobapplication" aria-selected="false">Job
					Applications</a></li>
			<li class="nav-item" role="presentation"><a
				class="nav-link btn-outline-info" id="skill-tab" data-toggle="tab"
				href="#skill" role="tab" aria-controls="skill" aria-selected="false">Skills
			</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active border rounded" id="home"
				role="tabpanel" aria-labelledby="home-tab">

				<div id="message"></div>
				<div id="error"></div>
				<table class="table">
					<tbody>
						<c:forEach items="${logs}" var="log">
							<tr>
								<td>${log}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				...
			</div>

			<div class="tab-pane fade border rounded" id="freelancer"
				role="tabpanel" aria-labelledby="profile-tab">
				<nav class="navbar navbar-light bg-light">
					<form class="form-inline">
						<input class="form-control " type="text" id="searchFreelancer"
							onkeyup="myFunction(mytable='freelancers',id='searchFreelancer', index=0)"
							placeholder="Search by Freelancer's name" />
					</form>

				</nav>

				<table class="table" id="freelancers">
					<caption>Freelancer's Records</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">User Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${freelancers}" var="freelancer">
							<tr>
								<td>${freelancer.getFirstName()}</td>
								<td>${freelancer.getLastName()}</td>
								<td>${freelancer.getUserName()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				@${freelancers}
			</div>

			<div class="tab-pane fade border rounded" id="recruiter"
				role="tabpanel" aria-labelledby="recruiter-tab">
				<nav class="navbar navbar-light bg-light">
					<form class="form-inline">
						<input class="form-control " type="text" id="searchRecruiter"
							onkeyup="myFunction(mytable='recruiters',id='searchRecruiter', index=0)"
							placeholder="Search for Recruiter's name" />
					</form>

					
				</nav>

				<table class="table" id="recruiters">
					<caption>Recruiter Records</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">User Name</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recruiters}" var="recruiter">
							<tr>
								<td>${recruiter.getFirstName()}</td>
								<td>${recruiter.getLastName()}</td>
								<td>${recruiter.getUserName()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				@${recruiters}
			</div>

			<div class="tab-pane fade border rounded" id="job" role="tabpanel"
				aria-labelledby="job-tab">
				<nav class="navbar navbar-light bg-light">
					<form class="form-inline">
						<input class="form-control " type="text" id="searchJob"
							onkeyup="myFunction(myTable='jobs',id='searchJob', index=2)"
							placeholder="Search for Job's name" />
					</form>

				</nav>

				<table class="table" id="jobs">
					<caption>Job Records</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col">Job ID</th>
							<th scope="col">Freelancer Name</th>
							<th scope="col">Skill Name</th>
							<th scope="col">Recruiter Name</th>
							<th scope="col">Job Title</th>
							<th scope="col">Job Description</th>
							<th scope="col">Posted Date</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobs}" var="job">
							<tr>
								<td>${job.getJobId()}</td>
								<td><c:choose>
										<c:when test="job.isJobStatus()">
								Null
								</c:when>
										<c:otherwise>${job.getFreelancerUName()}
								</c:otherwise>
									</c:choose></td>

								<td>${job.getSkillName()}</td>
								<td>${job.getRecruiterName()}</td>
								<td>${job.getJobTitle()}</td>
								<td>${job.getJobDescription()}</td>
								<td>${job.getPostedDate()}</td>
								<td>${job.isJobStatus()}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				@${jobs}
			</div>

			<div class="tab-pane fade border rounded" id="jobapplication"
				role="tabpanel" aria-labelledby="jobapplication-tab">
				<nav class="navbar navbar-light bg-light">
					<form class="form-inline">
						<input class="form-control " type="text" id="searchApplication"
							onkeyup="myFunction(myTable='jobapplications',id='searchApplication', index=0)"
							placeholder="Search by Application Ids" />
					</form>
					
				</nav>

				<table class="table" id="jobapplications">
					<caption>Job Applications</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col">Application ID</th>
							<th scope="col">Job ID</th>
							<th scope="col">Job Title</th>
							<th scope="col">Cover Letter</th>
							<th scope="col">Freelancer UserName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobapplications}" var="jobapplication">
							<tr>
								<td>${jobapplication.getId()}</td>
								<td>${jobapplication.getJobId()}</td>
								<td>${jobapplication.getJobTitle()}</td>
								<td>${jobapplication.getCoverLetter()}</td>
								<td>${jobapplication.getFreelancerUName()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				@${jobapplications}
			</div>
			<div class="tab-pane fade border rounded" id="skill" role="tabpanel"
				aria-labelledby="skill-tab">
				<nav class="navbar navbar-light bg-light">
					<form class="form-inline">
						<input class="form-control " type="text" id="searchSkill"
							onkeyup="myFunction(myTable='skills',id='searchSkill', index=2)"
							placeholder="Search for Skill" />
					</form>
					<!-- Button trigger for Update modal -->
					<button type="button" class="btn btn-outline-warning my-2 my-sm-0"
						data-toggle="modal" data-target="#exampleModal-addSkill">
						Add</button>
					<!-- Button trigger for Delete modal -->
					<button type="button" class="btn btn-outline-danger my-2 my-sm-0"
						data-toggle="modal" data-target="#exampleModal-skillDelete">
						Delete</button>
					<!-- Update Modal -->
					<div class="modal fade" id="exampleModal-addSkill"
						tabindex="-1" aria-labelledby="ModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Enter
										Skill Details</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="/admin/addSkill" method="post">
										<label for="exampleInputName1">Skill Name</label> <input
											class="form-control col-6 "  type="text" name="name" id="skillName" required>
										<label for="exampleInputName1">Skill Description</label> <input
											class="form-control col-6 "  type="text" name="description" id="skillDescription"
											required> <br>
										<button type="submit" class="btn btn-success">Add
											Now</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</form>
								</div>

							</div>
						</div>
					</div>
					

					<!--Delete Modal -->
					<div class="modal fade" id="exampleModal-skillDelete" tabindex="-1"
						aria-labelledby="ModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h6 class="modal-title" id="exampleModalLabel">Enter Skill
										ID to Delete the record.</h6>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="/admin/deleteSkill" method="post">
										<input type="number" name="id" id="skillId" required>
										<button type="submit" class="btn btn-danger">Delete
											Now</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</form>
								</div>

							</div>
						</div>
					</div>
				</nav>

				<table class="table" id="skills">
					<caption>Skills</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col">Skill ID</th>
							<th scope="col">Skill Name</th>
							<th scope="col">Description</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${skills}" var="skill">
							<tr>
								<td>${skill.getId()}</td>
								<td>${skill.getName()}</td>
								<td>${skill.getDescription()}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				@${Skills}
			</div>
		</div>
	</div>


	<script>
		function myFunction(myTable, id, index) {
			// Declare variables
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById(id);
			filter = input.value.toUpperCase();
			table = document.getElementById(myTable);
			tr = table.getElementsByTagName("tr");

			// Loop through all table rows, and hide those who don't match the search query
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[index];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
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
			document.getElementById("message").innerHTML = x;
		}
	</script>

</body>

</html>
