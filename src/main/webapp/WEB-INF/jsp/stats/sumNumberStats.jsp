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
<title>번호 합 통계</title>
<body>
 <form id="form" name="form" method="post" action="/stats/sumNumberStats.do"> 
   <div class="subContent">
   
	   
	   <h1>번호 합 통계</h1>
	   
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
	   		<div class="avg" style="margin-bottom: 30px;color: #5B5AFF; font-weight: bolder; font-size: larger;">
	   			번호 합 평균 : <c:out value="${average}"></c:out>
	   		</div>
	   		<table class="statsTable">
	   			<colgroup>
	   				<col style="width:10%">
					<col style="width:20%">
					<col style="width:20%">
					<col style="width:60%">
	   			</colgroup>
	   			<thead>
	   				<th scope="col">당첨회차</th>
	   				<th scope="col">당첨날짜</th>
					<th scope="col">번호 합</th>
					<th scope="col">당첨번호</th>		
	   			</thead>
	   			<tbody>
	   				<c:choose>
	   					<c:when test="${fn:length(result) > 0}">
	   						<c:forEach var="result" items="${result}" varStatus="status">
	   							<tr>
	   								<td>
	   									<c:out value="${result.drwNo}"></c:out>
	   								</td>
	   								<td>
	   									<c:out value="${result.drwNoDate}"></c:out>
	   								</td>
	   								<td>
	   									<c:out value="${result.sum}"></c:out>
	   								</td>
	   								<td>
	   									<c:choose>
	   										<c:when test="${statsVO.isBonus ne 'N' and statsVO.isBonus ne 'onlyBonus'}">
	   											<span style="display:inline-block !important;" class="num ball${result.drwtNo1}"><c:out value="${result.drwtNo1}"></c:out></span>
			   									<span style="display:inline-block !important;" class="num ball${result.drwtNo2}"><c:out value="${result.drwtNo2}"></c:out></span>
			   									<span style="display:inline-block !important;" class="num ball${result.drwtNo3}"><c:out value="${result.drwtNo3}"></c:out></span>
			   									<span style="display:inline-block !important;" class="num ball${result.drwtNo4}"><c:out value="${result.drwtNo4}"></c:out></span>
			   									<span style="display:inline-block !important;" class="num ball${result.drwtNo5}"><c:out value="${result.drwtNo5}"></c:out></span>
			   									<span style="display:inline-block !important;" class="num ball${result.drwtNo6}"><c:out value="${result.drwtNo6}"></c:out></span>
			   									<span style="display:inline-block !important;" class="num ball${result.bnusNo}"><c:out value="${result.bnusNo}"></c:out></span>
	   										</c:when>
	   										<c:otherwise>
	   											<c:if test="${statsVO.isBonus eq 'N'}">
	   												<span style="display:inline-block !important;" class="num ball${result.drwtNo1}"><c:out value="${result.drwtNo1}"></c:out></span>
				   									<span style="display:inline-block !important;" class="num ball${result.drwtNo2}"><c:out value="${result.drwtNo2}"></c:out></span>
				   									<span style="display:inline-block !important;" class="num ball${result.drwtNo3}"><c:out value="${result.drwtNo3}"></c:out></span>
				   									<span style="display:inline-block !important;" class="num ball${result.drwtNo4}"><c:out value="${result.drwtNo4}"></c:out></span>
				   									<span style="display:inline-block !important;" class="num ball${result.drwtNo5}"><c:out value="${result.drwtNo5}"></c:out></span>
				   									<span style="display:inline-block !important;" class="num ball${result.drwtNo6}"><c:out value="${result.drwtNo6}"></c:out></span>
				   								</c:if>
	   											<c:if test="${statsVO.isBonus eq 'onlyBonus'}">
	   												<span style="display:inline-block !important;" class="num ball${result.bnusNo}"><c:out value="${result.bnusNo}"></c:out></span>
	   											</c:if>
	   										</c:otherwise>
	   									</c:choose>
	   								</td>
	   							</tr>
	   						</c:forEach>
	   					</c:when>
	   					<c:otherwise>
	   						<tr>
	   							<td colspan="5">번호 합 통계 데이터가 없습니다.</td>
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