<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 11.01.2021
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <script
            src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js">
    </script>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <title>Tariffs</title>
<%--    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400" rel="stylesheet"/>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/tariffs.css">
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <script type="module" src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
<%--    <script src="js/script.js"></script>--%>
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">

</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a href="/">Home</a>
        <a href="/account">My account</a>
        <a href="">About</a>
        <a href="/tariff">Tariffs</a>
        <a href="/map">Map</a>
    </nav>
</header>
<!-- TESTIMONIALS -->

<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400" rel="stylesheet"/>
<h1>Tariffs</h1>
<script id="v-carousel" type="x/template">
    <div class="card-carousel-wrapper">
        <div class="card-carousel--nav__left" @click="moveCarousel(-1)" :disabled="atHeadOfList"></div>
        <div class="card-carousel">
            <div class="card-carousel--overflow-container">
                <div class="card-carousel-cards" :style="{ transform: 'translateX' + '(' + currentOffset + 'px' + ')'}">
                    <div class="card-carousel--card" v-for="item in items"><img src="/resources/jpg/kot.jpg"/>
                        <div class="card-carousel--card--footer">
                            <p>{{ item.name }}</p>
                            <p class="tag" v-for="(tag,index) in item.tag" :class="index &gt; 0 ? 'secondary' : ''">{{ tag }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-carousel--nav__right" @click="moveCarousel(1)" :disabled="atEndOfList"></div>
    </div>
</script>
<div id="app">
    <carousel></carousel>
</div>
<script src="${pageContext.request.contextPath}/resources/js/tariffs.js"></script>
</body>
</html>
