<html>
<head>
    <title>login</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">
</head>
<body>

<div id="layout">
    <h1>Welcome to Valera-mobile</h1>

<%--    <button id="show-modal" class="btn">Login/Registration</button>--%>
</div>


<form action="${pageContext.request.contextPath}/Users">
    <input type="submit" value="Users" />
</form>
<form action="${pageContext.request.contextPath}/log_reg">
    <input type="submit" value="Login/Reg" />
</form>


<%--<c:forEach items="${roles}" var="r">--%>
<%--    <tr>--%>
<%--        <td><c:out value="${r.id}"/></td>--%>
<%--        <td><c:out value="${r.role}"/></td>--%>
<%--        <td><a href='role/${u.id}/edit'>Edit</a></td>--%>
<%--        <td><a href='role/${u.id}/delete'>Delete</a></td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--<div id="modal">--%>
<%--    <div id="login">--%>
<%--        <form class="login-form" action="login" method="post">--%>
<%--            <div class="loginform-inputs">--%>
<%--                <div>--%>
<%--                    &lt;%&ndash;                    <label for="login-inp">UserName:</label>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <input id="login-inp" type='text' name='username' value=''>&ndash;%&gt;--%>
<%--                    <input id="login-inp" type='text' name='username' placeholder="First name" required="">--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    &lt;%&ndash;                    <label for="pass-inp">Password:</label>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <input id="pass-inp" type='password' name='password' value=''>&ndash;%&gt;--%>
<%--                    <input id="pass-inp" type='password' name='password' placeholder="Password" required="">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="loginform-buttons">--%>
<%--                <button class="reg-btn" value="registration">Register</button>--%>
<%--                <input class="login-btn" type="submit" value="login">--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>--%>
</body>
</html>
