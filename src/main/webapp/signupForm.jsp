<%--
  User: Kien Warren
  Date: 5/1/17
  Time: 6:35 PM
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
<%--Navigation --%>
<c:import url="theme/nav.jsp" />

<h3>Signup Form</h3>
<form action="/signupFormHandler" method="POST">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" >
    <br>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password" >
    <br>
    <label for="email">Email: </label>
    <input type="text" id="email" name="email" >
    <br>
    <label for="phoneNumber">Phone Number: </label>
    <input type="text" id="phoneNumber" name="phoneNumber">
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>