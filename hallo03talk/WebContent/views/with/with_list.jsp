<%@page import="com.h3.with.vo.PageVo"%>
<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	
	ArrayList<WithVo> voList = (ArrayList<WithVo>) request.getAttribute("voList");
	
	PageVo pv = (PageVo)request.getAttribute("pageVo");
	
	int currentPage = pv.getCurrentPage();
	int startPage = pv.getStartPage();
	int endPage = pv.getEndPage();
	int maxPage = pv.getMaxPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#container {
		padding: 3rem;
	}
	
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
	
	#align-dropdown {
		display: flex;
		justify-content: flex-end;
	}
	
	/* 여기서부터 아이템들 */
	#content-items {
		margin: 1rem;
		width: 100%;
		height: 120px;
	}
	
	#content-items:hover {
		background-color: bisque;
		cursor: pointer;;
	}
	
	#content-items * {
		margin: 10px;
	}
	
	#content-items-title {
		width: 40%;
	}
</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<main>
		<div id="container" class="container-xxl">

			<div id="container-header">
				<h1 class="chi">동행</h1>
				<h6 class="chi">쉽고 빠르게 같이 동행할 여행친구 찾기</h6>
				<c:if test="${not empty sessionScope.travelerLoginMember}">
					<button class="btn btn-outline-warning chi" onclick = "location.href = '<%= request.getContextPath()%>/with/post'">글쓰기</button>				
				</c:if>
			
			</div>
			<hr>
			<div class="dropdown" id="align-dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">최신순</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="<%= request.getContextPath()%>/with/list">최신순</a></li>
					<li><a class="dropdown-item" href="<%= request.getContextPath()%>/with/list?s=v">조회순</a></li>
					<li><a class="dropdown-item" href="<%= request.getContextPath()%>/with/list?s=a">모집중</a></li>
				</ul>
			</div>

			<div id="contents">

				<%
					for (WithVo vo : voList) {
						String content = vo.getContent();
						String imgPath = null;
						int findex = content.indexOf("<img src=\"") + "<img src=\"".length();
						
						if(content.indexOf("<img src=\"") != -1){
							int lindex = content.indexOf("\"",findex);
							imgPath = content.substring(findex,lindex);
						}
				%>
				<div id="content-items" class="d-flex" onclick="location.href = '<%= request.getContextPath()%>/with/detail?no=<%=vo.getNo()%>'">
						
						<%if(imgPath == null){ %>
							<img src="/hallo03talk/resources/img/with/with_board_defaultimg.jpg" class="rounded" height="100" width="150">
						<%}else{ %>
							<img src="<%=imgPath %>" class="rounded" height="100" width="150">
						<%} %>
						
						<div id="content-items-title">
							<h5><%=vo.getTitle()%></h5>
							<div class="ms-3">
							<%for(String tag : vo.getTag() ){ %>
								<!-- 태그검색 -->
								<a href = "" class="m-0"><%=tag %></a>
							<%} %>
							</div>
							<div class="d-flex align-items-center">
								<img src="/hallo03talk/resources/img/with/with_detail_cal.svg"
									width="16px" height="16px" class="me-1"> <span><%=vo.getStart_date()%>
									~ <%=vo.getEnd_date()%></span>
							</div>
						</div>
						<div class="d-flex align-items-center flex-shrink-0">
							<svg width="24px" height="24px" viewBox="0 0 24 24" version="1.1"
								xmlns="http://www.w3.org/2000/svg" class="forum-icon-fill">
	              				<path
									d="M11.5,5 C17.293,5 20.813,11.041 20.918,11.298 L20.918,11.298 L21,11.5 L20.918,11.701 C20.813,11.959 17.293,18 11.5,18 C5.707,18 2.187,11.959 2.082,11.701 L2.082,11.701 L2,11.5 L2.082,11.298 C2.187,11.041 5.707,5 11.5,5 Z M11.5,6.036 C6.92,6.036 3.565,10.488 3.089,11.499 C3.567,12.51 6.932,16.964 11.5,16.964 C16.08,16.964 19.435,12.512 19.911,11.5 C19.433,10.49 16.068,6.036 11.5,6.036 Z M11.5,8.25 C13.2949254,8.25 14.75,9.70507456 14.75,11.5 C14.75,13.2949254 13.2949254,14.75 11.5,14.75 C9.70507456,14.75 8.25,13.2949254 8.25,11.5 C8.25,9.70507456 9.70507456,8.25 11.5,8.25 Z M11.5,9.25 C10.2573593,9.25 9.25,10.2573593 9.25,11.5 C9.25,12.7426407 10.2573593,13.75 11.5,13.75 C12.7426407,13.75 13.75,12.7426407 13.75,11.5 C13.75,10.2573593 12.7426407,9.25 11.5,9.25 Z"
									id="Color">
	              				</path>
	            			</svg>
							<span><%=vo.getCnt() %></span> <img
								src="/hallo03talk/resources/img/with/with_board_defaultMan.png"
								width="24px" height="24px"> <span><%=vo.getTraveler_no()%></span>
							<%if("Y".equals(vo.getStatus())) {%>
								<span class="rounded bg-warning align-self-center p-1" id="mojip">모집중</span>					
							<%} else { %>						
								<span class="rounded bg-light align-self-center p-1" id="magam">마감됨</span>
							<%} %>
							<span class="text-black-50"><%=vo.getEnroll_date()%></span>
						</div>
					</div>
					<hr>
				<%} %>

			</div>
			
			<nav id="page-area">
				<ul class="pagination d-flex justify-content-center">
					<%if(currentPage != 1){ %>
						<li class="page-item">
							<a class="page-link" href="<%=request.getContextPath()%>/with/list?p=<%=currentPage-1%>&s=${sort}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					<%} %>
					
					<% for(int i = startPage; i <= endPage; ++i) {%>
						<%if(i == currentPage){%>
							<li class="page-item active"><a class="page-link" href="#"><%=i%></a></li>
						<%} else {%>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/with/list?p=<%=i%>&s=${sort}"><%=i%></a></li>
						<%} %>
					<%} %>
					
					<%if(currentPage != maxPage){ %>
						<li class="page-item">
							<a class="page-link" href="<%=request.getContextPath()%>/with/list?p=<%=currentPage+1%>&s=${sort}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					<%} %>
				</ul>
			</nav>
		</div>
	</main>
	

	<footer></footer>
	<script type="text/javascript">
		<% if(alertMsg !=null){%>
			alert('<%=alertMsg %>');
		<%}%>
	</script>
</body>
</html>