<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main3.css" rel="stylesheet">
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
<form id="frmm" action="" style="text-align: center;">
	<table>
		<tr>
			<td>id</td>
			<td>${loginUser.id }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${loginUser.name }</td>
		</tr>
		<tr>
			<td>e-mail</td>
			<td>${loginUser.email }</td>
		</tr>
		<tr>
			<td>휴대폰</td>
			<td>${loginUser.phone }</td>
		</tr>
	</table>
	<input type="button" value="회원 정보 수정" onclick="location.href='mypage_update'">
	<input type="button" value="메인 페이지로" onclick="location.href='main'">
</form>
</body>
</html>