// 전체
var container = document.getElementById('map_all');
var options = {
	center: new kakao.maps.LatLng(36, 128),
	level: 12
};

var map_all = new kakao.maps.Map(container, options);

//지도에 컨트롤을 추가해야 지도위에 표시됩니다
var mapTypeControlAll = new kakao.maps.MapTypeControl();
//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControlAll = new kakao.maps.ZoomControl();

//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map_all.addControl(mapTypeControlAll, kakao.maps.ControlPosition.TOPRIGHT);
map_all.addControl(zoomControlAll, kakao.maps.ControlPosition.RIGHT);



//1등
var container = document.getElementById('map_first');
var options = {
	center: new kakao.maps.LatLng(36, 128),
	level: 12
};

var map_first = new kakao.maps.Map(container, options);

//지도에 컨트롤을 추가해야 지도위에 표시됩니다
var mapTypeControlFirst = new kakao.maps.MapTypeControl();
//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControlFirst = new kakao.maps.ZoomControl();

//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map_first.addControl(mapTypeControlFirst, kakao.maps.ControlPosition.TOPRIGHT);
map_first.addControl(zoomControlFirst, kakao.maps.ControlPosition.RIGHT);


//2등
var container = document.getElementById('map_second');
var options = {
	center: new kakao.maps.LatLng(36, 128),
	level: 12
};

var map_second = new kakao.maps.Map(container, options);


//지도에 컨트롤을 추가해야 지도위에 표시됩니다
var mapTypeControlSecond = new kakao.maps.MapTypeControl();
//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControlSecond = new kakao.maps.ZoomControl();

//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map_second.addControl(mapTypeControlSecond, kakao.maps.ControlPosition.TOPRIGHT);
map_second.addControl(zoomControlSecond, kakao.maps.ControlPosition.RIGHT);



// 지도에 표출하기
function storeList(map, address, storeNm, grade, gb){
	
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(address, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {

	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

	        var con = "<div style='width:150px; text-align:center; padding:6px 0; font-size: small;'>";
	        con += grade + "등<br>";
	        if(gb != ""){
	        	 con += gb + "<br>";
	        }
	        con += storeNm;
	        con += "</div>";
	        
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: con
	        });
	        
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
}