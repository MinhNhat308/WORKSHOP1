<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>Car List</h2>
<a href="car-create.jsp">Create New Car</a>
<table border="1">
    <tr>
        <th>Car ID</th>
        <th>Car Name</th>
        <th>Manufacturer</th>
        <th>Price</th>
        <th>Released Year</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="car" items="${listCars}"> <!-- Lặp qua danh sách xe -->
        <tr>
            <td>${car.carID}</td>
            <td>${car.carName}</td>
            <td>${car.manufacturer}</td>
            <td>${car.price}</td>
            <td>${car.releasedYear}</td>
            <td>
                <a href="cars?action=edit&id=${car.carID}">Edit</a>
                <a href="cars?action=details&id=${car.carID}">Details</a>
                <a href="cars?action=delete&id=${car.carID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>