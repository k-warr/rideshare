<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 3/22/17
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile Page</title>
    <c:import url="theme/bootstrapReferences.jsp" />
</head>
<body>
    <c:import url="theme/nav.jsp" />
    <div>
        You have reached myProfile.jsp

    </div>
    <div>
        <nav>
            <a href="editProfileInfoForm.jsp">Edit Personal Information</a>
            <a href="becomeADriverForm.jsp">Become a Driver</a>
        </nav>
    </div>
    <div>
        <%--Show my ride requests, fulfilled, open, or closed--%>
            <h2>Fruits</h2>
            <table>
                <%--<c:forEach var="fruit" items="${}">--%>
                    <%--<tr>--%>
                        <%--<td>${fruit}</td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            </table>
    </div>
    <div>
        <%--if driver, show other's open ride requests to accept--%>
    </div>
    <div>
    </div>
</body>
</html>