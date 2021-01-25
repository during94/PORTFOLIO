<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/content.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
		<h3>게시글 상세보기</h3>
<form action="content_detail" method="post" name="write">
	<table>
		<tr>
			<td><h2>${detail.c_title}</h2></td>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="${detail.c_kind == '1' }">서울</c:when>
					<c:when test="${detail.c_kind == '2' }">부산</c:when>
					<c:when test="${detail.c_kind == '3' }">대구</c:when>
					<c:when test="${detail.c_kind == '4' }">광주</c:when>
					<c:when test="${detail.c_kind == '5' }">대전</c:when>
					<c:when test="${detail.c_kind == '6' }">울산</c:when>
					<c:when test="${detail.c_kind == '7' }">세종</c:when>
					<c:when test="${detail.c_kind == '8' }">경기</c:when>
					<c:when test="${detail.c_kind == '9' }">강원</c:when>
					<c:when test="${detail.c_kind == '10' }">충북</c:when>
					<c:when test="${detail.c_kind == '11' }">충남</c:when>
					<c:when test="${detail.c_kind == '12' }">전북</c:when>
					<c:when test="${detail.c_kind == '13' }">전남</c:when>
					<c:when test="${detail.c_kind == '14' }">경북</c:when>
					<c:when test="${detail.c_kind == '15' }">경남</c:when>
					<c:when test="${detail.c_kind == '16' }">제주</c:when>
					<c:otherwise>전체보기</c:otherwise>
				</c:choose>
				  | <fmt:formatDate value="${detail.c_regdate }" pattern="yyyy-MM-dd HH:mm"/> | ${detail.name }</td>
		</tr>
		<tr>
			<td>조회수 :${detail.c_count }</td>
		</tr>
		<tr>
			<td><textarea rows="20" cols="60" style="resize: none;" readonly="readonly">${detail.c_content }</textarea></td>
		</tr>
		<c:choose>
			<c:when test="${detail.c_file != 'noimage.jpg' }">
				<tr>
					<td><img src="upload/${detail.c_file }" width="300"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
		 <tr>
		 	<td style="text-align: center;">
		 		<c:choose>
		 			<c:when test="${loginUser.id != null && loginUser.id == detail.id}">
				  		<img src="upload/no_hart.jpg" onclick="self_like();" style="cursor:pointer; width: 40px;" align="middle">
				  		<div id="result4"> 좋아요:${count_like}</div>
				  	</c:when>
				  
				  <c:when test="${loginUser.id != null}">
				  	<c:choose>
				  		<c:when test="${like_check == 1}">
				  			<img src="upload/full_hart.jpg" id="img_result" onclick="like_up();" style="cursor:pointer; width: 40px;" align="middle">
				  			<div id="result4"> 좋아요:${count_like}</div>
				  		</c:when>
						
						<c:otherwise>
							<img src="upload/no_hart.jpg" id="img_result" onclick="like_up();" style="cursor:pointer; width: 40px;" align="middle">
							<div id="result4"> 좋아요:${count_like}</div>
						</c:otherwise>
					</c:choose>
				  </c:when>
				  
				  <c:otherwise>
					<img src="upload/no_hart.jpg" onclick="like_up_login();" style="cursor:pointer; width: 40px;" align="middle">
					<div id="result4"> 좋아요:${count_like}</div>
				  </c:otherwise>
				</c:choose>
		 	</td>
		 </tr>
		<tr>
			<td style="text-align: center;">
				<c:choose>
					<c:when test="${loginUser.id == detail.id}">
						<input type="button" value="수정하기" onclick="location.href='go_update_detail?num=${detail.num}';">
						<input type="button" value="삭제하기" onclick="location.href='delete_content?num=${detail.num}';">
						
						
						<tr>
							<td style="text-align: center;">
								<br>
								<input type="button" value="확인" onclick="back_content()">
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<input type="button" value="확인" onclick="back_content()">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</form>
<form name="frm_read" id="frm_read">
<input type="hidden" name="num" id="num" value="${detail.num }">
<input type="hidden" name="id" id="id" value="${loginUser.id}">
</form>
<%@ include file="../recontent/recontent.jsp" %>

</body>
</html>