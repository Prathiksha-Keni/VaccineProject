<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Page</title>
<style>
* {
	margin: 0%;
	padding: 0%;
}
.form {
	padding-top: 10rem;
	padding-bottom: 25.5rem;
	padding-left: 15rem;
	padding-right: 15rem;
	text-align: center;
	font-size: large;
	color: black;
}


.head {
	background-color: cornflowerblue;
	text-align: center;
	font-size: xx-large;
}

.foot {
	background-color: cornflowerblue;
	text-align: right;
}

.div {
	background-color: palegoldenrod;
	text-align: center;
}
</style>
</head>
<body bgcolor="lightcyan">
	<div class="div">

		<header class="head">Vaccine</header>
		<form action="otpvalidate" class="form">
			<h1>${message}</h1>
			<label>OTP</label>
			<input type="number" name="otp"> <br> <br>
			<input type="submit" value="Verify">
		</form>
		<footer class="foot">By PRATHIKSHA KENI</footer>


	</div>
</body>
</html>