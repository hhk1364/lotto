// 로또 당첨번호 정보 검색
function searchTitleChange(opt){
	var val = opt.options[opt.selectedIndex].value;
	
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