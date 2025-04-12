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
<style type="text/css">
.disabled {
    color: gray;
    pointer-events: none; /* Prevent clicks */
    opacity: 0.5;
}


</style>
</head>
<body>
	<div align="center">
		<jsp:include page="menu-nav.jsp" />
		<div class="container">
			<h1>${course.name}</h1>
			<a href="showAddLessonPage?courseId=${course.id}"
				class="btn btn-warning">Add-course</a> <br />
			<c:forEach var="lesson" items="${pagedListHolder.pageList}">

				<a href="openLesson?lessonId=${lesson.id}">${lesson.name}</a>&nbsp;&nbsp;
			<a
					href="showAddLessonPage?courseId=${course.id}&lessonId=${lesson.id}"
					style="color: green;">update-lesson</a>&nbsp;&nbsp;

		<a href="deleteLesson?lessonId=${lesson.id}" style="color: red;">DeleteLesson</a>

				<br />
			</c:forEach>
			<c:choose>
				<c:when test="${pagedListHolder.firstPage}">
					<p class="disabled">prev</p>
				</c:when>

				<c:otherwise>
					<a href="viewLessons?pageNo=prev">prev</a>&nbsp;
    </c:otherwise>
			</c:choose>


			<c:forEach var="i" begin="1" end="${pagedListHolder.pageCount}">
				<a href="viewLessons?pageNo=${i}">${i}</a>&nbsp;

			</c:forEach>
			<c:choose>
				<c:when test="${pagedListHolder.lastPage}">
					<p class="disabled">next</p>
				</c:when>

				<c:otherwise>
					<a href="viewLessons?pageNo=next">next</a>&nbsp;
    </c:otherwise>
			</c:choose>

		</div>
	</div>
</body>
</html>
