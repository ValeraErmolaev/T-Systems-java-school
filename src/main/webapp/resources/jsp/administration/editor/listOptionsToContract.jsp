<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 16.01.2021
  Time: 13:16
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
    <title>Account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <link href="<spring:url value='/resources/css/adminHeader.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/adminAccount.css'/>" rel="stylesheet">

</head>
<body>
<header>
    <h1>Administration</h1>
    <nav>
        <a style="color: white; text-decoration: none" href="/">Home</a>
        <a style="color: white; text-decoration: none" href="/auth/success">My account</a>
        <a style="color: white; text-decoration: none" href="/administration/users">Users menu</a>
        <a style="color: white; text-decoration: none" href="/administration/tariffs">Tariff menu</a>
        <a style="color: white; text-decoration: none" href="/administration/options">Option menu</a>
        <a style="color: white; text-decoration: none" href="/map">Map</a>
        <a style="color: white; text-decoration: none" href="#myModal1"  data-toggle="modal">Cart</a>
    </nav>
</header>
<h1>Hello, ${user.fullname}</h1>
<div class="container">
    <form action="/auth/logout" method="POST">
        <button type="submit" class="btn btn-primary">Logout</button>
    </form>
</div>
<table class="table table-bordered table-hover">

    <tr>
        <th>Your Contracts</th>
        <th>Tariff</th>
        <th>Connected options</th>
        <th>Available options</th>
    </tr>
    <c:if test="${user.contracts.size() > 0}">
        <c:if test="${contracts.size() > 0}">
            <c:forEach items="${contracts}" var="contract">
                <c:if test="${!contract.is_blocked}">
                    <tr>
                        <td><c:out value="${contract.number}"/></td>
                        <c:choose>
                            <c:when test="${contract.is_blocked == true}">
                                <c:choose>
                                    <c:when test="${contract.is_blocked_by_admin == true}">
                                        <td><p style="color: #EF3B3A">That information is not available</p></td>
                                        <td><p style="color: #EF3B3A">That information is not available</p></td>
                                        <td><p style="color: #EF3B3A">Blocked by eCare</p></td>
                                        <td><p></p></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${contract.tariff.name}</td>
                                        <td>
                                            <c:forEach items="${contract.options}" var="option">
                                                <div class="one-option">
                                                    <span>
                                                        <c:out value="${option.name}"/>
                                                    </span>
                                                    <span>
                                                        <form action="/administration/editor/${contract.id}/deleteOption/${option.id}" method="POST">
                                                            <input type="submit" value="Delete"/>
                                                        </form>
                                                    </span>
                                                </div>
                                            </c:forEach>

                                        </td>
                                        <td>Blocked</td>
                                        <td>
                                            <form action="/user/${user.id}/contract/${contract.id}/unblock"
                                                  method="post">
                                                <button value="Unblock" type="submit">Unblock</button>
                                            </form>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <td>${contract.tariff.name}</td>
                                <td>
                                    <c:forEach items="${contract.options}" var="option">
                                        <div class="one-option">
                                    <span>
                                        <c:out value="${option.name}"/>
                                    </span>
                                            <span>
                                        <form action="/administration/editor/${contract.id}/deleteOption/${option.id}" method="POST">
                                            <input type="submit" value="Delete"/>
                                        </form>
                                    </span>
                                        </div>
                                    </c:forEach>
                                    <span>
<%--                                 <form action="/user/editor/${contract.id}/addOption" method="get">--%>
<%--                                    <input type="submit" value="Add option"/>--%>
<%--                                 </form>--%>
                             </span>
                                </td>
                                <td>
                                    <c:if test="${contract.tariff.options.size() > 0}">
                                        <c:forEach items="${contract.tariff.options}" var="option">
                                            <c:if test="${!contract.options.contains(option)}">
                                                <span>
                                                     <c:out value="${option.name}"/>
                                                    <form action="/administration/editor/${contract.id}/addOption/${option.id}" method="post">
                                                        <input type="submit" value="Buy"/>
                                                    </form>
                                                </span>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:if>
            </c:forEach>
        </c:if>
    </c:if>
</table>
<div class="container">
    <div id="myModal1" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <%--                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">AAAAAAAA</button>--%>
                    <h4 class="modal-title">Cart</h4>
                </div>
                <div class="modal-body">
                    <c:choose>
                        <c:when test="${userCart.tariff !=null}">
                            Tariff: ${userCart.tariff.name}
                            <br>
                            Options:
                            <c:forEach items="${userCart.options}" var="option">
                                ${option.name}
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            Cart is empty
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
<%--                    <button type="button" class="btn btn-primary">Delete all</button>--%>
                </div>
            </div>
        </div>
    </div>
    <!-- jQuery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script>
        $(function () {
            $("#btn2").click(function () {
                $("#myModal2").modal('show');
            });
        });
    </script>
</div>
</body>
</html>

