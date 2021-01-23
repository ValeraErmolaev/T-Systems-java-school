<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 17.01.2021
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">

    <a href="/">Home</a>
    <a href="/auth/success">My account</a>
    <a href="/administration/tariffs">Back</a>
    <form action="/administration/editor/user/${user.id}/addContract", method="get">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Create new default contract</button>
    </form>

</nav>
<%--<img src="${urlTest}"/>--%>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Tariff name</th>
        <th>Description</th>
        <th>Turn on price</th>
        <th>Options</th>
        <th>Image</th>
    </tr>
    </thead>
    <td><c:out value="${tariff.name}"/></td>
    <td><c:out value="${tariff.description}"/></td>
    <td><c:out value="${tariff.turnOnPrice}"/></td>
    <td></td>
    <td>
        <img src="${tariff.pictureUrl}"/>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        <form action = "/administration/editor/tariff/${tariff.id}/image" method = "post"
              enctype = "multipart/form-data" >
            <input type = "file" name = "file"/>
            <br />
            <input type = "submit" value = "Upload File" />
        </form>
    </td>
<%--    <c:choose>--%>
<%--        <c:when test="${user.contracts.size() > 0}">--%>
<%--            <td>--%>
<%--                <c:forEach begin="0" end="${fn:length(user.contracts) - 1}" var="index">--%>
<%--                    <table class="table table-bordered">--%>
<%--                        <tr><c:out value="${user.contracts[index].number}"/></tr>--%>
<%--                        <tr><c:out value="${user.contracts[index].tariff.name}"/></tr>--%>
<%--                        <tr><c:out value="${user.contracts[index].tariff.description}"/></tr>--%>
<%--                    </table>--%>
<%--                </c:forEach>--%>
<%--            </td>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <td></td>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>


</table>
</body>
</html>
