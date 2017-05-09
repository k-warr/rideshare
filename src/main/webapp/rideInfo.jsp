<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 5/8/17
  Time: 1:51 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ride Info</title>
    <c:import url="theme/bootstrapReferences.jsp" />
</head>
<body>
    <c:import url="theme/nav.jsp" />
    <div class="container">
        <div class="row">
            <iframe
                    width="800"
                    height="600"
                    frameborder="0" style="border:0"
                    src="https://www.google.com/maps/embed/v1/directions?key=${apiKey}&origin=${origin}&destination=${destination}&waypoints=${waypoints}&avoid=tolls&mode=driving"
                    allowfullscreen >
            </iframe>
        </div>
    </div>
</body>
</html>
<c:import url="theme/themeStyling.jsp" />