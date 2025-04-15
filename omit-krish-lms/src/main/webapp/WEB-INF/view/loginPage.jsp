<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	background: linear-gradient(to bottom right, #000075, #6c757d);
	display: flex;
	align-items: center;
	justify-content: center;
	height: 50vh;
}

.login-container {
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0px 4px 12px rgba(04, 05, 0, 0.1);
	width: 100%;
	max-width: 400px;
	text-align: left;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
	color: #007bff;
}

h1, label {
	color: white;
}
</style>
</head>
<body>


	<div class="container mt-5" align="center">
		<div class="login-container">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger" style="color: red;">Invalid
					username or password!</div>
			</c:if>
		</div>
		<h1>Login Page</h1>

		<form action="process-login" method="post">
			<label>Username:</label> <input type="text" name="username" /> <br />
			<br /> <label>Password:</label> <input type="password"
				name="password" /> <br /> <br /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
				type="submit" value="Login" style="background-color: green;" />
				<br/>
				<br/>
				 <a
				href="registration"><i style="color:red;">Are you new user? register here...</i></a>
		</form>



	</div>
</body>
</html>
