<html>
<head>
    <title>login</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">
</head>
<body>

<div id="layout">
    <h1>Welcome to Valera-mobile</h1>

    <button id="show-modal" class="btn">Login/Registration</button>
</div>
${contract.toString()}
${contract.id}
${contract.number}
<div id="modal">
    <div id="login">
        <form class="login-form" action="login" method="post">
            <div class="loginform-inputs">
                <div>
                    <%--                    <label for="login-inp">UserName:</label>--%>
                    <%--                    <input id="login-inp" type='text' name='username' value=''>--%>
                    <input id="login-inp" type='text' name='username' placeholder="First name" required="">
                </div>
                <div>
                    <%--                    <label for="pass-inp">Password:</label>--%>
                    <%--                    <input id="pass-inp" type='password' name='password' value=''>--%>
                    <input id="pass-inp" type='password' name='password' placeholder="Password" required="">
                </div>
            </div>
            <div class="loginform-buttons">
                <button class="reg-btn" value="registration">Register</button>
                <input class="login-btn" type="submit" value="login">
            </div>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
