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
    <a href="/administration/editor/user/${user.id}">Back</a>
</nav>
</header>
</nav>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Option</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${contracts.size() !=0}">

        <c:forEach items="${contracts}" var="contract">
            <tr>

            <c:forEach items="${contract.tariff.options}" var="option">
                <c:if test="${!contract.options.contains(option)}">
                    <tr>
                        <div id="option-choose">
                            <td>
                                   <span>
                                    <c:out value="${option.name}"/>
                                       <form action="/administration/editor/${contract.id}/addOptionByAdmin/${option.id}/${contract.user.id}" method="GET">
                                           <input type="submit" value="Add this option"/>
                                       </form>
                                   </span>
                            </td>
                        </div>
                    </tr>

                </c:if>
            </c:forEach>

            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>