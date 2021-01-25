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
<link href="css/content.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<form method="get" name="formm">
	<h3>이용자 게시판</h3>
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
	<h3> 글 목록</h3>
	<h3>게시글 쓰기(로그인이 되어있을 경우, 안되어있으면 로그인 페이지로)</h3>
	<ul class="area">
		<li><a href="Seoul">서울</a></li><li><a href="Busan">부산</a></li>
		<li><a href="Daegu">대구</a></li><li><a href="Incheon">인천</a></li>
		<li><a href="Gwangju">광주</a></li><li><a href="Daejeaon">대전</a></li>
		<li><a href="Ulsan">울산</a></li><li><a href="Sejong">세종</a></li>
		<li><a href="Gyeonggi">경기</a></li><li><a href="Gangwon">강원</a></li>
		<li><a href="Chungbuk">충북</a></li><li><a href="Chungnam">충남</a></li>
		<li><a href="Jeonbuk">전북</a></li><li><a href="Jeonnam">전남</a></li>
		<li><a href="Gyengbuk">경북</a></li><li><a href="Gyengnam">경남</a></li>
		<li><a href="Jeju">제주</a></li>
	</ul>
	<br><br>
	<table class="content_table">
		<colgroup>
			<col style="width:10%;"/>
			<col style="width:auto%;"/>
			<col style="width:15%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
		</colgroup>
		<tr id="table_head">
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
						<td><a href="detail_content?num=${list.num}&id=${loginUser.id}&re_num=${list.num}&re_id=${loginUser.id}"><c:out value="${list.c_title }"></c:out></a></td>
						<td><c:out value="${list.name }"></c:out></td>
						<td><c:out value="${list.c_count }"></c:out></td>
						<td><fmt:formatDate value="${list.c_regdate }" pattern="yyyy-MM-dd HH:mm"/></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<p>
		<input type="button" value="글쓰기" onclick="write_content();">
		<input type="button" value="게시글 전체 목록" onclick="go_content_list();">
	</p>
	
	<div >
		<ul id="pageing">
			<c:if test="${pageMaker.prev }">
				<li><a href="UserContent_list${pageMaker.makeSearch(pageMaker.startPage-1)}">이전</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<li><a href="UserContent_list${pageMaker.makeSearch(idx)} ">${idx }</a></li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="UserContent_list${pageMaker.makeSearch(pageMaker.endPage+ 1)}">다음</a></li>
			</c:if>
		</ul>
	</div>
</form>
</body>
</html>