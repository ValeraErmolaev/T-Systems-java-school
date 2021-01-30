<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link href="<spring:url value='/resources/css/registration.css'/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

</head>
<body>
<div class="login-page">
    <div class="form">

        <form:form class="login-form" action="/auth/login" method='POST' modelAttribute="user">
            <h2 class="form-signin-heading"></h2>

            <form:input type="text" name='username' placeholder="username" path="username"/>
            <form:input type="password" name='password' placeholder="password" path="password"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form:form>
<%--        <form:errors path="error"></form:errors>--%>
        <p class="message" style="color: #EF3B3A">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>

        <p class="message">Not registered? <a href="/registration">Create an account</a></p>
        <%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    </div>
</div>
</body>
</html>