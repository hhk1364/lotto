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
<body>
  <div class="sideBar">
  	<div class="subMenuDiv">
	  	<div class="TopMenuName">
			<p><c:out value="${myTopMenu[0].menu_nm}" /></p>
	  	</div>
	  	<c:if test="${fn:length(myDownMenu) != 0}">
		  	<div class="DownMenuName">
		  		<c:forEach var="menu" items="${myDownMenu}" varStatus="status">
					<div class="downMenu" id="menu${menu.menu_no}" onclick="clickMenu('${menu.url}')">
			  			<c:out value="${menu.menu_nm}" />
			  		</div>
				</c:forEach>
			</div>
		</c:if>
  	</div>
  </div>
</body>
</html>