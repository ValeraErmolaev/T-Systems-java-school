<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 13.01.2021
  Time: 23:43
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
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="<spring:url value='/resources/css/adminUsers.css'/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">

    <a href="/">Home</a>
    <a href="/auth/success">My account</a>
<%--    <a href="/administration/registration">Add new user</a>--%>
<%--    <form:form class="form-inline" method="post" action="/administration/users"  modelAttribute="tariffs">--%>
<%--        <form:input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"--%>
<%--                    value="" path="condition"></form:input>--%>
<%--        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>--%>
<%--    </form:form>--%>

</nav>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Tariff name</th>
        <th>Description</th>
        <th>Turn on price</th>
        <th>Options</th>
        <th>Image</th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <c:if test="${tariffs.size() !=0}" >

        <c:forEach items="${tariffs}" var="tariff">
            <tr>
                <td><c:out value="${tariff.name}"/></td>
                <td><c:out value="${tariff.description}"/></td>
                <td><c:out value="${tariff.turnOnPrice}"/></td>
<%--                <td></td>--%>
<%--                <td><c:out value="${tariff.options.size()}"/></td>--%>
                <c:choose>
                    <c:when test="${tariff.options.size() > 0}">
                        <td>
                            <c:forEach begin="0" end="${fn:length(tariff.options) - 1}" var="index">
                                <table class="table table-bordered">
                                    <tr><c:out value="${tariff.options[index].name}"/></tr>
                                </table>
                            </c:forEach>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
                <td><img src="${tariff.pictureUrl}"/></td>
<%--                <c:choose>--%>
<%--                    <c:when test="${user.contracts.size() > 0}">--%>
<%--                        <td>--%>
<%--                            <c:forEach begin="0" end="${fn:length(user.contracts) - 1}" var="index">--%>
<%--                                <table class="table table-bordered">--%>
<%--                                    <tr><c:out value="${user.contracts[index].number}"/></tr>--%>
<%--                                </table>--%>
<%--                            </c:forEach>--%>
<%--                        </td>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <td></td>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

                <td><a href='/administration/editor/tariff/${tariff.id}'>Edit</a></td>
                <td><a href='administration/users/${user.id}/delete'>Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
