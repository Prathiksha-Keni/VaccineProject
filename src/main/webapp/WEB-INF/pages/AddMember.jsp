<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Memeber</title>
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

	//response.setHeader("Pragma", "no-cache"); 

	//response.setHeader("Expires", "0"); 

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
		<div class="d-grid gap-2 d-md-flex justify-content-end">
			<a class="btn btn-danger " href="logout">LOGOUT</a>
			<!--  <a class="btn btn-danger " href="<c:url value='/logout'/>">LOGOUT</a>-->
		</div>
		<h6 style="text-align: center;">WELCOME ${emailId}
			${username}</h6>
		<!--  <h6 style="text-align: center;">WELCOME ${username}</h6>-->
	</div>
	<div class="card border-dark mb-3"
		style="width: 40rem; margin-top: 10px;">
		<div class="card-header2">REGISTER HERE</div>
		<div class="card-body text-dark">
			<h4 class="border border-dark text-info">Please carry the copy
				of mentioned Id Proof it will be verified in the vaccine center</h4>
			<h2 class="text-danger" style="text-align: center;">${cantAdd}</h2>
			<form action="register">
				<div class="card-body">
					<div class="mb-3">
						<label class="font-weight-bold">Name</label>
						<p class="bg-danger text-white">${memberNotValid}</p>
						<input type="text" class="form-control" placeholder="Your Name"
							name="name">
					</div>

					<div class="mb-3 ">
						<label class="font-weight-bold">Gender</label> <input type="radio"
							id="gender" name="gender" value="Male"> <label>Male</label>
						&nbsp; &nbsp; <input type="radio" id="gender" name="gender"
							value="Female"> <label>Female</label> &nbsp; &nbsp; <input
							type="radio" id="gender" name="gender" value="Other"> <label>Other</label>
						&nbsp; &nbsp;
					</div>

					<div class="mb-3">
						<label class="font-weight-bold">Year Of Birth</label> <input
							type="text" class="form-control" name="yearOfBirth"
							placeholder="Eg.1997">
					</div>

					<div class="dropdown">
						<label class="font-weight-bold">Photo Id Proof</label> <select
							name="idProof" id="idProof" class="custom-select">
							<option value="" disabled selected>Select Any One</option>
							<option value="Aadhar Card">Aadhar Card</option>
							<option value="PAN Card">PAN Card</option>
							<option value="Voter ID">Voter ID</option>
							<option value="Passport">Passport</option>
							<option value="Driving License">Driving License</option>
						</select>
					</div>
					&nbsp;

					<div class="mb-3">
						<label class="font-weight-bold">Photo Id Number</label> <input
							type="text" class="form-control" placeholder="Id Number"
							name="idNumber">
					</div>

					<div class="dropdown">
						<label class="font-weight-bold">Vaccine Type</label> <select
							name="vaccineType" id="vaccineType" class="custom-select">
							<option value="" disabled selected>Vaccine Type</option>
							<option value="COVISHIELD">COVISHIELD</option>
							<option value="COVAXIN">COVAXIN</option>
							<option value="SPUTNIK">SPUTNIK</option>
						</select>
					</div>
					&nbsp;

					<div class="dropdown">
						<label class="font-weight-bold">Dose Type</label> <select
							name="dose" id="dose" class="custom-select">
							<option value="" disabled selected>DOSE</option>
							<option value="DOSE-1">DOSE-1</option>
							<option value="DOSE-2">DOSE-2</option>
						</select>
					</div>
					&nbsp;
					<div class="d-flex justify-content-center">
						<input type="submit" class="btn btn-primary btn-lg btn-block"
							value="ADD">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="card-footer2">Designed By &#128512; Prathiksha Keni</div>
</body>
</html>