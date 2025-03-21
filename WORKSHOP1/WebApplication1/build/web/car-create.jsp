<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create New Car</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<h2>Create New Car</h2>
<form action="cars" method="post">
    <input type="hidden" name="action" value="create"/>
    <label for="carName">Car Name:</label>
    <input type="text" name="carName" required/><br/>

    <label for="manufacturer">Manufacturer:</label>
    <input type="text" name="manufacturer" required/><br/>

    <label for="price">Price:</label>
    <input type="number" step="0.01" name="price" required/><br/>

    <label for="releasedYear">Released Year:</label>
    <input type="number" name="releasedYear" required/><br/>

    <input type="submit" value="Create"/>
    <a href="cars">Cancel</a>
</form>
</body>
</html>