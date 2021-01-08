
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
<div class="login-page">

<%--    REGISTRATION PART--%>
    <div class="form">
        <form:form class="register-form" method="POST" modelAttribute="user">
<%--        <form class="register-form">--%>
<%--            <input pattern="\d*" title="Numbers only, please.">--%>
            <div>
                <form:input pattern="[A-Za-z]*" title="Letters only, please." type="text" path="firstname" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
            <div>
                <form:input pattern="[^@\s]+@[^@\s]+\.[^@\s]+" title="Invalid email address" type="text" path="email" placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
                <span style="color: crimson">${emailIsNotUniqueError}</span>
            </div>
            <div>
                <form:input type="text" path="confirmEmail" placeholder="Confirm email"
                            autofocus="true"></form:input>
                <form:errors path="confirmEmail"></form:errors>
                  <span style="color: crimson">${emailsMutchError}</span>
            </div>
<%--            <input type="text" placeholder="name"/>--%>
            <div>
            <form:input type="password" path="password" placeholder="Password"
                        autofocus="true"></form:input>
            <form:errors path="password"></form:errors>
            </div>
            <div>
                <form:input type="password" path="confirmPassword" placeholder="Confirm Password"
                            autofocus="true"></form:input>
                <form:errors path="confirmPassword"></form:errors>
                <span style="color: crimson">${passwordError}</span>
            </div>
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
