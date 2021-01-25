<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style="padding: 20px;">
	<h2>댓글</h2>
	<br>
	<form name="recontent" id="recontent">
		<input type="hidden" name="re_id" id="re_id" value="${loginUser.id }">
		<input type="hidden" name="re_num" id="re_num" value="${detail.num }">
		
		<div id="text_Area">
			<textarea name="re_content" id="re_content" rows="30" cols="20" style="width: 1000px; height: 200px; resize: none;"></textarea>
		</div>
		
		<c:choose>
			<c:when test="${loginUser.id == null }">
				<input type="button" style="position: relative; top:10px; left: 920px" onclick="go_check();" value="등록">
			</c:when>
			<c:otherwise>
				<input type="button" style="position: relative; top:10px; left: 920px" onclick="go_insert();" value="등록">
			</c:otherwise>
		</c:choose>
	</form>
	
	<div class="ajax_re_id" id="ajax_re_id">
	<c:choose>
		<c:when test="${empty recontentlist }">
			<div>데이터가 없습니다</div>
		</c:when>
		<c:when test="${!empty recontentlist }">
			<c:forEach var="list" items="${recontentlist }" varStatus="status">
				<c:choose>
					<c:when test="${status.index == 0}">
						<div>
						____________________________________<br>
						${list.re_id } / ${list.re_regdate}
						<c:choose>
							<c:when test="${loginUser.id == list.re_id }">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="re_recontent(${list.re_number});">수정</a>&nbsp;
								<a onclick="re_delete();">삭제</a><br>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
							<div id="re_content_textArea_${list.re_number}">
								${list.re_content }<br>
							</div>
						____________________________________
						</div>
					</c:when>
					<c:otherwise>
						<div>
						${list.re_id } / ${list.re_regdate}
							<c:choose>
								<c:when test="${loginUser.id == list.re_id }">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="re_recontent(${list.re_number});">수정</a>&nbsp;
									<a onclick="re_delete();">삭제</a><br>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
							<div id="re_content_textArea_${list.re_number}">
								${list.re_content }<br>
							</div>
						____________________________________
						</div>
					</c:otherwise>	
				</c:choose>
			</c:forEach>
		</c:when>
	</c:choose>
	</div>
</div>
</body>
</html>