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
                        <a href="/login.jsp">Login</a>
                    </li>
                    <li>
                        <a href="/signupForm.jsp">Signup</a>
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
                    <%--<% if (new UserDao().getUserByUsername(session.getAttribute("username")))%>--%> If not a driver yet.
                    <li>
                        <a href="/be"></a>
                    </li>
                <% } %>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>