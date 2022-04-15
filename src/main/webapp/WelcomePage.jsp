<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<head>
<link rel="stylesheet"
	href="/vaccine/src/main/webapp/bootstrap/css/bootstrap.min.css.map">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">


</head>
<body>

	<div class="card-header">VACCINATION PORTAL</div>
	<div class="card text-white bg-dark " style="width: 19.5rem;">
		<div class="card-body">
			<h5 class="card-title">WELCOME</h5>
			<h6 class="card-subtitle mb-2 text-muted">Get Your Vaccine Here</h6>
			<form action="emailOtp">
				<div class="card-body">
					<h6>${message}</h6>
					<h6 class="text-warning">${message1}</h6>
					<h6 class="text-warning">${VerifyEmail}</h6>
					<h6 class="text-danger">${message2}</h6>
					<label>Email-Id</label> <input type="email" name="email"
						class="form-control"><br> <br> <input
						type="submit" value="Get OTP" class="btn btn-success">
				</div>
			</form>

		</div>
	</div>
	<div class="card-footer">By - Prathiksha Keni</div>



</body>

</html>