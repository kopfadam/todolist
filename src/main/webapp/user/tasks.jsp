<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">

<title>Tasks</title>
<style type="text/css">
<style type ="text /css">body {
	display: grid;
	grid-template-columns: 1fr 5fr 1fr;
	height: 720px;
	width: 1500px;
}

#content {
	display: grid;
	grid-template-rows: 1fr 5fr 1fr;
}

div {
	/*border: thin dashed black;*/
	
}

<style>#tasksheader {
	display: grid;
	grid-template-columns: 2fr 5fr 1fr;
}

hr {
	border-top: 1px solid green;
}

#formAdd {
	background-color: #f5f5f5;
}
</style>

</head>
<body>
	<header>
		<jsp:include page="/header.jsp"></jsp:include>
	</header>
	<main role="main" class="flex-shrink-0">
		<div class="task-container mt-5">
			<div class="row justify-content-between">

				<!-- Add Task Part -->
				<div class="col-md-4 order-md-2 mb-4 mt-5 mr-5 ">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Add Task</span>
					</h4>
					<hr class="mb-4">

					<form class="card p-2 bg-secondary" action="todo" method="post">

						<table id="formAdd" class="bg-light table table-hover">
							<tr>
								<td><input type="text" name="title"
									placeholder="Enter Title"
									class="form-control border border-info" required></td>
							</tr>
							<tr>
								<td><input type="text" name="description"
									class="form-control border border-info"
									placeholder="Enter Description"></td>
							</tr>
							<tr>
								<td>Date:&emsp;&emsp;<input type="date" name="date"
									placeholder="YY-MM-DD" class="form-control border border-info"
									required></td>
							</tr>
							<tr>
								<td>Status:&emsp;&emsp;<input type="radio" name="status"
									class="border border-info" value="complete">&nbsp;Open
									&emsp;&emsp;&emsp;&emsp;<input type="radio" name="status"
									class="border border-info" value="incomplete">&nbsp;Close
								</td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-info form-control"
										value="ADD">ADD</button></td>
							</tr>

						</table>
					</form>
				</div>

				<!-- Your Tasks Part -->
				<div class="mt-5  ml-5 col-md-6 order-md-1 ">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Your Tasks</span>
					</h4>

					<hr class="mb-4">
					<div>
						
						<c:if test="${empty messageTask}">
						
							<table class="table table-striped">
								<thead class="thead-dark">
									<tr>
										<th scope="col">#</th>
										<th scope="col">Title</th>
										<th scope="col">Description</th>
										<th scope="col">Date</th>
										<th scope="col">Status</th>
										<th scope="col">Edit</th>
										<th scope="col">Delete</th>
									</tr>
								</thead>
								<c:set var="counter" value="1" scope="page" />
								<c:forEach items="${todos}" var="todo">
								
									<tbody>
										<tr>
											<th scope="row">${counter}</th>
											<td>${todo.title}</td>
											<td>${todo.description}</td>
											<td>${todo.todoDate}</td>
											<td><c:set value="${todo.todoStatus}" var="bool" /> <c:out
													value="${bool eq true ? 'Open': 'Close'}" /></td>

											<td><button type="button" class="btn" id="${todo.id}"
													onClick="editTask(this)">
													<img alt="" src="/todo_app/images/pencil.png" width="32"
														height="32">
												</button></td>

											<td><a href="delete?id=${todo.id}"><img alt=""
													src="/todo_app/images/delete.png" width="32" height="32">
											</a></td>
									</tbody>
									<c:set var="counter" value="${counter + 1}" scope="page" />
								</c:forEach>
							</table>
						</c:if>

						<c:if test="${not empty messageTask}">
							<p>${messageTask}</p>

						</c:if>
					</div>

				</div>


			</div>
		</div>
	</main>

	<footer class="footer mt-auto py-3" style="background-color: #546e7a">
		<jsp:include page="/footer.jsp"></jsp:include>
	</footer>

	<!-- Modal part -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Edit Task</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>



			</div>
		</div>
	</div>
	<c:remove var="counter" scope="request" />

	<script>
		function editTask(element) {
			var id = element.getAttribute('id');
			var url = 'edit?id=' + String(id);
			console.log(id);
			$('.modal-body').load(url, function() {
				$('#editModal').modal({
					show : true
				});
			});
		}
	</script>
</body>
</html>