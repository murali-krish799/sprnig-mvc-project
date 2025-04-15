<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Instructor</title>
<!-- Include Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">

<!-- Custom CSS -->
<style>
    body {
        background-color: #f0f8ff; /* AliceBlue for background */
    }
    h1 {
        color: #1d3557; /* Dark blue for heading */
    }
    label {
        color: #457b9d; /* Medium blue for labels */
    }
    .btn-primary {
        background-color: #e63946; /* Vibrant red for the button */
        border-color: #e63946;
    }
    .btn-primary:hover {
        background-color: #d62828; /* Slightly darker red on hover */
        border-color: #d62828;
    }
    .card {
        background-color: #ffffff; /* White for the card background */
        border: 1px solid #a8dadc; /* Light blue border for the card */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add subtle shadow */
    }
</style>
</head>
<body>
<jsp:include page="menu-nav.jsp" />

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <!-- Card with custom colors and Bootstrap -->
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title text-center mb-4">Add Instructor</h1>
                        <form:form action="save-instructor" method="post" modelAttribute="instructor">
                            <!-- Name Field -->
                            <div class="mb-3">
                                <label for="name" class="form-label">Instructor Name:</label>
                                <form:input path="name" class="form-control" id="name" placeholder="Enter Name" />
                            </div>
                            <!-- Experience Field -->
                            <div class="mb-3">
                                <label for="experience" class="form-label">Instructor Experience:</label>
                                <form:input path="experience" class="form-control" id="experience" placeholder="Enter Experience" />
                            </div>
                            <!-- Email Field -->
                            <div class="mb-3">
                                <label for="email" class="form-label">Instructor Email:</label>
                                <form:input path="gMail" class="form-control" id="email" placeholder="Enter Email" />
                            </div>
                            
                            <!-- Submit Button -->
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
