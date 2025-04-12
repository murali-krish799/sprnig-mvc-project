<%@page import="com.krishsolution.entity.Lesson"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Streaming-Lesson</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- Custom CSS -->

</head>
<body>
	<div align="center">
		<%
		/* jpa script let */
		Lesson lesson = (Lesson) request.getAttribute("lesson");
		/* next video */
		int nextPage = lesson.getId() + 1;

		request.setAttribute("nextPage", nextPage);

		/* previous video */

		int previousPage = lesson.getId() - 1;

		request.setAttribute("previousPage", previousPage);
		%>
		<jsp:include page="menu-nav.jsp" />

		<h1>${lesson.name}</h1>
		<h5>${lesson.description}</h5>
		<h1>${lesson.link}</h1>

		<c:if test="${lesson.id<lesNextPreviousDTO.secondLesson}">
			<div align="right">

				<a href="openLesson?lessonId=${nextPage}">next-video</a>


			</div>
		</c:if>
		<c:if test="${lesson.id>lesNextPreviousDTO.firstLesson}">
			<div align="left">

				<a href="openLesson?lessonId=${previousPage}">previous-video</a>


			</div>
		</c:if>
	</div>
</body>
</html>
