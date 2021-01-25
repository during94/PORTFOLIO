<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/member.js"></script>
<link rel="stylesheet" href="css/main3.css" /></head>
</head>
<body>
<%@ include file="../header.jsp" %>
<form name="newUser" action="new_join" method="post">
	<h3>회원가입 페이지</h3>
	<table>
		<tr>
			<td>
				아 이 디 : <input type="text" name="id"> 
				<input type="hidden"    name="reid">
				<input type="button" value="아이디 중복 체크" class="ic" onclick="id_check();">
				</td>
		</tr>
		<tr>
			<td>비밀번호: <input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>비밀번호 확인: <input type="password" name="pwd_check"></td>
		</tr>
		<tr>
			<td>이 &nbsp;&nbsp;&nbsp;&nbsp;름 : <input type="text" name="name" ></td>
		</tr>
		<tr>
			<td>이 메 일 : <input type="text" name="email"></td>
		</tr>
		<tr>
			<td>
				핸 드 폰 : <input type="text" name="phone" >
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="회원가입" onclick="check_all();">
				<button type="reset">다시 입력</button>
				<button type="button" onclick="location.href='login_form'">취소</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>