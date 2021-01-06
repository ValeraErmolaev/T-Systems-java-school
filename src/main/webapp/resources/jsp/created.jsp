<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 02.01.2021
  Time: 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Created:
${user.id}
${user.firstname}
<form action="${pageContext.request.contextPath}/Users">
    <input type="submit" value="Users" />
</form>

</body>
</html>
