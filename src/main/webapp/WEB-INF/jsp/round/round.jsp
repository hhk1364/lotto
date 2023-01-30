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
<title>회차별 당첨 정보</title>
<body>
   <h1>회차별 당첨 정보</h1>
   <div class="content">
   	
	<!--로딩바-->
	<div id="loading" style="margin-left: 0px;">
	    <img src="../image/loadingBar.gif">
	    <p>잠시 기다려주세요</p>
	</div>
   
   	 <form id="form" name="form" method="post" action="/round/round.do"> 
   		 <div class="searchArea">
			<div class="form-group">
				<label class="label_form">회차</label>
				<select id="drwNo" name="drwNo" onchange="roundSearch();">
					<c:if test="${fn:length(drwNoList) > 0}">
						<c:forEach var="list" items="${drwNoList}" varStatus="status">
							<option value="<c:out value='${list.drwNo}'/>" <c:if test="${list.drwNo eq roundVO.drwNo}">selected</c:if>><c:out value='${list.drwNo}'/> (<c:out value='${list.drwNoDate}'/>)</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
	   </div>
	 </form>
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
	   			<h4 class="search_title">당첨 판매점</h4>
	   			<p style="font-size: small;">* 997회차 부터 제공됩니다. (동행복권 기준)</p>
	   		</div>
	   		
	   		<div class="search_title_area"> 
	   			<h4 class="search_title">지도</h4>
	   		</div>
	   		
	   		<div class="gp_tab_menu">
				<ul style="padding-left: 0px;margin-bottom: 5px;">
					<li name="searchStoreTab" id="tab_1" class="action" onclick="javascript:storeTabId(this)"><a href="javascript:;">전체</a></li>
					<li name="searchStoreTab" id="tab_2" onclick="javascript:storeTabId(this)"><a href="javascript:;">1등</a></li>
					<li name="searchStoreTab" id="tab_3" onclick="javascript:storeTabId(this)"><a href="javascript:;">2등</a></li>
				</ul>
			</div>
			
				<input type="hidden" id="storeResult" value="<c:out value="${storeResult}"/>"></input>
   				<input type="hidden" id="storeFirstResult" value="<c:out value="${storeFirstResult}"/>"></input>
   			 	<input type="hidden" id="storeSecondResult" value="<c:out value="${storeSecondResult}"/>"></input>
   			 	
	   		<div class="map_area">
	   			 <div name="map" id="map_all" style="width:99%;height:100%; display: inline-block;"></div>
	   			 <div name="map" id="map_first" style="width:99%;height:100%; visibility:hidden;"></div>
	   			 <div name="map" id="map_second" style="width:99%;height:100%; visibility:hidden;"></div>
	   			 <script src="/js/map.js"></script>
	   		</div>
	   		
	   		<div class="search_title_area"> 
	   			<h4 class="search_title">목록</h4>
	   		</div>
	   		
	   		<div class="gp_tab_menu" style="margin-top: 20px;">
				<ul style="padding-left: 0px;margin-bottom: 5px;">
					<li name="storeListTab" id="storeListTab1" class="action" onclick="javascript:storeListTab(this)"><a href="javascript:;">1등</a></li>
					<li name="storeListTab" id="storeListTab2" onclick="javascript:storeListTab(this)"><a href="javascript:;">2등</a></li>
				</ul>
			</div>
	   		
	   		<div class="storeListArea" id="storeList1">
		   		<table class="listTable">
		   			<colgroup>
		   				<col style="width:10%">
						<col style="width:20%">
						<col style="width:10%">
						<col style="width:40%">
		   			</colgroup>
		   			<thead>
		   				<th scope="col">순번</th>
		   				<th scope="col">판매점</th>
						<th scope="col">구분</th>
						<th scope="col">주소</th>		
		   			</thead>
		   			<tbody>
		   				<c:choose>
		   					<c:when test="${fn:length(storeFirstResultTmp) > 0}">
		   						<c:forEach var="storeFirstResult" items="${storeFirstResultTmp}" varStatus="status">
		   							<tr>
		   								<td>
		   									<c:out value="${storeFirstResult.seq}"></c:out>
		   								</td>
		   								<td>
		   									<c:out value="${storeFirstResult.storeNm}"></c:out>
		   								</td>
		   								<td>
		   									<c:out value="${storeFirstResult.gb}"></c:out>
		   								</td>
		   								<td>
		   									<c:out value="${storeFirstResult.address}"></c:out>
		   								</td>
		   							</tr>
		   						</c:forEach>
		   					</c:when>
		   					<c:otherwise>
		   						<tr>
		   							<td colspan="5">판매점 데이터가 없습니다.</td>
		   						</tr>
		   					</c:otherwise>
		   				</c:choose>
		   			</tbody>
		   		</table>
		   </div>
	   		
	   		<div class="storeListArea" id="storeList2" style="display:none;">
		   		<table class="listTable">
		   			<colgroup>
		   				<col style="width:10%">
						<col style="width:20%">
						<col style="width:40%">
		   			</colgroup>
		   			<thead>
		   				<th scope="col">순번</th>
		   				<th scope="col">판매점</th>
						<th scope="col">주소</th>		
		   			</thead>
		   			<tbody>
		   				<c:choose>
		   					<c:when test="${fn:length(storeSecondResultTmp) > 0}">
		   						<c:forEach var="storeSecondResult" items="${storeSecondResultTmp}" varStatus="status">
		   							<tr>
		   								<td>
		   									<c:out value="${storeSecondResult.seq}"></c:out>
		   								</td>
		   								<td>
		   									<c:out value="${storeSecondResult.storeNm}"></c:out>
		   								</td>
		   								<td>
		   									<c:out value="${storeSecondResult.address}"></c:out>
		   								</td>
		   							</tr>
		   						</c:forEach>
		   					</c:when>
		   					<c:otherwise>
		   						<tr>
		   							<td colspan="5">판매점 데이터가 없습니다.</td>
		   						</tr>
		   					</c:otherwise>
		   				</c:choose>
		   			</tbody>
		   		</table>
		   </div>
	   		
	   	</div>
   </div>
</body>
</html>