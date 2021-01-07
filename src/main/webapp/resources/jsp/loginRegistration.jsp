<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 07.01.2021
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>log_reg</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/log_reg.css">

</head>
<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input type="text" placeholder="name"/>
            <input type="password" placeholder="password"/>
            <input type="text" placeholder="email address"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form" action="${pageContext.request.contextPath}/auth" method='POST'>
            <input type="text" name='username' placeholder="username"/>
            <input type="password" name='password' placeholder="password"/>
            <c:if test="${not empty error}">
                <div class="text-danger text-sm-center" role="alert">${error}</div>
            </c:if>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit">login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/log_reg.js"></script>
</body>
</html>
