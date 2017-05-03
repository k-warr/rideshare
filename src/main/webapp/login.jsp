<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 3/22/17
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<h3>Please enter your username and password below.</h3>
    <form action="loginFormServlet" method="post">
        User Name: <input type="text" name="j_username"><br />
        Password:  <input type="password" name="j_password"><br />
        <input type="submit" value="Login">
    </form>
</body>
</html>

