<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 5/1/17
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request a Ride</title>
    <c:import url="theme/bootstrapReferences.jsp" />
</head>
<body>
    <!-- Navigation -->
    <c:import url="theme/nav.jsp" />

    <h3>Ride Request Form</h3>
    <form action="/rideRequestFormHandler" method="GET">
        <label for="username">Username</label>
        <input type="text" id="username" name="username">
        <br>
        <fieldset>
            <legend>Origin Information</legend>
            <label for="numberOrigin">Address Number: </label>
            <input type="text" id="numberOrigin" name="numberOrigin" pattern="[0-9]{0,}">
            <br>
            <label for="streetOrigin">Street Name: </label>
            <input type="text" id="streetOrigin" name="streetOrigin">
            <br>
            <label for="cityOrigin">City: </label>
            <input type="text" id="cityOrigin" name="cityOrigin" >
            <br>
            <label for="stateOrigin">State: </label>
            <select id="stateOrigin" name="stateOrigin">
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
            <label for="zipCodeOrigin">Zip Code: </label>
            <input type="text" id="zipCodeOrigin" name="zipCodeOrigin"
                   placeholder="5-digit zip code" pattern="[0-9]{5}">
        </fieldset>
        <fieldset>
            <legend>Destination Information</legend>
            <label for="numberDestination">Address Number: </label>
            <input type="text" id="numberDestination" name="numberDestination" pattern="[0-9]{0,}">
            <br>
            <label for="streetDestination">Street Name: </label>
            <input type="text" id="streetDestination" name="streetDestination" >
            <br>
            <label for="cityDestination">City: </label>
            <input type="text" id="cityDestination" name="cityDestination">
            <br>
            <label for="stateDestination">State: </label>
            <select id="stateDestination" name="stateDestination">
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
            <label for="zipCodeDestination">Zip Code: </label>
            <input type="text" id="zipCodeDestination" name="zipCodeDestination"
                   placeholder="5-digit zip code" pattern="[0-9]{5}" >
        </fieldset>
        <label for="dropoffTime">Dropoff Time: </label>
        <input type="text" id="dropoffTime" name="dropoffTime"
               pattern="[0-9]{4}"
               placeholder="Enter value between 0000 and 2359. Must be 4 digits" >
        <br>
        <label for="recurrenceDay">Recurrence Day: </label>
        <select id="recurrenceDay" name="recurrenceDay">
            <option value="M">Monday</option>
            <option value="T">Tuesday</option>
            <option value="W">Wednesday</option>
            <option value="R">Thursday</option>
            <option value="F">Friday</option>
            <option value="S">Saturday</option>
            <option value="N">Sunday</option>
        </select>
        <br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>
