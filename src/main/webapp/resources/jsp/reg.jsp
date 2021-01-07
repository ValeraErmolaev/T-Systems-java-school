<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 05.01.2021
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap CSS -->
<%--    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">--%>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/created" method="post">
    id <input type="text" value=${user.id}>
    firstname<input type="text" value=${user.firstname}>
    <input type="submit" value="add" />
</form>
</body>
</html>
