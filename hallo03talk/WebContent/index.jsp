<%@page import="com.h3.boss.vo.BossVo"%>
<%@page import="com.h3.traveler.vo.TravelerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String contextPath =request.getContextPath();
   
	TravelerVo loginTraveler = (TravelerVo)session.getAttribute("travelerLoginMember");
	BossVo loginBoss = (BossVo)session.getAttribute("BossLoginMember");
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>
    

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>할로영삼 talk</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" />
    <!--head íê·¸ ë´ ì¶ê°-->
    <link rel="icon" href="resources/img/main_favi.png" />
    <style>
      @font-face {
        font-family: "Somi";
        src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff")
          format("woff");
        font-weight: normal;
        font-style: normal;
      }
      @font-face {
        font-family: "KyoboHandwriting2020A";
        src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2112@1.0/KyoboHandwriting2020A.woff")
          format("woff");
        font-weight: normal;
        font-style: normal;
      }
      * {
        margin: 0;
        padding: 0;
      }
      html,
      body {
      	width:100%;
        height: 100%;
      }
      #img {
        position: fixed;
        background-size: cover;
        width: 100%;
        height: 100%;
        z-index: -10;
        filter: brightness(30%);
       	
      }
      a {
        text-decoration: none;
        color: #fff;
      }
      body {
        color: white;
        margin: 0;
        padding: 0;
        font-size: 1.2em;
        font-family: "Hack";
      }
      header {
        padding: 20px;
      }
      section {
        padding: 20px;
        color: black;
        display: flex;
        flex-direction: row-reverse;
      }

      section > div {
        margin: auto;
        width: 150px;
        height: 70px;
        padding: 10px;
      }
      ul {
        margin: 0;
        padding: 0;
        list-style-type: none;
        float: right;
      }
      li {
        display: inline;
        margin: 0 20px 0 0;
      }

      #canvas_section {
        display: block;
      }
      #canvas {
        margin: 10px;
        padding: 10px;

        border: thin inset #aaaaaa;
      }
      #logo h1 {
        font-family: "Somi";
        font-weight: normal;
        margin-left: 20px;
      }
      .menu1 li {
      }
      .menu1 li a:hover {
        opacity: 0.5;
        cursor:pointer
      }
      #middle {
        font-family: "Somi";
        color: #fff;
        font-size: 70px;
        width: 400px;
        margin-top: 70px;
      }
      #middle2 {
        width: 100%;
        padding-top: 40px;
        justify-content: center;
        margin: auto;
        text-align: center;
        font-family: "KyoboHandwriting2020A";
        letter-spacing: 10px;
        text-shadow: 10px 10px 10px gray;
      }
      .search-box {
        padding: 10px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        height: 30px;
        background-color: #fff;
        margin-top: 100px;
        opacity: 0.5;
        border-radius: 30px;
        transition: 0.4s;
        width: 682px;
      }
      .search-btn {
        text-decoration: none;
        float: right;
        width: 30px;
        height: 30px;
        background-color: #fff;
        border-radius: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        color: #51e3d4;
      }
      .search-txt {
        display: flex;
        padding: 0;
        width: 0px;
        border: none;
        background: none;
        outline: none;
        float: left;
        font-size: 1rem;
        line-height: 30px;
        transition: 0.4s;
      }
      .search-box > .search-txt {
        width: 640px;
        padding: 0 6px;
      }
      #withlist {
        font-family: "KyoboHandwriting2020A";
        width: 100%;
        display:flex;
        font-size: 26px;
        justify-content:center;
        margin-top:300px;
        
      }
      #withlist ul li {
        margin-left: 60px;
        margin-right: 60px;
        cursor:pointer;
        
        
      }
       #withlist ul li:hover{
       opacity:0.5;
        
        
      }
      #footer ul li a:hover {
        opacity: 0.5;
      }
    </style>

    <meta charset="UTF-8" />
    <title>할로 영삼 TALK</title>
  </head>
  <body>
    <img id="img" src="resources/img/main_2.jpg" alt="" />
    <header>
      <nav>
      <%if (loginTraveler== null && loginBoss== null){%>
        <ul class="menu1">
          <li><a onclick="location.href='/hallo03talk/comm/list?view=notice'">공지사항</a></li>
          <li><a onclick="location.href='/hallo03talk/traveler/login'">로그인</a></li>
           <li><a  onclick="location.href='/hallo03talk/traveler/join'">회원가입</a></li>
        </ul>
        <%} %>
        <%if(loginTraveler!= null && loginBoss == null){%>
         <ul class="menu1">
          <li><%=loginTraveler.getName() %>님 환영 합니다~ ^^</li>
          <li><a onclick="location.href='/hallo03talk/comm/list?view=notice'">공지사항</a></li>
          <li><a onclick="location.href='/hallo03talk/traveler/myPage'">마이페이지</a></li>
           <li><a  onclick="location.href='/hallo03talk/member/logout'">로그아웃</a></li>
        </ul>
        <%} %>
         <%if(loginTraveler== null && loginBoss != null){%>
         <ul class="menu1">
          <li><%=loginBoss.getId() %>님 환영 합니다~ ^^</li>
          <li><a onclick="location.href='/hallo03talk/comm/list?view=notice'">공지사항</a></li>
          <li><a onclick="location.href='/hallo03talk/boss/myPage'">마이페이지</a></li>
           <li><a  onclick="location.href='/hallo03talk/member/logout'">로그아웃</a></li>
        </ul>
        <%} %>
      </nav>
      <div id="logo">
        <h1><a onclick="location.href='/hallo03talk">할로영삼talk</a></h1>
      </div>
    </header>
    <section id="tripple">
      <div id="middle">할로영삼talk</div>
    </section>
    <div id="middle2">
    
     <br />
    </div>
    <div class="search-box">
      <input type="text" class="search-txt" name="focus" placeholder="Type to search" />
      <a class="search-btn" href="#">
        <i class="fas fa-search"></i>
      </a>
    </div>
    <div id ="withlist">
<ul>
        |
        <li><a onclick="location.href='/hallo03talk/with/list'">동행</a></li>
        |


        <li><a onclick="location.href='/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0'">장소</a></li>
        |
        <li><a onclick="location.href='/hallo03talk/party/list?p=1'">이벤트</a></li>
        |
         <li><a onclick="location.href='/hallo03talk/comm/list'">커뮤니티</a></li>
        |
      </ul>
   </div>
      
  <script>
		<%if(alertMsg!=null){%>
		alert('<%=alertMsg%>');
		<%}%>
		
		
		
		
		
		
	</script>
  </body>
</html>
