
$('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$(document).ready(function () {

    $('.register-form').hide();
    $('.login-form').show();

    $('.register').click(function () {
        $('.register-form').show();
        $('.login-form').hide();
    });
    $('.login').click(function () {
        $('.register-form').hide();
        $('.login-form').show();
    });
});

