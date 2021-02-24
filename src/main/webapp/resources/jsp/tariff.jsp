<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 28.01.2021
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Tariff</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">

</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a style="color: white; text-decoration: none"   href="/">Home</a>
        <a  style="color: white; text-decoration: none" href="/auth/success">My account</a>
        <a  style="color: white; text-decoration: none" href="">About</a>
        <a  style="color: white; text-decoration: none" href="/tariff">Tariffs</a>
        <a  style="color: white; text-decoration: none" href="/map">Map</a>
        <a  style="color: white; text-decoration: none" href="#myModal1"  data-toggle="modal">Cart</a>
    </nav>
</header>
<div id="tariff-description">
<table class="table table-bordered">

<%--        <th>Tariff name</th><td></td><td>Description</td><td>Turn on price</td><td>Options</td></tr>--%>
    <c:if test="${tariffs.size() !=0}" >

        <c:forEach items="${tariffs}" var="tariff">
            <tr>
                <th>Tariff name</th>
                <td><c:out value="${tariff.name}"/></td>
            </tr>
            <tr>
                <th></th><td><img src="${tariff.pictureUrl}"/></td>
            </tr>
            <tr>
                <th>Description</th><td><c:out value="${tariff.description}"/></td>
            </tr>
            <tr>
                <th>Turn on price</th><td><c:out value="${tariff.turnOnPrice}"/></td>
            </tr>
            <tr>
                <th>Options</th>
                <td>
                    <c:choose>
                    <c:when test="${tariff.options.size() > 0}">

                    <c:forEach items="${tariff.options}" var="option">
                        <table class="table table-bordered">
                            <tr>
                                <div class="one-option">
                                <span>
                                    <c:out value="${option.name}"/>
                                </span>
                                <span>
                                     <form action="/tariff/${tariff.id}/option/${option.id}/addToCart" method="POST">
                                         <input type="submit" value="Add to Cart"/>
                                     </form>
                                </span>
                                </div>
                            </tr>
                        </table>
                    </c:forEach>

                </c:when>
                <c:otherwise>
                    <td></td>
                </c:otherwise>
                </c:choose>
            </td>
            </tr>
        </c:forEach>
    </c:if>

</table>
</div>
<footer style="background-color:   #3498db">
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
<%--                    <button type="button" class="btn btn-primary">Delete all</button>--%>
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
