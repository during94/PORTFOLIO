<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
<form method="get" name="frm">
<br><br><br>
	<h3>배너 추가 및 삭제</h3>
	<input type="button" value="배너 정보 추가" onclick="banner_insert();">
	
	<table>
			<tr>
				<td>배너 정보</td>
			</tr>	
		</table>
		<br><br><br>
		
		<table class="content_table">
		<c:choose>
			<c:when test="${empty bannerList }">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty bannerList }">
				<c:forEach var="list" items="${bannerList }">
					<tr>
						<td> 제목 : <c:out value="${list.b_main_title }"></c:out></td>
					</tr>
					<tr>
						<td> 부제목 : <c:out value="${list.b_sub_title }"></c:out></td>
					</tr>
					<tr>
						<td>
							<a href="${list.b_link }">
								<img src="upload/${list.b_image} " alt="${list.b_main_title }" width="300px" height="300px">
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="배너 정보 수정" onclick="location.href='banner_update_form?b_num=${list.b_num}'">
						</td>
					</tr>
						<td><br><br></td>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</form>
</body>
</html>