$(function(){
    // alert(1);
    $("#SignIn").text(window.localStorage.username);
    if(window.localStorage.username != 'Sign In or On'){
        $('.exit').css({
            'backgroundColor':'#5ca11f',
            'color':'#fff'
        });
    }
    $(".exit").click(function(){
        window.localStorage.username = 'Sign In or On';
        $(this).css({
            'backgroundColor':'transparent',
            'color':'transparent'
        });
    });
});