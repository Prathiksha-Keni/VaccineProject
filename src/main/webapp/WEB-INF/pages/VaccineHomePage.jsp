<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccine Home Page</title>
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

	</div>

	<h2 class="text-success" style="text-align: center;">${verifyOTP}</h2>
	<form action="addMember">
		<div class="d-grid gap-2 d-md-flex justify-content-end">
			<button class="btn btn-primary btn-lg" type="submit">+Add
				Members</button>
		</div>
		<br>


		<h2 class="alert alert-success" role="alert"
			style="text-align: center;">${memberSaved}</h2>
	</form>
	<br>
	<table class="table table-striped table-hover table-bordered">
		<thead class="table-dark">
			<tr>
				<th scope="col">NAME</th>
				<th scope="col">GENDER</th>
				<th scope="col">YEAR OF BIRTH</th>
				<th scope="col">ID PROOF</th>
				<th scope="col">ID NUMBER</th>
				<th scope="col">VACCINE TYPE</th>
				<th scope="col">DOSE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${ListOfAllMembers}">
				<tr>
					<td>${listValue.name}</td>
					<td>${listValue.gender}</td>
					<td>${listValue.yearOfBirth}</td>
					<td>${listValue.idProof}</td>
					<td>${listValue.idNumber}</td>
					<td>${listValue.vaccineType}</td>
					<td>${listValue.dose}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div class="card-footer2">Designed By &#128512; Prathiksha Keni</div>
</body>