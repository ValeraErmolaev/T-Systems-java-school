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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<div style="text-align: center; transform: translate(0, 100%)" >
<form:form div="new-tariff-form" method="POST" modelAttribute="tariff">
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
</div>
</body>
</html>
