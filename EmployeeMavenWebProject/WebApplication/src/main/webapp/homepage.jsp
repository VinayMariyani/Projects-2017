<html lang="en">
<head>
<title>Employee Input Form</title>
<meta charset="utf-8">
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
		<div class ="col-xs-6">
		<h3>Add Employee</h3>
		<form action="/WebApplication/home" method="post">
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<label for="empId"> Employee Id: </label> <input type="text"
							pattern="\d+" title="Id Should be a number" class="form-control"
							name="empId" placeholder="Enter employee Id" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<label for="firstName"> Employee First name: </label> <input
							type="text" class="form-control" name="firstName"
							placeholder="Enter employee First Name" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<label for="lastName"> Employee Last name: </label> <input
							type="text" class="form-control" name="lastName"
							placeholder="Enter employee last Name" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<label for="salary"> Employee Salary:</label> <input type="text"
							pattern="(\d+\.?\d+)" title="Salary Should be a number"
							type="number" class="form-control" name="salary"
							placeholder="Enter employee Salary" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<label for="salary"> Select gender : </label> <select
							class="form-control" name="gender" required="required">
							<option>Male</option>
							<option>Female</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<button type="submit" class="btn btn-default">Add</button>
						<button type="reset" class="btn btn-default">Reset</button>
					</div>
				</div>
				</div>
		</form>
</div>

<div class="col-xs-6">
		<h3>Search Employee</h3>
		<form action="/WebApplication/view?action=view" method="post">
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<label for="empId"> Enter Employee Id: </label> <input type="text"
							pattern="\d+" title="Id Should be a number" class="form-control"
							name="empId" placeholder="Enter employee Id" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<button type="submit" class="btn btn-default">Search</button>
					</div>
				</div>
			</div>
		</form>
	
	<h3>View All Employees</h3>
		<form action="/WebApplication/viewAll" method="post">
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<button type="submit" class="btn btn-default">View All</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	</div>
		<h2 align = "center">${requestScope.message}</h2>
</body>
</html>


