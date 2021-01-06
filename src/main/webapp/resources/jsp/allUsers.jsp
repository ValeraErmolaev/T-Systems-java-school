<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 02.01.2021
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>First name</th> <th>Last name</th> <th>Email</th> <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.firstname}"/></td>
<%--            <td><c:out value="${u.getLastname()}"/></td>--%>
<%--            <td><c:out value="${u.getEmail}"/></td>--%>
<%--            <td><c:out value="${u.getRole().getRole()}"/></td>--%>
            <td><a href='user/${u.id}/edit'>Edit</a></td>
            <td><a href='user/${u.id}/delete'>Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
