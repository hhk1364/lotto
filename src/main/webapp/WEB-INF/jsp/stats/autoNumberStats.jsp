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
<title>자동 수동 통계</title>
<body>
 <form id="form" name="form" method="post" action="/stats/autoNumberStats.do"> 
   <div class="subContent">
   
	   
	   <h1>자동 수동 통계</h1>
	   
	   <div class="searchArea">
			
			<div class="form-group">
				<label class="label_form">회차</label>
				<select id="drwNoStart" name="drwNoStart">
					<c:if test="${fn:length(drwNoList) > 0}">
						<c:forEach var="list" items="${drwNoList}" varStatus="status">
							<option value="<c:out value='${list.drwNo}'/>" <c:if test="${list.drwNo eq statsVO.drwNoStart}">selected</c:if>><c:out value='${list.drwNo}'/>  (<c:out value='${list.drwNoDate}'/>)</option>
						</c:forEach>
					</c:if>
				</select>
				~
				<select id="drwNoEnd" name="drwNoEnd">
					<c:if test="${fn:length(drwNoList) > 0}">
						<c:forEach var="list" items="${drwNoList}" varStatus="status">
							<option value="<c:out value='${list.drwNo}'/>" <c:if test="${list.drwNo eq statsVO.drwNoEnd}">selected</c:if>><c:out value='${list.drwNo}'/>  (<c:out value='${list.drwNoDate}'/>)</option>
						</c:forEach>
					</c:if>
				</select>
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
	   				<th scope="col">종류</th>
					<th scope="col">당첨횟수</th>
					<th scope="col">당첨확률</th>		
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
	   									<c:out value="${result.kind}"></c:out>
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
	   							<td colspan="5">홀짝 통계 데이터가 없습니다.</td>
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