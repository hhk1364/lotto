<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<head>
<script src="/js/round/round.js"></script>
<link rel="stylesheet" href="/css/round.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
</head>
<title>로또 당첨번호 정보</title>
<body>
   <div class="content">
   	<div id="round-bx">
   		<div class="current-wrap">
   			<div class="current_lotto_wrap">
   				<div class="current_lotto_title">
   					<span class="current_lotto_title_text"><span class="current">${result[0].drwNo}</span>회차 당첨번호 <br> 당첨날짜 : <span class="current">${result[0].drwNoDate} (토)</span></span></span>
   				</div>
   				<div class="current_lotto_number">
   					<span class="num ball${result[0].drwtNo1}"><c:out value="${result[0].drwtNo1}"/></span> 
   					<span class="num ball${result[0].drwtNo2}"><c:out value="${result[0].drwtNo2}"/></span> 
   					<span class="num ball${result[0].drwtNo3}"><c:out value="${result[0].drwtNo3}"/></span> 
   					<span class="num ball${result[0].drwtNo4}"><c:out value="${result[0].drwtNo4}"/></span> 
   					<span class="num ball${result[0].drwtNo5}"><c:out value="${result[0].drwtNo5}"/></span> 
   					<span class="num ball${result[0].drwtNo6}"><c:out value="${result[0].drwtNo6}"/></span> 
   					<span class="bonus">보너스번호</span> 
   					<span class="num ball${result[0].bnusNo}"><c:out value="${result[0].bnusNo}"/></span>
   				</div>
   			</div>
			<div class="detail_show">
  				<span class="icoArrow" onclick="showDetail();">상세내용 보기<img style="width:15px; vertical-align:middle; margin-left:5px; margin-bottom: 3px;" src="/image/arrow.png" alt="상세내용 보기 (누적상금, 1등 당첨금, 1등 당첨 인원, 1등 당첨금 총액)"></span>
  			</div>
   			<div class="current_lotto_detail">
 						<span class="current_lotto_detail_text">
							1등 당첨 인원 : <fmt:formatNumber value="${result[0].firstPrzwnerCo}" pattern="#,###" />명 
							<br>1등 당첨금 : <fmt:formatNumber value="${result[0].firstWinamnt}" pattern="#,###" />원 (${result[0].firstWinamntKoreanVer} 원)
 						</span>
 				</div>
   		</div>
   	</div>
   	<div id="round-bx">
   		<div class="search_title_area"> 
   			<h4 class="search_title">당첨지역</h2>
   		</div>
   		<div class="search_area">
   			 
   		</div>
   	</div>
   </div>
</body>
</html>