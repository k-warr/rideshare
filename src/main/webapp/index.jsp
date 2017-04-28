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
<c:import url="content/content-index.jsp" />

</body>
</html>

<style>
    /*
 * Start Bootstrap - Business Frontpage (http://startbootstrap.com/)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */

    body {
        padding-top: 50px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }

    /* Header Image Background - Change the URL below to your image path (example: ../images/background.jpg) */
    .business-header {
        height: 400px;
        background: url('http://placehold.it/1920x400') center center no-repeat scroll;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
    }

    /* Customize the text color and shadow color and to optimize text legibility. */
    .tagline {
        text-shadow: 0 0 10px #000;
        color: #fff;
    }

    .img-center {
        margin: 0 auto;
    }

    footer {
        margin: 50px 0;
    }
</style>