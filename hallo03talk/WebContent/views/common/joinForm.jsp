<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
        .form-wrap {
            /* width: 380px; */
            width: 500px;
            height: 780px;
            position: relative;
            margin: auto;
            margin-top: 120px;
            margin-bottom: 120px;
            border-radius: 25px;
            padding: 5px;
            overflow: hidden;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        
        .button-wrap {
            width: 220px;
            margin: 35px auto;
            position: relative;
            box-shadow: 0 0 600px 9px #fcae8f;
			border-radius: 6px;
            top: 60px;
        }
        .togglebtn {
            padding: 5px;
			margin-left: 5px;
            width: 100px;
            cursor: pointer;
            background: transparent;
            border: 0;
            outline: none;
            position: relative;
        }
        .togglebtn:hover{
          color: white;
        }
        #btn {
            top: 0;
            left: 0;
            position: absolute;
			width: 50%;
            height: 100%;
            background-color: rgb(233, 187, 100);
            border-radius: 6px;
            transition: .5s;
        }
        
    
        .input-group {
            top: 80px;
            height: 0px;
            transition: .5s;
            margin-left: 50px;
        }
        
        .input-field {
            width: 100%;
            padding: 10px 0;
            margin: 5px 0;
            border: none;
            border-bottom: 1px solid #999;
            outline: none;
            background: transparent;
        }
        
        /* 회원가입 버튼 */
        .join {
            width: 100%;
            padding: 10px 30px;
            cursor: pointer;
            display: block;
            margin: auto;
            background-color: rgb(233, 187, 100);
            color: white;
            border: 0;
            outline: none;
            border-radius: 6px;
            margin-top: 30px;
        }
        
        #gender_table{
            margin-top: 13px;
        }
        
        #login {
            left: 50px;
        }
        
        #register {
            left: 450px;
        } 
        #travelerIdCheck, #travelerNickCheck, #bossIdCheck{
            border: 0;
            border-radius: 6px;
            width: 80px;
            background-color: rgb(233, 187, 100);
            color: white;
        }
        #travelerIdCheck:hover, #travelerNickCheck:hover, #bossIdCheck:hover, .join:hover{
          background-color: skyblue;
        }
        
     .ggg{
        /* border: 2px solid red; */
        width: 300px;
     }
     </style>


</head>
<body>


	<%@ include file="/views/common/header.jsp"%>
	
	
	 <main>
	      <div id="container" class="container-xxl">
	      
	
	        <!-- 내가 작성 한 부분 -->  
	        <div class="wrap">
	            
	            <div class="form-wrap">
	                <!-- <div class="logo">할로영삼talk</div> -->
	                
	                <div class="button-wrap">
	                    <div id="btn"></div>
	                    <button type="button" class="togglebtn" onclick="login()">일반회원</button>
	                    <button type="button" class="togglebtn" onclick="register()">사장님</button>
	                </div>
	                
	                <!-- --------------- 일반회원 ---------------------- -->
	                  <form action="/hallo03talk/traveler/join" method="post">   
	              
	                    <div id="login" action="" class="input-group">
	                        <div class="ggg">
	                            <table>
	                                <tr>
	                                    <td><input type="text" id="userId" name="travelerJoinId" class="input-field" placeholder="아이디" required></td>
	                                    <td style="padding-left: 30px;"><button id="travelerIdCheck">중복확인</button></td>
	                                </tr>
	                            </table>
	                          
	                            <input type="password" name="travelerJoinPwd" class="input-field" placeholder="비밀번호" required>
	                            <input type="password" name="travelerJoinPwd2" class="input-field" placeholder="비밀번호 확인" required>
	                            <input type="text" name="travelerJoinName" class="input-field" placeholder="이름" required>
	        
	                            <table>
	                                <tr>
	                                    <td><input type="text" id="userNick" name="travelerJoinNick" class="input-field" placeholder="닉네임"></td>
	                                    <td style="padding-left: 30px;"><button id="travelerNickCheck">중복확인</button></td>
	                                </tr>
	                            </table>
	                           
	                            <table id="gender_table">
	                                <tr> 
	                                    <td style="padding-right: 30px; color: gray;">성별</td>
	                                    
	                                    <td style="padding-right: 10px;">
	                                    	<input type="radio" name="travelerJoinGender" value="man" required>남
	                                    </td>
	                                    <td>
	                                    	<input type="radio" name="travelerJoinGender" value="woman" required>여
	                                    </td>
	                                    
	                                </tr>
	                            </table>
	        
	                            <input type="tel" name="travelerJoinPhone" class="input-field" placeholder="전화번호" required>
	                            <input type="email" name="travelerJoinEmail" class="input-field" placeholder="이메일" required>
	                            <button type="submit" class="join">회원가입</button>
	                        </div>
	        
	                    </div>
					</form>
	
					<!-- ------일반회원_아이디 중복체크-------------------------------------- -->
					
					<script>
					
						$("#travelerIdCheck").click(function(e){
							
							
							var userId  = $('#userId').val();
							
					        var url = "${pageContext.request.contextPath}/traveler/idCheck"

			
							$.ajax({
								url  : url,
								method : "post",
					        	data : { userId : userId },
					            
					            success : function(x){
					            	//alert("x : " + x);
					            	if(x == 1){
						               alert("이미 존재하는 아이디입니다.");
					            	}else{
			  			              alert("사용 가능한 아이디 입니다.");
					            	}
					            },
					            error : function(e){
					            	alert('서버요청 실패!');
					            } 
					            
							})
							
							
						})
						
					
					</script>
						<!-- ------일반회원_닉네임 중복체크-------------------------------------- -->
					
					<script>
					
						$("#travelerNickCheck").click(function(e){
							
							
							var userNick  = $('#userNick').val();
							
					        var url = "${pageContext.request.contextPath}/traveler/nickCheck"

			
							$.ajax({
								url  : url,
								method : "post",
					        	data : { userNick : userNick },
					            
					            success : function(x){
					            	//alert("x : " + x);
					            	if(x == 1){
						               alert("이미 존재하는 닉네임 입니다.");
					            	}else{
			  			              alert("사용 가능한 닉네임 입니다.");
					            	}
					            },
					            error : function(e){
					            	alert('서버요청 실패!');
					            } 
					            
							})
							
							
						})
						
					
					</script>
					
					<!-- --------------------------------------------- -->
	              
					<!-- --------------------------------------------- -->
	              
	               <!-- ---------------사장님 ---------------------- -->
	             <form action="/hallo03talk/boss/join" method="post">   
	                     
	                <div id="register" action="" class="input-group">
	                    <div class="ggg">
	                        <table>
	                            <tr>
	                                <td><input type="text" id="bossId" name="bossJoinId" class="input-field" placeholder="아이디" required></td>
	                                <td style="padding-left: 30px;"><button id="bossIdCheck">중복확인</button></td>
	                            </tr>
	                        </table>
	                      
	                        <input type="password" name="bossJoinPwd" class="input-field" placeholder="비밀번호" required>
	                        <input type="password" name="bossJoinPwd2" class="input-field" placeholder="비밀번호 확인" required>

	                       
	                        <input type="tel" name="bossJoinPhone" class="input-field" placeholder="전화번호" required>
	                        <input type="email" name="bossJoinEmail" class="input-field" placeholder="이메일" required>
	                        <button type="submit" class="join">회원가입</button>
	                    </div>
	                </div>
	             </form>  

           	<!-- ------사장님_아이디 중복체크-------------------------------------- -->
					
			<script>
			
				$("#bossIdCheck").click(function(e){
					
					
					var bossId  = $('#bossId').val();
					
			        var url = "${pageContext.request.contextPath}/boss/idCheck"

	
					$.ajax({
						url  : url,
						//url : "/hallo03talk/boss/idCheck",
						method : "post",
			        	data : { bossId : bossId },
			            
			            success : function(x){
			            	if(x == 1){
				               alert("이미 존재하는 아이디입니다.");
			            	}else{
	  			              alert("사용 가능한 아이디 입니다.");
			            	}
			            },
			            error : function(e){
			            	alert('서버요청 실패!');
			            } 
			            
					})
					
					
				})
				
			
			</script>
			
	<!-- --------------------------------------------- -->  
	               
	            </div>
	        </div>
		             
	
	        <script>
	            var x = document.getElementById("login");
	            var y = document.getElementById("register");
	            var z = document.getElementById("btn");
	            
	            
	            function login(){
	                x.style.left = "50px";
	                y.style.left = "450px";
	                z.style.left = "0";
	            }
	    
	            function register(){
	                x.style.left = "-400px";
	                y.style.left = "50px";
	                z.style.left = "110px";
	            }
	        </script>
	
			<!-- </form> -->
	
	      </div>
	      
      
    </main>
			
	
	
	
	<footer></footer>
	
	

</body>
</html>