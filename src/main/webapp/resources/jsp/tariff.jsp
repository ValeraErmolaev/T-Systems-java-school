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

                    <c:forEach begin="0" end="${fn:length(tariff.options) - 1}" var="index">
                        <table class="table table-bordered">
                            <tr><c:out value="${tariff.options[index].name}"/></tr>
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
</body>
</html>
