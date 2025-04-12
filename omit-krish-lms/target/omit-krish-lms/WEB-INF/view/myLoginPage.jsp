<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Instructors</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- Custom CSS -->
<style>
body {
	background-color: #f8f9fa;
	/* Light gray background for better readability */
}

h1 {
	color: #007bff; /* Blue heading to make it stand out */
}

a {
	color: #28a745; /* Green color for the link */
	font-weight: bold;
}

a:hover {
	color: #218838; /* Darker green on hover for interactivity */
}

table {
	border: 1px solid #dee2e6; /* Light border around the table */
}

thead th {
	background-color: #6c757d; /* Dark gray background for header */
	color: white; /* White text for contrast */
}

tbody tr:hover {
	background-color: #f1f3f5; /* Light hover effect for rows */
}
</style>
</head>
<body>
	<jsp:include page="menu-nav.jsp" />

	<div class="container mt-5">
	<h1>Login Page</h1>
	
	<form:form action="process-login" method="post">
	
	<label for="name">Username :</label>
	<form:input path="username"  placeholder="enter username"id="name"/>
	<br/>
	<br/>
	<label for="pwd">password :</label>
	<form:input path="username"  placeholder="enter username"id="pwd"/>
	<br/>
	<br/>
	<input type="submit" value="login">
	</form:form>
	
	
	
	</div>
</body>
</html>
