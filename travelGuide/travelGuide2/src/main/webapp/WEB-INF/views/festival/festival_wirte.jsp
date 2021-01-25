<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/content.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
<form action="festival_insert" method="post" name="write" enctype="multipart/form-data">
	<table>
		<tr>
			<td>
				축제 정보 추가 페이지입니다
			</td>
		<tr>
			<td>
				링크를 입력해 주세요 : <input type="text" name="f_link">
			</td>
		</tr>
		<tr>
			<td>
				메인 제목을 입력해 주세요 : <input type="text" name="f_main_title">
			</td>
		<tr>
			<td>
				기간을 입력해 주세요 : <input type="text" name="f_sub_title">
			</td>
		</tr>
		<tr>
			<td>
				지역 선택 : 
				<select name="f_kind">
					<option value="0" selected="selected">서울</option>
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
					<option value="100">전체</option>
				</select>
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
	<input type="button" value="저장하기" onclick="fetival_write();">
</form>
</body>
</html>