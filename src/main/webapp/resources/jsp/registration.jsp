<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 02.01.2021
  Time: 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">
</head>
<body>
<div class="main-w3layouts wrapper">
    <h1>Registration</h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
<form action="${pageContext.request.contextPath}/registration/account" modelAttribute="userForm"  method="post">
    <input class="text" type="text" name="firstname" placeholder="First name" required="" value=${User.firstname}>
    <input class="text" type="text" name="lastname" placeholder="Last name" required="" value=${User.lastname}>
    <input class="text" type="text" name="patronymic" placeholder="Patronymic" required="" value=${User.patronymic}>
    <input class="text" type="text" name="birthday" placeholder="Birth date" required="" value=${User.birthdaydata}>
    <input class="text" type="text" name="passport" placeholder="Passport" required="" value=${User.passport}>
    <input class="text" type="text" name="address" placeholder="Address" required="" value=${User.address}>
    <input class="text email" type="email" name="email" placeholder="Email" required="" value=${User.email}>
<%--    <input class="text" type="text" name="contract" placeholder="Contract" required="" value=${User.firstname}>--%>
    <input class="text" type="password" name="password" placeholder="Password" required="" value=${User.password}>
    <input class="text w3lpass" type="password" name="password" placeholder="Confirm Password" required="">
    <input type="submit" value="Submit">
</form>

<%--            </form>--%>
        </div>
    </div>
</div>
</body>
</html>