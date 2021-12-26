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
<script src="<c:url value="/js/home.js"/>"></script>
</head>
<title>오늘의 로또</title>
</head>
<body>
    <tiles:insertAttribute name="head" />
    <tiles:insertAttribute name="contents" />
    <tiles:insertAttribute name="bottom" />
</body>
</html>
 