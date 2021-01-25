<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/content.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
<form action="banner_update" method="post" name="frm" enctype="multipart/form-data">
	<input type="hidden" name="b_image" value="${banner.b_image}">
	<table>
		<tr>
			<td>
				배너 정보 수정 페이지입니다
				<input type="hidden" name="b_num" value="${banner.b_num }">
			</td>
		<tr>
			<td>
				링크를 입력해 주세요 : <input type="text" name="b_link" value="${banner.b_link }">
			</td>
		</tr>
		<tr>
			<td>
				메인 제목을 입력해 주세요 : <input type="text" name="b_main_title" value="${banner.b_main_title }">
			</td>
		<tr>
			<td>
				부 제목을 입력해 주세요 : <input type="text" name="b_sub_title" value="${banner.b_sub_title }">
			</td>
		</tr>
		<tr>
		<c:choose>
			<c:when test="${!empty banner.b_image}">
				<td>
					<img src="upload/${banner.b_image }">
					<input type="file" name="uploadFile">
				</td>
			</c:when>
			<c:otherwise>
				<td>
					이미지 파일 : <input type="file" name="uploadFile">
				</td>
			</c:otherwise>
		</c:choose>
		</tr>
	</table>
	<br><br>
	<input type="button" value="취소" onclick="cancle_content();"> 
	<input type="reset" value="다시쓰기">
	<input type="button" value="삭제하기" onclick="location.href='banner_delete?b_num=${banner.b_num}'">
	<input type="submit" value="저장하기">
</form>
</body>
</html>