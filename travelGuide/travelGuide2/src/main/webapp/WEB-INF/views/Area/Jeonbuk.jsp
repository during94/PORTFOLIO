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
<link href="css/main3.css" rel="stylesheet">
</head>
<body>
	<h1>안녕하세요 전북 페이지 입니다.</h1>
	
	<a href="https://korean.visitseoul.net/index">서울 전체 정보</a><br>
	
	<a href="https://www.gangnam.go.kr/contents/tourgangnam/1/view.do?mid=FM010406">강남구</a>
	<a href="https://culture.gangdong.go.kr/web/portal/culture.do">강동구</a>
	<a href="http://www.gangbuk.go.kr/tour/index.do">강북구</a>
	<a href="http://www.gangseo.seoul.kr/site/munhwa/index.jsp">강서구</a>
	<a href="http://www.gwanak.go.kr/site/gwanak/area/areaMain.do?cateCont=Area02">관악구</a>
	<a href="https://www.gwangjin.go.kr/portal/main/contents.do?menuNo=200241">광진구</a>
	<a href="https://www.guro.go.kr/www/selectBbsNttList.do?bbsNo=678&key=2924&searchAditfield10=%EB%AC%B8%ED%99%94&">구로구</a>
	<a href="https://www.geumcheon.go.kr/portal/schdlWebList.do?key=624">금천구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">노원구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">도봉구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">동대문구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">동작구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">마포구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">서대문구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">서초구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">성동구</a>
	<a href="https://www.nowon.kr/www/info/info1/info1_01.jsp">성북구</a>
	
	<br><br><br><br><br><br><br><br><br><br>
	
	<form method="get" name="formm">
	<h3>전북 게시글</h3>
	<div class="search">
		<h3>
			게시글 검색:
			<select name="searchType">
				<option value="title" <c:out value="${scri.searchType eq 'title' ? 'selected' : ''}"/>>제목</option>
				<option value="content" <c:out value="${scri.searchType eq 'content' ? 'selected' : ''}"/>>내용</option>
				<option value="write" <c:out value="${scri.searchType eq 'write' ? 'selected' : ''}"/>>작성자</option>
				<option value="t_c" <c:out value="${scri.searchType eq 't_c' ? 'selected' : ''}"/>>제목 + 내용</option>
			</select>
			
			<input type="text" name="keyword" id="keywordInput" value="${scri.keyword }">
			<button name="searchBtn" id="searchBtn" onclick="searchBtn();">검색</button>
		</h3>
	</div>
	
	<table class="content_table">
		<colgroup>
			<col style="width:10%;"/>
			<col style="width:auto%;"/>
			<col style="width:15%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
		</colgroup>
		<tr id="con_head">
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
					<c:if test="${list.c_kind =='12'}">
						<tr id="body">
							<td>
							<c:choose>
								<c:when test="${list.c_kind == '12' }">전북</c:when>
								<c:otherwise>전체 지역</c:otherwise>
							</c:choose>
						</td>
							<td><a href="detail_content?num=${list.num}"><c:out value="${list.c_title }"></c:out></a></td>
							<td><c:out value="${list.name }"></c:out></td>
							<td><c:out value="${list.c_count }"></c:out></td>
							<td><fmt:formatDate value="${list.c_regdate }" pattern="yyyy-MM-dd hh:mm"/></td>
						</tr>
						</c:if>
					</c:forEach>
				</c:when>
			</c:choose>
			
	</table>
		<p>
			<input type="button" value="글쓰기" onclick="location.href='go_Area_write?c_kind=12'">
			<input type="button" value="게시글 전체 목록" onclick="go_content_list();">
		</p>
	<div >
		<ul>
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