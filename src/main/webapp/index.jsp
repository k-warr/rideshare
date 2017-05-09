<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Ride Share</title>
    <c:import url="theme/bootstrapReferences.jsp" />
</head>
<body>

<!-- Navigation -->
<c:import url="theme/nav.jsp" />

<!-- Image Background Page Header -->
<!-- Note: The background image is set within the business-casual.css file. -->
<header class="business-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="tagline">Ride Share</h1>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <hr>

    <div class="row">
        <div class="col-sm-8">
            <h2>Problem Description</h2>
            <p>The idea came to me last summer when I saw that other interns at my internship didn't have rides and bussed to work. I had a potential web app project that involved creating a solution to help interns sign up for a ride share and assigned passengers to vehicles. Unfortunately, that didn't come to fruition since it would have taken too long to create. I decided that I would give it a shot for my Individual Project since I liked the idea at the time and I still do now.</p>
            <p>
                <a class="btn btn-default btn-lg" href="https://github.com/Tubakien/rideshare">Link to Github &raquo;</a>
            </p>
        </div>
        <div class="col-sm-4">
            <h2>Contact Us</h2>
            <address>
                <strong>Kien Warren</strong>
                <br>
                <abbr title="Email">E:</abbr> <a href="mailto:kwarren2@madisoncollege.edu">kwarren2@madisoncollege.edu</a>
            </address>
        </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy;RideShare  2017</p>
            </div>
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- /.container -->

</body>
</html>
<c:import url="theme/themeStyling.jsp" />