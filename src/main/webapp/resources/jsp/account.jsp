<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 27.12.2020
  Time: 3:45
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


    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/account.css'/>" rel="stylesheet">

</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a href="/">Home</a>
        <a href="/account">My account</a>
        <a href="">About</a>
        <a href="/tariff">Tariffs</a>
        <a href="/map">Map</a>
    </nav>
</header>

<div>
    <h1 id="hello-fullname">Hello, ${user.fullname}</h1>
    <form action="/auth/logout" method="POST">
        <button type="submit" class="btn btn-primary">Logout</button>
    </form>
</div>
<table class="table table-bordered table-hover">

    <tr>
        <th>Your Contracts</th>
        <th>Tariff</th>
        <th>Connected options</th>
        <th>Status</th>
        <th></th>
    </tr>

    <c:if test="${user.contracts.size() > 0}">

        <c:forEach items="${user.contracts}" var="contract">
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
                                <%--                                <td></td>--%>
                                <%--                                <td></td>--%>
                            </c:when>
                            <c:otherwise>
                                <td>${contract.tariff.name}</td>
                                <%--                            <td>${contract.options}</td>--%>
                                <td>
                                    <c:forEach items="${contract.options}" var="option">
                                        <div class="one-option">
                                    <span class="option-name modal-responsive">
                                        <c:out value="${option.name}"/>
                                    </span>
                                            <span>
                                        <form action="/user/editor/${contract.id}/delete/${option.id}" method="POST">
                                            <input type="submit" value="Delete"/>
                                        </form>
                                    </span>
                                        </div>
                                    </c:forEach>

                                </td>
                                <td>Blocked</td>
                                <td>
                                    <form action="/user/${user.id}/contract/${contract.id}/unblock" method="post">
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
<%--                                    <span>--%>
<%--                                        <form action="/user/editor/${contract.id}/delete/${option.id}" method="POST">--%>
<%--                                            <input type="submit" value="Delete"/>--%>
<%--                                        </form>--%>
<%--                                    </span>--%>
                                </div>
                            </c:forEach>
                            <span>
                                 <form action="/administrator/editor/${contract.id}/addOption" method="get">
                                    <input type="submit" value="Options menu"/>
                                 </form>
                             </span>
                        </td>

                        <td>Active</td>
                        <td>
                            <form action="/user/${user.id}/contract/${contract.id}/block" method="post">
                                <button value="Block" type="submit">Block</button>
                            </form>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </c:if>

</table>


</body>
</html>
