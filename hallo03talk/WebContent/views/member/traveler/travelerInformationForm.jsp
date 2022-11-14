<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="com.h3.boss.vo.BossVo"%>
<%@page import="com.h3.traveler.vo.TravelerVo"%>
<%@page import="com.h3.traveler.vo.TravelerAttachmentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
  		TravelerVo travelerLoginMember = (TravelerVo)session.getAttribute("travelerLoginMember");
      	 BossVo BossLoginMember = (BossVo)session.getAttribute("BossLoginMember");
      	TravelerAttachmentVo tav = (TravelerAttachmentVo)session.getAttribute("travelerAttachment");
      		
      //-----------------------------------------------------------------------
      	String alertMsg = (String)session.getAttribute("alertMsg");
      	session.removeAttribute("alertMsg");   
      	
      //	-----------------------------------------------------------------------
      	String contextPath = request.getContextPath();
   %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- CDN으로 추가하는 방법 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>

.choice{
	margin-top:260px;
	position: absolute;
	
}

.choose{
      margin-top:270px;
	
}



/*할로영삼talk 폰트*/
@font-face {
	font-family: 'Somi';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
#MyPageText {
	font-family: 'Somi';
	font-size: 50px;
	margin-top: -20px;
}
.content {
	padding: 150px;
}
/* --------네비게이션 바------------------------------------------------------------------- */
.navbar {
	margin-top: 60px;
}
/* ----------------내 정보-------------------------------------------------- */
aside.context {
	text-align: center;
}
aside.context .explanation {
	/* max-width: 700px; */
	margin: 2em auto 0;
}
.explanation>input {
	/* border: 3px solid purple; */
	margin-left: 30px;
}
.main-content {
	margin: 4em auto;
	max-width: 900px;
	background: #fff;
	padding: 15px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.25);
	text-transform: uppercase;
	transition: all 0.1s ease-in-out;
}
 .id__wrapper {
	display: grid;
	width: 100%;
			//height: 350px;
	
	transition: width 0.2s ease-in-out;
	margin: auto;
	grid-gap: 15px;
	padding: 15px;
	background: rgba(76, 162, 205, 0.2);
	border: 2px solid;
	grid-template-columns: repeat(3, 1fr);
	grid-template-rows: repeat(4, auto);
	grid-template-areas: "your-face name name" "your-face job country"
		"your-face twitter codepen" "your-face blood blood";
} 





.id__wrapper>div {
	transition: all 0.1s ease;
}
textarea::-webkit-scrollbar {
	display: none;
}
.your-face {
	grid-area: your-face;
	background: #fff;
	border: 2px solid;
	cursor: pointer;
	position: relative;
	max-height: 300px;
	overflow: hidden;
}
.your-face img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	z-index: 10;
	position: relative;
	visibility: hidden;
}
.your-face .image-persuader {
	position: absolute;
	top: 40%;
	text-align: center;
	width: 70%;
	left: 15%;
}
.your-face input {
	display: none;
}
label {
	font: 600 16px "Prompt";
	margin-bottom: 2px;
	display: block;
	flex: 0 0 auto;
}
input.full, textarea.full {
	font: 400 20px "Prompt";
	border: none;
	padding: 10px;
	height: 40px;
	width: 100%;
	border-bottom: 2px solid;
	resize: none;
	overflow: visible;
	line-height: 1;
}
input.full:focus, textarea.full:focus {
	outline: none;
}
.Id {
	grid-area: name;
}
.Name {
	grid-area: job;
}
.Nick {
	grid-area: country;
}
.Phone {
	grid-area: twitter;
}
.Email {
	grid-area: codepen;
}
.blood {
	grid-area: blood;
}
.checkbox__wrapper {
	display: flex;
	flex-wrap: wrap;
}
.checkbox__wrapper .checkbox {
	flex: 0 0 auto;
	padding-right: 30px;
	display: flex;
	align-items: center;
	margin: 2px 0;
}
.checkbox__wrapper input {
	visibility: hidden;
}
.checkbox__wrapper label {
	position: relative;
	padding-left: 5px;
	cursor: pointer;
	margin-left: 10px;
}
.checkbox__wrapper label:before {
	content: "";
	width: 16px;
	height: 16px;
	position: absolute;
	border: 2px solid;
	left: -20px;
	top: 2px;
}
.checkbox__wrapper input:checked+label:after {
	content: "";
	width: 12px;
	height: 12px;
	position: absolute;
	background: #000;
	left: -16px;
	top: 6px;
}
 .deco {
	position: absolute;
	background: linear-gradient(to top left, rgba(0, 242, 96, 0.8),
		rgba(76, 162, 205, 0.8));
	width: 1%;
	height: 170px;
	top: 20px;
	right: -165px;
	transform: rotate(55deg);
	opacity: 0;
}
.deco:before {
	content: "";
	background: linear-gradient(to top right, rgba(0, 242, 96, 0.6),
		rgba(76, 162, 205, 0.9));
	width: 1%;
	height: 120px;
	position: absolute;
	transform: rotate(140deg);
	bottom: 0px;
	margin-left: -140px;
}
.as-card {
	box-shadow: none;
	background: none;
	pointer-events: none;
}
.as-card .header span:nth-child(1) {
	display: none;
}
.as-card .header span:nth-child(2) {
	display: block;
}
.as-card .deco, .as-card .deco:before {
	opacity: 1;
	width: 120%;
	animation: 0.8s deco-piece forwards;
}
.as-card .id__wrapper {
	width: 325px;
	overflow: hidden;
	margin: 2em auto 0;
	border-radius: 10px;
	border: none;
	background: #fff;
	position: relative;
	box-shadow: 0 10px 40px rgba(0, 0, 0, 0.15);
	padding: 85px 25px 65px;
	grid-gap: 5px;
	grid-template-columns: repeat(2, 1fr);
	grid-template-rows: auto 60px repeat(4, auto);
	grid-template-areas: "your-face your-face" "name name" "job job"
		"country country" "blood blood" "twitter codepen";
}
.as-card .id__wrapper:before {
	content: "Attendee";
	background: linear-gradient(to top right, #4ca2cd, #00f260);
	position: absolute;
	bottom: -0.5px;
	left: 0;
	width: 100%;
	padding: 10px 0;
	letter-spacing: 2px;
	font: 600 20px "Prompt";
	text-align: center;
	color: #fff;
}
.as-card .id__wrapper:after {
	content: "";
	position: absolute;
	top: 15px;
	left: 50%;
	width: 80px;
	height: 12px;
	margin-left: -40px;
	background: #f8f8f8;
	border-radius: 20px;
	box-shadow: inset 0 2px 8px rgba(0, 0, 0, 0.1);
}
.as-card .id__wrapper input.full, .as-card .id__wrapper textarea.full {
	background: transparent;
	border: none;
	padding: 0;
}
.as-card .id__wrapper textarea.full {
	line-height: 0.9;
	height: 63px;
}
.as-card .id__wrapper .checkbox__wrapper {
	margin: 5px;
}
.as-card .id__wrapper .checkbox__wrapper label {
	padding: 0;
	font-size: 14px;
	color: #4ca2cd;
	margin: 0;
	padding-right: 10px;
}
.as-card .id__wrapper .checkbox__wrapper label:before, .as-card .id__wrapper .checkbox__wrapper label:after
	{
	content: none;
}
.as-card .id__wrapper .checkbox__wrapper input {
	display: none;
}
.as-card .id__wrapper .checkbox {
	padding-right: 0;
}
.as-card .id__wrapper .checkbox input:not(:checked), .as-card .id__wrapper .checkbox input:not(:checked)+label
	{
	display: none;
	padding: 0;
}
.as-card .your-face {
	border-radius: 50%;
	width: 100px;
	height: 100px;
	padding: 2px;
	border: 4px solid #4ca2cd;
}
.as-card .your-face img {
	border-radius: 50%;
}
.as-card .your-face .image-persuader {
	display: none;
}
.as-card .name label:not(.label-check), .as-card .job label:not(.label-check),
	.as-card .country label:not(.label-check), .as-card .blood label:not(.label-check)
	{
	display: none;
}
.as-card .name textarea {
	font: 600 32px "Prompt";
	margin: 5px 5px 0;
	color: #374e71;
	position: relative;
}
.as-card .job input {
	color: #4ca2cd;
	font: 600 20px "Prompt";
	margin: 0 5px;
}
.as-card .country input {
	color: #4ca2cd;
	font: 400 18px "Prompt";
	margin: -15px 5px 10px;
}
.as-card .twitter, .as-card .codepen {
	text-align: center;
	margin: 10px 0;
}
.as-card .twitter label, .as-card .codepen label {
	font: 600 12px "Prompt";
	color: #999;
	margin: 0 0 -2px;
}
.as-card .twitter input, .as-card .codepen input {
	font: 400 16px "Prompt";
	color: #374e71;
	text-align: center;
}
.js-switch {
	cursor: pointer;
	margin: 0 0 3em;
	display: inline-block;
	padding: 0.6em 1.5em;
	/* color: #374e71; */
	color: white;
	background-color: #4ca2cd;
	border: 2px solid;
	border-radius: 7px;
	font: 20px "Prompt";
	position: relative;
	top: 0;
	transition: 0.1s ease;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
}
.js-switch:hover {
	top: -5px;
	box-shadow: 0 3px 10px rgba(0, 0, 0, 0.2);
}
@
keyframes deco-piece { 0% {
	opacity: 0;
	width: 0%;
}
100
%
{
opacity
:
1;
width
:
120%;
}
}
/* ----------------------------------------------------------------------- */
</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<main>
		<!--하얀색-->
		<div id="container" class="container-xxl">

			<!-- 내가 작성 한 부분 -->

			<div class="content">
				<div align="center" id="MyPageText">My Page</div>

				<!-- 네비게이션 바 -->
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="navbarNavDropdown">
							<ul class="navbar-nav">
								<li class="nav-item"
									style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;">
									<a class="nav-link active" aria-current="page"
									href="/hallo03talk/traveler/myPage">내 정보</a>
								</li>
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/hallo03talk/travelerMpgPost/list">내가
										쓴 글</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/hallo03talk/travelerMpgReply/list">내가 쓴 댓글</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/hallo03talk/travelerMpgRsv/list">예약 내역</a></li>

								<li class="nav-item"><a class="nav-link"
									href="/hallo03talk/travelerMpgZzim/list">찜 목록</a></li>
								
							</ul>
						</div>
					</div>
				</nav>
				<!-- ------내 정보-------------------------------------------------------- -->

				<form action="/hallo03talk/traveler/myPage" method="post">
					<input type="hidden" value="<%=travelerLoginMember.getNo()%>"
						name="travelerNo">


					<div class="main-content printed">
						<div class="id__wrapper">
							<div class="deco"></div>
							<!-- ------------------------------------------------------------------------------ -->
							
							
							<!-- ------------------------------------------------------------------------------ -->
							
							<c:set var="tav" value="<%=tav %>" />
							<c:choose> 
								<c:when test="${empty tav.getChangeName()}">
									<label class="your-face" id="image-form" for="image-input">
									<input class="file" type="file" name="f"id="image-input" /> <!-- onchange="setThumbnail(event)" -->
									<button type="button" class="choose" id="upload" style="width:265px;">upload</button>
	    							<div class="image-persuader">Upload Image Here</div> 
	    							</label>
								</c:when>
								<c:otherwise> 
									<img class="your-face" src="<%=contextPath %>/resources/upload/traveler_profile/<%=tav.getChangeName() %>" alt="image" width="250px" height="auto"/>
									<input class="file choice" type="file" name="f" id="image-input"/> <!-- onchange="setThumbnail(event)" -->
									<button type="button" id="upload" class="hello" style="width:250px;" >upload</button>
									
								</c:otherwise>
								</c:choose> 
							
							<!-- ------------------------------------------------------------------------------ -->
							
							<div class="Id">
								<label>Id</label> <input class="full" type="text"
									name="travelerJoinId" value="<%=travelerLoginMember.getId() %>"
									required readonly></input>
							</div>
							<div class="Name">
								<label>Name</label> <input class="full" type="text"
									name="travelerJoinName"
									value="<%=travelerLoginMember.getName() %>" />
							</div>
							<div class="Nick">
								<label>Nick</label> <input class="full" type="text"
									name="travelerJoinNick"
									value="<%=travelerLoginMember.getNick() %>" />
							</div>
							<div class="Phone">
								<label>Tel</label> <input class="full" type="tel"
									name="travelerJoinPhone"
									value="<%=travelerLoginMember.getPhone() %>" />
							</div>
							<div class="Email">
								<label>Email</label> <input class="full" type="email"
									name="travelerJoinEmail"
									value="<%=travelerLoginMember.getEmail() %>" />
							</div>
							<div class="blood">
								<label>Gender</label>
								<div class="checkbox__wrapper">
									<div class="checkbox">
										<input id="design" type="radio" name="travelerJoinGender"
											value="woman" /> <label class="label-check" for="design">woman</label>
									</div>
									<div class="checkbox">
										<input id="front-end" type="radio" name="travelerJoinGender"
											value="man" /> <label class="label-check" for="front-end">man</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<aside class="context">
						<div class="explanation">
							<input type="submit" class="js-switch" id="" value="정보변경">
							<input type="button" class="js-switch" id="" value="비밀번호 변경"
								data-bs-toggle="modal" data-bs-target="#pwdChange"> <input
								type="button" class="js-switch" value="회원탈퇴" class="btn-danger"
								data-bs-toggle="modal" data-bs-target="#quit">

						</div>
					</aside>

					<!-- ---------------------------------------------------------------------------------- -->

					<script> 
			
              // GENDER 가 보이게 하기 위함
				$(function(){
					
					const travelerJoinGender = '<%=travelerLoginMember.getGender()%>';
					
					$('input:radio[name=travelerJoinGender]').each(function(){
						
				        var result = travelerJoinGender.indexOf(this.value);
				        
				        console.log(result);
				        
						if(result != -1){
							this.checked = true;
						}
						
					});
					
					
				})
				
			</script>

					<!-- ---------------------------------------------------------------------------------- -->

				</form>


				<!-- --모달창_비밀번호 변경----------------- -->

				<!-- Modal -->
				<div class="modal fade" id="pwdChange" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">비밀번호 변경</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<!-- ----- -->
								<div id="pwdFormOuter">

									<form action="<%=contextPath%>/traveler/pwd" method="post">
										<input type="hidden" name="travelerJoinId"
											value="<%=travelerLoginMember.getId()%>">

										<div class="form-floating mb-3">
											<input type="password" class="form-control"
												id="floatingInput" name="travelerJoinPwd"
												placeholder="name@example.com"> <label
												for="floatingInput">기존 비밀번호</label>
										</div>
										<div class="form-floating mb-3">
											<input type="password" class="form-control"
												id="floatingPassword" name="travelerJoinPwdNew"
												placeholder="Password"> <label
												for="floatingPassword">신규 비밀번호</label>
										</div>
										<div class="form-floating">
											<input type="password" class="form-control"
												id="floatingPassword" name="travelerJoinPwdNew2"
												placeholder="Password"> <label
												for="floatingPassword">신규 비밀번호 확인</label>
										</div>
								</div>
								<!-- ----- -->

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">닫기</button>
								<button type="submit" class="btn btn-primary"
									onclick="return checkPwd();">변경하기</button>
							</div>
						</div>
						</form>

					</div>
				</div>

				<!------------------------------------------------------------------------------------>

				<script>
		
		<!-- 사진 수정/등록 -->
		<!-- 미리보기 -->
		/*  function setThumbnail(event) {
			var data = event.target;
			var reader = new FileReader();
			reader.onload = function(e){
				 $('#preview').attr('src', e.target.result);
	        }
			reader.readAsText(data.files[0]);
		  }   */
		
		   $(document).ready(function() {
		        $("#upload").on("click", uploadToAjax);
		    });  
		
		 function uploadToAjax(e){
			 var form = $('#image-input')
			 var formdata = new FormData();
			 formdata.append("file", form[0].files[0])
			 
			 $.ajax({
				 type:"post",
				 enctype: "multipart/form-data",
				 url : "/hallo03talk/traveler/ajax",
				 data : formdata,
				 processData: false,
				 contentType: false,
				 timeout: 600000,
				 success: function(e){
					 location.reload()
				 },
			 	 error : function(e){
					alert(e.message)
				 }	 
			 })
		 }
		 
			<!-- 신규 비밀번호 체크 -->
			function checkPwd(){
				
				var isSame = $('input[name=travelerJoinPwdNew]').val() == $('input[name=travelerJoinPwdNew2]').val()
				
				if(isSame == true){
					return true;
				}else{
					alert("신규 비밀번호가 일치하지 않습니다.")
					return false;
				}
				
				
			}
	
		</script>


				<!-- ----------------------------------------------------- -->

				<!-- 부트스트랩_모달창_회원탈퇴 -->

				<!-- Modal -->
				<div class="modal fade" id="quit" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">회원탈퇴</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<div id="pwdFormOuter">

									<form action="<%=contextPath%>/traveler/quit" method="post">
										<input type="hidden" name="travelerJoinId"
											value="<%=travelerLoginMember.getId()%>">

										<div class="form-floating mb-3">
											<input type="password" class="form-control"
												name="travelerJoinPwd" id="pwdpwd"
												placeholder="Password"> <label for="floatingInput">비밀번호</label>
										</div>
										<div class="form-floating mb-3">
											<input type="password" class="form-control"
												name="travelerJoinPwd2" id="floatingPassword"
												placeholder="Password"> <label
												for="floatingPassword">비밀번호 확인</label>
										</div>
								</div>

								<!-- ----- -->

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">닫기</button>
								<button type="submit" class="btn btn-danger"
									onclick="return quit();">탈퇴하기</button>
							</div>
						</div>
						</form>

					</div>
				</div>


				<!------------------------------------------------------------------------------------>

				<!-- 회원탈퇴 체크 -->

				<script>
		
			function quit(){
				var isSame = $('#pwdpwd').val() == $('input[name="travelerJoinPwd2"]').val()
				
				alert($('#pwdpwd').val());
				alert($('input[name="travelerJoinPwd2"]').val());

				if(isSame == true){
					return true;
				}else{
					alert("비밀번호가 서로 일치하지 않습니다.")
					return false;
				}
				
				
			}
	
		</script>

				<!-- ----------------------------------------------------- -->

			</div>
	</main>

	<footer></footer>

	<!------------------------------------------->

	<script>
    
		<%if(alertMsg != null){%>
			alert('<%=alertMsg%>');
		<%}%>
		
	</script>

	<!------------------------------------------->

</body>
</html>