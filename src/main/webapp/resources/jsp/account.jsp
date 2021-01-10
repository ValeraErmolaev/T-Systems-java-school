<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 27.12.2020
  Time: 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello, ${user.firstname}</h1>
<div class="container">
    <h1>Congrats!!! You did it!</h1>
    <form action="/auth/logout" method="POST">
        <button type="submit">Logout</button>
    </form>
    <form action="/" method="get">
        <button type="submit">Main menu</button>
    </form>
</div>
<security:authorize access="hasRole('ADMIN')">
<form action="${pageContext.request.contextPath}/Users">
    <input type="submit" value="Users" />
</form>
    </security:authorize>

</body>
</html>
