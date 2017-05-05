<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<h3>Employee Details</h3>
	<div class="table-responsive">
		<table class="table">
			<tr>
			<tr>
				<td>Employee Id</td>
				<td>${requestScope.employee.id}</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td>${requestScope.employee.firstName}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${requestScope.employee.lastName}</td>
			</tr>
			<tr>
				<td>Salary</td>
				<td>${requestScope.employee.salary}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${requestScope.employee.gender}</td>
			</tr>
		</table>
		<h3>
			Add Employee<a href=homepage.html> Add</a>
		</h3>
		<h3>
			Search Employee<a href=homepage.html>Search</a>
		</h3>
	</div>
</body>
</html>