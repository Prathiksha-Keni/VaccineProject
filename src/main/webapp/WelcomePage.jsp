<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/vaccine/src/main/webapp/css/style.css">
</head>
<body class="body">
	<!-- <h1 class="card-title">WELCOME</h1> -->
	<div class="row justify-content-center">
		<form action="emailOtp">
			<div class="card-body">
				<h1>${message}</h1>
				<h2>${message1}</h2>
				<h2>${message2}</h2>
				<h2>${message3}</h2>
				<label>Email-Id</label> 
				<input type="email" name="email" class="form-control"><br>
				<br><input type="submit" value="Get OTP" class="btn btn-success">
			</div>
		</form>
	</div>
</body>
</html>