<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 16.01.2021
  Time: 13:16
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
    <title>Account</title>
    <link href="<spring:url value='/resources/css/adminHeader.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/adminAccount.css'/>" rel="stylesheet">

</head>
<body>
<header>
    <h1>Administration</h1>
    <nav>
        <a href="/">Home</a>
        <a href="/administration/users">Users menu</a>
        <a href="/administration/tariffs">Tariff menu</a>
        <a href="/administration/options">Option menu</a>
        <a href="/map">Map</a>
    </nav>
</header>
<h1>Hello, ${user.fullname}</h1>
<div class="container">
    <form action="/auth/logout" method="POST">
        <button type="submit" class="btn btn-primary">Logout</button>
    </form>
</div>
<table class="table table-bordered table-hover">

    <tr>
        <th>Your Contracts</th>
        <th>Tariff</th>
        <th>Connected options</th>
        <th>Available options</th>
    </tr>
    <c:if test="${user.contracts.size() > 0}">
        <c:if test="${contracts.size() > 0}">
            <c:forEach items="${contracts}" var="contract">
                <c:if test="${!contract.is_blocked}">
                    <tr>
                        <td><c:out value="${contract.number}"/></td>
                        <c:choose>
                            <c:when test="${contract.is_blocked == true}">
                                <c:choose>
                                    <c:when test="${contract.is_blocked_by_admin == true}">
                                        <td><p style="color: #EF3B3A">That information is not available</p></td>
                                        <td><p style="color: #EF3B3A">That information is not available</p></td>
                                        <td><p style="color: #EF3B3A">Blocked by eCare</p></td>
                                        <td><p></p></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${contract.tariff.name}</td>
                                        <td>
                                            <c:forEach items="${contract.options}" var="option">
                                                <div class="one-option">
                                                    <span>
                                                        <c:out value="${option.name}"/>
                                                    </span>
                                                    <span>
                                                        <form action="/administration/editor/${contract.id}/deleteOption/${option.id}" method="POST">
                                                            <input type="submit" value="Delete"/>
                                                        </form>
                                                    </span>
                                                </div>
                                            </c:forEach>

                                        </td>
                                        <td>Blocked</td>
                                        <td>
                                            <form action="/user/${user.id}/contract/${contract.id}/unblock"
                                                  method="post">
                                                <button value="Unblock" type="submit">Unblock</button>
                                            </form>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <td>${contract.tariff.name}</td>
                                <td>
                                    <c:forEach items="${contract.options}" var="option">
                                        <div class="one-option">
                                    <span>
                                        <c:out value="${option.name}"/>
                                    </span>
                                            <span>
                                        <form action="/administration/editor/${contract.id}/deleteOption/${option.id}" method="POST">
                                            <input type="submit" value="Delete"/>
                                        </form>
                                    </span>
                                        </div>
                                    </c:forEach>
                                    <span>
<%--                                 <form action="/user/editor/${contract.id}/addOption" method="get">--%>
<%--                                    <input type="submit" value="Add option"/>--%>
<%--                                 </form>--%>
                             </span>
                                </td>
                                <td>
                                    <c:if test="${contract.tariff.options.size() > 0}">
                                        <c:forEach items="${contract.tariff.options}" var="option">
                                            <c:if test="${!contract.options.contains(option)}">
                                                <span>
                                                     <c:out value="${option.name}"/>
                                                    <form action="/administrator/editor/${contract.id}/addOption/${option.id}" method="post">
                                                        <input type="submit" value="Buy"/>
                                                    </form>
                                                </span>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:if>
            </c:forEach>
        </c:if>
    </c:if>
</table>
</body>
</html>

