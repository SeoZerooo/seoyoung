<%@page import="com.h3.with.vo.PageVo"%>
<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<WithVo> wvoList = (ArrayList<WithVo>) request.getAttribute("wvoList");

System.out.println(wvoList);

String contextPath = request.getContextPath();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<main>
		<div id="container" class="container-xxl">

			<div id="container-header">
				<h1 class="chi" style = "margin-left: 5%; margin-top : 30px">동행</h1>
				<h6 class="chi"style = "margin-left: 5%;">쉽고 빠르게 같이 동행할 여행친구 찾기</h6>
				    <br>
                    <input type="text" name="placeKeyword" class="placeSearch" value="" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;" placeholder="  검색어를 입력하세요.">
                        <br><br>
                        <button type="button" class="btn btn-warning" id="send" style="float:right; margin-right: 65px; ">검색</button>
                        <button onclick ="location.href='<%=contextPath%>/search/searchPlace'" type="button" class="btn btn-primary" style="float:left; margin-left: 65px; ">이전</button>
                    <br><br>
			</div>
			<hr style = "width: 90%; margin-left: 5%;">
			
			<div id="accordion" style="width: 90%; margin-left: 5%;">
			<%for(int i = 0 ; i < wvoList.size(); i++){%>
			  <div class="card">
			    <div class="card-header">
			      <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
			        <b><%= wvoList.get(i).getTitle() %></b> 
			        <br>
			        <h5 style = "margin"><%= wvoList.get(i).getStart_date()%> ~ <%= wvoList.get(i).getEnd_date()%></h5> 
			      </a>
			    </div>
			    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
			      <div class="card-body">
			        <%= wvoList.get(i).getContent() %>
		            <div style="text-align: right; margin-right: 30px;">
                           <a href="/hallo03talk/with/detail?no=<%=wvoList.get(i).getNo()%>" style="text-decoration: none; color: gray;">더보기...</a>
                    </div>
			      </div>
			    </div>
			  </div>
			  <%} %>
			  
			  <br><br><br>
			  

			
			</div>

	</main>


	<footer></footer>

</body>
</html>