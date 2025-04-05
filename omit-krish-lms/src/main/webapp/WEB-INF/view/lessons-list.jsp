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

</head>
<body>
<div align ="center">
	<jsp:include page="menu-nav.jsp" />

	<h1>${course.name}</h1>
	<c:forEach var="lesson" items="${course.lessons}">
	
	<a href="openLesson?lessonId=${lesson.id}">${lesson.name}</a><br>
	
	
	</c:forEach>
	
	</div>
</body>
</html>
