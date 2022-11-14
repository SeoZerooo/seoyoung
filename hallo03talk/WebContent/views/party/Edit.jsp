<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
<link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
</head>

<body>


	<%@ include file="/views/common/header.jsp"%>
	<c:if test="${ BossLoginMember.id ne pv.bossId }">
		<script>
			alert('해당 글 작성자만 수정 가능합니다');
			history.go(-1);
		</script>
	
	</c:if>
	
	<main>
		<div id="container" class="container-xxl">
			<div class="board_wrap">
				<div class="board_title">
					<strong>이벤트 소식</strong>
					<P>제주도에서만 즐길 수 있는 축제 및 가게들의 행사를 안내해드립니다!</P>
				</div>
				<form action="/hallo03talk/party/edit" method="post" id="pform">
					<div class="write_wrap">
					<input type="hidden" value="${pv.no }" name="pNo">
						<div class="write">
							<div class="catag"></div>
							<dl>
								<dt>말머리</dt>
								<select   class="form-control" name="category">
									<option value="1" selected>지역축제</option>
									<option value="2">가게홍보</option>
								</select>
							</dl>
							<div class="title">
								<dl>
									<dt>제목</dt>
									<dd>
										<input type="text" placeholder="제목 입력" value="${ pv.title }" name="title" class="form-control" >
									</dd>
								</dl>
							</div>

							<div class="cont">
								<textarea placeholder="내용 입력" name="content" class="form-control" >${pv.content }</textarea>
							</div>
						</div>
						<div class="bt_wrap">
						<button type="submit" class="btn btn-dark">등록</button>
							<button type="button" class="btn btn-danger"
								onclick="location.href='/hallo03talk/party/list'">취소</button>
						</div>
						
					</div>
				</form>
			</div>



		</div>
	</main>


	<footer></footer>


</body>
</html>