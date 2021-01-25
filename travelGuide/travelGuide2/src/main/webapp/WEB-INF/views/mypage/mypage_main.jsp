<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mypage_main2" method="post">
<input type="hidden" name="id" value="${loginUser.id}">
	<div>
		비밀번호 : <input type="password" name="pwd" id="pwd">
	</div>
	<c:choose>
		<c:when test="${message == 1}">
			<span style="color: red;">잘못된 비밀번호 입니다</span>
		</c:when>
	</c:choose>
	<div style="text-align: center;">
		<input type="submit" value="확인">
	</div>
</form>
</body>
</html>