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
    <form action="">
        <label for="username">Username</label>
        <input type="text" id="username" >
        <br>
        <fieldset>
            <legend>Origin Information</legend>
            <label for="numberOrigin">Address Number: </label>
            <input type="text" id="numberOrigin" pattern="[0-9]{0,}">
            <br>
            <label for="streetOrigin">Street Name: </label>
            <input type="text" id="streetOrigin" >
            <br>
            <label for="cityOrigin">City: </label>
            <input type="text" id="cityOrigin" >
            <br>
            <label for="zipCodeOrigin">Zip Code: </label>
            <input type="text" id="zipCodeOrigin"
                   placeholder="5-digit zip code" pattern="[0-9]{5}">
        </fieldset>
        <fieldset>
            <legend>Destination Information</legend>
            <label for="numberDestination">Address Number: </label>
            <input type="text" id="numberDestination" pattern="[0-9]{0,}">
            <br>
            <label for="streetDestination">Street Name: </label>
            <input type="text" id="streetDestination" >
            <br>
            <label for="cityDestination">City: </label>
            <input type="text" id="cityDestination" >
            <br>
            <label for="zipCodeDestination">Zip Code: </label>
            <input type="text" id="zipCodeDestination"
                   placeholder="5-digit zip code" pattern="[0-9]{5}" >
        </fieldset>
        <label for="dropoffTime">Dropoff Time: </label>
        <input type="text" id="dropoffTime" placeholder="Enter value between 0000 and 2359" >
        <br>
        <label for="recurrenceDay">Recurrence Day: </label>
        <input type="text" id="recurrenceDay"
               placeholder="MTWRFSN as days of the week" pattern="[MTWRFSNmtwrfsn]{1}">
        <br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>
