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
	<div align="center">
		<h3>Add-Course</h3>
		<form:form action="addCourse" method="post" modelAttribute="course">
			<label for="name">Course Name :</label>
			<form:input path="name" placeholder="enter course name" id="name" />
			<br />
			<label for="duration">Duration Of Course :</label>

			<form:input path="duration" placeholder="duration of course"
				id="duration" />
			<br />
			<label for="instructors">Select Instructor :</label>
			<form:select path="instructor.id" id="instructors">

				<form:options items="${instructors}" itemLabel="name" itemValue="id" />
			</form:select>
			<br />
			<input type="submit" value="add course">
		</form:form>
	</div>

</body>
</html>
