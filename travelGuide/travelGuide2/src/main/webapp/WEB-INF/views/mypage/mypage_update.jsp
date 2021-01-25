<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/member.js"></script>
<link href="css/main3.css" rel="stylesheet">
</head>
<body>
<%@ include file="../header.jsp" %>
<form name="mypage_update" action="myinfo_update" method="post">
	<h3>글 정보 수정페이지</h3>
	<table>
		<tr>
			<td>아 이 디 : <input type="text" name="id" value="${loginUser.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호: <input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>비밀번호 확인: <input type="password" name="pwd_check"></td>
		</tr>
		<tr>
			<td>이 &nbsp;&nbsp;&nbsp;&nbsp;름 : <input type="text" name="name" value="${loginUser.name}"></td>
		</tr>
		<tr>
			<td>핸 드 폰 : <input type="text" name="phone" value="${loginUser.phone}"></td>
		</tr>
		<tr>
			<td>이 메 일 : <input type="text" name="email" value="${loginUser.email}"></td>
		</tr>
		<tr>
			<td>
				<input type="button" value="수정하기" onclick="update_pwd_check()">
				<button type="reset">리셋</button>
				<button type="button" onclick="location.href='mypage_main2?id=${loginUser.id}&pwd=${loginUser.pwd}'">취소</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>