<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Page</title>
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
		<div class="d-grid gap-2 d-md-flex justify-content-end">
			<a class="btn btn-danger " href="logout">LOGOUT</a>
		</div>

	</div>
	<h5>${newPassAndConfirmNotMatch}</h5>
	<h5>${ResetdetailsNotValid}</h5>
	<div class="card border-dark mb-3"
		style="width: 40rem; margin-top: 10px;">
		<div class="card-header2">RESET PASSWORD</div>


		<div class="card-body text-dark">
			<form action="resetPassword">
				<div class="card-body">
					<div class="mb-3">
						<label class="font-weight-bold">Email Id</label> <input
							type="text" class="form-control" placeholder="Registred Email-Id"
							name="email">
					</div>

					<div class="mb-3">
						<label class="font-weight-bold">New Password</label> <input
							type="password" class="form-control" placeholder="New password"
							name="newPassword">
					</div>

					<div class="mb-3">
						<label class="font-weight-bold">Confirm new Password</label> <input
							type="password" class="form-control"
							placeholder="Confirm password" name="confirmPassword">
					</div>

					&nbsp;
					<div class="d-flex justify-content-center">
						<input type="submit" class="btn btn-primary btn-lg btn-block"
							value="Reset">
					</div>

				</div>
			</form>
		</div>
	</div>
	<div class="card-footer">Designed By &#128512; Prathiksha Keni</div>









</body>
</html>