<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 07.01.2021
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
    <title>log_reg</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/log_reg.css">

</head>
<body>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <% response.sendRedirect("/"); %>--%>
<%--</sec:authorize>--%>
<div class="login-page">

<%--    REGISTRATION PART--%>
    <div class="form">
        <form:form class="register-form" method="POST" modelAttribute="userForm">
<%--        <form class="register-form">--%>
            <div>
                <form:input type="text" path="firstname" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="firstname"></form:errors>
                ${usernameError}
            </div>
            <div>
                <form:input type="text" path="email" placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
                ${usernameError}
            </div>
<%--            <input type="text" placeholder="name"/>--%>
            <div>
            <form:input type="password" path="passwordHash" placeholder="Password"
                        autofocus="true"></form:input>
            <form:errors path="passwordHash"></form:errors>
            ${usernameError}
            </div>
<%--            <input type="password" placeholder="password"/>--%>
<%--            <input type="text" placeholder="email address"/>--%>
<%--            <button>create</button>--%>
            <button type="submit">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form:form>



        <form class="login-form" action="${pageContext.request.contextPath}/auth" method='POST'>
            <input type="text" name='username' placeholder="username"/>
            <input type="password" name='password' placeholder="password"/>
            <c:if test="${not empty error}">
                <div class="text-danger text-sm-center" role="alert">${error}</div>
            </c:if>
<%--            <input type="hidden"--%>
<%--                   name="${_csrf.parameterName}"--%>
<%--                   value="${_csrf.token}"/>--%>
            <button type="submit">login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/log_reg.js"></script>
</body>
</html>
