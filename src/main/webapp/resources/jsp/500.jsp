<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 30.01.2021
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/500.css">
</head>
<body>
<div class="error-500" data-text="Oh no! My spaghetti code is not working properly. :(">
    <spaguetti>
        <fork></fork>
        <meat></meat>
        <pasta></pasta>
        <plate></plate>
    </spaguetti>
</div>
<script>
    const error = document.querySelector(".error-500");
    let i = 0, data = "", text = error.getAttribute("data-text");

    let typing = setInterval(() => {
        if(i == text.length){
            clearInterval(typing);
        }else{
            data += text[i];
            document.querySelector(".error-500").setAttribute("data-text", data);
            i++;
        }
    }, 100);
</script>
</body>
</html>
