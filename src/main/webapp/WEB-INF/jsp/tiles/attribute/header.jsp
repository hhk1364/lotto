<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<title>오늘의 로또</title>
</head>
<body>
  <div style="text-align:center">
	<img src="../image/favicon.png" alt="로고이미지" style="width: 100px;padding-bottom: 10px;">
  	<img src="../image/logo.png" alt="오늘의 로또 로고" style="width: 300px;">
  </div>
  <div style="position: relative;">
  	<div>
  		<img src="../image/menubackground.png" alt="오늘의 로또 메뉴 배경" style="position: relative;width:1130px;height: 65px;margin-bottom: 20px;margin-top: 0px;">
  	</div>
  	<div class="menuDiv">
	 	<div class="menu" id="menu1" onclick="clickMenu(this)">로또 당첨번호 정보</div>
	 	<!-- <div class="menu" id="menu2" onclick="clickMenu(this)">로또 번호 추천기</div>
	 	<div class="menu" id="menu3" onclick="clickMenu(this)">로또 번호 통계</div>
	 	<div class="menu" id="menu4" onclick="clickMenu(this)">당첨 지역 통계</div> -->
	</div>
  </div>
</body>
</html>