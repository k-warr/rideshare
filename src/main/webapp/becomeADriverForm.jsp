<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 5/2/17
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Become a Driver</title>
</head>
<body>
    <form action="becomeADriverFormHandler" method="POST">
        <%--<label for="username">Username: </label>--%>
        <%--<input type="text" id="username" name="username">--%>
        <%--<br>--%>
        <label for="make">Car Make: </label>
        <input type="text" id="make" name="make">
        <br>
        <label for="model">Car Model: </label>
        <input type="text" id="model" name="model">
        <br>
        <label for="year">Manufactured Year: </label>
        <input type="text" id="year" name="year">
        <br>
        <label for="maxOccupants">Max Occupants Including Driver: </label>
        <input type="text" id="maxOccupants" name="maxOccupants" pattern="[0-9]{,2}">
        <br>
        <label for="vin">VIN: </label>
        <input type="text" id="vin" name="vin">
        <br>
        <label for="driversLicense">Driver's License Number: </label>
        <input type="text" id="driversLicense" name="driversLicense">
        <br>
        <label for="licensePlate">License Plate Number: </label>
        <input type="text" id="licensePlate" name="licensePlate">
        <br>
        <label for="insuranceProvider">Insurance Provider: </label>
        <input type="text" id="insuranceProvider" name="insuranceProvider">
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
