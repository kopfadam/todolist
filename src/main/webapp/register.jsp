<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="bootstrap-4.5.0-dist/css/bootstrap.min.css" />
<style>
html, body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signup {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signup .checkbox {
	font-weight: 400;
}

.form-signup .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signup .form-control:focus {
	z-index: 2;
}

.form-signup input[type="text"] {
	margin-bottom: 10px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signup input[type="email"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.form-signup input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<title>REGISTER</title>
</head>
<body class="text-center">
	<form action="register" method="post" class="form-signup">
		<img class="mb-4" src="images/register.png" alt="" width="140"
			height="140">
		<h1 class="h3 mb-3 font-weight-normal">Please fill in this form
			to create an account</h1>
		<div>

			<label for="name" class="sr-only"><b>Name</b></label> <input
				type="text" class="form-control" placeholder="Enter your name"
				name="name" id="name" required autofocus> <label for="email"
				class="sr-only"><b>Email</b></label> <input type="email"
				class="form-control" placeholder="Enter your email" name="email"
				id="email" required> <label for="pass" class="sr-only"><b>Password</b></label>
			<input type="password" placeholder="Enter your password" name="pass"
				class="form-control" id="pass" required>
			<p class="mt-0 mb-3 1rem text-muted">!!!Your password must
				contain at least one number, one letter and at least 6 or more
				characters!!!</p>

			<button type="submit" value="REGİSTER" id="registerbtn"
				class="btn btn-lg btn-info btn-block">Register</button>
				<br>
				<c:if test="${not empty registeredMessage}">
				<h4>${registeredMessage}</h4>
			<p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
			
				

		</c:if>
		</div>
	
	</form>
	<script src="bootstrap-4.5.0-dist/jquery-3.5.1.min.js"></script>
	<script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</body>
</html>