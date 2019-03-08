$(function () {

    var pagenum = 1;
    ajaxIndex();

    $(".page1").click(function () {
        pagenum = 1;
        ajaxIndex();

    })
    $(".page2").click(function () {
        pagenum = 2;
        ajaxIndex();
    })
    $(".page3").click(function () {
        pagenum = 3;
        ajaxIndex();
    })
    $(".prev").click(function () {
        if (pagenum == 2 || pagenum == 3) {
            pagenum--;
            ajaxIndex();
            $(".add").siblings().removeClass("active_page");
            $(".add")[pagenum - 1].classList.add("active_page");
        } else {
            pagenum = 1;
            ajaxIndex();
        }
    })
    $(".next").click(function () {
        if (pagenum == 1 || pagenum == 2) {
            pagenum++;
            ajaxIndex();
            $(".add").siblings().removeClass("active_page");
            $(".add")[pagenum - 1].classList.add("active_page");
        } else {
            pagenum = 3;
            ajaxIndex();
        }
    })

    function ajaxIndex() {
        $.ajax({
            url: "http://localhost:8080/ssmtest1/htmlTemplates",
            type: "post",
            data: {
                "index":pagenum,
                "maxNumPerPage":5
            },
            success: function (msg) {
                $(".tex-all").html("");

                for (let id in msg.data) {
                    var objproperty = msg.data[id];
                    // alert(objproperty.feature[0])
                    var date = new Date(objproperty.lastUpdate).getFullYear() + '/' + (new Date(objproperty.lastUpdate).getMonth() + 1) + '/' + new Date(objproperty.lastUpdate).getDate();
                    $(".tex-all")[0].innerHTML += "<div class='item'>" + "<div class='images'>" + "<a href='#' class='post'>" + "<img src='" + objproperty.thumbnail + "'>" + "</a>" + "<p>" + "<a href='#'>" + objproperty.tag + "</a>" + "</p>" + "</div>" + "<div class='item-text'>" + "<h2>" + objproperty.title + "</h2>" + "<i>" + "by yahyaessam" + "</i>" + "<p>" + "Site Templates/Peronal" + "</p>" + "<ul>" + "<li>" + "<a href='#'>" + objproperty.feature[0] + "</a>" + "</li>" + "<li>" + "<a href='#'>" + objproperty.feature[1] + "</a>" + "</li>" + "<li>" + "<a href='#'>" + objproperty.feature[2] + "</a>" + "</li>" + "</ul>" + "</div>" + "<div class='card'>" + "<div class='card-top'>" + "<img src='images/Group2.png'>" + "<img src='images/Group1.png'>" + "</div>" + "<div class='card-text'>" + "<h3>" + "$14" + "</h3>" + "<p>" + "Last updated:" + date + "</p>" + "</div>" + "<div class='stay-bottom'>" + "<div class='card-bottom'>" + "<button>" + "preview" + "</button>" + "<img src='images/shopping.png'>" + "</div>" + "</div>" + "</div>" + "<div class='hidden'>" + objproperty.itemId + "</div>" + "</div>";

                    // var index = objproperty.itemId;
                    // alert(index);
                    // var url = "./item.html"+"?"+index;
                    // alert(url)

                }
                var a = $(".images").length;
                // alert(a);
                for (let id in msg.data) {
                    $(".images")[id].onclick = function () {
                        if (pagenum == 1) {
                            var d = 100 + id;
                            d = Number(d);
                        } else if (pagenum == 2) {
                            if (id == 5) {
                                id = id - 5;
                            }
                            id = Number(id) + 5;
                            var d = 100 + String(id);
                            d = Number(d);
                        } else if (pagenum == 3) {
                            if (id == 10) {
                                id = id - 10;
                            }
                            id = Number(id) + 10;
                            var d = 100 + String(id);
                            d = Number(d);
                        }


                        // alert(id);
                        // alert(d);
                        var url = "./htmls/item.html" + "?" + d;
                        window.location.href = url;
                    }
                }


            }
        })
    }

    $(".add").click(function () {
        $(this).addClass("active_page").siblings().removeClass("active_page");
    })


    /************item************/

})