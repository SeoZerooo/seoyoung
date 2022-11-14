<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- summernote -->
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

<!-- tagify -->
<script src="https://unpkg.com/@yaireo/tagify"></script>
<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css"
	rel="stylesheet" type="text/css" />

	<style>
	a {
		text-decoration: none;
	}
	
	/* 컨텐트 영역 */
	#head-img {
		box-sizing: border-box;
		margin-top: 12px;
		width: 100%;
		height: 300px;
		background-size: cover;
	}
	
	#content {
		margin-left: auto;
		margin-right: auto;
		width: 800px;
		padding: 1rem;
	}
	
	#jeju div:hover, #souguipo div:hover {
		background-color: antiquewhite;
		transition: 0.5s;
	}
	</style>
</head>
<body>


	<main>
		<div id="container" class="container-xxl">

			<div id="wraper">
				<div id="head-img">
					<img src="/hallo03talk/resources/img/with/with_detail_img2.jpg"
						width="100%" height="100%">
				</div>
				<div id="content">
					<div class="d-flex align-items-end">
						<c:if test="${not empty editVo}">
							<h1>수정</h1>
						</c:if>
						<c:if test="${empty editVo}">
							<h1>글쓰기</h1>
						</c:if>
						<span class="text-muted" style="margin-left: 10px;"> - 글을 잘 써 보아요</span>
					</div>
					<hr>
					<c:if test="${not empty editVo}">
						<form action="/hallo03talk/with/edit" method="post" style="padding: 20px;" class="d-flex flex-column">
						<input type ="hidden" value= ${editVo.no } name = "no">
					</c:if>
					<c:if test="${empty editVo}">
						<form action="/hallo03talk/with/post" method="post" style="padding: 20px;" class="d-flex flex-column">
					</c:if>
						<!-- 글쓰기 요청 폼 -->

						<label for="exampleFormControlInput1" class="form-label mt-3"><h4>제목</h4></label>
						<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="제목을 입력하세요" name="title" value="${editVo.title}"> 
						<label for="exampleFormControlTextarea1"
							class="form-label mt-3"><h4>내용</h4></label>
						<!-- summernote -->
						<textarea class="summernote" name="content" id="exampleFormControlTextarea1"></textarea>


						<!-- 태그 -->
						<input type="text" class="form-control mt-1" id="tag" placeholder="태그 입력"> <input type="hidden" name="tag" id="tag1" value="tag"> 
						
						<label for="exampleFormControlInput1" class="form-label mt-3"><h4>인스타아이디</h4></label> 
						<input type="text" class="form-control"  id="exampleFormControlInput1" placeholder="인스타 아이디 입력" name="insta" value="${editVo.insta}"> 
						
						<label for="formDatepicker" class="mt-3"><h4>날짜</h4></label>
						<div id="formDatepicker" class="d-flex">
							<input type="date" id="date1" class="flex-grow-1 border" name="startDate" value="${editVo.start_date}"> ~ 
							<input type="date" id="date1" class="flex-grow-1 border" name="endDate" value="${editVo.end_date}">
						</div>

						<label for="formPlace" class="mt-3"><h4>장소</h4></label>

						<div id="formPlace">
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item" role="presentation">
									<button class="nav-link active" id="jeju-tab"
										data-bs-toggle="tab" data-bs-target="#jeju" type="button"
										role="tab" aria-controls="home" aria-selected="true">제주</button>
								</li>
								<li class="nav-item" role="presentation">
									<button class="nav-link" id="souguipo-tab" data-bs-toggle="tab"
										data-bs-target="#souguipo" type="button" role="tab"
										aria-controls="profile" aria-selected="false">서귀포</button>
								</li>
							</ul>

							<div class="tab-content" id="myTabContent"
								style="margin-bottom: 50px; position: relative;">

								<div
									class="tab-pane fade show border border-top-0 rounded-bottom active d-flex"
									id="jeju" role="tabpanel" aria-labelledby="home-tab"
									style="position: absolute; width: 100%; z-index: 1;">
									<div class="flex-grow-1 text-center p-2">제주시</div>
									<div class="flex-grow-1 text-center p-2">한경면</div>
									<div class="flex-grow-1 text-center p-2">한림읍</div>
									<div class="flex-grow-1 text-center p-2">애월읍</div>
									<div class="flex-grow-1 text-center p-2">조천읍</div>
									<div class="flex-grow-1 text-center p-2">구좌읍</div>
									<div class="flex-grow-1 text-center p-2">우도면</div>
								</div>

								<div
									class="tab-pane fade border border-top-0 rounded-bottom d-flex "
									id="souguipo" role="tabpanel" aria-labelledby="profile-tab"
									style="position: absolute; width: 100%; z-index: 0;">
									<div class="flex-grow-1 text-center p-2">서귀포시</div>
									<div class="flex-grow-1 text-center p-2">대정읍</div>
									<div class="flex-grow-1 text-center p-2">안덕면</div>
									<div class="flex-grow-1 text-center p-2">남원읍</div>
									<div class="flex-grow-1 text-center p-2">표선면</div>
									<div class="flex-grow-1 text-center p-2">성산읍</div>
								</div>

							</div>

						</div>
						<input type="text" id="input-place" name="place" class="mt-1 border" readonly placeholder="장소" value="${editVo.place}">
						
						<button type="submit" class="btn btn-outline-warning" style="margin-top: 10px;">글쓰기</button>
					</form>

				</div>

			</div>

		</div>
	</main>


	<footer></footer>

	<script>
		$(function() {
			$('#jeju-tab').click(function() {
				$('#jeju').css('z-index', '1');
				$('#souguipo').css('z-index', '0');
			});

			$('#souguipo-tab').click(function() {
				$('#jeju').css('z-index', '0');
				$('#souguipo').css('z-index', '1');
			});

			$('#jeju div').each(function(i) {
				$(this).click(function() {
					$('#input-place').val($(this).text());
				});
			});

			$('#souguipo div').each(function(i) {
				$(this).click(function() {
					$('#input-place').val($(this).text());
				});
			});
		})
	</script>

	<script>
		$(document).ready( function() {
			$('.summernote').summernote({
				height : 400,
				toolbar : [
										// [groupName, [list of button]]
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
								url : "/hallo03talk/with/imgUpload",
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

							//tagify
			var input = document.querySelector('#tag');
			var tagify = new Tagify(input);
	
			// 태그가 추가되면 이벤트 발생
			tagify.on('add', function() {
				let string = '';
				for (let i = 0; i < tagify.value.length; i++) {
					string = string + tagify.value[i].value + ',';
				}
				string = string.slice(0, -1);
				console.log(string);
	
				const tag = document.querySelector("#tag1");
				tag.value = string;
			})
			//=========================================
			
			const content = '${editVo.content}';
			if(!(content == null || content =='')){
				$('.summernote').summernote('reset');
				$('.summernote').summernote('pasteHTML', content);
			}
		});
	</script>
</body>
</html>

