<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
}

.form-container {
	background-color: white;
	border: 1px solid #dee2e6;
	border-radius: 8px;
	padding: 30px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	max-width: 500px;
	margin: auto;
	margin-top: 50px;
}

.form-header {
	color: #007bff;
	text-align: center;
	margin-bottom: 20px;
}

.btn-custom {
	background-color: #007bff;
	color: white;
}

.btn-custom:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<div class="form-container">
			<h1 class="form-header">Registration</h1>
			<form:form action="registration-process" method="post"
				modelAttribute="registrationDTO">
				<!-- Username Field -->
				<div class="mb-3">
					<label for="name" class="form-label">Username</label>
					<form:input path="name" cssClass="form-control" id="name"
						htmlEscape="true" />
				</div>

				<!-- Password Field -->
				<div class="mb-3">
					<label for="pas" class="form-label">Password</label> <input
						type="password" class="form-control" name="password" id="pas"
						placeholder="Enter your password" required>
				</div>

				<!-- Email Field -->
				<div class="mb-3">
					<label for="mail" class="form-label">Email</label> <input
						type="email" class="form-control" name="gmail" id="mail"
						placeholder="Enter your email" required>
				</div>

				<!-- Country Field -->
				<div class="mb-3">
					<label for="country" class="form-label">Country</label> <input
						type="text" class="form-control" name="country" id="country"
						placeholder="Enter your country">
				</div>

				<!-- Submit Button -->
				<div class="d-grid">
					<button type="submit" class="btn btn-custom btn-lg">Register</button>
				</div>
			</form:form>
			
						<a href="myLoginPage"><i style="color:red;">Are you existing user!
						? login here!!!!</i></a>
			
		</div>
	</div>

	<!-- Include Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-9ndCyUa1z0v2Q2zZ3IR3eafJL5yPYibPhzWj74mB49j0x04e0Gh0kNfclIOCR6An"
		crossorigin="anonymous"></script>
</body>
</html>
