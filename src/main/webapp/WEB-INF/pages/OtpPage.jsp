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
<link rel="stylesheet" href="./css/style.css">
</head>
<body>


	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	//response.setHeader("Pragma", "no-cache"); //wont work

	//response.setHeader("Expires", "0"); //wont work

	//if (session.getAttribute("emailId") == null || session.getAttribute("username") == null)
	//if (session.getAttribute("emailId") == null)
	//response.sendRedirect("WelcomePage.jsp");

	//if (session.getAttribute("emailId") == null)
	//	if (session.getAttribute("username") == null)
	//	if (session.getAttribute("LoginUsername") == null)
	//	response.sendRedirect("WelcomePage.jsp");

	if (session.getAttribute("emailId") == null) {

		if (session.getAttribute("username") == null) {
			response.sendRedirect("WelcomePage.jsp");
		}

	}
	%>

	<div class="card-header">
		VACCINATION PORTAL
		<h6 style="text-align: center;">WELCOME ${emailId}</h6>
	</div>

	<div class="card text-white bg-dark " style="width: 19.5rem;">

		<div class="card-body">
			<h5 class="card-title">OTP VERFICATION</h5>
			<h6 class="card-subtitle mb-2 text-muted">Please Enter The OTP</h6>
			<form action="otpvalidate">

				<div class="card-body">
					<h6 class="text-success">${message}</h6>
					<h6 class="text-warning">${validOtp}</h6>
					<h6 class="text-success">${verifyOTP}</h6>
					<h6 class="text-danger">${invalidOTP}</h6>
					<label>OTP</label> <input type="number" name="otp"
						class="form-control" placeholder="OTP"><br> <br>
					<div class="text-center">
						<input type="submit" value="Verify" class="btn btn-success">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="card-footer">Designed By &#128512; Prathiksha Keni</div>
</body>
</html>