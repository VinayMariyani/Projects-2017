<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Input Form</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="col-xs-6">
			<h3>Add Employee</h3>
			<form:form action="/EmployeeSpringMvc/Employee/createEmployee"
				commandName="employee" method="post">
				<form:errors path="*" cssClass="errorblock" element="div" />

				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label for="id"> <spring:message
									code="employee.empid.lbl" /></label>
							<form:input type="text" path="id" class="form-control"
								placeholder="Employee Id" />
							<form:errors path="id" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label for="firstName"><spring:message
									code="employee.empFirstName.lbl" /> </label>
							<form:input type="text" path="firstName" class="form-control"
								placeholder="Enter employee First Name" />
							<form:errors path="firstName" cssClass="error" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label for="lastName"><spring:message
									code="employee.empLastName.lbl" /> </label>
							<form:input type="text" path="lastName" class="form-control"
								name="lastName" placeholder="Enter employee last Name" />
							<form:errors path="lastName" cssClass="error" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label for="salary"> <spring:message
									code="employee.salary.lbl" /></label>
							<form:input type="text" path="salary" class="form-control"
								placeholder="Enter employee Salary" />
							<form:errors path="salary" cssClass="error" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label for="gender"><spring:message
									code="employee.gender.lbl" /> </label>
							<form:select path="gender" class="form-control" name="gender">
								<form:option value="MALE">Male</form:option>
								<form:option value="FEMALE">Female</form:option>
							</form:select>
							<form:errors path="gender" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<form:button type="submit" class="btn btn-primary">Add</form:button>
							<form:button type="reset" class="btn btn-danger">Reset</form:button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<div class="col-xs-6">
			<h3>Search Employee</h3>
			<form:form action="/EmployeeSpringMvc/Employee/viewEmployee"
				commandName="employee" method="post">
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label for="id"> <spring:message
									code="employee.empid.lbl" />
							</label>
							<form:input type="text" class="form-control" path="id"
								placeholder="Enter employee Id" />
							<form:errors path="id" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<form:button type="submit" class="btn btn-primary">Search</form:button>
						</div>
					</div>
				</div>
			</form:form>

			<!-- <h3>View All Employees</h3> -->
			<form:form action="/EmployeeSpringMvc/Employee/viewAll" method="post">
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<button type="submit" class="btn btn-success">View All</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<h2 align="center">${message}</h2>
	</div>
</body>
</html>


