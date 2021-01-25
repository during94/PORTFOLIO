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
<form action="festival_update" method="post" name="frm" enctype="multipart/form-data">
	<input type="hidden" name="f_image" value="${festival.f_image}">
	<table>
		<tr>
			<td>
				축제 정보 수정 페이지입니다
				<input type="hidden" name="f_num" value="${festival.f_num }">
			</td>
		<tr>
			<td>
				링크를 입력해 주세요 : <input type="text" name="f_link" value="${festival.f_link }">
			</td>
		</tr>
		<tr>
			<td>
				메인 제목을 입력해 주세요 : <input type="text" name="f_main_title" value="${festival.f_main_title }">
			</td>
		<tr>
			<td>
				기간을 입력해 주세요 : <input type="text" name="f_sub_title" value="${festival.f_sub_title }">
			</td>
		</tr>
		<tr>
			<%@include file="festivalOption.jsp" %>
		</tr>
		<tr>
			<td>
				<img src="upload/${festival.f_image }">
				<input type="file" name="uploadFile">
			</td>
		</tr>
	</table>
	<br><br>
	<input type="button" value="취소" onclick="cancle_content();"> 
	<input type="reset" value="다시쓰기">
	<input type="button" value="삭제하기" onclick="location.href='festival_delete?f_num=${festival.f_num}'">
	<input type="submit" value="저장하기">
</form>
</body>
</html>