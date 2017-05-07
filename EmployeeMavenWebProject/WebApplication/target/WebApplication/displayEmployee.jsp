<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
	<div class="container-fluid">
		<h3>Employee Details</h3>
		<div class="table-responsive">
			<form action="view?action=update" method="post">
				<table class="table">
					<tr>
						<th>Employee Id</th>
						<td><input readonly="readonly" type="text" name="empId"
							class="form-control" value="${requestScope.employee.id}"></td>
					</tr>
					<tr>
						<th>First Name</th>
						<td><input type="text" name="firstName" class="form-control"
							value="${requestScope.employee.firstName}"></td>
					</tr>
					<tr>
						<th>Last Name</th>
						<td><input type="text" name="lastName" class="form-control"
							value="${requestScope.employee.lastName}"></td>
					</tr>
					<tr>
						<th>Salary</th>
						<td><input type="text" name="salary" class="form-control" pattern="(\d+\.?\d+)"
							 title="salary Should be a number" value="${requestScope.employee.salary}"></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td><input readonly="readonly" type="text" name="gender"
							class="form-control" value="${requestScope.employee.gender}"></td>
					</tr>
				</table>
				<button type="submit" class="btn btn-default">Update</button>
			</form>
			<br>
			<form action="view?action=delete" method=post>
				<input type="hidden" name="empId" class="form-control"
					value="${requestScope.employee.id}">
				<button type="submit" class="btn btn-default">Delete</button>
			</form>
			<h2 align="center">${requestScope.message}</h2>
			<h3>View All Employees</h3>
			<form action="/WebApplication/viewAll" method="post">
				<button type="submit" class="btn btn-default">View All</button>
			</form>
			<h3>
				Home Page<a href=homepage.jsp> Home</a>
			</h3>
		</div>
	</div>
</body>
</html>