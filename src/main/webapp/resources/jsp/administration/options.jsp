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
    <form action="/administration/editor/option/create", method="get">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Create new option</button>
    </form>

</nav>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Option name</th>
        <th>Description</th>
        <th>Connect price</th>
        <th>Price</th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <c:if test="${options.size() !=0}">

        <c:forEach items="${options}" var="option">
            <tr>
                <td><c:out value="${option.name}"/></td>
                <td><c:out value="${option.description}"/></td>
                <td><c:out value="${option.connectPrice}"/></td>
                <td><c:out value="${option.price}"/></td>
                <td><a href='/administration/editor/option/${option.id}'>Edit</a></td>
                <td><a href='administration/users/${user.id}/delete'>Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
