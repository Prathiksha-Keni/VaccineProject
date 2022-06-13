<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
<link rel="stylesheet"
	href="/vaccine/src/main/webapp/bootstrap/css/bootstrap.min.css.map">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>



	<div class="card-header">
		VACCINATION PORTAL
		<div class="text-center">
			<a class="btn btn-primary" href="Welcomelogin">Already Registred Login Here</a>
		</div>
		<!--  	<div class="d-grid gap-2 d-md-flex justify-content-end">
			<a class="btn btn-danger " href="logout">LOGOUT</a>
		</div>-->

	</div>
	<div class="card border-dark mb-3"
		style="width: 40rem; margin-top: 10px;">
		<div class="card-header2">REGISTER USER</div>

		<h6>${userNotRegistred}</h6>
		<div class="card-body text-dark">
			<form action="registerUser">
				<div class="card-body">
					<h6 class="text-danger">${userNotValid}</h6>
					<div class="mb-3">

						<label class="font-weight-bold">UserName</label><h6>${InvalidName}</h6> <input
							type="text" class="form-control" placeholder="UserName"
							name="username">
					</div>
					<div class="mb-3">
						<label class="font-weight-bold">Email-Id</label><h6>${InvalidEmail}</h6> <input
							type="email" class="form-control" placeholder="example@gmail.com"
							name="email">
					</div>
					<div class="mb-3">
						<label class="font-weight-bold">Password</label><h6>${InvalidPassword}</h6> <input
							type="password" class="form-control" placeholder="password"
							name="password">
					</div>

					<div class="mb-3 ">
						<label class="font-weight-bold">Gender</label> <h6>${InvalidGender}</h6> <input type="radio"
							id="gender" name="gender" value="Male"> <label>Male</label>
						&nbsp; &nbsp; <input type="radio" id="gender" name="gender"
							value="Female"> <label>Female</label> &nbsp; &nbsp; <input
							type="radio" id="gender" name="gender" value="Other"> <label>Other</label>
						&nbsp; &nbsp;
					</div>

					<div class="mb-3">
						<label class="font-weight-bold">Year Of Birth</label><h6>${InvalidYOB}</h6> <input
							type="text" class="form-control" name="yearOfBirth"
							placeholder="Eg.1997">
					</div>
					<div class="mb-3">
						<label class="font-weight-bold">Contact Number</label><h6>${InvalidPhoneNumber}</h6> <input
							type="number" class="form-control" placeholder="Phone Number"
							name="phoneNumber">
					</div>
					&nbsp;
					<div class="d-flex justify-content-center">
						<input type="submit" class="btn btn-primary btn-lg btn-block"
							value="Register">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="card-footer2">Designed By &#128512; Prathiksha Keni</div>
</body>
</html>