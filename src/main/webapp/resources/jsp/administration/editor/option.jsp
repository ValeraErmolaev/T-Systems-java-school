<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 30.01.2021
  Time: 17:24
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="<spring:url value='/resources/css/adminUsers.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/tariffEditor.css'/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">

    <a href="/">Home</a>
    <a href="/auth/success">My account</a>
    <a href="/administration/options">Back</a>


</nav>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Option name</th>
        <th>Description</th>
        <th>Connect price</th>
        <th>Price</th>
        <th>Associated options</th>
        <th>Incompatible options</th>
    </tr>
    </thead>
    <c:if test="${options.size() !=0}">
        <c:forEach items="${options}" var="option">
            <td><c:out value="${option.name}"/></td>
            <td><c:out value="${option.description}"/></td>
            <td><c:out value="${option.connectPrice}"/></td>
            <td><c:out value="${option.price}"/></td>
            <c:choose>
                <c:when test="${option.associatedOptions.size() > 0}">
                    <td>
                        <div class="options-container">
                            <c:forEach items="${option.associatedOptions}" var="associated_option">
                                <%--                            <c:forEach begin="0" end="${fn:length(option.associatedOptions) - 1}" var="index">--%>
                                <div class="one-option">
                                    <span><c:out value="${associated_option.name}"/></span>
                                        <%--                                    <span>--%>
                                        <%--                                        <form action="/administration/editor/tariff/${option.id}/addOption" method="get">--%>
                                        <%--                                            <input type="submit" value="Add option"/>--%>
                                        <%--                                        </form>--%>
                                        <%--                                    </span>--%>
                                </div>
                            </c:forEach>
                            <span>
                                 <form action="/administration/editor/option/${option.id}/associateOption" method="get">
                            <input type="submit" value="Add option"/>
                        </form>
                            </span>
                        </div>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                        <form action="/administration/editor/option/${option.id}/associateOption" method="get">
                            <input type="submit" value="Add option"/>
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${option.incompatibledOptions.size() > 0}">
                    <td>
                        <div class="options-container">
                            <c:forEach items="${option.incompatibledOptions}" var="incompatibled_option">
                                <%--                            <c:forEach begin="0" end="${fn:length(option.associatedOptions) - 1}" var="index">--%>
                                <div class="one-option">
                                    <span><c:out value="${incompatibled_option.name}"/></span>
                                        <%--                                    <span>--%>
                                        <%--                                        <form action="/administration/editor/tariff/${option.id}/addOption" method="get">--%>
                                        <%--                                            <input type="submit" value="Add option"/>--%>
                                        <%--                                        </form>--%>
                                        <%--                                    </span>--%>
                                </div>
                            </c:forEach>
                            <span>
                                <form action="/administration/editor/option/${option.id}/addIncompatibleOption" method="get">
                        <input type="submit" value="Add option"/>
                    </form>
                            </span>
                        </div>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                        <form action="/administration/editor/option/${option.id}/addIncompatibleOption" method="get">
                            <input type="submit" value="Add option"/>
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
            <%--            <span>--%>
            <%--                    <form action="/administration/editor/option/${option.id}/associateOption" method="get">--%>
            <%--                        <input type="submit" value="Add option"/>--%>
            <%--                    </form>--%>
            <%--                </span>--%>

<%--            <td>--%>
<%--                <span>--%>
<%--                    <form action="/administration/editor/option/${option.id}/addIncompatibleOption" method="get">--%>
<%--                        <input type="submit" value="Add option"/>--%>
<%--                    </form>--%>
<%--                </span>--%>
<%--            </td>--%>
            <%--            <td><c:out value="${option.turnOnPrice}"/></td>--%>
            <%--            <c:choose>--%>
            <%--                <c:when test="${option.options.size() > 0}">--%>
            <%--                    <td>--%>
            <%--                        <div class="options-container">--%>
            <%--                            <c:forEach begin="0" end="${fn:length(option.options) - 1}" var="index">--%>
            <%--                                <div class="one-option">--%>
            <%--                                    <span><c:out value="${option.options[index].name}"/></span>--%>
            <%--                                    <span>--%>
            <%--                            <form action="/administration/editor/tariff/${option.id}/delete/${option.options[index].id}"--%>
            <%--                                  method="POST">--%>
            <%--                            <input type="submit" value="Delete"/>--%>
            <%--                        </form>--%>
            <%--                            </span>--%>
            <%--                                </div>--%>
            <%--                            </c:forEach>--%>
            <%--                            <span>--%>
            <%--                         <form action="/administration/editor/tariff/${option.id}/addOption" method="get">--%>
            <%--                            <input type="submit" value="Add option"/>--%>
            <%--                         </form>--%>
            <%--                    </span>--%>
            <%--                        </div>--%>
            <%--                    </td>--%>
            <%--                </c:when>--%>
            <%--                <c:otherwise>--%>
            <%--                    <td>--%>
            <%--                        <form action="/administration/editor/tariff/${option.id}/addOption" method="get">--%>
            <%--                            <input type="submit" value="Add option"/>--%>
            <%--                        </form>--%>
            <%--                    </td>--%>
            <%--                </c:otherwise>--%>
            <%--            </c:choose>--%>
            <%--            <td>--%>
            <%--                <img src="${option.pictureUrl}"/>--%>
            <%--                <h3>Change the image:</h3>--%>
            <%--                Select a file to upload: <br/>--%>
            <%--                <form action="/administration/editor/tariff/${option.id}/image" method="post"--%>
            <%--                      enctype="multipart/form-data">--%>
            <%--                    <input type="file" name="file"/>--%>
            <%--                    <br/>--%>
            <%--                    <input type="submit" value="Upload File"/>--%>
            <%--                </form>--%>
            <%--            </td>--%>
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

        </c:forEach>
    </c:if>
</table>
</body>
</html>
