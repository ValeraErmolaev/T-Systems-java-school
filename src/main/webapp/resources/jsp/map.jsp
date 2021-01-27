<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 12.01.2021
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>World Map</title>

    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/jqvmap.css'/>" rel="stylesheet">
    <link href="/resources/css/jqvmap.css" media="screen" rel="stylesheet" type="text/css"/>
    <link href="<spring:url value='/resources/css/common.css'/>" rel="stylesheet">


    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.js"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.world.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.sampledata.js"></script>
    <script type="text/javascript" src='/resources/js/header.js'></script>
    <script type="text/javascript" src='/resources/js/vmap.js'></script>

</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a href="/">Home</a>
        <a href="/auth/success">My account</a>
        <a href="">About</a>
        <a href="/tariff">Tariffs</a>
        <a href="/map">Map</a>
    </nav>
</header>
<h2 align="center" style="color: white">Coverage map</h2>
<div>
    <div id="vmap"
         style="width: 100%; height: 400px; margin: 0px auto; position: relative; overflow: hidden; background-color: rgb(255, 255, 255);">
    </div>
</div>
    <div class="wrapper">
         <section>
            <%--        <h2> This is some steezy stuff</h2>--%>
<%--             <span>Test</span>--%>
            <p>Egypt France French Guiana Germany Gibraltar Greece Guadeloupe Hong Kong Hungary Iceland Ireland</p>
            <p> Israel Italy Latvia Liechtenstein Lithuania Luxembourg Malta Martinique Mexico Monaco Netherlands</p>
            <p>Norway Poland Portugal Puerto Rico Russia Singapore Slovakia South Korea Spain Sweden Switzerland</p>
            <p>United Kingdom United States of America United States Virgin Islands</p>
         </section>
    </div>
<div id="footer" style="background-color: #76b852">
    <br>
    <p> &copy; Valerii Ermolaev</p>
    <br>
</div>
</body>
</html>
