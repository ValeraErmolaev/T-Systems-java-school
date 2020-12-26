<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 25.12.2020
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>login</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<div id="layout">
    <h1>Home Page</h1>
    <button id="show-modal" class="btn">Открыть</button>
</div>
<div id="modal">
    <div id="login">
        <form class="login-form">
            <label>
                <input type="text"/>
            </label>
            <label>
                <input type="password"/>
            </label>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
