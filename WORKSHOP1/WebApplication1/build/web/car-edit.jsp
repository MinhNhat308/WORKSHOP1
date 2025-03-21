<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Car</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<h2>Edit Car</h2>
<form action="cars" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="carID" value="${car.carID}"/>
    
    <label for="carName">Car Name:</label>
    <input type="text" name="carName" value="${car.carName}" required/><br/>

      <label for="manufacturer">Manufacturer:</label>
    <input type="text" name="manufacturer" value="${car.manufacturer}" required/><br/>

    <label for="price">Price:</label>
    <input type="number" step="0.01" name="price" value="${car.price}" required/><br/>

    <label for="releasedYear">Released Year:</label>
    <input type="number" name="releasedYear" value="${car.releasedYear}" required/><br/>

    <input type="submit" value="Update"/>
    <a href="cars">Cancel</a>
</form>
</body>
</html>