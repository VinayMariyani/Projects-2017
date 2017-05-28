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
			<form:form action="/AirlineWebApp/Passenger/update"
				commandName="passenger" method="post">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table class="table">
					<tr>
						<th> <spring:message code="passenger.profileid.lbl"/></th>
						<td><form:input readonly="true" type="text" path="profileId"
							class="form-control" value="${passenger.profileId}"/>
							<form:errors path="id" cssClass="error" /></td>			
					</tr>
					<tr>
						<th> <spring:message code="passenger.password.lbl"/></th>
						<td><form:input readonly="true" type="text" path="password"
							class="form-control" value="${passenger.password}"/>
							<form:errors path="password" cssClass="error" /></td>			
					</tr>
					<tr>
						<th><spring:message code="passenger.FirstName.lbl"/></th>
						<td><form:input type="text" path="firstName" class="form-control"
							value="${passenger.firstName}"/>
							<form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<th><spring:message code="passenger.LastName.lbl"/></th>
						<td><form:input type="text" path="lastName" class="form-control"
							value="${passenger.lastName}"/>
							<form:errors path="lastName" cssClass="error"/></td>
					</tr>
					<tr>
						<th><spring:message code="passenger.address.lbl"/></th>
						<td><form:input type="text" path="address" class="form-control"
							value="${passenger.address}"/>
							<form:errors path="address" cssClass="error"/></td>
					</tr>
					<tr>
						<th><spring:message code="employee.gender.lbl"/></th>
						<td><form:input readonly="true" type="text" path="tel_no"
							class="form-control" value="${passenger.tel_no}"/>
							<form:errors path="tel_no" cssClass="error"/></td>
					</tr>
					<tr>
						<th><spring:message code="employee.gender.lbl"/></th>
						<td><form:input readonly="true" type="text" path="email_id"
							class="form-control" value="${passenger.email_id}"/>
							<form:errors path="email_id" cssClass="error"/></td>
					</tr>
					
				</table>
				<form:button type="submit" class="btn btn-primary">Update</form:button>
			</form:form>
			<br>
			<form:form action="/AirlineWebApp/Passenger/delete" commandName="passenger" method="post">
				<form:input type="hidden" path="profileId" class="form-control"
					value="${employee.profileId}"/>
				<form:button type="submit" class="btn btn-default">Delete</form:button>
			</form:form>
			<h2 align="center">${message}</h2>
			
			<h3>
				Home Page<a href="/AirlineWebApp/Passenger/newPassenger"> Home</a>
			</h3>
		</div>
	</div>
</body>
</html>