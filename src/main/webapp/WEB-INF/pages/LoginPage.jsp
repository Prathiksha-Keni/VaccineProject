<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
		<form action="onclickregister">
			<div class="d-grid gap-2 d-md-flex justify-content-end">
				<button class="btn btn-primary btn-lg" type="submit">Register
					User</button>
			</div>
		</form>

		<h6 style="text-align: center;">${userRegistred}</h6>
	</div>
	<h5 class="text-warning" style="text-align: center;">${notVerified}</h5>
	<h6 class="text-success" style="text-align: center;">${RegisterEmail}</h6>
	<h5 class="text-danger" style="text-align: center;">${accountBlocked}</h5>
	<h5 class="text-danger" style="text-align: center;">${userVerifiedButBlocked}</h5>
	<h6 class="text-success" style="text-align: center;">${newPassMail}</h6>
	<h6 class="text-success" style="text-align: center;">${passwordResetDone}</h6>
	<div class="card text-white bg-dark" style="width: 19.5rem;">
		<div class="card-body">
			<h5 class="card-title">WELCOME</h5>
			<h6 class="card-subtitle mb-2 text-muted">Login Here</h6>
			<form action="login">
				<div class="card-body">
					<div class="mb-3">
						<label class="font-weight-bold">UserName</label> <input
							type="text" class="form-control" placeholder="UserName"
							name="username">
					</div>

					<div class="mb-3">
						<label class="font-weight-bold">Password</label> <input
							type="password" class="form-control" placeholder="password"
							name="password">
					</div>

					&nbsp;
					<div class="d-flex justify-content-center">
						<input type="submit" class="btn btn-primary btn-lg btn-block"
							value="Login">
					</div>
					<br>
					<div class="d-flex justify-content-center">
						<a class="btn btn-danger btn-lg btn-block" href="reset">Reset
							Password</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="card-footer">Designed By &#128512; Prathiksha Keni</div>
</body>
</html>