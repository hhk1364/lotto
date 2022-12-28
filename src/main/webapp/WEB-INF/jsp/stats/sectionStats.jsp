<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<head>
<script src="/js/stats/common.js"></script>
<link rel="stylesheet" href="/css/stats.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
</head>
<title>구간별 통계</title>
<body>
 <form id="form" name="form" method="post" action="/stats/sectionStats.do"> 
   <div class="subContent">
   
	   
	   <h1>구간별 통계</h1>
	   
	   <div class="searchArea">
			<div class="form-group">
				<label class="label_form">보너스 번호 포함여부</label>
				<select id="isBonus" name="isBonus">
					<option value="" <c:if test="${statsVO.isBonus eq null or '' eq statsVO.isBonus}">selected</c:if>>포함</option>
					<option value="N" <c:if test="${statsVO.isBonus ne null and 'N' eq statsVO.isBonus}">selected</c:if>>미포함</option>
					<option value="onlyBonus" <c:if test="${statsVO.isBonus ne null and 'onlyBonus' eq statsVO.isBonus}">selected</c:if>>보너스번호만</option>
				</select>
			</div>
			
			<div class="form-group">
				<label class="label_form">회차</label>
				<select id="drwNoStart" name="drwNoStart">
					<c:if test="${fn:length(drwNoList) > 0}">
						<c:forEach var="list" items="${drwNoList}" varStatus="status">
							<option value="<c:out value='${list.drwNo}'/>" <c:if test="${list.drwNo eq statsVO.drwNoStart}">selected</c:if>><c:out value='${list.drwNo}'/></option>
						</c:forEach>
					</c:if>
				</select>
				~
				<select id="drwNoEnd" name="drwNoEnd">
					<c:if test="${fn:length(drwNoList) > 0}">
						<c:forEach var="list" items="${drwNoList}" varStatus="status">
							<option value="<c:out value='${list.drwNo}'/>" <c:if test="${list.drwNo eq statsVO.drwNoEnd}">selected</c:if>><c:out value='${list.drwNo}'/></option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			
			<div class="form-group">
				<label class="label_form">날짜</label>
				<input type="date" name="drwNoDateStart" id="drwNoDateStart" value="<c:out value='${statsVO.drwNoDateStart}'/>">
				~
				<input type="date" name="drwNoDateEnd" id="drwNoDateEnd" value="<c:out value='${statsVO.drwNoDateEnd}'/>">
			</div>
			
			<button class="search-btn" form="form">검색</button>
	   </div>
	   <div class="statsArea">
	   		<table class="statsTable">
	   			<colgroup>
	   				<col style="width:10%">
					<col style="width:20%">
					<col style="width:40%">
					<col style="width:40%">
	   			</colgroup>
	   			<thead>
	   				<th scope="col">순번</th>
	   				<th scope="col">구간</th>
					<th scope="col">당첨횟수</th>
					<th scope="col">당첨확률(당첨횟수/전체회차)</th>		
	   			</thead>
	   			<tbody>
	   				<c:choose>
	   					<c:when test="${fn:length(result) > 0}">
	   						<c:forEach var="result" items="${result}" varStatus="status">
	   							<tr>
	   								<td>
	   									<c:out value="${status.count}"></c:out>
	   								</td>
	   								<td>
	   									<c:set var="startNum" value="${fn:split(result.num,'~')[0]}"/>
	   									<c:set var="endNum" value="${fn:split(result.num,'~')[1]}"/>
	   									<span style="display:inline-block !important;" class="num ball${startNum}"><c:out value="${startNum}"></c:out></span>
	   									<span style="font-size:x-large;">~</span>
	   									<span style="display:inline-block !important;" class="num ball${endNum}"><c:out value="${endNum}"></c:out></span>
	   								</td>
	   								<td>
	   									<c:out value="${result.cnt}"></c:out>
	   								</td>
	   								<td>
	   									<c:out value="${result.percent}"></c:out>
	   								</td>
	   							</tr>
	   						</c:forEach>
	   					</c:when>
	   					<c:otherwise>
	   						<tr>
	   							<td colspan="5">구간별 통계 데이터가 없습니다.</td>
	   						</tr>
	   					</c:otherwise>
	   				</c:choose>
	   			</tbody>
	   		</table>
	   </div>
   </div>
 </form>
</body>
</html>