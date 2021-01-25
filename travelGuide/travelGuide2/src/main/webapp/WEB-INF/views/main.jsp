<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="css/content.css" rel="stylesheet">
<link rel="stylesheet" href="css/main3.css" />
</head>
<body>
<%@ include file="header.jsp" %>

<section class="banner full">
	<c:choose>
		<c:when test="${empty bannerList }">
				데이터가 없습니다.
		</c:when>
		<c:when test="${!empty bannerList }">
			<c:forEach var="list" items="${bannerList }">
				
				<article style="cursor:pointer;" onclick="window.open('${list.b_link}');">
						<img src="upload/${list.b_image}" style="width: 500px; height: 200px;"/>
					<div class="inner">
						<header>
							<div style="font-size: 3vw">
								${list.b_main_title}
							</div>
							<div style="font-size: 2.3vw">
								${list.b_sub_title}
							</div>
						</header>
					</div>
				</article>
			</c:forEach>
		</c:when>
	</c:choose>
</section>

<div style="width: 600px; height: 400px; border: 1px solid black;">
<div style="text-align: center;"><h3>인기 게시글</h3></div>
<div style="text-align: right;"><a href="UserContent_list">+더보기</a></div>
<table class="content_table">
		<colgroup>
			<col style="width:10%;"/>
			<col style="width:60%;"/>
			<col style="width:30%;"/>
		</colgroup>
		<tr id="con_head">
			<th>순위</th><th style="text-align: center;">제목</th><th>작성자</th>
		</tr>
		<c:choose>
			<c:when test="${empty contentList }">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty contentList }">
				<c:forEach var="list" items="${contentList }" varStatus="status">
					<tr id="body">
						<td><c:out value="${status.count}"></c:out></td>
						<td style="text-align: center;"><a href="detail_content?num=${list.num}&id=${loginUser.id}"><c:out value="${list.c_title }"></c:out></a></td>
						<td><c:out value="${list.name }"></c:out></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</div>
<br><br><br>
			<script src="js/jquery.min.js"></script>
			<script src="js/jquery.scrollex.min.js"></script>
			<script src="js/skel.min.js"></script>
			<script src="js/util.js"></script>
			<script src="js/main.js"></script>

</body>
</html>