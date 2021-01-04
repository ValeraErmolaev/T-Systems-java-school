<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 04.01.2021
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log_reg</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home_v2.css">
    <script src="${pageContext.request.contextPath}/resources/js/log_reg.js"></script>
</head>
<body>
<div class="login-page">
    <div id="regID" class="form">
        <form class="register-form">
            <input type="text" placeholder="name"/>
            <input type="password" placeholder="password"/>
            <input type="text" placeholder="email address"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form id="loginID" class="login-form">
            <input type="text" placeholder="username"/>
            <input type="password" placeholder="password"/>
            <button>login</button>
            <p id="showSignUp" class="message">Not registered? <a href="#">Create an account</a> </p>
        </form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script>

    $(document).ready(function(){
        $("#showSignUp").click(function(){
            $("#loginID").hide();
            $("#regID").show();

        });
    });

</script>

</body>
</html>
