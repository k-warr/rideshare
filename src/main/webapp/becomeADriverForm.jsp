<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 5/2/17
  Time: 1:51 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Become a Driver</title>
    <c:import url="theme/bootstrapReferences.jsp" />
</head>
<body>

<!-- Navigation -->
<c:import url="theme/nav.jsp" />
    <div class="container">
        <form action="becomeADriverFormHandler" method="GET">
            <label for="make">Car Make: </label>
            <select id="make" name="make" required>
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
            <input type="text" id="model" name="model" required>
            <br>
            <label for="year">Manufactured Year: </label>
            <input type="text" id="year" name="year" placeholder="Ex. 1991" pattern="[0-9]{4}" required>
            <br>
            <label for="maxOccupants">Max Occupants Including Driver: </label>
            <input type="text" id="maxOccupants" name="maxOccupants" pattern="[0-9]{,2}" required>
            <br>
            <label for="vin">VIN: </label>
            <input type="text" id="vin" name="vin">
            <br>
            <label for="driversLicense">Driver's License Number: </label>
            <input type="text" id="driversLicense" name="driversLicense" required>
            <br>
            <label for="licensePlate">License Plate Number: </label>
            <input type="text" id="licensePlate" name="licensePlate" required>
            <br>
            <label for="insuranceProvider">Insurance Provider: </label>
            <input type="text" id="insuranceProvider" name="insuranceProvider" required>
            <fieldset>
                <legend>Home Address</legend>
                <label for="houseNumber">House Number: </label>
                <input type="text" id="houseNumber" name="houseNumber">
                <br>
                <label for="street">Street: </label>
                <input type="text" id="street" name="street">
                <br>
                <label for="city">City: </label>
                <input type="text" id="city" name="city">
                <br>
                <label for="state">State: </label>
                <select id="state" name="state">
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DE">Delaware</option>
                    <option value="DC">District Of Columbia</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="IA">Iowa</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="ME">Maine</option>
                    <option value="MD">Maryland</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MS">Mississippi</option>
                    <option value="MO">Missouri</option>
                    <option value="MT">Montana</option>
                    <option value="NE">Nebraska</option>
                    <option value="NV">Nevada</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NY">New York</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="OH">Ohio</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VT">Vermont</option>
                    <option value="VA">Virginia</option>
                    <option value="WA">Washington</option>
                    <option value="WV">West Virginia</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WY">Wyoming</option>
                </select>
                <br>
                <label for="zipCode">Zip Code: </label>
                <input type="text" id="zipCode" name="zipCode">
            </fieldset>
            <br>
            <br>
            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>
