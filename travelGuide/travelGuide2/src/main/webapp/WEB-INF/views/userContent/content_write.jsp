<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/content.js"></script>
<link href="css/main3.css" rel="stylesheet">
</head>
<body>
	<h3>게시글 작성</h3>
<form action="content_write" method="post" name="write" enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="2"><select name="c_kind">
				<option value="0">서울</option>
				<option value="1">부산</option>
				<option value="2">대구</option>
				<option value="3">인천</option>
				<option value="4">광주</option>
				<option value="5">대전</option>
				<option value="6">울산</option>
				<option value="7">세종</option>
				<option value="8">경기</option>
				<option value="9">강원</option>
				<option value="10">충북</option>
				<option value="11">충남</option>
				<option value="12">전북</option>
				<option value="13">전남</option>
				<option value="14">경북</option>
				<option value="15">경남</option>
				<option value="16">제주</option>
			</select></td>
		</tr>
		<tr>
			<th>제목</th><td><input type="text" name="c_title"></td>
		</tr>
		<tr>
			<th>파일</th><td><input type="file" name="uploadFile"></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea cols="50" rows="20" style="resize:none;" name="c_content"></textarea>
				<input type="hidden" value="${loginUser.id }" name="id">
				<input type="hidden" value="${loginUser.name }" name="name"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="back" type="button" value="취소" onclick="cancle_content()">
				<input type="button" value="작성 완료" onclick="check_write()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>