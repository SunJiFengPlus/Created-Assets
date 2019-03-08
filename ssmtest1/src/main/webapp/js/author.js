$(function(){

	var obj = $(".author_container")[0];
	var arrChild = obj.childNodes;
	for( var i=0; i<arrChild.length; i++ ){
		if( arrChild[i].nodeType === 3 && /^\s+$/.test(arrChild[i].nodeValue) ){
			// console.log(i + arrChild[i]);
			obj.removeChild(arrChild[i]);    //注意用js的方法
		}
	}

	// 星星
	// function star(k){
	// 	// if( m==1 || m==2 || m==3 || m==4 || m==5 ){
	// 	// 	$("#tab2_star b:lt(" + m + ")").each(function(){
	// 	// 		// console.log($(this).index());
	// 	// 		$(this).css('backgroundPosition','-41px 0');
	// 	// 	});
	// 	// }
	// 	// if( n==1 || n==2 || n==3 || n==4 || n==5 ){
	// 	// 	$("#tab3_star b:lt(" + n + ")").each(function(){
	// 	// 		// console.log($(this).index());
	// 	// 		$(this).css('backgroundPosition','-41px 0');
	// 	// 	});
	// 	// }
	// 	if( k==1 || k==2 || k==3 || k==4 || k==5 ){
	// 		$("#star b:lt(" + k + ")").each(function(){
	// 			// console.log($(this).index());
	// 			$(this).css('backgroundPosition','-41px 0');
	// 		});
	// 	}
	// }


	function star(str,k){
		if( k==1 || k==2 || k==3 || k==4 || k==5 ){
			$(str + " b:lt(" + k + ")").each(function(){
				// console.log($(this).index());
				$(this).css('backgroundPosition','-41px 0');
			});
		}
		// console.log(str);
	}
	star("#star",4);


	// Tab键切换
	$("#tabs .tab_1").animate({marginTop:"0px",opacity:'1'},1000);;
	var arrTabs = $("#tabs>div");
	$(".author_tab button").each(function(){
		$(this).click(function(){
			$(".author_tab button").each(function(){
				$(this).removeClass();

			});
			$(this).addClass('active');;
			arrTabs.each(function(){
				$(this).css('display','none');
				$(this).css({'marginTop':'100px','opacity':'0'});
			});
			// console.log($(this).index());
			// console.log(arrTabs);
			arrTabs.eq($(this).index()).css('display','block');
			arrTabs.eq($(this).index()).animate({marginTop:"0px",opacity:'1'},1000);
		});
	});

	function safeStr(str){
		return str.replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
	}



	$.ajax({
		url: 'http://localhost:8080/ssmtest1/following/1006',
		type: 'get',
		success: function(msg){
			// console.log(msg.data);
			var arr = [];
			var num = 0;
			$("#tab3_left").html();
			for( var id in msg.data ){
				// console.log(msg[key][id]);
				var idJson = msg.data[id];
				// for( var key in idJson ){
					// console.log(idJson[key]);
				// }
				// console.log(idJson.username);
				var date = new Date(idJson.registerDate).getFullYear() + '/' + (new Date(idJson.registerDate).getMonth()+1) + '/' + new Date(idJson.registerDate).getDate();
				$("#tab3_left").html('<div class="tab3_model"><div class="media_left"><div><img src="' + idJson.avatar + '" alt="" width="80"><p><button class="follow_ready">Follow</button></p></div><div class="media_left_right"><h3>' + idJson.username + '</h3><p>' + idJson.profile + '</p></div></div><div class="media_body"><p>7 Items</p><p>14 Followers</p><p>Member Since: ' + date + '</p></div><div class="media_right"><div><strong>186</strong><b>Sales</b></div><div class="tab3_star"><div class="star_rating star' + num + '"><b></b><b></b><b></b><b></b><b></b></div><span>10 ratings</span></div></div></div>');
				star("#tab3_left .star" + num,(num%5)+1);
				num++;
				// console.log(num);
			}
			$("#following_num").text(num);
			// 关注功能（暂时的）：
			$(".follow_ready").each(function(){
				$(this).click(function(){
					$(this).css({'backgroundColor': '#82b440','color': '#ffffff'});
					$(this).html('&#10003;');
				});
			});
		},
		error: function(){
			alert('error');
		}
	});

	$.ajax({
			url: 'https://realdoer.top/ssmtest1/user/listFollower/1000',
			type: 'get',
			headers: {
	            'Authorization' : window.localStorage.s
	        },
			success: function(msg){
				// console.log(msg);
				var arr = [];
				var num = 0;
				$("#tab2_left").html();
				for( var id in msg.data ){
					// console.log(msg[key][id]);
					var idJson = msg.data[id];
					// for( var key in idJson ){
						// console.log(idJson[key]);
					// }
					// console.log(idJson.username);
					// $("#tab2_left").html('<div class="tab3_model"><div class="media_left"><div><img src="' + idJson.avatar + '" alt="" width="80"><p><button>Follow</button></p></div><div class="media_left_right"><h3>' + idJson.username + '</h3></div></div><div class="media_body"><p>7 Items</p><p>14 Followers</p><p>Member Since:January 2017</p><p>' + safeStr(idJson.profile) + '</p></div><div class="media_right"><div><strong>186</strong><b>Sales</b></div><div class="tab3_star"><div class="star_rating" id="tab3_star"><b></b><b></b><b></b><b></b><b></b></div><span>10 ratings</span></div></div></div>');
					
					var date = new Date(idJson.registerDate).getFullYear() + '/' + (new Date(idJson.registerDate).getMonth()+1) + '/' + new Date(idJson.registerDate).getDate();

					$("#tab2_left")[0].innerHTML += '<div class="tab3_model"><div class="media_left"><div><img src="' + idJson.avatar + '" alt="" width="80"><p><button class="follow_ready">Follow</button></p></div><div class="media_left_right"><h3>' + idJson.username + '</h3><p>' + safeStr(idJson.profile) + '</p></div></div><div class="media_body"><p></p><p>' + num + 'Followers</p><p>Member Since: ' + date + '</p></div><div class="media_right"><div><strong>' + ((num%5)+1)*5 + '</strong><b>Sales</b></div><div class="tab3_star"><div class="star_rating star' + num + '"><b></b><b></b><b></b><b></b><b></b></div><span>' + ((num%5)+1)*2 + ' ratings</span></div></div></div>';

					star("#tab2_left .star" + num,(num%5)+1);

					num++;

					// console.log(new Date(idJson.registerDate).getMonth()+1);
					// console.log(new Date(idJson.registerDate).getDate());
					// console.log(new Date(idJson.registerDate).getFullYear());

					// console.log(".star" + num);



					// console.log(num);
				}
				$("#followers_num").text(num);
				// 关注功能（暂时的）：
				$(".follow_ready").each(function(){
					$(this).click(function(){
						$(this).css({'backgroundColor': '#82b440','color': '#ffffff'});
						$(this).html('&#10003;');
					});
				});


			},
			error: function(){
				alert('error');
			}
		});

console.log(window.localStorage.s);





});