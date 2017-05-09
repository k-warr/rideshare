<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.persistence.UserDao" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Home</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <% if (session.getAttribute("username") == null) { %>
                    <li>
                        <a href="/toLoginForm">Login</a>
                    </li>
                    <li>
                        <a href="/toSignupForm">Signup</a>
                    </li>
                <% } else {%>
                    <li>
                        <a href="/logout">Logout</a>
                    </li>
                    <li>
                        <a href="/myprofile">Profile</a>
                    </li>
                    <li>
                        <a href="/toRideRequestForm">New Ride Request</a>
                    </li>
                    <li>
                        <a href="/toBecomeADriverForm">Become a Driver</a>
                    </li>
                <% } %>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>