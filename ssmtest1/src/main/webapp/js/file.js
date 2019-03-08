$(function(){

	var file_value1 = "";
	$("#file_btn_1 input").change(function(){
		file_value1 = $("#file_btn_1 input")[0].value;
		// console.log($("#file_btn_1 input")[0].value);
		// $(this).parent().append(file_value);
		$("#file_btn_1 p").empty();
		$("#file_btn_1 p").append(file_value1);
	});
	var file_value2 = "";
	$("#file_btn_2 input").change(function(){
		file_value2 = $("#file_btn_2 input")[0].value;
		// console.log($("#file_btn_1 input")[0].value);
		// $(this).parent().append(file_value);
		$("#file_btn_2 p").empty();
		$("#file_btn_2 p").append(file_value2);
	});

});