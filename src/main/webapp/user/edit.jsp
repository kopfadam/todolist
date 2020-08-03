<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit task</title> !-- Favicons -->
<meta name="theme-color" content="#563d7c">

<!-- Custom styles for this template -- main style will come here -->

<!-- jQuery library -->
<script src="/todolist/bootstrap-4.5.0-dist/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="/todolist/bootstrap-4.5.0-dist/css/bootstrap.min.css" />
<script src="/todolist/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="task-container">
		<div class="d-flex justify-content-center">
			<div class="col-md-12 mb-3">
				<form action="edit" method="get" class="card p-2">
					<div class="mb-3">
						<label for="title">Title <span class="text-muted"></span></label>
						<input type="text" class="form-control" id="modal-title"
							name="title" value="${todo.title}" required>
					</div>
					<div class="mb-3">
						<label for="description">Description <span
							class="text-muted">(Optional)</span></label> <input type="text"
							class="form-control" id="modal-description" name="description"
							value="${todo.description}">
					</div>
					<div class="mb-3">
						<label for="date">Date<span class="text-muted"></span></label> <input
							type="date" class="form-control" id="modal-date" name="date"
							value="${todo.todoDate}" required>
					</div>

					<c:choose>
						<c:when test="${todo.todoStatus == true}">
							<div class="row ml-1">
								<label for="status">Status<span
									class="text-muted font-italic"></span></label>
								<div class="col-md-3 mb-3 mr-5">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="radio" name="status"
													aria-label="Radio button for following text input"
													id="complete" value="complete" checked>
											</div>
											<span class="ml-2">Open</span>
										</div>
									</div>
								</div>
								<div class="col-md-3 mb-3">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="radio" name="status"
													aria-label="Radio button for following text input"
													id="incomplete" value="incomplete">
											</div>
											<span class="ml-2">Close</span>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:when test="${todo.todoStatus == false}">
							<div class="row ml-1">
								<label for="status">Status<span
									class="text-muted font-italic"></span></label>
								<div class="col-md-3 mb-3 mr-5">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="radio" name="status"
													aria-label="Radio button for following text input"
													id="complete" value="complete">
											</div>
											<span class="ml-2">Open</span>
										</div>
									</div>
								</div>
								<div class="col-md-3 mb-3">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="radio" name="status"
													aria-label="Radio button for following text input"
													id="incomplete" value="incomplete" checked>
											</div>
											<span class="ml-2">Close</span>
										</div>
									</div>
								</div>
							</div>
						</c:when>
					</c:choose>

					<button class="btn btn-primary btn-lg btn-block" name="update"
						type="submit">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>