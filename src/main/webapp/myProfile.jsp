<%--
  Created by IntelliJ IDEA.
  User: Kien Warren
  Date: 3/22/17
  Time: 6:53 PM
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
            <h2>My Rides</h2>
            <table>
                <thead>
                    <tr>
                        <th>Request Status</th>
                        <th>Day</th>
                        <th>Pickup Address</th>
                        <th>Dropoff Address</th>
                        <th>Dropoff Time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="rideRequest" items="${riderRideRequests}">
                        <tr>
                            <td>${rideRequest.getRequestStatus()}</td>
                            <td>${rideRequest.getRecurrenceDay()}</td>
                            <td>${rideRequest.getPickupAddress().getFullAddress()}</td>
                            <td>${rideRequest.getDropoffAddress().getFullAddress()}</td>
                            <td>${rideRequest.getDropoffTime()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </div>
    <div>
        <%--if driver, show other's open ride requests to accept--%>
        <table>
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Day</th>
                    <th>Dropoff Time</th>
                    <th>Pickup Address</th>
                    <th>Dropoff Address</th>
                    <th>Time of Request</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="openRideRequest" items="${openRideRequests}">
                    <tr>
                        <%--<td>${openRideRequest.}</td>--%>
                        <td>${openRideRequest.getRequestStatus()}</td>
                        <td>${openRideRequest.getRecurrenceDay()}</td>
                        <td>${openRideRequest.getPickupAddress().getFullAddress()}</td>
                        <td>${openRideRequest.getDropoffAddress().getFullAddress()}</td>
                        <td>${openRideRequest.getDropoffTime()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
    </div>
</body>
</html>