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
    <script type="text/javascript" src='/resources/js/header.js'></script>
</head>
<body>

<div id="layout">
    <h1>Welcome to Valera-mobile</h1>

 </div>
<header class="header">

</header>
<ul>
    <li><a href="/account">My account</a></li>
    <li><a href="/tariffs">Tariffs</a>
        <ul>
            <li><a href="#">All</a></li>
            <li><a href="#">For </a></li>
            <li><a href="#">qqq</a></li>
        </ul>
    </li>
    <li><a href="#">qqq</a></li>
    <li><a href="#">qqq</a></li>
</ul>
<security:authorize access="hasRole('ADMIN')">
        <form:form action="/Users" method="get">
             <input type="submit" value="Users"/>
        </form:form>
</security:authorize>
        <form:form action="/account">
            <input type="submit" value="My account"/>
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
