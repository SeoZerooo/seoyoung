<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <style>
        /* .help-block 을 일단 보이지 않게 설정 */
        #myForm .help-block{
            display: none;
        }
        /* glyphicon 을 일단 보이지 않게 설정 */
        #myForm .glyphicon{
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>

    console.log("스크립트 들어옴.");

    function checkLogin(){

        console.log("유효성 검사 시작");

//         var usId = documet.getElementById("usId");
//         var usPassword = documet.getElementById("usPassword");
//         var rePwd = documet.getElementById("rePwd");
//         var usName = documet.getElementById("usName");
//         var usEmail = documet.getElementById("usEmail");
//         var usPhoneNum = documet.getElementById("usPhoneNum");

        if(usId.value == ""){
			alert("아이디를 입력해주세요");
			usId.focus();
			return false;
        }

        if(usPassword.value == ""){
			alert("비밀번호를 입력해주세요");
			usPassword.focus();
			return false;
        }

        var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

        if (!pwdCheck.test(usPassword.value)){
            alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
            usPassword.focus();
			return false;
        }

        if(rePwd.value !== usPassword.value){
        	alert("비밀번호는가 일치하지 않습니다.");
        	rePwd.focus();
			return false;
        }

        if(usEmail.value== ""){
			alert("이메일을 입력해주세요");
			usEmail.focus();
			return false;
        } 

        var emailCheck = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if (!emailCheck.test(usEmail.value)){
            alert("이메일이 형식에 맞지 않습니다.");
            usEmail.focus();
			return false;
        }

        if(usPhoneNum.value== ""){
			alert("전화번호를 입력해주세요");
			usPhoneNum.focus();
			return false;
        } 

        var phoneCheck = /^[0-9]/g;

        if (!phoneCheck.test(usPhoneNum.value)){
            alert("전화번호는 숫자만 입력해주세요.");
            usPhoneNum.focus();
			return false;
        }

        console.log("유효성 검사 종료");
        document.myForm.submit();
        

		}

        //아이디 중복검사
        var idck = 0;
        
 		$(function(){
 	 		console.log("아이디 중복검사 시작함.");
			$("#IdDup").click(function(){
				var usId = $("#usId").val();
	
				$.ajax({
					async : true,
					type : 'POST',
					data : usId,
					url : "idDup",
					dataType : "json",
					contentType : "application/json; charset=UTF-8",
					success : function(data){
						if(data.cnt > 0){
							alert("아이디가 존재합니다.");
							$("#usId").focus();
							}else{
							alert("사용가능한 아이디입니다.");
							console.log("아이디 중복검사 성공.");
							$("#usPassword").focus();
							idck = 1;
								}
						}, 
						error : function(error){
							alert("error : " + error);
							}
					});
				});
 	 		});

        //닉네임 중복검사
        var nickck = 0;
        
         $(function(){
 	 		console.log("닉네임 중복검사 시작함.");
			$("#nickDup").click(function(){
				var usName = $("#usName").val();
	
				$.ajax({
					async : true,
					type : 'POST',
					data : usName,
					url : "nickDup",
					dataType : "json",
					contentType : "application/json; charset=UTF-8",
					success : function(data){
						if(data.cnt > 0){
							alert("닉네임이 존재합니다.");
							$("#usName").focus();
						}else{
							alert("사용가능한 닉네임입니다.");
							console.log("닉네임 중복검사 성공.");
							$("#usEmail").focus();
							nickck = 1;
						}
					}, 
					error : function(error){
							alert("error : " + error);
					}
					});
				});
 	 		});


	 		//이메일 인증하기
	 		var code = "";
	 		$(function(){
				console.log("이메일 인증 검사 시작");
				$("#checkEmail").click(function(){
				var usEmail = $("#usEmail").val();
				$.ajax({
			        type:"GET",
			        url:"mailCheck?usEmail=" + usEmail,
			        cache : false,
			        success:function(data){
			        	if(data == "error"){
			        		alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
							$("#usEmail").attr("autofocus",true);
							$(".successEmailChk").text("유효한 이메일 주소를 입력해주세요.");
							$(".successEmailChk").css("color","red");
			        	}else{	        		
							alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.");
			        		$("#checkNum").attr("disabled",false);
			        		$("#numOk").css("display","inline-block");
			        		$(".successEmailChk").text("인증번호를 입력한 뒤 이메일 인증을 눌러주십시오.");
			        		$(".successEmailChk").css("color","green");
			        		code = data;
				        	}
				        }
				    });
				});
	 		});

			//인증번호 대조
			//이메일 인증번호 대조
			$(function(){
			$("#numOk").click(function(){
				if($("#checkNum").val() == code){
					$(".successEmailChk").text("인증번호가 일치합니다.");
					$(".successEmailChk").css("color","green");
					$("#checkNum").attr("disabled",true);
				}else{
					$(".successEmailChk").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
					$(".successEmailChk").css("color","red");
					$("#checkNum").attr("autofocus",true);
					}
				});
			});    

	</script>
</head>
<body>
<div class="container">
    <h3>회원가입</h3>
    <form action="/membership/user/register.do" method="post" id="myForm" name="myForm"> 
        <div class="form-group has-feedback">
            <label class="control-label" for="usId">아이디</label>
            <input class="form-control" type="text" name="usId" id="usId"/>
            <button type="button" class="btn btn-primary" id = "IdDup">중복확인</button>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <br>
        <div class="form-group has-feedback">
            <label class="control-label" for="usPassword">비밀번호</label>
            <input class="form-control" type="password" name="usPassword" id="usPassword"/>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <br>
        <div class="form-group has-feedback">
            <label class="control-label" for="rePwd">비밀번호 재확인</label>
            <input class="form-control" type="password" name="rePwd" id="rePwd"/>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <br>
        <div class="form-group has-feedback">
            <label class="control-label" for="usName">닉네임</label>
            <input class="form-control" type="text" name="usName" id="usName"/>
            <button type="button" class="btn btn-primary"  id = "nickDup">중복확인</button>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <br>
        <div class="form-group has-feedback">
            <label class="control-label" for="usEmail">이메일</label>
            <input class="form-control" type="text" name="usEmail" id="usEmail"/>
            <button type="button" class="btn btn-primary" id="checkEmail">이메일 인증번호 보내기</button>
            <br><br>
            <input class="form-control" type="text" name="checkNum" id="checkNum" placeholder="인증번호를 입력해주세요"/>
            <button type="button" class="btn btn-primary" id = "numOk">인증 확인</button>
            <span class="point successEmailChk">이메일 입력후 인증번호 보내기를 해주십시오.</span>
<!--             <input type="hidden" id="emailDoubleChk"/> -->
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <br>
        <div class="form-group has-feedback">
            <label class="control-label" for="userPhoneNum">전화번호</label>
            <input class="form-control" type="text" name="usPhoneNum" id="usPhoneNum"/>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <br>
        <button type="button" class="btn btn-success" onclick="checkLogin();">가입</button>
    </form>
</div>

</script>    
</body>
</html>
