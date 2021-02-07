<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 07.02.2021
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Tariff creation</title>
</head>
<body>
<form:form class="new-tariff-form" method="POST" modelAttribute="tariff">
    <div>
    <form:input type="text" path="name" placeholder="Tariff name" autofocus="true"></form:input>
<%--    <form:errors path="firstname"></form:errors>--%>
    </div>
    <div>
    <form:input type="text" path="description" placeholder="Tariff description" autofocus="true"></form:input>
<%--    <form:errors path="lastname"></form:errors>--%>
    </div>

    <div>
    <form:input type="text" path="turnOnPrice" placeholder="Turn on price" autofocus="true"></form:input>
<%--    <form:errors path="email"></form:errors>--%>

    </div>
    <div>
    <form:input type="text" path="price" placeholder="Price" autofocus="true"></form:input>
<%--    <form:errors path="confirmEmail"></form:errors>--%>

    </div>
    <button type="submit">Create tariff</button>
    <p class="message"> <a href="/administration/tariffs">Back</a></p>
</form:form>
</body>
</html>
