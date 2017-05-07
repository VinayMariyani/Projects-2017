<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.28.9/js/jquery.tablesorter.min.js"></script>


<script>
$(document).ready(function() {
	  $('#sortTable').DataTable();
	});	
</script>
</head>
<body>

	<div class="container">
		<h2>List of Employees</h2>
		<div class="table-responsive">
			<table class="table table-sorter" id =sortTable>
				<thead>
					<tr>
						<th>#</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Salary</th>
						<th>Gender</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.employees}" var="employee">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>${employee.salary}</td>
							<td>${employee.gender}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h3>
				Home Page<a href=homepage.jsp> Home</a>
			</h3>
		</div>
	</div>

</body>
</html>
