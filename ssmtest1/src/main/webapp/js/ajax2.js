$(function(){
	$(".change-image").html("");
	
	var c=window.location.href.split("?")[1];
	var sg=$("#gg").addClass(c);

	function ajaxItem(){
		var h=$("#gg").attr("class");
		// alert(h)
		$.ajax({
			// XXX: 都是我的错, 不是前端的错, 都怪我没把问题说清楚, 都怪我不想太过麻烦前端
			// XXX: 我总是以为前端回向我想的那也去做, 可是每次都差点意思, 检讨检讨   -- 后端留
			url:"http://localhost:8080/ssmtest1/portfolio/1000",
			type:"get",
			success:function(msg){
					h=Number(h);
					var objText=msg.data[h%1000];
					$(".change-image")[0].innerHTML="<a href='"+objText.demoUrl+"'>"+"<img class='model' src='"+objText.preview+"'>"+"</a>";
					$(".intruduce-all")[0].innerHTML="<p>"+objText.description+"</p>"
					$(".item-price")[0].innerHTML="<h1>"+"Regular License"+"</h1>"+"<span>"+"$"+objText.regularLicensePrice+"</span>";
					$(".sales")[0].innerHTML="<img src='../images/grey.png'>"+"<span>"+objText.sales+"</span>"+"<span>"+"Sales"+"</span>";
					var date = new Date(objText.releaseDate).getFullYear() + '/' + (new Date(objText.releaseDate).getMonth()+1) + '/' + new Date(objText.releaseDate).getDate();
					// alert(date);
					$(".update-time").html("<strong>"+"Last Update"+"</strong>"+"<p>"+date+"</p>");
					$(".create-time").html("<strong>"+"Last Update"+"</strong>"+"<p>"+date+"</p>");
					$(".compatibleBrower").html("<strong>"+"Compatible"+"</strong>"+"<p>"+objText.compatibleBrower+"</p>");
					$(".compatibleScript").html("<strong>"+"Compatible"+"</strong>"+"<p>"+objText.compatibleScript+"</p>");
					$(".down").html("<a href='"+objText.mainFile+"'>"+"Buy Now"+"</a>");
			}
		})
	}
	ajaxItem();
})