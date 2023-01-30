/**
 * 오늘의 통계 공통함수
 */

// 1등 2등 탭
function areaStatsTab(obj){
	
	for(var i=0; i<$(obj.parentNode).find("li").length; i++){
		$(obj.parentNode).find("li").eq(i).removeClass();
	}
	
	$(obj).addClass("action");

	// 1등
	if(obj.id == 'storeListTab1'){
		$("#statsAreaFirst").css("display", "block");
		$("#statsAreaSecond").css("display", "none");
	// 2등
	}else{
		$("#statsAreaFirst").css("display", "none");
		$("#statsAreaSecond").css("display", "block");
	}
	
}