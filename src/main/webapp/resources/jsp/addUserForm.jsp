<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 02.01.2021
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>add new User</title>
</head>
<body>
<div class="container">
    <h2>User Form</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
    <hr />
<%--    <form:form method="POST" modelAttribute="user"--%>
<%--               cssClass="form-horizontal">--%>
<%--    <form action="${pageContext.request.contextPath}/created" method="post">--%>
<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/created">
        <form:input type="hidden" path="id" id="id" />

        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:input path="firstname" id="firstName" cssClass="form-control" />
        </div>

        <div class="form-group">
            <label for="lastName">Last Name</label>
            <form:input path="lastname" id="lastName" cssClass="form-control" />
        </div>

        <div class="form-group">
            <label for="contract">Contract</label>
            <form:input path="contract" id="contract" cssClass="form-control" />
        </div>
        <hr />
        <c:choose>
            <c:when test="${edit}">
                <button type="submit" class="btn btn-primary">Update</button>
            </c:when>
            <c:otherwise>
                <button type="submit" class="btn btn-primary">Save</button>
            </c:otherwise>
        </c:choose>

<%--        <a class="btn btn-secondary" href="<c:url value='/list' />">List--%>
<%--            of All Students</a>--%>

    </form:form>
</div>
</body>
</html>
