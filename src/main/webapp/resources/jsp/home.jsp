<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 12.01.2021
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Valera</title>
    <%--    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src='/resources/js/header.js'></script>
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
<div class="wrapper">

    <div id="carouselExample" class="carousel carousel-dark slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#carouselExampleDark" data-bs-slide-to="1"></li>
        </ol>

        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="10000">
                <%--            <a href="${pageContext.request.contextPath}/plans/${Dictator.id}">--%>
                <img src="<spring:url value='https://sun9-75.userapi.com/impg/A_KFMTNbW-UwIjVacI-wpV32rbvTuxFeW-jJOA/bQBqEftnVMM.jpg?size=1280x395&quality=96&sign=fc889b292c584bd792eae80494772aa2&type=album' />"
                     class="carousel-img" alt="Dictator plan">
                <%--            </a>--%>
            </div>
            <div class="carousel-item" data-bs-interval="10000">
                <%--            <a href="${pageContext.request.contextPath}/plans/${Exile.id}">--%>
                <img src="<spring:url value='https://sun9-41.userapi.com/impg/zyRKcK7SwSdFlkeS9xO5d1neSztJRjXETwmhwQ/VnvXxbUMzqA.jpg?size=1280x395&quality=96&sign=ea997c95a6079b75859098262471cb8d&type=album' />"
                     class="carousel-img" alt="Exile plan">
                <%--            </a>--%>
            </div>
            <div class="carousel-item" data-bs-interval="10000">
                <%--            <a href="${pageContext.request.contextPath}/plans/${Exile.id}">--%>
                <img src="<spring:url value='https://sun9-4.userapi.com/impg/w26V45JnmOlA1PbAJZZBYCmqrF2YOlGojIvEsw/pVnIFFB8yak.jpg?size=1280x395&quality=96&sign=a00dab29e285734b85b4f5c9f106549f&type=album' />"
                     class="carousel-img" alt="Exile plan">
                <%--            </a>--%>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleDark" role="button" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleDark" role="button" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </a>
    </div>

    <div class="wrapper-text">
        <section>
            <p> eCare is an International1 Mobile Operator providing mobile services to customers all around the world*.
                Through consistent expansion, eCare covers an ever-increasing number of locations, using the latest
                technology
                and equipment to support its customer offerings.
            </p>
        </section>
        <section>
            <p> eCare Subscribers can forget about multiple devices and multiple SIM cards. A single eCare SIM card
                provides
                eCare customers with the ability to have an almost unlimited number of permanently active personal phone
                numbers from any country on one device.
            </p>
        </section>
        <section>
            <p> eCare Services makes communication limitless by dissolving borders between countries and continents: the
                roaming-free network allows eCare customers to forget about huge roaming rates, limited communication
                and
                unpredictable bills. eCare provides customers with mobile services and fixed rates around the world*.
            </p>
        </section>
        <section>
            <p> eCare Networks combine high-speed communication channels and switching systems in one high-tech solution
                based
                on a unique multi-IMSI platform controlled by a state-of-the-art global billing system. This innovative
                technology provides eCare customers with a global “home“ network, allowing them to access voice,
                Internet and
                SMS services in any part of the world*.
            </p>
        </section>
        <section>
            <p> eCare Customer Care ensures that eCare customer partners, relatives and friends all benefit. A call to
                another
                eCare Subscriber from anywhere in the world* is charged according to the caller’s local rate.
            </p>
        </section>
        <section>
            <p> eCare Team members have extensive telecommunications experience. Many of them have worked with major
                international telecoms companies or developed telecoms products and services, which are now used as
                industry
                standards.
            </p>
        </section>
    </div>
</div>

<div id="footer" style="background-color: #4cae4c">
    <br>
    <p> &copy; Valerii Ermolaev</p>
    <br>
    <br>
</div>
</body>
</html>
