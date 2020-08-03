<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp"></jsp:include>
	</header>
	<main role="main" class="flex-shrink-0">
		<div class="task-container mt-5">
			<div class="row justify-content-between">
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


			</div>
		</div>
	</main>

	<footer class="footer mt-auto py-3" style="background-color: #546e7a">
		<jsp:include page="/footer.jsp"></jsp:include>
	</footer>


</body>
</html>