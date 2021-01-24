<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 17.01.2021
  Time: 17:49
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
    <link href="<spring:url value='/resources/css/userContracts.css'/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">

    <a href="/">Home</a>
    <a href="/auth/success">My account</a>
    <a href="/administration/users">Back</a>
    <form action="/administration/editor/user/${user.id}/addContract", method="get">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Create new default contract</button>
    </form>

</nav>
<table class="table table-bordered">
    <thead class="thead-dark">
        <tr>
            <th>Full name</th>
            <th>Contracts</th>
            <th>Tariff</th>
            <th>Options</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${user.fullname}"/></td>
            <c:choose>
                <c:when test="${user.contracts.size() > 0}">
                    <td>
                        <div class="contracts-container">
                            <c:forEach begin="0" end="${fn:length(user.contracts) - 1}" var="index">
                                <div class="one-contract">
                                    <span><c:out value="${user.contracts[index].number}"/></span>
                                    <span><c:out value="${user.contracts[index].tariff.name}"/></span>
                                    <div class="options-list">

                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                </c:when>
                <c:otherwise>
                    <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </tbody>
</table>
</body>
</html>
