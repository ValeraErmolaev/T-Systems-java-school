<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 24.01.2021
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/404.css">
</head>
<body>
<div class="box">
    <div class="box__ghost">
        <div class="symbol"></div>
        <div class="symbol"></div>
        <div class="symbol"></div>
        <div class="symbol"></div>
        <div class="symbol"></div>
        <div class="symbol"></div>

        <div class="box__ghost-container">
            <div class="box__ghost-eyes">
                <div class="box__eye-left"></div>
                <div class="box__eye-right"></div>
            </div>
            <div class="box__ghost-bottom">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="box__ghost-shadow"></div>
    </div>

    <div class="box__description">
        <div class="box__description-container">
            <div class="box__description-title">Whoops!</div>
            <div class="box__description-text">It seems like we couldn't find the page you were looking for</div>
        </div>

        <a href="/" target="_blank" class="box__button">Go home</a>

    </div>

</div>
<script>
    //based on https://dribbble.com/shots/3913847-404-page

    var pageX = $(document).width();
    var pageY = $(document).height();
    var mouseY=0;
    var mouseX=0;

    $(document).mousemove(function( event ) {
        //verticalAxis
        mouseY = event.pageY;
        yAxis = (pageY/2-mouseY)/pageY*300;
        //horizontalAxis
        mouseX = event.pageX / -pageX;
        xAxis = -mouseX * 100 - 100;

        $('.box__ghost-eyes').css({ 'transform': 'translate('+ xAxis +'%,-'+ yAxis +'%)' });

        //console.log('X: ' + xAxis);

    });
</script>
</body>
</html>
