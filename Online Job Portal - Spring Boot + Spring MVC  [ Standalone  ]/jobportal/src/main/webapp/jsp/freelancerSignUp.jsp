<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

 <link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>

    <title>SIGN UP</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Online Job Portal</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Sign Up</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <div class="container font-weight-normal text-monospcae">
            <h3 class="text-center font-weight-normal text-monospcae">Personal Information</h3>
            <p class="text-center font-weight-normal text-monospcae">Please enter your information and proceed to the next step so we
                can build your accounts. </p>
        </div>
        <form action="/freelancerSignUp" method="POST">
           <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control col-6"name="userName" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="example@email.com" required>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                    else.</small>
            </div>
            <div class="form-group">
                <label>First Name</label>
                <input type="text" class="form-control col-6 " name="firstName"id="exampleInputname" placeholder="First Name" required>
            </div>
            <div class="form-group">
                <label>Last Name</label>
                <input type="text" class="form-control col-6" name="lastName"id="exampleInputname" placeholder="Last Name" required>
            </div>
            
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control col-6"name="password" id="exampleInputPassword1" required>
            </div>
           
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>

</html>