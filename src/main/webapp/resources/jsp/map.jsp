<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 12.01.2021
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>World Map</title>

    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/jqvmap.css'/>" rel="stylesheet">
    <link href="/resources/css/jqvmap.css" media="screen" rel="stylesheet" type="text/css"/>
    <link href="<spring:url value='/resources/css/common.css'/>" rel="stylesheet">




</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a style="color: white; text-decoration: none" href="/">Home</a>
        <a style="color: white; text-decoration: none" href="/auth/success">My account</a>
        <a style="color: white; text-decoration: none" href="">About</a>
        <a style="color: white; text-decoration: none" href="/tariff">Tariffs</a>
        <a style="color: white; text-decoration: none" href="/map">Map</a>
        <a style="color: white; text-decoration: none" href="#myModal1"  data-toggle="modal">Cart</a>
    </nav>
</header>
<h2 align="center" style="color: #3498db">Coverage map</h2>
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
<footer style="background-color: #3498db">
    <p> &copy; Valerii Ermolaev</p>
    <br>
</footer>
<div class="container">
    <div id="myModal1" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <%--                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">AAAAAAAA</button>--%>
                    <h4 class="modal-title">Cart</h4>
                </div>
                <div class="modal-body">
                    <c:choose>
                        <c:when test="${userCart.tariff !=null}">
                            Tariff: ${userCart.tariff.name}
                            <br>
                            Options:
                            <c:forEach items="${userCart.options}" var="option">
                                ${option.name}
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            Cart is empty
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Delete all</button>
                </div>
            </div>
        </div>
    </div>
    <!-- jQuery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.js"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.world.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.sampledata.js"></script>
    <script type="text/javascript" src='/resources/js/header.js'></script>
    <script type="text/javascript" src='/resources/js/vmap.js'></script>
    <script>
        $(function () {
            $("#btn2").click(function () {
                $("#myModal2").modal('show');
            });
        });
    </script>
</div>
</body>
</html>
