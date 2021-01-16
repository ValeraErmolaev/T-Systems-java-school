<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 16.01.2021
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Account</title>
    <link href="<spring:url value='/resources/css/adminHeader.css'/>" rel="stylesheet">

</head>
<body>
<header>
    <h1>Administration</h1>
    <nav>
        <a href="/">Home</a>
        <a href="/administration/users">User editor</a>
        <a href="/administration/tariffs">Tariff editor</a>
        <a href="/map">Map</a>
    </nav>
</header>
<h1>Hello, ${user.fullname}</h1>
<div class="container">
    <form action="/auth/logout" method="POST">
        <button type="submit">Logout</button>
    </form>
</div>
<security:authorize access="hasAnyRole('ADMIN')">
    <form action="${pageContext.request.contextPath}/Users">
        <input type="submit" value="Users" />
    </form>
</security:authorize>

</body>
</html>
