<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="bootstrap-4.5.0-dist/css/bootstrap.css" />
<link rel="stylesheet" href="style.css" />
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
</head>
<body class="d-flex flex-column h-100">
	<header class="mb-5">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<main role="main" class="flex-shrink-0">

			<img src="images/home.png" class="img-fluid" alt="">
			<c:if test="${empty user}">

			</c:if>
		
	</main>
	<footer class="footer mt-auto py-3" style="background-color: #546e7a">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<script src="bootstrap-4.5.0-dist/jquery-3.5.1.min.js"></script>
	<script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</body>
</html>

