<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 5/9/17
  Time: 4:23 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Administrator page</title>
</head>
<body>
    <c:if test="${users != null}">
        <h3>Users</h3>
        <table>
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Delete?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.getUsername()}</td>
                        <td><a href="/adminPage?fromAdmin=yes&userId=${user.getUserId()}">Delete user</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
