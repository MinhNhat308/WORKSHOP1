<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car Details</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<h2>Car Details</h2>
<p><strong>Car ID:</strong> ${car.carID}</p>
<p><strong>Car Name:</strong> ${car.carName}</p>
<p><strong>Manufacturer:</strong> ${car.manufacturer}</p>
<p><strong>Price:</strong> ${car.price}</p>
<p><strong>Released Year:</strong> ${car.releasedYear}</p>
<a href="cars">Back to List</a>
</body>
</html>