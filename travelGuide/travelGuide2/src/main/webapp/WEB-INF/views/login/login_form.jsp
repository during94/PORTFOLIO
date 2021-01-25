<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/member.js"></script>
<link href="css/main3.css" rel="stylesheet">
</head>
<body>
<form name="frm" action="login" method="post">
	<h3>아이디 : <input type="text" name="id"></h3>
	<h3>비밀번호 : <input type="password" name="pwd"></h3>
	<input type="submit" value="로그인">
	<input type="button" value="회원가입" onclick="location = 'join_form'">
	<input type="button" value="아이디 및 비밀번호 찾기" onclick="go_find_login();">
</form>
</body>
</html>