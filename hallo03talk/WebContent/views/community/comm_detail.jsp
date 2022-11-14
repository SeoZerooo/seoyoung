<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "<%=request.getContextPath() %>"></c:set>

<%
String alertMsg = (String)session.getAttribute("alertMsg");
session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#container-header {
	display: flex;
	align-items: baseline;
	justify-content: space-between;
}

.chi:nth-child(1) {
	flex-grow: 1;
}

.chi:nth-child(2) {
	flex-grow: 50;
}

.chi:nth-child(3) {
	flex-grow: 0;
}

#container {
	padding: 3rem;
}
</style>

</head>

<body>


	<main>
		<div id="container" class="container-xxl">
			<div id="container-header">
				<h1 class="chi">커뮤니티</h1>
				<h6 class="chi">맛집 추천글, 장소 추천등 여행자들의 소통</h6>
			</div>
			<hr>
			<div class="d-flex flex-grow-1">
			
				<div class="h-100" style="width: 20%; margin-right: 3rem;">
					<ul class="list-group list-group-flush">
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=all&p=&s='">전체보기</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=qna&p=&s='">질문답변</li>
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=free&p=&s='">자유게시판</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=notice&p=&s='">공지사항</li>
					</ul>
				</div>
				<div class="border rounded h-100 d-flex flex-column" style="width: 80%; padding: 1rem;">
<!-- 카테고리 추가 -->
					<div class="d-flex"> <!-- 소제목 -->
						<div class="flex-grow-1">
							<h5>
								<c:choose>
									<c:when test="${vo.category == 'notice' }">공지사항</c:when>
									<c:when test="${vo.category == 'qna' }">질문답변</c:when>
									<c:when test="${vo.category == 'free' }">자유게시판</c:when>
								</c:choose>
							</h5>
<!-- 제목 추가 -->
							<h3>${vo.title}</h1>
						</div>	
							
						<div class="align-self-baseline text-muted">
							<a href="/hallo03talk/comm/list" class="btn btn-outline-warning btn-sm"	style="margin-left: 150px">목록으로</a>
							<div>조회수 : ${vo.cnt}</div>
							<div>등록일 : ${vo.enroll_date}</div>
							<div>작성자 : ${vo.writer}</div>
						</div>
					</div>
					<hr>
<!-- 내용 추가 -->
					<div>${vo.content}</div>
					<hr style="margin-top: 6rem">
						<div class="d-flex justify-content-end pb-3">
<!-- 모달 연결 -->
							<a href="" class="me-2" data-bs-toggle="modal" data-bs-target="#reportMain">신고</a>
							<c:if test="${travelerLoginMember.nick eq vo.writer}">
								<a href="/hallo03talk/comm/edit?no=${vo.no}" class="me-2">수정</a>
								<a href="/hallo03talk/comm/delete?no=${vo.no}">삭제</a>
							</c:if>
							<c:if test="${loginAdmin.name eq vo.writer}">
								<a href="/hallo03talk/comm/notice/edit?no=${vo.no}" class="me-2">수정</a>
								<a href="/hallo03talk/comm/delete?no=${vo.no}">삭제</a>
							</c:if>
						</div>
					
					
<!-- 뎃글 폼태그 -->
					<form action="/hallo03talk/comm/reply/post" method="post">
						<div class="d-flex">
							<c:if test="${empty loginAdmin}">
								<div class="form-floating flex-grow-1">
		<!-- 댓글 내용 -->				<input type="hidden" name="travelerNo" value="${travelerLoginMember.no}">
									<input type="hidden" name="communityNo" value="${vo.no}">
									
									<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px; resize: none;" name="content" required="required"></textarea>
									<label for="floatingTextarea2">Comments</label>
								</div>
								<c:if test="${empty travelerLoginMember}">
									<input class="ms-2 btn btn-outline-warning" type="submit" value="로그인 하세요" disabled="disabled">
								</c:if>
								<c:if test="${not empty travelerLoginMember }">
									<input class="ms-2 btn btn-outline-warning" type="submit" value="등록" >
								</c:if>
							</c:if>
							<c:if test="${not empty loginAdmin}">
								<div class="form-floating flex-grow-1">
		<!-- 댓글 내용 -->				<input type="hidden" name="travelerNo" value="0">
									<input type="hidden" name="communityNo" value="${vo.no}">
									
									<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px; resize: none;" name="content" required="required"></textarea>
									<label for="floatingTextarea2">Comments</label>
								</div>
								<input class="ms-2 btn btn-outline-warning" type="submit" value="등록" >
							</c:if>
						</div>
					</form>
<!-- 등록된 댓글 뿌리기 -->
					<c:forEach var="rvo" items="${replyList}">
						<div class="border mt-2 p-2 d-flex" >
							<div class="me-3 p-auto w-25" >${rvo.travelerNo }</div>
	
							<div>
		<!-- 등록된 댓글 내용 -->
								${rvo.content}
		<!-- 등록된 뎃글 날자 -->
								<span style="font-size: 0.8rem"> - ${rvo.enrollDate}</span>
		<!-- 신고버튼 -->
								<a href="" style="font-size: 0.8rem; text-decoration: none;" data-bs-toggle="modal" data-bs-target="#reportMain${rvo.no}">[신고]
								</a>
		<!-- 등록된 뎃글 삭제 버튼 -->
								<c:if test="${travelerLoginMember.nick eq rvo.travelerNo}">
									<a href="/hallo03talk/comm/reply/delete?comm=${vo.no}&reply=${rvo.no}" style="font-size: 0.8rem; text-decoration: none;">[삭제]</a>
								</c:if>
							</div>
						</div>
						<div class="modal" id="reportMain${rvo.no}">
						  <div class="modal-dialog modal-lg">
						    <div class="modal-content">
						
						      <!-- Modal Header -->
						      <div class="modal-header">
						        <h3 class="modal-title" style="">신고하기</h3>
						        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
						      </div>
						
						      <!-- Modal body -->
						      <form action="/hallo03talk/report/reportComment" method="post" id = "comform">
						      <div class="modal-body">
						        <h5>신고하려고 하는 항목 : <b>댓글</b></h5>
						
						        <br>
						        <h5>1.신고하려는 항목에 대한 이유를 선택해주세요.</h5>
						        <h6 style="margin-bottom: 10px;">항목은 한가지만 선택할 수 있습니다.</h6>
						            <div style="margin-left: 20px;">
						              <input type="checkbox" value="name" name = "guilty" id="name" onclick="example_4();">
						              <label for="name"><b>부적절한 이름, 제목</b></label>
						              <br> 불쾌감을 주거나, 부적절한 이름 또는 제목 사용
						              <br>
						              <input type="checkbox" value="curse" name = "guilty" id="curse" onclick="example_5();">
						              <label for="curse"><b>욕설</b></label>
						              <br> 상대방에게 공격적인 언어 사용
						              <br>
						              <input type="checkbox" value="disgust" name = "guilty" id="disgust" onclick="example_6();">
						              <label for="disgust"><b>혐오 발언</b> </label>
						              <br> 각종 비하 또는 차별 발언
						              <br>
						              <input type="checkbox" value="ad" name = "guilty" id="ad" onclick="example_7();"> 
						              <label for="ad"><b>광고성 계정, 게시물</b> </label>
						              <br> 과도한 광고성 게시물, 댓글 작성. 또는 그 계정
						              <br><br>
						            </div>
						
						
						        <h5>2.신고하려는 자세한 이유를 적어주세요.</h5>
						        <textarea name="content" cols="98" rows="5" placeholder="내용을 입력해 주세요." style="margin-right: 30px;"></textarea>
						      </div>
						
						      <!-- Modal footer -->
						      <div class="modal-footer">
						        <button id="reportBtn" type="submit" id="rcommentsend" class="btn btn-danger" data-bs-dismiss="modal"  data-bs-target="#reportThank" style="margin: 0 auto;">확인</button>
						      </div>
						      <input type="hidden" value="reply" name="type">
								<input type="hidden" value="${rvo.no}" name="replyNo">
								<input type="hidden" value="${vo.no}" name="commNo">
								
						    </form>
						    
						    </div>
						  </div>
						</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</main>
	<div class="modal" id="reportMain">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h3 class="modal-title" style="">신고하기</h3>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<form action="/hallo03talk/report/reportContent" method="post" id="confrom">
					<div class="modal-body">
						<h5>
							신고하려고 하는 항목 : <b>게시물</b>
						</h5>

						<br>
						<h5>1.신고하려는 항목에 대한 이유를 선택해주세요.</h5>
						<h6 style="margin-bottom: 10px;">항목은 한가지만 선택할 수 있습니다.</h6>
						<div style="margin-left: 20px;">
							<input type="checkbox" value="name" id="name" onclick="example_4();" name="guilty">
							<label for="name"><b>부적절한 이름, 제목</b></label> <br> 불쾌감을 주거나,부적절한 이름 또는 제목 사용 <br>
							
							<input type="checkbox" value="curse"id="curse" onclick="example_5();"  name="guilty">
							<label for="curse"><b>욕설</b></label><br> 상대방에게 공격적인 언어 사용 <br>
							
							<input type="checkbox" value="disgust" id="disgust" onclick="example_6();" name="guilty">
							<label for="disgust"><b>혐오 발언</b> </label> <br> 각종 비하 또는 차별 발언 <br>
							
							<input type="checkbox" value="ad" id="ad" onclick="example_7();" name="guilty">
							<label for="ad"><b>광고성 계정, 게시물</b> </label> <br> 과도한 광고성 게시물, 댓글 작성. 또는 그 계정 <br>
							<br>
						</div>


						<h5>2.신고하려는 자세한 이유를 적어주세요.</h5>
						<textarea name="content" id="" cols="98" rows="5"
							placeholder="내용을 입력해 주세요." style="margin-right: 30px;"></textarea>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button id="reportBtn" type="submit" id="rcontentsend"
							class="btn btn-danger" data-bs-dismiss="modal"
							data-bs-target="#reportThank" style="margin: 0 auto;">확인</button>
					</div>
					<input type="hidden" value="community" name="type">
					<input type="hidden" value="${vo.no}" name="boardNo">
				</form>

				<script type="text/javascript">

        $(document).ready(function(){ 
            $("#rcommentsend").click(function(){
                
                $("#confrom").attr("action", ""); // attribute setting
                $("#confrom").submit();
            });
        });
    
    </script>

			</div>
		</div>
	</div>

	<footer></footer>
	
	
	<script type="text/javascript">
	
	        $(document).ready(function(){ 
	        	<%if (alertMsg != null) {%>
					alert('<%=alertMsg%>');
				<%}%>
	        	
	            $("#rcommentsend").click(function(){
	                
	                $("#comform").attr("action", ""); // attribute setting
	                $("#comform").submit();
	            });
	            
	           
	        });
	        
	    
	</script>
	
	<script src="/hallo03talk/resources/js/report.js"></script>
</body>
</html>