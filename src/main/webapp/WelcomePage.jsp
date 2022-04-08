<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
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

.div {
	background-color: palegoldenrod;
	text-align: center;
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

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 3px 3px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body bgcolor="lightcyan">
	<div class="div">
		<h1>${message}</h1>
		<h2>${message2}</h2>
		 <header class="head">Vaccine</header>
        <form action="emailOtp" class="form">
            <label>Email-Id</label> <input type="email" name="email"><br><br>
            <input type="submit" value="Get OTP" class="button">
        </form>
        <footer class="foot">By PRATHIKSHA KENI</footer>


	</div>
</body>
</html>