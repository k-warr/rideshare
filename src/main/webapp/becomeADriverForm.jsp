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
    <form action="/becomeADriverFormHandler" method="GET">
        <%--<label for="username">Username: </label>--%>
        <%--<input type="text" id="username" name="username">--%>
        <%--<br>--%>
        <label for="make">Car Make: </label>
        <select id="make" name="make">
            <option value="Alfa Romeo">Alfa Romeo</option>
            <option value="Aston Martin">Aston Martin</option>
            <option value="Audi">Audi</option>
            <option value="Bentley">Bentley</option>
            <option value="BMW">BMW</option>
            <option value="Cadillac">Cadillac</option>
            <option value="Chevrolet">Chevrolet</option>
            <option value="Chrysler">Chrysler</option>
            <option value="Citroen">Citroen</option>
            <option value="Datsun">Datsun</option>
            <option value="De Lorean">De Lorean</option>
            <option value="Dodge">Dodge</option>
            <option value="Ferrari">Ferrari</option>
            <option value="Fiat">Fiat</option>
            <option value="Ford">Ford</option>
            <option value="Honda">Honda</option>
            <option value="Hummer">Hummer</option>
            <option value="Hyundai">Hyundai</option>
            <option value="Jaguar">Jaguar</option>
            <option value="Jeep">Jeep</option>
            <option value="KIA">KIA</option>
            <option value="Koenigsegg">Koenigsegg</option>
            <option value="Lada">Lada</option>
            <option value="Lamborghini">Lamborghini</option>
            <option value="Land Rover">Land Rover</option>
            <option value="Lexus">Lexus</option>
            <option value="Lincoln">Lincoln</option>
            <option value="Lotus">Lotus</option>
            <option value="Maserati">Maserati</option>
            <option value="Maybach">Maybach</option>
            <option value="Mazda">Mazda</option>
            <option value="McLaren">McLaren</option>
            <option value="Mercedes-Benz">Mercedes-Benz</option>
            <option value="Mini">Mini</option>
            <option value="Mitsubishi">Mitsubishi</option>
            <option value="Nissan">Nissan</option>
            <option value="Opel">Opel</option>
            <option value="Peugeot">Peugeot</option>
            <option value="Pontiac">Pontiac</option>
            <option value="Porsche">Porsche</option>
            <option value="Renault">Renault</option>
            <option value="Rolls-Royce">Rolls-Royce</option>
            <option value="Rover">Rover</option>
            <option value="Saab">Saab</option>
            <option value="Smart">Smart</option>
            <option value="Subaru">Subaru</option>
            <option value="Suzuki">Suzuki</option>
            <option value="Toyota">Toyota</option>
            <option value="Volkswagen">Volkswagen</option>
            <option value="Volvo">Volvo</option>
        </select>
        <br>
        <label for="model">Car Model: </label>
        <input type="text" id="model" name="model">
        <br>
        <label for="year">Manufactured Year: </label>
        <input type="text" id="year" name="year" placeholder="Ex. 1991" pattern="[0-9]{4}">
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
