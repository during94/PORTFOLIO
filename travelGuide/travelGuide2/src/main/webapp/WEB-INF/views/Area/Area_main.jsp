<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/content.js"></script>
<link href="css/content.css" rel="stylesheet">
<link href="css/main3.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

</head>
<body>
<br><br><br><br><br>
	<div style="text-align: center">
	<button id="btn1" value="1">서울</button>
	<button id="btn2" value="2">부산</button>
	</div>
	<div id="result1"></div>

	<div style="text-align: center">
	<ul class="area">
		<li><a href="Seoul">서울</a></li><li><a href="Busan">부산</a></li>
		<li><a href="Daegu">대구</a></li><li><a href="Incheon">인천</a></li>
		<li><a href="Gwangju">광주</a></li><li><a href="Daejeaon">대전</a></li>
		<li><a href="Ulsan">울산</a></li><li><a href="Sejong">세종</a></li>
		<li><a href="Gyeonggi">경기</a></li><li><a href="Gangwon">강원</a></li>
		<li><a href="Chungbuk">충북</a></li><li><a href="Chungnam">충남</a></li>
		<li><a href="Jeonbuk">전북</a></li><li><a href="Jeonnam">전남</a></li>
		<li><a href="Gyengbuk">경북</a></li><li><a href="Gyengnam">경남</a></li>
		<li><a href="Jeju">제주</a></li>
	</ul>
	</div>
	<br><br>
		<button id="seoul">서울 정보</button>
		<div id="result"></div>
</body>
</html>