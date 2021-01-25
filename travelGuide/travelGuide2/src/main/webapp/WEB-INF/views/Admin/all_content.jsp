<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
	안녕하세요 게시판 부분입니다
	<h3>게시글 전체 목록 불러오기</h3>
	<form method="get" name="formm">
	<h3>운영자 게시판</h3>
	<div class="search">
		<h3>
			게시글 검색:
			<select name="searchType">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="write">작성자</option>
				<option value="t_c">제목 + 내용</option>
			</select>
			
			<input type="text" name="keyword" id="keywordInput">
			<button name="searchBtn" id="searchBtn" onclick="go_search()">검색</button>
		</h3>
	</div>
	<br><br>
	<table class="content_table">
		<colgroup>
			<col style="width:10%;"/>
			<col style="width:auto%;"/>
			<col style="width:15%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
		</colgroup>
		<tr id="header">
			<th>지역</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty contentList }">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty contentList }">
				<c:forEach var="list" items="${contentList }">
					<tr id="body">
						<td>
							<c:choose>
								<c:when test="${list.c_kind == '0' }">서울</c:when>
								<c:when test="${list.c_kind == '1' }">부산</c:when>
								<c:when test="${list.c_kind == '2' }">대구</c:when>
								<c:when test="${list.c_kind == '3' }">인천</c:when>
								<c:when test="${list.c_kind == '4' }">광주</c:when>
								<c:when test="${list.c_kind == '5' }">대전</c:when>
								<c:when test="${list.c_kind == '6' }">울산</c:when>
								<c:when test="${list.c_kind == '7' }">세종</c:when>
								<c:when test="${list.c_kind == '8' }">경기</c:when>
								<c:when test="${list.c_kind == '9' }">강원</c:when>
								<c:when test="${list.c_kind == '10' }">충북</c:when>
								<c:when test="${list.c_kind == '11' }">충남</c:when>
								<c:when test="${list.c_kind == '12' }">전북</c:when>
								<c:when test="${list.c_kind == '13' }">전남</c:when>
								<c:when test="${list.c_kind == '14' }">경북</c:when>
								<c:when test="${list.c_kind == '15' }">경남</c:when>
								<c:when test="${list.c_kind == '16' }">제주</c:when>
								<c:otherwise>전체지역</c:otherwise>
							</c:choose>
						</td>
						<td><a href="oper_detail_content?num=${list.num}"><c:out value="${list.c_title }"></c:out></a></td>
						<td><c:out value="${list.name }"></c:out></td>
						<td><c:out value="${list.c_count }"></c:out></td>
						<td><fmt:formatDate value="${list.c_regdate }" pattern="yyyy-MM-dd HH:mm"/></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<p>
		<input type="button" value="게시글 전체 목록" onclick="admin_all_list();">
	</p>
	
	<div >
		<ul>
			<c:if test="${pageMakers.prev }">
				<li><a href="UserContent_list${pageMakers.makeSearch(pageMakers.startPage-1)}">이전</a></li>
			</c:if>
			
			<c:forEach begin="${pageMakers.startPage }" end="${pageMakers.endPage }" var="idx">
				<li><a href="UserContent_list${pageMakers.makeSearch(idx)} ">${idx }</a></li>
			</c:forEach>
			
			<c:if test="${pageMakers.next && pageMakers.endPage > 0}">
				<li><a href="UserContent_list${pageMakers.makeSearch(pageMakers.endPage+ 1)}">다음</a></li>
			</c:if>
		</ul>
	</div>
</form>
</body>
</html>