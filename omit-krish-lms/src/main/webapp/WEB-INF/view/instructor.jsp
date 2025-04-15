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
	display: inline-block;
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
		<!-- Centering the content -->
		<div align="center" class="mb-4">
			<h1>Instructors</h1>
			<div align="left">
			<h1>Hi </h1> <span style="color: blue;">${username}</span>
			</div>
			<a href="show-instructor-page" class="btn btn-success">Add
				Instructors</a>
		</div>
		<div align="left">

			<form:form action="findName" method="post"
				modelAttribute="instructorDTO">
				<label for="search">Search :</label>
				<form:input type="text" path="name" placeholder="Enter name"
					id="serach" />
				<input type="submit" value="search" />

			</form:form>
			<div align="right">
				<a href="instructors">refreshAll</a>

			</div>
		</div>
		<!-- Table with improved styling -->
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Instructor ID</th>
					<th>Instructor Name</th>
					<th>Teaching Experience</th>
					<th>Instructor Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="instructor" items="${listOfInstructors}">
					<tr>
						<td>${instructor.id}</td>
						<td>${instructor.name}</td>
						<td>${instructor.experience}</td>
						<td>${instructor.gMail}</td>
						<td>
							<table class="table">
								<thead>
									<tr>
										<th>courseName</th>
										<th>Duration</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="course" items="${instructor.courses}">

										<tr>
											<td>${course.name}</td>
											<td>${course.duration}</td>
											<td><a href="viewLessons?courseId=${course.id}">view-course</a>
										</tr>



									</c:forEach>

								</tbody>

							</table>

						</td>

						<td><a href="deleteinstructorById?id=${instructor.id}"
							style="color: red;">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
