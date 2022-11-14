<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String alertMsg = (String)session.getAttribute("alertMsg");
session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="contextPath" value = "<%=request.getContextPath() %>"></c:set>
<c:choose>
	<c:when test="${view == 'all' || empty view }"><c:set var="view_k" value="전체보기"></c:set></c:when>
	<c:when test="${view == 'notice' }"><c:set var="view_k" value="공지사항"></c:set></c:when>
	<c:when test="${view == 'qna' }"><c:set var="view_k" value="질문답변"></c:set></c:when>
	<c:when test="${view == 'free' }"><c:set var="view_k" value="자유게시판"></c:set></c:when>
</c:choose>

<style>
#container-header {
	display: flex;
	align-items: baseline;
	justify-content: space-between;
}

.chi:nth-child(1) {
	flex-grow: 1;
}

.chi:nth-child(2) {
	flex-grow: 50;
}

.chi:nth-child(3) {
	flex-grow: 0;
}

#container {
	padding: 3rem;
}


</style>
</head>

<body>


	<main>
		<div id="container" class="container-xxl d-flex flex-column">
			<div id="container-header">
				<h1 class="chi">커뮤니티</h1>
				<h6 class="chi">맛집 추천글, 장소 추천등 여행자들의 소통</h6>
				<c:if test="${not empty travelerLoginMember}">
					<button class="btn btn-outline-warning chi" onclick="location.href='${contextPath}/comm/post'">글쓰기</button>
				</c:if>
				<c:if test="${not empty loginAdmin}">
					<button class="btn btn-outline-warning chi" onclick="location.href='${contextPath}/comm/notice/post'">공지사항 작성</button>
				</c:if>
			</div>
			<hr>
			<div class="d-flex flex-grow-1">
				<!-- 사이드 네비게이션 -->
				<div class="h-100" style="width: 20%; margin-right: 3rem;">
					<ul class="list-group list-group-flush">
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=all&p=&s='">전체보기</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=qna&p=&s='">질문답변</li>
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=free&p=&s='">자유게시판</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=notice&p=&s='">공지사항</li>
					</ul>
				</div>
				<div class="border rounded h-100 d-flex flex-column" style="width: 80%; padding: 1rem;">
				
					<div class="d-flex"> <!-- 소제목 -->
						<h5 class="flex-grow-1">
							<c:choose>
								<c:when test="${view == 'all' || empty view }">전체보기</c:when>
								<c:when test="${view == 'notice' }">공지사항</c:when>
								<c:when test="${view == 'qna' }">질문답변</c:when>
								<c:when test="${view == 'free' }">자유게시판</c:when>
							</c:choose>
						</h5>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-sm" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">최신순</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="${contextPath}/comm/list?view=${view}&p=1&">최신순</a></li>
								<li><a class="dropdown-item" href="${contextPath}/comm/list?view=${view}&p=1&s=v">조회순</a></li>
							</ul>
						</div>
					</div>
					<hr>
					
					<div class="flex-grow-1"> <!-- 내용 테이블-->
						<table class="table table-striped table-hover" style="table-layout: fixed">
							<thead>
								<tr>
									<th scope="col" style="width: 24px">#</th>
									<th scope="col" style="width: 500px">제목</th>
									<th scope="col">작성자</th>
									<th scope="col" style="width: 65px">조회수</th>
									<th scope="col">작성일</th>
								</tr>
							</thead>
							<tbody>
								<!-- 공지사항 먼저 보여주기 -->
								<c:forEach  var="vo" items="${voList}">
									<c:if test="${vo.category eq 'notice' }">
										<c:choose>
											<c:when test="${vo.category eq 'notice' }">
												<c:set var="view_t" value="[공지사항] "></c:set>
											</c:when>
											<c:when test="${vo.category eq 'qna' }">
												<c:set var="view_t" value="[질문답변] "></c:set>
											</c:when>
											<c:when test="${vo.category eq 'free' }">
												<c:set var="view_t" value="[자유게시판] "></c:set>
											</c:when>
										</c:choose>
										<tr class="table-warning" onclick="location.href='${contextPath}/comm/detail?no=${vo.no}'" style="cursor:pointer;"><!-- 상세보기 요청 추가 -->
											<th scope="row" class="align-middle">${vo.no} </th>
											<td class="overflow-hidden text-truncate align-middle"><span style="font-size:small;">${view_t}</span>${vo.title}</td>
											<td class="align-middle">${vo.writer}</td>
											<td class="align-middle">${vo.cnt}</td>
											<td style = "font-size:small;" class="align-middle">${vo.enroll_date}</td>
										</tr>
									</c:if>
								</c:forEach>
								
								<!-- 나머지 보여주기 -->
								<c:forEach  var="vo" items="${voList}">
									<c:if test="${vo.category ne 'notice' }">
										<c:choose>
											<c:when test="${vo.category eq 'notice' }">
												<c:set var="view_t" value="[공지사항] "></c:set>
											</c:when>
											<c:when test="${vo.category eq 'qna' }">
												<c:set var="view_t" value="[질문답변] "></c:set>
											</c:when>
											<c:when test="${vo.category eq 'free' }">
												<c:set var="view_t" value="[자유게시판] "></c:set>
											</c:when>
										</c:choose>
										<tr style="cursor:pointer;"  onclick="location.href='${contextPath}/comm/detail?no=${vo.no}'"><!-- 상세보기 요청 추가 -->
											<th scope="row" class="align-middle">${vo.no} </th>
											<td class="overflow-hidden text-truncate align-middle"><span style="font-size:small;">${view_t}</span>${vo.title}</td>
											<td class="align-middle">${vo.writer}</td>
											<td class="align-middle">${vo.cnt}</td>
											<td style = "font-size:small;" class="align-middle">${vo.enroll_date}</td>
										</tr>
									</c:if>
								</c:forEach>
								
								
							</tbody>
						</table>
					</div>
					
					<hr>
					
					<div><!-- 페이지네이션  -->
						<nav aria-label="Page navigation" >
							<ul class="pagination d-flex justify-content-center">
								
								<c:if test="${pageVo.currentPage != 1}">
									<li class="page-item">
										<a class="page-link" href="${contextPath}/comm/list?view=${view}&p=${pageVo.currentPage-1}&s=${sort}" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:if>
								
								<c:forEach begin="${pageVo.startPage}" step="1" end="${pageVo.endPage}" var="i">
									<c:choose>
										<c:when test="${i eq pageVo.currentPage}">
											<li class="page-item active"> <a class="page-link">${i}</a> </li>
										</c:when>
										<c:otherwise>
											<li class="page-item"> <a class="page-link" href="${contextPath}/comm/list?view=${view}&p=${i}&s=${sort}">${i}</a> </li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
								<c:if test="${pageVo.currentPage != pageVo.endPage}">
									<li class="page-item">
										<a class="page-link" href="${contextPath}/comm/list?view=${view}&p=${pageVo.currentPage+1}&s=${sort}" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
									</li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</main>


	<footer></footer>
<script type="text/javascript">
		<%if (alertMsg != null) {%>
			alert('<%=alertMsg%>');
		<%}%>
		
	</script>
</body>
</html>