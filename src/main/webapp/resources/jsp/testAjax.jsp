<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 14.01.2021
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
</head>
<body>
<form class="my-form">
    <button class="my-button" type="submit">AJAX</button>
</form>
<script>
    var myForm = document.querySelector(".my-form");
    var btn = myForm.querySelector(".my-button");


    myForm.addEventListener("submit",function (e){
        e.preventDefault();
        console.log("imma here");
        $.ajax({
            type : 'POST',
            url : '/show.ajax',
            success : function(response) {
                let table = "<table border=1><tr><td>id</td><td>name</td></tr>";
                for ( var i = 0; i < response.length; i++){
                    // alert(response[i].id);
                    // alert(response[i].name);
                    table = table + "<tr><td>" + response[i].id + "</td><td>" + response[i].name + "</td></tr>";
                }
                $("#Tariffs").html(table);
            },
            error : function() {
                alert("opps error occured");
            }

        });
    });
</script>
<div id="Tariffs">

</div>
</body>
</html>
