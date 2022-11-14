<%@page import="com.h3.admin.vo.AdminVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin");
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
  <head>
  	<link rel="icon" href="<%=request.getContextPath()%>resources/img/main_favi.png" />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>할로영삼 talk</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" />
    <!--head íê·¸ ë´ ì¶ê°-->
    <link rel="icon" href="resources/img/main_favi.png" />
     <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
   
   
   
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
        max-height: 100vh;
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
      .menu1 li a:hover {
        opacity: 0.5;
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
        margin-top:250px;
        
      }
      #withlist ul li {
        margin-left: 60px;
        margin-right: 60px;
        
      }
      #footer ul li:hover {
        opacity: 0.5;
      }
      .btn{
      color:#fff;
      }
      /* ---------로그인------------------------------- */
	.main input[type=radio] {
		display: none;
	}
	#tab-1:checked ~ .tab label:nth-child(1),
	#tab-2:checked ~ .tab label:nth-child(2),
	#tab-3:checked ~ .tab label:nth-child(3) {
		background-color: rgba(0, 0, 0, 0.2);
	  box-shadow: none;
	}
	.content > div {
		display: none;
	}
	#tab-1:checked ~ .content div:nth-child(1),
	#tab-2:checked ~ .content div:nth-child(2){
		display: block;
	}
	.tab {
	  overflow: hidden;
	 
	}
	.tab label {
	    font-size: 18px;
	    cursor: pointer;
	    /* float: left; */
	    width: 120px;
	    text-align: center;
	    padding: 15px 0;
	    text-transform: uppercase;
	    font-weight: bold;
	    letter-spacing: 2px;
	    user-select: none;
	    -webkit-user-select: none;
	    margin-top: 50px;
	}
	    /* ----------------------------------------------- */
	    .main{
	        height: 500px;
	    }
	  /* ------ */
	  .login-page {
	    padding: 13% 0 0; 
	  }
	 .main {
	  position: relative;
	  z-index: 1;
	  width: 480px;
	  height: 390px;
	  margin: 0 auto 100px;
	  margin-top: 50px;
	 
	  padding: 45px;
	  text-align: center;
	  border-radius: 25px;
	  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
	}
	  
	    .form input {
	  font-family: "Roboto", sans-serif;
	  outline: 0;
	  background: #f2f2f2;
	  width: 100%;
	  border: 0;
	  margin: 0 0 15px;
	  padding: 25px;
	  box-sizing: border-box;
	  font-size: 14px;
	  border-radius: 6px;
	}
	.form button {
	  font-family: "Roboto", sans-serif;
	  text-transform: uppercase;
	  outline: 0;
	  background: #4CAF50;
	  border-radius: 6px;
	  width: 100%;
	  border: 0;
	  padding: 25px;
	  color: #FFFFFF;
	  font-size: 14px;
	  -webkit-transition: all 0.3 ease;
	  transition: all 0.3 ease;
	  cursor: pointer;
	}
	.form button:hover{
	  background-color: green;
	}
	    .footer>input{
	    background-color: skyblue;
	    width: 191px;
	    margin-top: 13px;
	    border-radius: 6px;
	    
	}
    
    .modal-content h3{
     font-family: "Somi";
     margin:auto;
     padding-top: 30px;
    }
    .login-page h5{
     font-family: "Somi";
     margin:auto;
    
     color:black;
    }
    .modal-content{
    border-radius: 25px;
    width: 75%;
    margin-left: 55px;
    }
    
   
    </style>

    <meta charset="UTF-8" />
    <title>할로 영삼 TALK</title>
  </head>
  <body>
    <img id="img" src="../../../resources/img/main_2.jpg" alt="" />
    <header>
      <nav>
        <ul class="menu1">
         <%if(loginAdmin == null){%>
          <li><a class="btn" onclick="location.href='/hallo03talk/comm/list?view=notice'">공지사항</a></li>
          <li><a  href="" id="testBtn" class="btn" >로그인</a></li>
          <li><a   onclick="location.href='/hallo03talk/search/searchPlace'" class="btn" >검색</a></li>

           <%} else {%>
   	
    	<li><a class="btn" onclick="location.href='/hallo03talk/comm/list?view=notice'">공지사항</a></li>
    	<li><a  onclick="location.href='/hallo03talk/search/searchPlace'" class="btn" >검색</a></li>
    	<li class="btn"  onclick="location.href='/hallo03talk/admin/placeAdmin?p=1'">숙소관리</li>
    	<li><a  class="btn"  onclick="location.href='/hallo03talk/admin/reportContent?p=1'">신고관리</a></li>
          <li><a  href="/hallo03talk/admin/logout"  class="btn" >로그아웃</a></li>
          <li class=""><%=loginAdmin.getName() %> 님 환영합니다</li>
    	
   <% }%>
        </ul>
      </nav>
      <div id="logo">
        <h1><a href="">할로영삼talk</a></h1>
      </div>
    </header>
    <section id="tripple">
      <div id="middle">할로영삼talk</div>
    </section>
    <div id="middle2">
    
     <br />
    </div>
  
    <div id ="withlist">
   
<ul>
       <ul>
        |
        <li><a onclick="location.href='/hallo03talk/with/list'">동행</a></li>
        |

        <li><a onclick="location.href='/hallo03talk/place/list'">장소</a></li>
        |
        <li><a onclick="location.href='/hallo03talk/party/list'">이벤트</a></li>
        |
         <li><a href="">커뮤니티</a></li>
        |
      </ul>
      </ul>
     
    
   
   </div>

  <!-- 회원가입 확인 Modal-->
	<div class="modal fade" id="testModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<h3 style="color:black;  font-family: "Somi";">할로영삼talk</h3>
				<div class="modal-header">
					
						
					
					 <div class="main">
	            <input type="radio" id="tab-1" name="show" checked/>
	            <input type="radio" id="tab-2" name="show" />
	            <input type="radio" id="tab-3" name="show" />
	           
	
	            <div class="content">
	
	              <div class="content-dis">
	                <div class="login-page">
	                <h5>나는 관리자다..</h5>
	                    <div class="form">
	                        <form class="login-form" action="<%=contextPath%>/admin/login" method="post">
	                                <input type="text" placeholder="아이디" name="adminId" />
	                                <input type="password" placeholder="비밀번호" name="adminPwd" />
	                                <button>로그인</button>
	        
	                                
	                        </form>
	                    </div>
	                  </div>
	              </div>
	
	
	              <div class="content-dis">
	                <div class="login-page">
	                    <div class="form">
	                        <form class="login-form">
	                                <input type="text" placeholder="아이디" />
	                                <input type="password" placeholder="비밀번호" />
	                                <button>로그인</button>
	        
	                                
	                        </form>
	                    </div>
	                  </div>
	              </div>
	
				</div>
				
		</div>
	</div>
	</div>
	</div>
	</div>


	
	<script>
		$('#testBtn').click(function(e){
			e.preventDefault();
			$('#testModal').modal("show");
		});
	</script>
	 <script>
		<%if(alertMsg!=null){%>
		alert('<%=alertMsg%>');
		<%}%>
		
	</script>
</body>
  </body>
</html>

