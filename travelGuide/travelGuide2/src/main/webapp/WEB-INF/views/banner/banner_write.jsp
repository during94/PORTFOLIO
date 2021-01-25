<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/admin.js"></script>
<script type="text/javascript" src="js/content.js"></script>
</head>
<body>
	<h3>안녕하세요 배너 추가 페이지 입니다</h3>
	배너 이미지, 배너 제목, 배너 부제목, 배너 링크
	
<form action="banner_insert" method="post" name="write" enctype="multipart/form-data">
	<table>
		<tr>
			<td>
				배너 정보 추가 페이지입니다
			</td>
		<tr>
			<td>
				링크를 입력해 주세요 : <input type="text" name="b_link">
			</td>
		</tr>
		<tr>
			<td>
				메인 제목을 입력해 주세요 : <input type="text" name="b_main_title">
			</td>
		<tr>
			<td>
				부 제목을 입력해 주세요 : <input type="text" name="b_sub_title">
			</td>
		</tr>
		<tr>
			<td>
				이미지 파일 : <input type="file" name="uploadFile">
			</td>
		</tr>
	</table>
	<br><br>
	<input type="button" value="취소" onclick="cancle_content();"> 
	<input type="reset" value="다시쓰기">
	<input type="button" value="저장하기" onclick="banner_write();">
</form>
</body>
</html>