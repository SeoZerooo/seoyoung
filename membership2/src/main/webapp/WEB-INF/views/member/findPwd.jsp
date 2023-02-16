<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
// 	$(function(){
// 		$("#findBtn").click(function(){
// 			$.ajax({
// 				url : "/membership/user/findpw",
// 				type : "POST",
// 				data : {
// 					usId : $("#usId").val(),
// 					usEmail : $("#usEmail").val()
// 				},
// 				success : function(result) {
// 					alert(result);
				
// 				},
// 			    error: function (request, status, error) {
// 			        console.log("code: " + request.status)
// 			        console.log("message: " + request.responseText)
// 			        console.log("error: " + error);
// 			    }
// 			});
// 		});
// 	});

//이메일 인증하기
	 		var code = "";
	 		$(function(){
				console.log("비밀번호 찾기 시작");
				$("#findBtn").click(function(){
				var usEmail = $("#usEmail").val();
				var usId = $("#usId").val();
				$.ajax({
			        type:"GET",
			        url:"findpw?usEmail=" + usEmail,
			        cache : false,
			        success:function(data){
			        	if(data == "error"){
			        		alert("정확한 이메일을 입력해주세요");
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
</script>
<style type="text/css">
.mybtn{
  width:150px;
  height:40px;
  padding:0;
  display:inline; 
  border-radius: 4px; 
  background: #212529;
  color: #fff;
  margin-top: 20px;
  border: solid 2px #212529; 
  transition: all 0.5s ease-in-out 0s;
}
.mybtn:hover .mybtn:focus {
  background: white;
  color: #212529;
  text-decoration: none;
}
</style>
<title>비밀번호 찾기</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호 찾기</h3>
			</div>
			<div>
				<p>
					<label>아이디</label>
					<input class="w3-input" type="text" id="usId" name="usId" placeholder="회원가입한 아이디를 입력하세요" required>
				</p>
				<p>
					<label>이메일</label>
					<input class="w3-input" type="text" id="usEmail" name="usEmail" placeholder="회원가입한 이메일주소를 입력하세요" required>
				</p>
				<p class="w3-center">
					<button type="button" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">찾기</button>
					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button>
				</p>
			</div>
		</div>
	</div>
</body>
</html>