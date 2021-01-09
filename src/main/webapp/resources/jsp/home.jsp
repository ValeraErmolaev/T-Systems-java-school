<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>login</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

    <link href="<spring:url value='/resources/css/main.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/registration.css'/>" rel="stylesheet">
</head>
<body>

<div id="layout">
    <h1>Welcome to Valera-mobile</h1>

 </div>
<security:authorize access="hasRole('ADMIN')">
        <form:form action="/Users" method="get">
             <input type="submit" value="Users"/>
        </form:form>
</security:authorize>
        <form:form action="/auth/login">
            <input type="submit" value="Login/Reg"/>
        </form:form>
<%--<security:authorize access="hasRole('ADMIN')">--%>
        <form:form action="admin">
            <input type="submit" value="For Admin">
        </form:form>
<%--</security:authorize>--%>
<%--<security:authorize access="hasAnyRole('USER','ADMIN')">--%>
        <form:form action="user">
            <input type="submit" value="For User">
        </form:form>
<%--</security:authorize>--%>
</body>
</html>
