<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<form:form action="/EmployeeSpringMvc/Employee/updateEmployee"
				commandName="employee" method="post">

				<form:errors path="*" cssClass="errorblock" element="div" />
				<table class="table">
					<tr>
						<th> <spring:message code="employee.empid.lbl"/></th>
						<td><form:input readonly="true" type="text" path="id"
							class="form-control" value="${employee.id}"/>
							<form:errors path="id" cssClass="error" /></td>			
					</tr>
					<tr>
						<th><spring:message code="employee.empFirstName.lbl"/></th>
						<td><form:input type="text" path="firstName" class="form-control"
							value="${employee.firstName}"/>
							<form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<th><spring:message code="employee.empLastName.lbl"/></th>
						<td><form:input type="text" path="lastName" class="form-control"
							value="${employee.lastName}"/>
							<form:errors path="lastName" cssClass="error"/></td>
					</tr>
					<tr>
						<th><spring:message code="employee.salary.lbl"/></th>
						<td><form:input type="text" path="salary" class="form-control"
							value="${employee.salary}"/>
							<form:errors path="salary" cssClass="error"/></td>
					</tr>
					<tr>
						<th><spring:message code="employee.gender.lbl"/></th>
						<td><form:input readonly="true" type="text" path="gender"
							class="form-control" value="${employee.gender}"/>
							<form:errors path="gender" cssClass="error"/></td>
					</tr>
				</table>
				<form:button type="submit" class="btn btn-primary">Update</form:button>
			</form:form>
			<br>
			<form:form action="/EmployeeSpringMvc/Employee/deleteEmployee" commandName="employee" method="post">
				<form:input type="hidden" path="id" class="form-control"
					value="${employee.id}"/>
				<form:button type="submit" class="btn btn-default">Delete</form:button>
			</form:form>
			<h2 align="center">${message}</h2>
			<h3>View All Employees</h3>
			<form action="/EmployeeSpringMvc/Employee/viewAll" method="post">
				<button type="submit" class="btn btn-default">View All</button>
			</form>
			<h3>
				Home Page<a href="/EmployeeSpringMvc/Employee/newEmployee"> Home</a>
			</h3>
		</div>
	</div>
</body>
</html>