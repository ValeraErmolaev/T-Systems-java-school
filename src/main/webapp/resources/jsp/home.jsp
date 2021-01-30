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
        <a style="color: white; text-decoration: none"   href="/">Home</a>
        <a  style="color: white; text-decoration: none" href="/auth/success">My account</a>
        <a  style="color: white; text-decoration: none" href="">About</a>
        <a  style="color: white; text-decoration: none" href="/tariff">Tariffs</a>
        <a  style="color: white; text-decoration: none" href="/map">Map</a>
    </nav>
</header>
<div class="wrapper">

    <div id="carouselExample" class="carousel carousel-dark slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#" data-bs-slide-to="1"></li>
            <li data-bs-target="#" data-bs-slide-to="2"></li>
        </ol>

        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="3000">
                <%--            <a href="${pageContext.request.contextPath}/plans/${Dictator.id}">--%>
                <img src="<spring:url value='https://sun9-75.userapi.com/impg/CsX8KHkmOLh282zKaOGf5uh_Xyr-SNQ2eUPLww/eG8c8LDUYAk.jpg?size=1280x395&quality=96&sign=99da34314d967c2bb6e0bc9eabbc9e92&type=album' />"
                     class="carousel-img" alt="Travel">
                <%--            </a>--%>
            </div>
            <div class="carousel-item" data-bs-interval="3000">
                <%--            <a href="${pageContext.request.contextPath}/plans/${Exile.id}">--%>
                <img src="<spring:url value='https://sun9-6.userapi.com/impg/NtM4_Utd1FyiWV9FP110lNoJNBpteIPDrqJR5w/2ns3vBm5p2E.jpg?size=1280x395&quality=96&sign=7d696d148e9f238a7a6c9922230441c0&type=album' />"
                     class="carousel-img" alt="Study">
                <%--            </a>--%>
            </div>
            <div class="carousel-item" data-bs-interval="3000">
                <%--            <a href="${pageContext.request.contextPath}/plans/${Exile.id}">--%>
                <img src="<spring:url value='https://sun9-43.userapi.com/impg/7Ffd7t8JPxMbVauVu3P3M-s-35iXa5rr-zsWLw/AcihEpWxMr0.jpg?size=1280x395&quality=96&sign=3e66b5637754918496793b7bb24d7c7d&type=album' />"
                     class="carousel-img" alt="For you!">
                <%--            </a>--%>
            </div>
        </div>
        <a class="carousel-control-prev" href="#" role="button" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </a>
        <a class="carousel-control-next" href="#" role="button" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </a>
    </div>

    <div class="wrapper-text">
        <section>
            <p> eCare is an International Mobile Operator providing mobile services to customers all around the world*.
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

<%--<footer style="background-color: #76b852">--%>
    <footer style="background-color:   #3498db">

    <p> &copy; Valerii Ermolaev</p>
    <br>
</footer>
</body>
</html>
