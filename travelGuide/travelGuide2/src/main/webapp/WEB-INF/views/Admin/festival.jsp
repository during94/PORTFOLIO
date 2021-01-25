<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 페이지</title>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
<br><br><br>
	<form method="get" name="frm">
		
		<h3>축제 추가 및 삭제</h3>
		<input type="button" value="축제 정보 추가" onclick="festival_insert();">
		<table>
			<tr>
				<td>축제 정보</td>
			</tr>	
		</table>
		<br><br><br>
		
		<table class="content_table">
		<c:choose>
			<c:when test="${empty festivalList }">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty festivalList }">
				<c:forEach var="list" items="${festivalList }">
					<tr>
						<td><c:out value="${list.f_main_title }"></c:out></td>
					</tr>
					<tr>
						<td><c:out value="${list.f_sub_title }"></c:out></td>
					</tr>
					<tr id="body">
						<td>
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
						</td>
						
						<td>
							<a href="${list.f_link }">
								<img src="upload/${list.f_image} " alt="${list.f_main_title }" width="300px" height="300px">
							</a>
						</td>
						<td>
							<input type="button" value="이벤트 정보 수정" onclick="location.href='festival_update_form?f_num=${list.f_num}'">
						</td>
						<td><br><br></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
		</table>
	</form>
</body>
</html>