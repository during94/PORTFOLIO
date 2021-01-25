<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
<link href="css/main3.css" rel="stylesheet">
<script type="text/javascript" src="js/js.js"></script> 
</head>
<body>
<div class=container>
	<div id="mysidenav" class="sidenav">
			<a href="#" class="closebtn" onclick='closeNav()'>x</a>
			
			<c:choose>
				<c:when test="${loginUser.id == null }">
					<a href="main_form">홈</a>
					<a href="login_form">로그인</a>
				</c:when>
				<c:otherwise>
					<c:if test="${loginUser.id == '123' }">
						<a href="oper_login_form">관리자 페이지로</a>
					</c:if>
					<a href="main_login">홈</a>
					<a href="logout_form">로그아웃</a>
					<a href="mypage_main?id=${loginUser.id}&pwd=${loginUser.pwd}">마이페이지</a>
				</c:otherwise>
			</c:choose>
			
			<a href="UserContent_list">게시판</a>
					
					<!-- 슬라이드 지역
				<div id="myareaNav" class="areanav">
					<a href="Area_main" class="uparea">지역</a>
				</div>
				-->
			<a href="go_event_festival">이벤트 및 축제</a>
		</div>
	<span class="openmenu" onclick='openNav()'>&equiv;</span>
	<div class="logo">
		<c:choose>
				<c:when test="${loginUser.id == null }">
					<a href="main_form"><img alt="" src="upload/travel.jpg" style="height: 50px; width: 400px"></a>
				</c:when>
				<c:otherwise>
					<a href="main_form"><img alt="" src="upload/travel.jpg" style="height: 50px; width: 400px"></a>
				</c:otherwise>
			</c:choose>
	</div>
</div>
</body>
</html>