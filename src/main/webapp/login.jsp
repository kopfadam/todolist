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

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: 10px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
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
<title>login</title>
</head>
<body class="text-center">
	<form action="login" method="post" class="form-signin">
		<img class="mb-4" src="images/login.png" alt="" width="140"
			height="140">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<div>
			<label for="email" class="sr-only"><b>Username</b></label> <input
				type="email" placeholder="Enter your email" class="form-control"
				name="email" required autofocus /> <label for="pass"
				class="sr-only"><b>Password</b></label> <input type="password"
				placeholder="Enter your password" class="form-control" name="pass"
				required />

			<button type="submit" class="btn btn-lg btn-info btn-block">Sign
				in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
		</div>
	</form>
	<script src="bootstrap-4.5.0-dist/jquery-3.5.1.min.js"></script>
	<script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</body>
</html>