<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu-bar</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- Custom CSS -->
<style>
.navbar {
	transition: all 0.3s ease-in-out;
}

.navbar:hover {
	transform: scale(1.02); /* Slight zoom-in effect */
}

.navbar {
	background-color: #4CAF50 !important; /* Green background */
}

.nav-link {
	color: white !important; /* White text */
	font-weight: bold;
}

.nav-link:hover {
	color: yellow !important; /* Highlight effect */
}
.logout {
    color: red; 
    padding-left: 200px; 
    display: block; 
    position: relative; 
    top: 50%; 
    transform: translateY(-50%); 
}

</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-info">
		<div class="container-fluid">
			<a class="navbar-brand" href="/omit-krish-lms/instructors">omit_krish_LMS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/omit-krish-lms/instructors">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/omit-krish-lms/show-instructor-page">add-instructor</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/omit-krish-lms/showAddCoursePage">add-course</a></li>

					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">Disabled</a></li>
					<li class="nav-item"><a  class="logout" href="logout" >
							logout</a></li>

				</ul>






			</div>
		</div>

	</nav>

</body>
</html>
