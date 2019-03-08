/**
 * Created by jiangxin on 18/9/19.
 */
$(function () {
    $("#item").click(function () {
        $(".item-content-left").show();
        $(".item-content-left2").hide();
        $("#comments").css({'border':'none','background':'#f9f9f9','bottom':0});
        $("#item").css({'border-top':'1px solid rgba(0,0,0,0.2)','border-left':'1px solid rgba(0,0,0,0.2)','border-right':'1px solid rgba(0,0,0,0.2)','background':'#fff','bottom':-1});

    });
    $("#comments").click(function () {
        $(".item-content-left2").show();
        $(".item-content-left").hide();
        $("#item").css({'border':'none','background':'#f9f9f9','bottom':0});
        $("#comments").css({'border-top':'1px solid rgba(0,0,0,0.2)','border-left':'1px solid rgba(0,0,0,0.2)','border-right':'1px solid rgba(0,0,0,0.2)','background':'#fff','bottom':-1});
    })
});