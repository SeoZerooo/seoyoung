<%@page import="com.h3.placeReview.vo.PlaceReviewVo"%>
<%@page import="com.h3.community.vo.CommVo"%>
<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    ArrayList<PlaceVo> pvoList = (ArrayList<PlaceVo>)request.getAttribute("pvoList");
    ArrayList<CommVo> cvoList = (ArrayList<CommVo>)request.getAttribute("cvoList");
    ArrayList<PlaceReviewVo> rvoList = (ArrayList<PlaceReviewVo>)request.getAttribute("rvoList");
    
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

</style>

<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>

</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">

                        
                        <div class="inner">

                        <br><br><br><br><br>
                        <div class="text" style=" width: 50%; float: left;" >
                            <h1 style="margin-left: 60px;"><b>검색</b></h1>
                        </div>
                        <div style=" width: 45%; float: right; margin-top: 20px; margin-right: 60px;">
                        </div>

                        <br><br><br>
						<form action="" id="pform">
                        <input type="searchbox" value="" class="placeSearch" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;">
						</form>

                        <br><br>
                        
                        <button type="button" class="btn btn-warning" id="send" style="float:right; margin-right: 65px; ">검색</button>
                        <button onclick ="location.href='<%=contextPath%>/search/searchPlace'" type="button" class="btn btn-primary" style="float:left; margin-left: 65px; ">이전</button>
                        

                        <br><br><br><br><br>

                        <h1 style="margin-left: 60px;  font-family: somi; font-size: 60px; font-weight: lighter;"><b>장소</b></h1>
                        <br>
                        <div class ="d-flex flex-wrap w-100 " style = " margin-left : 5%;">
                        <%for(int i = 0 ; i < pvoList.size(); i++){%>
                        <div class="row" >
                            <div class="col-md-4 ">
                                <div class="card" onclick ="location.href ='/hallo03talk/place/one?placeNo=<%=pvoList.get(i).getNo()%>' " style="width: 18rem; height : 300px; float: none; margin-top:20px; margin-right : 5px;">
                                    <img src="/hallo03talk/resources/upload/place/<%= pvoList.get(i).getPhotoName() %>" class="card-img-top" alt="">
                                    <div class="card-body">
                                    <h5 class="card-title"><%= pvoList.get(i).getName() %></h5>
                                    <h6 class="card-subtitle mb-2 text-muted"><%= pvoList.get(i).getAddress() %></h6>
                                    <p class="card-text"><%= pvoList.get(i).getContent() %></p>

                               
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}%>
                        </div>

                        <br>
                        <br>
                        <hr style="width: 90%; margin: 0 auto;">
                        <br><br>

                        <h1 style="margin-left: 60px; font-family: somi; font-size: 60px; font-weight: lighter;"><b>커뮤니티</b></h1>
                        <br>
                        
                        <div class="d-flex flex-wrap" style="width: 100%; padding-left : 5%;">
                        <%for(int i = 0 ; i < cvoList.size(); i++){%>
					        <div class="border rounded" style="width: 17rem; height: 100px; margin : 5px;" onclick ="location.href ='/hallo03talk/comm/detail?no=<%=cvoList.get(i).getNo()%>' ">
					            <div ><h4 style ="margin : 5px"><%= cvoList.get(i).getTitle() %></h4></div>
					            <div style ="margin : 5px"><%= cvoList.get(i).getWriter() %></div>
					            <div style ="margin : 5px"><%= cvoList.get(i).getEnroll_date() %></div>
					           
					        </div>
					        <%} %> 
					    </div>

<%--                         <div class="row">
                        <%for(int i = 0 ; i < cvoList.size(); i++){%>
                            <div class="col-4">
                                <div class="card" style="width: 18rem; float: none; margin:0 auto;">
                                    <div class="card-body"  onclick ="location.href ='/hallo03talk/comm/detail?no=<%=cvoList.get(i).getNo()%>' ">
                                    <h5 class="card-title"><%= cvoList.get(i).getTitle() %></h5>
                                    <h6 class="card-subtitle mb-2 text-muted"><%= cvoList.get(i).getWriter() %></h6>
                                    <p class="card-text"><%= cvoList.get(i).getEnroll_date() %></p>
                                    </div>
                                </div>
                            <%} %>
                            
                            </div> 

                        </div>--%>
                        
                        
                        <br>
                        <br>

                    </div>
                    </div>

					</div>
			</main>


	<footer></footer>

</body>
</html>