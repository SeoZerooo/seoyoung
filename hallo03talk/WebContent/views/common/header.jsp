<%@page import="com.h3.admin.vo.AdminVo"%>
<%@page import="com.h3.boss.vo.BossVo"%>
<%@page import="com.h3.traveler.vo.TravelerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
   
	TravelerVo loginTraveler2 = (TravelerVo)session.getAttribute("travelerLoginMember");
	BossVo loginBoss2 = (BossVo)session.getAttribute("BossLoginMember");
	AdminVo loginAdmin2 = (AdminVo)session.getAttribute("loginAdmin");
	
%>
<% String regAlert = (String)session.getAttribute("registerOk");
//알람창은 한번만!
session.removeAttribute("registerOk"); 
%>
<%String regAlert1 = (String)session.getAttribute("registerFail"); %>
 <!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>할로 영삼 talk</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="/hallo03talk/resources/css/style.css" rel="stylesheet" type="text/css" />
 <link rel="icon" href="resources/img/main_favi.png" />
  </head>
  <body>
    <!-- 헤더-->
     <%if (loginTraveler2== null && loginBoss2== null && loginAdmin2 == null){%>
    <header class="p-3 border-bottom">
      <div class="container">
        <div
          class="d-flex flex-item flex-wrap align-items-center justify-content-center justify-content-lg-start"
        >
          <a href="#" onclick="location.href='/hallo03talk'" class="nav-link px-2 link-secondary hallo"
            >할로영삼talk</a
          >
          <ul
            class="nav col-12 col-lg-auto ms-lg-auto mb-2 justify-content-center mb-md-0"
          >
            <li><a onclick="location.href='/hallo03talk/with/list'" class="nav-link px-2 link-dark">동행</a></li>
            <li><a onclick="location.href='/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0'" href="#" class="nav-link px-2 link-dark">장소</a></li>
            <li><a onclick="location.href='/hallo03talk/comm/list'" class="nav-link px-2 link-dark">커뮤니티</a></li>
          </ul>

          <div class="col-md-3 text-end">
            <button onclick="location.href='/hallo03talk/search/searchPlace'"
            
              class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 btn btn-warning"
              role="search"
            >
              검색
            </button>
            <button onclick="location.href='/hallo03talk/traveler/login'" type="button" class="btn btn-outline-primary me-2">
              Login
            </button>
            <button onclick="location.href='/hallo03talk/traveler/join'" type="button" class="btn btn-primary">Sign-up</button>
          </div>
        </div>
      </div>
    </header>
    <%} else if(loginAdmin2 != null){%>
    <header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="#" onclick="location.href='/hallo03talk/views/member/admin/adminPage.jsp'" class="nav-link px-2 link-secondary hallo"
            >할로영삼talk</a
          >
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
         <li><a href="#" onclick="location.href='/hallo03talk/with/list'" class="nav-link px-2 link-dark">동행</a></li>
            <li><a onclick="location.href='/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0'" href="#" class="nav-link px-2 link-dark">장소</a></li>
            <li><a href="#" onclick="location.href='/hallo03talk/comm/list'" class="nav-link px-2 link-dark">커뮤니티</a></li>
        </ul>

       <button
              class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 btn btn-warning"
              onclick="location.href='/hallo03talk/search/searchPlace'"
              role="search"
            >
              검색
            </button>
            <button onclick="location.href='/hallo03talk/admin/logout'" type="button" class="btn btn-outline-primary me-2">
              LogOut
            </button>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="<%=request.getContextPath()%>/resources/img/god.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small">
            <li><a onclick="location.href='/hallo03talk/admin/placeAdmin?p=1'"class="dropdown-item" href="#">숙소관리</a></li>
            <li><a onclick="location.href='/hallo03talk/admin/reportContent?p=1'"class="dropdown-item"g href="#">게시글 신고관리</a></li>
            <li><a onclick="location.href='/hallo03talk/admin/reportReply?p=1'"class="dropdown-item" href="#">댓글 신고관리</a></li>
            
            <li><hr class="dropdown-divider"></li>
            <li><a onclick="location.href='/hallo03talk/admin/logout'" class="dropdown-item" href="#">로그아웃</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
    <%} else{ %>
    
    
<header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="#" onclick="location.href='/hallo03talk'" class="nav-link px-2 link-secondary hallo"
            >할로영삼talk</a
          >
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
         <li><a href="#" onclick="location.href='/hallo03talk/with/list'" class="nav-link px-2 link-dark">동행</a></li>
            <li><a onclick="location.href='/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0'" href="#" class="nav-link px-2 link-dark">장소</a></li>
            <li><a href="#" onclick="location.href='/hallo03talk/comm/list'" class="nav-link px-2 link-dark">커뮤니티</a></li>
        </ul>

       <button
       onclick="location.href='/hallo03talk/search/searchPlace'"
              class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 btn btn-warning"
              role="search"
            >
              검색
            </button>
            <button onclick="location.href='/hallo03talk/member/logout'" type="button" class="btn btn-outline-primary me-2">
              LogOut
            </button>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small">
          <% if (loginTraveler2 != null) { %>
            <li><a class="dropdown-item" onclick="location.href='/hallo03talk/traveler/myPage'">마이페이지</a></li>
           <%} %>
           <% if (loginBoss2 != null) { %>
            <li><a class="dropdown-item" onclick="location.href='/hallo03talk/boss/myPage'">마이페이지</a></li>
            <%} %>
            <li><a class="dropdown-item" href="#" ></a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a onclick="location.href='/hallo03talk/member/logout'" class="dropdown-item" href="#">로그아웃</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
    <%} %>
    
   
    
    
  </body>
</html>