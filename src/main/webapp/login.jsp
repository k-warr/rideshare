<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 3/22/17
  Time: 6:48 PM
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<c:if test="${newUser}">
    <h3>Account Creation Successful!</h3>
</c:if>
<c:if test="${notLoggedIn}">
    <h2>Please login before proceeding</h2>
</c:if>
<h3>Please enter your username and password below to login.</h3>
    <form action="loginFormServlet" method="post">
        User Name: <input type="text" name="j_username"><br />
        Password:  <input type="password" name="j_password"><br />
        <input type="submit" value="Login">
    </form>
</body>
</html>

