<%@ page session="true"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.entity.User"%>

<%
	User user = (User) request.getSession().getAttribute("user");
%>
<meta charset="utf-8">
<nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: #546e7a;">
	<a class="navbar-brand" href="#">Made By AGA</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">

		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/todolist/index.jsp">Home <span
					class="sr-only">(current)</span>
			</a></li>
			<c:if test="${not empty user}">
			<li class="nav-item"><a class="nav-link" href="user/tasks">My Todos</a></li>
			</c:if>
		</ul>
		<c:if test="${empty user}">
			<form action="login" class="form-inline mt-2 mt-md-0">
				<button class="btn btn-primary mr-3 my-2 my-sm-0" type="submit">Sign
					in</button>
			</form>
			<form action="register" class="form-inline mt-2 mt-md-0">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Register</button>
			</form>
		</c:if>

		<c:if test="${not empty user}">
			<ul class="navbar-nav mr-5">
				<li class="nav-item"><p class="nav-link disabled"> <span> Hello ${user.getName()}</span></p></li>
				<li class="nav-item"><a class="nav-link" href="/todolist/logout">Logout</a></li>
			</ul>
		</c:if>
	</div>
</nav>
