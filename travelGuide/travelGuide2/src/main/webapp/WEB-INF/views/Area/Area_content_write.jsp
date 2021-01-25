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
	<input type="hidden" value="${c_kind }">
<form action="content_write" method="post" name="write" enctype="multipart/form-data">
	<input type="hidden" name="return_kind" value=${c_kind }>
	<table>
		<tr>
			<td>
				<input type="hidden" value="${loginUser.id }" name="id">
				<input type="hidden" value="${loginUser.name }" name="name">
			</td>
		</tr>
		<tr>
			<%@ include file="areaOption.jsp" %>
		</tr>
		<tr>
			<th>제목</th><td><input type="text" name="c_title"></td>
		</tr>
		<tr>
			<th>파일</th><td><input type="file" name="uploadFile"></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea cols="50" rows="20" style="resize:none;" name="c_content"></textarea></td>
		</tr>
		<tr>
			<td>
				<input name="back" type="button" value="취소" onclick="cancle_content()">
				<input type="button" value="작성 완료" onclick="check_Area_write()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>