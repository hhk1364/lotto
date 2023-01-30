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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9df61b4d32597b0e0762c05280b1b969&libraries=services,clusterer,drawing"></script>
</head>
<title>오늘의 로또</title>
</head>
<body>
  <div style="text-align:left;border-bottom: 1px solid #eff2f4;">
	<div class="logo" onclick="clickMenu('/home.do')">
		<img src="../image/favicon.png" alt="로고이미지" style="width:45px;padding-bottom: 10px;">
  		<img src="../image/logo.png" alt="오늘의 로또 로고" style="width:120px;">
  	</div>
  	<div class="menuDiv">
  		<c:if test="${fn:length(allTopMenu) != 0}">
  			<c:forEach var="menu" items="${allTopMenu}" varStatus="status">
  				<div class="menu" id="menu${menu.menu_no}" onclick="clickMenu('${menu.url}')"><c:out value="${menu.menu_nm}" /></div>
	 		</c:forEach>
	 	</c:if>
	</div>
  </div>
</body>
</html>