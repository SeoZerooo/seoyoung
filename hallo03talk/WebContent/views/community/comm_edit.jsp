<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<style>
#container {
	padding: 3rem;
}
</style>

</head>

<body>
	<main>
		<div id="container" class="container-xxl ">
			<div class="d-flex align-items-end">
				<h1>글쓰기</h1>
				<span class="text-muted flex-grow-1" style="margin-left: 10px;"> - 글을 잘 써 보아요</span>
				<a href="/hallo03talk/comm/list" class="btn btn-warning">목록으로</a>
			</div>
			<hr>
<!-- 글쓰기 폼 -->
			<form class="w-75 mx-auto" action="/hallo03talk/comm/edit?no=${vo.no}" method="post">
				<input type="hidden" name = "no" value="${vo.no}">
			
				<label for="category" class="form-label" style="display: block;">카테고리</label>
				<div class="btn-group mb-3" role="group" aria-label="Basic radio toggle button group" id="category">
<!-- 카테고리 체크박스 -->
				<c:if test="${vo.category eq 'free'}">
					<input type="radio" class="btn-check" name="category" id="btnradio1" autocomplete="off" value="free" checked>
					<label class="btn btn-outline-warning" for="btnradio1">자유게시판</label>
				
					<input type="radio" class="btn-check" name="category" id="btnradio3" autocomplete="off" value="qna">
					<label class="btn btn-outline-warning" for="btnradio3">질문답변</label>
				</c:if>
				<c:if test="${vo.category eq 'qna'}">
					<input type="radio" class="btn-check" name="category" id="btnradio1" autocomplete="off" value="free">
					<label class="btn btn-outline-warning" for="btnradio1">자유게시판</label>
				
					<input type="radio" class="btn-check" name="category" id="btnradio3" autocomplete="off" value="qna" checked>
					<label class="btn btn-outline-warning" for="btnradio3">질문답변</label>
				</c:if>
				
				</div>
				
				<div class="mb-3">
					<label for="title" class="form-label">제목</label>
					<input type="text" class="form-control" id="title" placeholder="제목을 입력하세요" name="title" value="${vo.title}">
				</div>
				<div class="mb-3">
					<label for="content" class="form-label">내용</label>
					<textarea class="form-control summernote" id="content" name="content" ></textarea>
				</div>
				<input type="hidden" name="writer" value="${travelerLoginMember.no}">
				<button type="submit" class="btn btn-outline-warning" style="margin-top: 10px; width: 100%;">글쓰기</button>
			</form>
		</div>
	</main>


<footer></footer>
	<script type="text/javascript">
		$(document).ready( function() {
			$('.summernote').summernote({
				height : 400,
				toolbar : [
					[ 'fontname',[ 'fontname' ] ],
					[ 'fontsize',[ 'fontsize' ] ],
					['style',['bold','italic','underline','strikethrough','clear' ] ],
					[ 'color', [ 'color' ] ],
					[ 'para',[ 'paragraph' ] ],
					[ 'height',[ 'height' ] ],
					['insert',[ 'picture','link' ] ],
					[ 'view', [ 'help' ] ],
					[ 'misc',[ 'codeview' ] ] ],
				fontNames : [ '맑은 고딕', '궁서', '굴림체', '굴림', '돋움체', '바탕체', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New' ],
				fontSizes : [ '8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72' ],
				callbacks : {
					onImageUpload : function(files) {
						var reader = new FileReader();
						reader.readAsDataURL(files[0]);
						
						reader.onload = function() {
							const url = reader.result;
							$.ajax({
								data : {img : url},
								url : "/hallo03talk/comm/imgUpload",
								method : "POST",
								success : function(path) {
									console.log('success');
									const imgNode = document.createElement('img');
									imgNode.setAttribute('src',path);

									$('.summernote').summernote('insertNode',imgNode);
								}
							});
						};
					}
				}
			});
			
			const content = '${vo.content}';
			if(!(content == null || content =='')){
				$('.summernote').summernote('reset');
				$('.summernote').summernote('pasteHTML', content);
			}
			
		});
	</script>
</body>
</html>