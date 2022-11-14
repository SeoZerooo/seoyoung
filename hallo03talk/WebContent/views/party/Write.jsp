<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/views/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
<link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
</head>

<body>



	<c:if test="${empty BossLoginMember  }">
		<script>
			alert('로그인하세요')
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
				<form action="/hallo03talk/party/write" method="post" id="pform">
					<div class="write_wrap">
					<input type="hidden" value="${ BossLoginMember.no }" name="bossNo">
						<div class="write">
							<div class="catag"></div>
							<dl>
								<dt>말머리</dt>
								<select name="category" class="form-control" >
									<option value="1">지역축제</option>
									<option value="2">가게홍보</option>	
								</select>
							</dl>
							<div class="title">
								<dl>
									<dt>제목</dt>
									<dd>
										<input type="text" placeholder="제목 입력" name="title"  class="form-control" > 
									</dd>
								</dl>
							</div>

							<div class="cont">
								<textarea placeholder="내용 입력" name="content"  class="form-control" ></textarea>
							</div>
						</div>
					</div>
					<div class="bt_wrap">
					<button type="submit" class="btn btn-dark">등록</button>
					<button type="button" class="btn btn-danger" onclick="location.href='/hallo03talk/party/list'">취소</button>
					</div>
				</form>

				


			</div>



		</div>
	</main>


	<footer></footer>

</body>
</html>