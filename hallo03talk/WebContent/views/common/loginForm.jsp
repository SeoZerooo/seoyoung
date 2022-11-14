<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	 String idFind = (String)session.getAttribute("idFind");
	 
	 String alertMsg = (String)session.getAttribute("alertMsg");
	 session.removeAttribute("alertMsg");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <!-- CDN으로 추가하는 방법 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
 
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
	  height: 650px;
	  margin: 0 auto 100px;
	  margin-top: 150px;
	  margin-bottom: 150px;
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
    </style>
    
</head>
<body>


		<%@ include file="/views/common/header.jsp"%>
	
		<main>
	        <!--하얀색-->
	      <div id="container" class="container-xxl">
	
	        <!-- --내가 작성한 부분 -->
	        <div class="main">
	            <input type="radio" id="tab-1" name="show" checked/>
	            <input type="radio" id="tab-2" name="show" />
	            <input type="radio" id="tab-3" name="show" />
	            <div class="tab">
	              <label for="tab-1">일반회원</label>
	              <label for="tab-2">사장님</label>
	            </div>
	
	            <div class="content">
	
	              <!-- --------------- 일반회원 ---------------------- -->
	              <div class="content-dis">
	                <div class="login-page">
	                    <div class="form">
                           <form action="/hallo03talk/traveler/login" method="post" class="login-form">
	                                <input type="text"  name="travelerJoinId" class="input_id" placeholder="아이디" />
	                                <input type="password" name="travelerJoinPwd" placeholder="비밀번호" />
	                                <button>로그인</button>
	        
	                                <div class="footer">
	                                    <input type="button"  id="find_id" value="아이디 찾기" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#travelerFindId">
	                                    <input type="button"  id="find_pwd" value="비밀번호 찾기" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#travelerFindPwd">
	                                </div>
	                        </form>
	                    </div>
	                  </div>
	              </div>
	
	
	              <!-- --------------- 사장님 ---------------------- -->
	              <div class="content-dis">
	                <div class="login-page">
	                    <div class="form">
                           <form action="/hallo03talk/boss/login" method="post" class="login-form">
	                                <input type="text" name="bossJoinId"  class="input_id" placeholder="아이디" />
	                                <input type="password" name="bossJoinPwd" placeholder="비밀번호" />
	                                <button>로그인</button>
	        
	                                <div class="footer">
	                                    <input type="button" id="find_id" value="아이디 찾기" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#bossFindId">
	                                    <input type="button" id="find_pwd" value="비밀번호 찾기" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#bossFindPwd">
	                                </div>
	                        </form>
	                    </div>
	                  </div>
	              </div>
	
	              <!-- -------------- -->
	              <div>
	              </div>
	
	    <!-- ------------------------------------------------------------------ -->
	       </div>
	        
	    </main>
	
	    <footer></footer> 
	
	
	  <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->
   
       <!--모달창_일반회원_아이디 찾기 -->
       
   
       <!-- Modal -->
      <div class="modal fade" id="travelerFindId" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-dialog-centered">
         <div class="modal-content">
                  
           <!-- Modal Header -->
           <div class="modal-header">
             <h5 class="modal-title" id="exampleModalLabel">아이디 찾기</h5>
             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
           </div>
           
           <!-- Modal body -->
           <div class="modal-body">
             <!-- ----- -->
             <div id="pwdFormOuter">
   				<form action="/hallo03talk/traveler/idFind" method="post"> 
                 <div class="form-floating mb-3">
                   <input type="tel" name="travelerJoinPhone" class="form-control" id="floatingInput" placeholder="name@example.com">
                   <label for="floatingInput">전화번호</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="email" name="travelerJoinEmail" class="form-control" id="floatingPassword" placeholder="Password">
                   <label for="floatingPassword">이메일</label>
                 </div>
     		 
             </div>
           <!-- ----- -->
   
           </div>
   
           <div class="modal-footer">
             <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
             <button type="submit" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#exampleModal">찾기</button>
           </div>
         </div>
       </div>
     </div>
    </form>
    
    

  
  
	<!-- --모달창_일반회원_비밀번호 찾기----------------- -->
        
      <!-- Modal -->
      <div class="modal fade" id="travelerFindPwd" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-dialog-centered">
         <div class="modal-content">
                  
           <!-- Modal Header -->
           <div class="modal-header">
             <h5 class="modal-title" id="exampleModalLabel">비밀번호 찾기</h5>
             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
           </div>
           
           <!-- Modal body -->
           <div class="modal-body">
             <!-- ----- -->
             <div id="pwdFormOuter">
   				<form action="/hallo03talk/traveler/pwdFind" method="post"> 
   
                 <!-- ----- -->
                 <div class="form-floating mb-3">
                   <input type="text" name="travelerJoinId" class="form-control" id="floatingInput" placeholder="name@example.com">
                   <label for="floatingInput">아이디</label>
                 </div>
                 
                 <div class="form-floating">
                   <input type="tel" name="travelerJoinPhone" class="form-control" id="floatingPassword" placeholder="Password">
                   <label for="floatingPassword">전화번호</label>
                 </div>
                 <!-- -- -->
   
             </div>
           <!-- ----- -->
   
           </div>
   
           <div class="modal-footer">
             <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
             <button type="submit" class="btn btn-primary">찾기</button>
           </div>
         </div>
       </div>
     </div>
    </form>
     
  <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->
   
       <!--모달창_사장님_아이디 찾기 -->
   
       <!-- Modal -->
      <div class="modal fade" id="bossFindId" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-dialog-centered">
         <div class="modal-content">
                  
           <!-- Modal Header -->
           <div class="modal-header">
             <h5 class="modal-title" id="exampleModalLabel">아이디 찾기</h5>
             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
           </div>
           
           <!-- Modal body -->
           <div class="modal-body">
             <!-- ----- -->
             <div id="pwdFormOuter">
   				<form action="/hallo03talk/boss/idFind" method="post"> 
                 <div class="form-floating mb-3">
                   <input type="tel" name="bossJoinPhone" class="form-control" id="floatingInput" placeholder="name@example.com">
                   <label for="floatingInput">가게 전화번호</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="email" name="bossJoinEmail" class="form-control" id="floatingPassword" placeholder="Password">
                   <label for="floatingPassword">이메일</label>
                 </div>
   
             </div>
           <!-- ----- -->
   
           </div>
   
           <div class="modal-footer">
             <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
             <button type="submit" class="btn btn-primary">찾기</button>
           </div>
         </div>
       </div>
     </div>
    </form>
   
    <!-- --모달창_사장님_비밀번호 찾기----------------- -->
        
      <!-- Modal -->
      <div class="modal fade" id="bossFindPwd" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-dialog-centered">
         <div class="modal-content">
                  
           <!-- Modal Header -->
           <div class="modal-header">
             <h5 class="modal-title" id="exampleModalLabel">비밀번호 찾기</h5>
             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
           </div>
           
           <!-- Modal body -->
           <div class="modal-body">
             <!-- ----- -->
             <div id="pwdFormOuter">
   				<form action="/hallo03talk/boss/pwdFind" method="post"> 
   
                 <!-- ----- -->
                 <div class="form-floating mb-3">
                   <input type="text" name="bossJoinId" class="form-control" id="floatingInput" placeholder="name@example.com">
                   <label for="floatingInput">아이디</label>
                 </div>
                 
                 <div class="form-floating">
                   <input type="tel" name="bossJoinPhone" class="form-control" id="floatingPassword" placeholder="Password">
                   <label for="floatingPassword">가게 전화번호</label>
                 </div>
                 <!-- -- -->
   
             
             </div>
           <!-- ----- -->
   
           </div>
   
           <div class="modal-footer">
             <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
             <button type="submit" class="btn btn-primary">찾기</button>
           </div>
         </div>
       </div>
     </div>
     
  </form>
  
  
	<script>
		<%if(alertMsg!=null){%>
			alert('<%=alertMsg%>');
		<%}%>
		
	</script>
	

</body>
</html>