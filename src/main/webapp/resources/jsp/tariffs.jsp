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
        <a href="/">Home</a>
        <a href="/auth/success">My account</a>
        <a href="">About</a>
        <a href="/tariff">Tariffs</a>
        <a href="/map">Map</a>
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
                            <a :href="'/tariff/' + item.id"  class="btn btn-success">More information</a>
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
<footer style="background-color: #76b852">

    <p> &copy; Valerii Ermolaev</p>
    <br>
</footer>
</body>
</html>
