<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Page</title>
<link rel="stylesheet"
	href="/vaccine/src/main/webapp/bootstrap/css/bootstrap.min.css.map">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<Style>
.card-header {
	padding: 70px;
	background-color: lightskyblue;
	color: black;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

.card-footer {
	padding: 92px;
	background-color: lightskyblue;
	color: black;
	text-align: right;
	font-size: 20px;
}

.card {
	margin: 0 auto;
	/* Added */
	float: none;
	/* Added */
	margin-bottom: 0px;
	/* Added */
}

.body {
	background-image: url(/image/vaccine.jpg);
	background-position: center;
	background-repeat: repeat-x;
	background-size: 497px;
}
</Style>
</head>


<body class="body">

	<div class="card-header">VACCINATION PORTAL</div>
	<div class="card text-white bg-dark " style="width: 19.5rem;">
		<div class="card-body">
			<h5 class="card-title">OTP VERFICATION</h5>
			<h6 class="card-subtitle mb-2 text-muted">Please Enter The OTP</h6>
			<form action="otpvalidate">
				<div class="card-body">
					<h6 class="text-success">${message}</h6>
					<h6 class="text-success">${validOtp}</h6>
					<h6 class="text-success">${verifyOTP}</h6>
					<h6 class="text-danger">${invalidOTP}</h6>
					<label>OTP</label> <input type="number" name="otp"
						class="form-control"><br> <br> <input
						type="submit" value="Verify" class="btn btn-success">
				</div>
			</form>

		</div>
	</div>
	<div class="card-footer">By - Prathiksha Keni</div>


</body>
</html>