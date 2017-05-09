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
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <c:if test="${becomeADriverSignupSuccess}">
                    <h3>Successfully signed up to be a driver.</h3>
                </c:if>
                <c:if test="${alreadyDriver}">
                    <h3>You are already signed up to be a driver.</h3>
                </c:if>
                <c:if test="${acceptedRide}">
                    <h3>You have accepted a ride. It has either created a new Ride or been added to an existing Ride.</h3>
                </c:if>
                <c:if test="${fullRide}">
                    <h3>The ride request you have accepted has not been added. It appears you already have a full ride scheduled for the same time.</h3>
                </c:if>
            </div>
        </div>
        <c:if test="${riderRideRequests.size() > 0}">
            <div class="row">
                <div class="col-lg-12">
                        <%--Show my ride requests, fulfilled, open, or closed--%>
                    <h2>My Ride Requests</h2>
                    <table>
                        <thead>
                        <tr>
                            <th>Request Status</th>
                            <th>Time of Request</th>
                            <th>Day</th>
                            <th>Pickup Address</th>
                            <th>Dropoff Address</th>
                            <th>Dropoff Time</th>
                            <th>Ride Info</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="rideRequest" items="${riderRideRequests}">
                            <tr>
                                <td>${rideRequest.getRequestStatus()}</td>
                                <td>${rideRequest.getRequestTime()}</td>
                                <td>${rideRequest.getRecurrenceDay()}</td>
                                <td>${rideRequest.getPickupAddress().getFullAddress()}</td>
                                <td>${rideRequest.getDropoffAddress().getFullAddress()}</td>
                                <td>${rideRequest.getDropoffTime()}</td>
                                <td>
                                    <c:if test="${rideRequest.getRequestStatus().equals(\'Accepted\')}">
                                        <a href="/rideInfo?rideId=${rideRequest.getRide().getRideId()}">Ride Info</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>
        <c:if test="${isDriver}">
            <div class="row">
                <div class="col-lg-12">
                    <h3>Open Ride Requests</h3>
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
                            <th>Accept Request</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="openRideRequest" items="${openRideRequests}">
                            <tr>
                                <td>${openRideRequest.getUser().getUsername()}</td>
                                <td>${openRideRequest.getRecurrenceDay()}</td>
                                <td>${openRideRequest.getPickupAddress().getFullAddress()}</td>
                                <td>${openRideRequest.getDropoffAddress().getFullAddress()}</td>
                                <td>${openRideRequest.getDropoffTime()}</td>
                                <td>${openRideRequest.getRequestTime()}</td>
                                <td><a href="/createOrUpdateRide?requestId=${openRideRequest.getRequestId()}">Accept</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div> <%-- end open ride requests div --%>
            <%-- Show user's rides div --%>
            <div class="row">
                <div class="col-lg-12">
                    <h3>My Rides</h3>
                    <table>
                        <thead>
                        <tr>
                            <th>Ride DateTime</th>
                            <th>Number of Riders</th>
                            <th>Depart Time</th>
                            <th>Ride Info</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ride" items="${rides}">
                                <tr>
                                    <td>${ride.getRequestDateTime()}</td>
                                    <td>${ride.getNumRidersInclDriver() - 1}</td>
                                    <td>${ride.getDepartTime()}</td>
                                    <td><a href="/rideInfo?rideId=${ride.getRideId()}">Ride Info</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>

    </div>
</body>
</html>
<c:import url="theme/themeStyling.jsp" />