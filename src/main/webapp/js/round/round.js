

$(document).ready(function(){
	
	$('#loading').show();
	
	const storeResult = JSON.parse(document.getElementById("storeResult").value);
	const storeFirstResult = JSON.parse(document.getElementById("storeFirstResult").value);
	const storeSecondResult = JSON.parse(document.getElementById("storeSecondResult").value);

	for(var i=0; i<storeResult.length; i++){
		var storeNm = storeResult[i].storeNm;
		var address = storeResult[i].address;
		var gb = storeResult[i].gb;
		var grade = storeResult[i].grade;
		
		storeList(map_all, address, storeNm, grade, gb);
	}
	
	for(var i=0; i<storeFirstResult.length; i++){
		var storeNm = storeFirstResult[i].storeNm;
		var address = storeFirstResult[i].address;
		var gb = storeFirstResult[i].gb;
		var grade = storeFirstResult[i].grade;
		
		storeList(map_first, address, storeNm, grade, gb);
	}
	
	for(var i=0; i<storeSecondResult.length; i++){
		var storeNm = storeSecondResult[i].storeNm;
		var address = storeSecondResult[i].address;
		var grade = storeSecondResult[i].grade;
		
		storeList(map_second, address, storeNm, grade, "");
	}
	
})

window.onload = function(){
	
	$('#loading').hide();
	
	$("#map_first").css("width", "0%");
	$("#map_first").css("height", "0%");
	$("#map_second").css("width", "0%");
	$("#map_second").css("height", "0%");
	
//	$("#map_first").css("display", "none");
//	$("#map_second").css("display", "none");
}

// 상세내용보기
function showDetail(){
	
	if($(".current_lotto_detail").css("display") == "none"){
		$(".current_lotto_detail").css("display", "block");
		$(".icoArrow img").css("transform", "rotate(180deg)");
	}else{
		$(".current_lotto_detail").css("display", "none");
		$(".icoArrow img").css("transform", "");
	}
}

// 검색
function roundSearch(){
	form.submit();
}
// 당첨판매점 리스트 탭 변경
function storeListTab(obj){
	
	for(var i=0; i<$(obj.parentNode).find("li").length; i++){
		$(obj.parentNode).find("li").eq(i).removeClass();
	}
	
	$(obj).addClass("action");

	// 1등
	if(obj.id == 'storeListTab1'){
		$("#storeList1").css("display", "block");
		$("#storeList2").css("display", "none");
	// 2등
	}else{
		$("#storeList1").css("display", "none");
		$("#storeList2").css("display", "block");
	}
	
}

// 지도 탭 변경
function storeTabId(obj){

	for(var i=0; i<$(obj.parentNode).find("li").length; i++){
		$(obj.parentNode).find("li").eq(i).removeClass();
	}
	
	$(obj).addClass("action");
	
	for(var i=0; i<$("div[name=map]").length; i++){
		$("div[name=map]").eq(i).css("display", "none");
		$("div[name=map]").eq(i).css("visibility", "hidden");
		$("div[name=map]").eq(i).css("width", "99%");
		$("div[name=map]").eq(i).css("height", "100%");
	}
	
	// 1등
	if(obj.id == 'tab_2'){
		$("#map_first").css("display", "inline-block");
		$("#map_first").css("visibility", "visible");
	// 2등
	}else if(obj.id == 'tab_3'){
		$("#map_second").css("display", "inline-block");
		$("#map_second").css("visibility", "visible");
	// 전체
	}else{
		$("#map_all").css("display", "inline-block");
		$("#map_all").css("visibility", "visible");
	}
	
}
