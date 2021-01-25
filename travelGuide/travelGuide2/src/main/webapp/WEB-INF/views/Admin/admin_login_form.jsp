<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
<form name="frm" action="oper_login" method="post">
	<h3>관리자 페이지 입니다</h3>
	<h3>아이디 : <input type="text" name="o_id"></h3>
	<h3>비밀번호 : <input type="password" name="o_pwd"></h3>
	<input type="submit" value="로그인">
</form>
<br>
<form name=frmm>
	<input type="button" value="고객페이지" onclick="go_main();">
</form>
</body>
</html>