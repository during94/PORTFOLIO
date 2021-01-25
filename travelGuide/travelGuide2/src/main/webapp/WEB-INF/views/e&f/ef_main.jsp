<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width: auto;
}
.e_image{
	position: relative;
	text-align: center;
}
.e_image .e_event_text{
	position: absolute;
	top: 35%;
	left: 44%;
	color: white;
	font-size: 20px;
	font-weight: 1000;
}
.e_image img{
	-webkit-filter: contrast(50%);
	filter: contrast(50%);
}
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
		<h3>이벤트</h3>
		<table class="event" id="event">
			<tr>
				<td>이벤트 정보</td>
			</tr>	
		</table>
		
		<table class="event_table" style="all: none;">
		<c:choose>
			<c:when test="${empty eventList }">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty eventList }">
				<c:forEach var="list" items="${eventList }">
					
					<tr id="body">
						
							<td>
								<a href="${list.e_link }" target="_blank">
									<img src="upload/${list.e_image} " alt="${list.e_main_title }" width="300px" height="300px">
								</a>
							</td>
							<td>지역 정보 : 
							<c:choose>
								<c:when test="${list.e_kind == '0' }">서울</c:when>
								<c:when test="${list.e_kind == '1' }">부산</c:when>
								<c:when test="${list.e_kind == '2' }">대구</c:when>
								<c:when test="${list.e_kind == '3' }">인천</c:when>
								<c:when test="${list.e_kind == '4' }">광주</c:when>
								<c:when test="${list.e_kind == '5' }">대전</c:when>
								<c:when test="${list.e_kind == '6' }">울산</c:when>
								<c:when test="${list.e_kind == '7' }">세종</c:when>
								<c:when test="${list.e_kind == '8' }">경기</c:when>
								<c:when test="${list.e_kind == '9' }">강원</c:when>
								<c:when test="${list.e_kind == '10' }">충북</c:when>
								<c:when test="${list.e_kind == '11' }">충남</c:when>
								<c:when test="${list.e_kind == '12' }">전북</c:when>
								<c:when test="${list.e_kind == '13' }">전남</c:when>
								<c:when test="${list.e_kind == '14' }">경북</c:when>
								<c:when test="${list.e_kind == '15' }">경남</c:when>
								<c:when test="${list.e_kind == '16' }">제주</c:when>
								<c:otherwise>전체지역</c:otherwise>
							</c:choose>
							<br><br>
							제목 :${list.e_main_title }
							<br><br>
							부 제목:${list.e_sub_title }</td>
							
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
		
		<h3>축제 정보</h3>
		<table>
			<tr>
				<td>축제 정보</td>
			</tr>	
		</table>
	
	<c:choose>
		<c:when test="${empty festivalList }">
				데이터가 없습니다.
		</c:when>
		<c:when test="${!empty festivalList }">
			<c:forEach var="list" items="${festivalList }">
			
			<div class="e_image">
				<a href="${list.f_link }" target="_blank">
					<img src="upload/${list.f_image} " alt="${list.f_main_title }" width="400px" height="300px">
				</a>
			
				<div class="e_event_text">
					<div>
						<c:choose>
							<c:when test="${list.f_kind == '0' }">서울</c:when>
							<c:when test="${list.f_kind == '1' }">부산</c:when>
							<c:when test="${list.f_kind == '2' }">대구</c:when>
							<c:when test="${list.f_kind == '3' }">인천</c:when>
							<c:when test="${list.f_kind == '4' }">광주</c:when>
							<c:when test="${list.f_kind == '5' }">대전</c:when>
							<c:when test="${list.f_kind == '6' }">울산</c:when>
							<c:when test="${list.f_kind == '7' }">세종</c:when>
							<c:when test="${list.f_kind == '8' }">경기</c:when>
							<c:when test="${list.f_kind == '9' }">강원</c:when>
							<c:when test="${list.f_kind == '10' }">충북</c:when>
							<c:when test="${list.f_kind == '11' }">충남</c:when>
							<c:when test="${list.f_kind == '12' }">전북</c:when>
							<c:when test="${list.f_kind == '13' }">전남</c:when>
							<c:when test="${list.f_kind == '14' }">경북</c:when>
							<c:when test="${list.f_kind == '15' }">경남</c:when>
							<c:when test="${list.f_kind == '16' }">제주</c:when>
							<c:otherwise>전체지역</c:otherwise>
						</c:choose>
					</div>
							<div>
								${list.f_main_title}
							</div>
							<div>
								${list.f_sub_title}
							</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
</body>
</html>