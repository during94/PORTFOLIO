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
	<h3>게시글 수정</h3>
<form action="content_write" method="post" name="write" enctype="multipart/form-data">
	<input type="hidden" value="${loginUser.id }" name="id">
	<input type="hidden" value="${loginUser.name }" name="name">
	<input type="hidden" value="${detail.c_file }" name="c_file">
	<input type="hidden" name="num" value="${detail.num }">
	<table>
		<colgroup>
			<col style="width:15%;"/>
			<col style="width:auto%;"/>
		</colgroup>
		<tr>
			<%@ include file="content_option.jsp" %>
		</tr>
		<tr>
			<th>제목</th><td><input type="text" name="c_title" value="${detail.c_title }"></td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${!empty detail.c_file}">
					<th>파일 변경</th>
					<td><input type="file" name="uploadFile"></td>
				</c:when>
				<c:otherwise>
					<th>파일</th>
					<td><input type="file" name="uploadFile"></td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>내용</th><td><textarea cols="50" rows="20" style="resize:none;" name="c_content" >${detail.c_content}</textarea></td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${!empty detail.c_file}">
					<td colspan="2">
						<img src="upload/${detail.c_file }" style="width: 300px; height: 150px">
					</td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
		</c:choose>
		</tr>
		<tr>
			<td>
				<input name="back" type="button" value="취소" onclick="cancle_content()">
				<input type="button" value="변경사항 저장하기" onclick="update_detail()">
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>