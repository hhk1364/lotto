<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<head>
<script src="/js/round/round.js"></script>
<link rel="stylesheet" href="/css/round.css">
</head>
<title>회차별 당첨번호</title>
<body>
   <div class="content">
   	<div id="round-bx">
   		<div class="round_title_area"> 
   			<h2 class="round_title">로또6/45 당첨번호 정보</h2>
   		</div>
   		<div class="round-wrap">
   			<div class="round_lotto_wrap">
   				<div class="round_lotto_title"></div>
   				<div class="round_lotto_number">
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
   		</div>
   	</div>
   </div>
</body>
</html>