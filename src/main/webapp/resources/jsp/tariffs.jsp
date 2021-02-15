<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 11.01.2021
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Tariffs</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/tariffs.css">
    <script type="module" src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/account.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/buttonTariff.css'/>" rel="stylesheet">
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a style="color: white; text-decoration: none" href="/">Home</a>
        <a style="color: white; text-decoration: none" href="/auth/success">My account</a>
        <a style="color: white; text-decoration: none" href="">About</a>
        <a style="color: white; text-decoration: none" href="/tariff">Tariffs</a>
        <a style="color: white; text-decoration: none" href="/map">Map</a>
        <a style="color: white; text-decoration: none" href="#myModal1"  data-toggle="modal">Cart</a>
    </nav>
</header>
<div id="tariff-carousel">
    <div class="card-carousel-wrapper">
        <div class="card-carousel--nav__left" @click="moveCarousel(-1)" :disabled="atHeadOfList"></div>
        <div class="card-carousel">
            <div class="card-carousel--overflow-container">
                <div class="card-carousel-cards" :style="{ transform: 'translateX' + '(' + currentOffset + 'px' + ')'}">
                    <div class="card-carousel--card" v-for="item in items" :key="item.id">
                        <div class="card-carousel--card--footer">
                            <img :src="item.imgUrl" width=200px height=120px/>
                            <p>{{item.name}}</p>
                            <%--                            <p>{{item.description}}</p>--%>
                            <p>
                            <a :href="'/tariff/' + item.id"  class="btn btn-primary">More information</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-carousel--nav__right" @click="moveCarousel(1)" :disabled="atEndOfList"></div>
    </div>
</div>

<script>
    let vueItems = new Vue({
        el: '#tariff-carousel',
        data: {
            currentOffset: 0,
            windowSize: 2,
            paginationFactor: 220,
            items: []
        },
        mounted: function () {
            <c:forEach items="${tariffs}" var="item" varStatus="status">
            this.items = this.items.concat({
                id: ${item.id},
                name: "${item.name}",
                description: "${item.description}",
                price: "${item.turnOnPrice}",
                imgUrl: "${item.pictureUrl}"
            });
            </c:forEach>
        },
        computed: {
            atEndOfList() {
                return this.currentOffset <= (this.paginationFactor * -1) * (this.items.length - this.windowSize);
            },
            atHeadOfList() {
                return this.currentOffset === 0;
            },
        },
        methods: {
            moveCarousel(direction) {
                // Find a more elegant way to express the :style. consider using props to make it truly generic
                if (direction === 1 && !this.atEndOfList) {
                    this.currentOffset -= this.paginationFactor;
                } else if (direction === -1 && !this.atHeadOfList) {
                    this.currentOffset += this.paginationFactor;
                }
            },
            HandlerFunction(event) {
                console.log(event.target)
            }

        }

    });
</script>
<%--<footer style="background-color: #76b852">--%>
<footer style="background-color:   #3498db">
    <p> &copy; Valerii Ermolaev</p>
    <br>
</footer>
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
                    <button type="button" class="btn btn-primary">Delete all</button>
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
