<%@page import="java.util.ArrayList"%>
<%@page import="com.h3.placePhoto.vo.PlacePhotoVo"%>
<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<c:if test="${!empty placeAlert}">
		<script>
			alert('비정상적인 접근');
			location.href = "/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0";
		</script>
	</c:if>
	<main>
		<div id="container" class="container-xxl">
			<h1 class="text-center py-lg-5" style="font-family: 'Somi'">장소</h1>
			<!-- 장소 카테고리들 -->
			<c:if test="${not empty BossLoginMember}">
				<a class="btn btn-warning" href="/hallo03talk/place/add">장소추가</a>
			</c:if>
			<div id="place-finder" class="fw-bolder text-center mt-5 mx-5">
				<div class="row border border-4" id="placeCategory">
					<div class="row">
						<div class="col-2 border-end border-3 makePo"
							onclick="clickCategory(0)" id="categoryAll">모두 보기</div>
						<div class="col-2 bg-warning border-end border-3 makePo"
							onclick="clickCity(0)" id="cityAll">모두 보기</div>
						<!-- 제주시 -->
						<div class="col in-jeju d-none makePo" onclick="clickInside(0)"
							id="jejuAll">모두 보기</div>
						<div class="col in-jeju d-none makePo" onclick="clickInside(1)"
							id="inJeju">시내</div>
						<div class="col in-jeju d-none makePo" onclick="clickInside(2)"
							id="aewol">애월</div>


						<!-- 서귀포 -->
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(0)" id="seogwipoAll">모두 보기</div>
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(1)" id="inSeogwipo">시내</div>
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(2)" id="namwon">남원</div>

					</div>
					<div class="row">
						<div class="col-2 border-end border-3 makePo" id="hotel"
							onclick="clickCategory(2)">숙소</div>
						<div class="col-2 border-end border-3 makePo" id="jeju"
							onclick="clickCity(1)">제주</div>
						<!-- 제주시 -->
						<div class="col in-jeju d-none makePo" onclick="clickInside(3)"
							id="hanrim">한림</div>
						<div class="col in-jeju d-none makePo" onclick="clickInside(4)"
							id="hankyung">한경</div>
						<div class="col in-jeju d-none makePo" onclick="clickInside(5)"
							id="zochun">조천</div>

						<!-- 서귀포 -->
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(3)" id="ahnduk">안덕</div>
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(4)" id="daejung">대정</div>
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(5)" id="pyosun">표선</div>

					</div>
					<div class="row">
						<div class="col-2 border-end border-3 makePo"
							onclick="clickCategory(3)" id="dinner">맛집</div>
						<div class="col-2 border-end border-3 makePo" id="seogwipo"
							onclick="clickCity(2)">서귀포</div>
						<div class="col in-jeju d-none" onclick="clickInside(6)"
							id="guzwa">구좌</div>
						<div class="col in-seogwipo d-none makePo"
							onclick="clickInside(6)" id="sungsan">성산</div>
						<div class="col"></div>
						<div class="col"></div>
					</div>
					<div class="row">
						<div class="col-2 border-end border-3 makePo"
							onclick="clickCategory(1)" id="cafe">카페</div>
						<div class="col-2 border-end border-3"></div>
						<div class="col"></div>
						<div class="col"></div>
					</div>
				</div>
			</div>

			<div id="place-show" class="mt-lg-5 w-100">
				<div class="row px-lg-5">
					<c:forEach items="${ placeList }" var="p" varStatus="st">
						<div class="col mb-5">
							<div class="card" style="width: 350px">
								<img class="card-img-top"
									src="/hallo03talk/resources/upload/place/${ p.photoName }"
									alt="Card image" width="350px" height="350px" />
								<div class="card-body">
									<h4 class="card-title">${ p.name }</h4>
									<p class="card-text">${ p.address }</p>

									<div class="row">
										<a href="/hallo03talk/place/one?placeNo=${ p.no }"
											class="btn btn-primary col-5 ms-3">더보기</a>
										<div class="col"></div>
										<div class="d-flex col align-items-center">
											<svg width="24px" height="24px" viewBox="0 0 24 24"
												version="1.1" xmlns="http://www.w3.org/2000/svg"
												class="forum-icon-fill">
                          					<path
													d="M11.5,5 C17.293,5 20.813,11.041 20.918,11.298 L20.918,11.298 L21,11.5 L20.918,11.701 C20.813,11.959 17.293,18 11.5,18 C5.707,18 2.187,11.959 2.082,11.701 L2.082,11.701 L2,11.5 L2.082,11.298 C2.187,11.041 5.707,5 11.5,5 Z M11.5,6.036 C6.92,6.036 3.565,10.488 3.089,11.499 C3.567,12.51 6.932,16.964 11.5,16.964 C16.08,16.964 19.435,12.512 19.911,11.5 C19.433,10.49 16.068,6.036 11.5,6.036 Z M11.5,8.25 C13.2949254,8.25 14.75,9.70507456 14.75,11.5 C14.75,13.2949254 13.2949254,14.75 11.5,14.75 C9.70507456,14.75 8.25,13.2949254 8.25,11.5 C8.25,9.70507456 9.70507456,8.25 11.5,8.25 Z M11.5,9.25 C10.2573593,9.25 9.25,10.2573593 9.25,11.5 C9.25,12.7426407 10.2573593,13.75 11.5,13.75 C12.7426407,13.75 13.75,12.7426407 13.75,11.5 C13.75,10.2573593 12.7426407,9.25 11.5,9.25 Z"
													id="Color"></path>
                        					</svg>
											${ p.cnt }
										</div>
										<div class="d-flex col align-items-center">
											<c:if test="${ p.zzim eq travelerLoginMember.no }">
												<!-- 찜 하기 -->
												<svg style="color: rgb(253, 195, 86); cursor: pointer;"
													xmlns="http://www.w3.org/2000/svg" width="32" height="34"
													fill="currentColor" class="bi bi-heart-fill zzimBtn"
													viewBox="0 0 16 16" onclick="delZzim(${p.no})">
	                           									 <path fill-rule="evenodd"
														d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"
														fill="#fdc356"></path>
	                          					</svg>
											</c:if>
											<c:if test="${ p.zzim ne travelerLoginMember.no }">
												<svg style="color: #f3da35; cursor: pointer;"
													xmlns="http://www.w3.org/2000/svg" width="32" height="32"
													fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16"
													onclick="addZzim(${p.no})">
	                            					<path
														d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
														fill="#f3da35"></path>
	                         					</svg>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<c:set var="x" value="${ fn:length(placeList)%3 }" />
					<c:if test="${ x==2 }">
						<div class="col mb-5"></div>
					</c:if>
				</div>
			</div>
		</div>
	</main>
	<footer></footer>
	<script>
		function delZzim(x) {
			$.ajax({
				url : "/hallo03talk/zzim/del",
				method : "POST",
				data :  {
					 place : x
				},
				success : function (item) {
					if (item == 1) {
						history.go(0);
					} else {
						alert('에러')
					}
				},
				error : function () {
					alert('찜하기 실패');
				}
			});
		}
	</script>
	<c:if test="${!empty travelerLoginMember}">
		<script>
		function addZzim(x) {
			$.ajax({
				url : "/hallo03talk/zzim/add",
				method : "POST",
				data :  {
					 place : x
				},
				success : function (item) {
					if (item == 1) {
						history.go(0);
					} else {
						alert('에러')
					}
				},
				error : function () {
					alert('찜하기 실패');
				}
			});
		}
	</script>
	</c:if>
	<c:if test="${empty travelerLoginMember}">
		<script>
		function addZzim(x) {
			alert('로그인 후 이용가능합니다.');
		}
	</script>
	</c:if>

	<!-- 현재 선택된 카테고리 색칠하기,,, -->
	<script>
		const placeCategory = document.querySelector('#placeCategory');
		const injeju = placeCategory.querySelectorAll(".in-jeju");
		const inseogwipo = placeCategory.querySelectorAll(".in-seogwipo");
	</script>
	<c:if test="${ categoryNo == 0 }">
		<script>
				document.querySelector('#categoryAll').classList.add('bg-warning');
				document.querySelector('#hotel').classList.remove('bg-warning');
				document.querySelector('#dinner').classList.remove('bg-warning');
				document.querySelector('#cafe').classList.remove('bg-warning');
			</script>
	</c:if>
	<c:if test="${ categoryNo == 1 }">
		<script>
				document.querySelector('#categoryAll').classList.remove('bg-warning');
				document.querySelector('#hotel').classList.remove('bg-warning');
				document.querySelector('#dinner').classList.remove('bg-warning');
				document.querySelector('#cafe').classList.add('bg-warning');
			</script>
	</c:if>
	<c:if test="${ categoryNo == 2 }">
		<script>
				document.querySelector('#categoryAll').classList.remove('bg-warning');
				document.querySelector('#hotel').classList.add('bg-warning');
				document.querySelector('#dinner').classList.remove('bg-warning');
				document.querySelector('#cafe').classList.remove('bg-warning');
			</script>
	</c:if>
	<c:if test="${ categoryNo == 3 }">
		<script>
				document.querySelector('#categoryAll').classList.remove('bg-warning');
				document.querySelector('#hotel').classList.remove('bg-warning');
				document.querySelector('#dinner').classList.add('bg-warning');
				document.querySelector('#cafe').classList.remove('bg-warning');
			</script>
	</c:if>

	<!-- 도시 색칠,,, -->
	<c:if test="${ cityNo == 0 }">
		<script>
				document.querySelector('#cityAll').classList.add('bg-warning');
				document.querySelector('#jeju').classList.remove('bg-warning');
				document.querySelector('#seogwipo').classList.remove('bg-warning');
				injeju.forEach((item) => {
		 			item.classList.add("d-none");
				});
				inseogwipo.forEach((item) => {
					item.classList.add("d-none");
				});
			</script>
	</c:if>
	<c:if test="${ cityNo == 1 }">
		<script>
				document.querySelector('#cityAll').classList.remove('bg-warning');
				document.querySelector('#jeju').classList.add('bg-warning');
				document.querySelector('#seogwipo').classList.remove('bg-warning');
				inseogwipo.forEach((item) => {
			    		item.classList.add("d-none");
					});
				injeju.forEach((item) => {
						item.classList.remove("d-none");
					});
		</script>
	</c:if>
	<c:if test="${ cityNo == 2 }">
		<script>
				document.querySelector('#cityAll').classList.remove('bg-warning');
				document.querySelector('#jeju').classList.remove('bg-warning');
				document.querySelector('#seogwipo').classList.add('bg-warning');
				injeju.forEach((item) => {
					item.classList.add("d-none");
				  });
				inseogwipo.forEach((item) => {
				    item.classList.remove("d-none");
				  });
		</script>
	</c:if>
	<!-- 읍 색칠,,, -->
	<c:if test="${ insideNo == 0 }">
		<script>
				injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				  document.querySelector('#jejuAll').classList.add('bg-warning');
				document.querySelector('#seogwipoAll').classList.add('bg-warning');
			</script>
	</c:if>
	<c:if test="${ insideNo == 1 }">
		<script>
			injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				document.querySelector('#inJeju').classList.add('bg-warning');
				document.querySelector('#inSeogwipo').classList.add('bg-warning');
			
			</script>
	</c:if>
	<c:if test="${ insideNo == 2 }">
		<script>
				injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				document.querySelector('#aewol').classList.add('bg-warning');
				document.querySelector('#namwon').classList.add('bg-warning');
			
			</script>
	</c:if>
	<c:if test="${ insideNo == 3 }">
		<script>
				injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				document.querySelector('#hanrim').classList.add('bg-warning');
				document.querySelector('#ahnduk').classList.add('bg-warning');
			
			</script>
	</c:if>
	<c:if test="${ insideNo == 4 }">
		<script>
				injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				document.querySelector('#hankyung').classList.add('bg-warning');
				document.querySelector('#daejung').classList.add('bg-warning');
				
			</script>
	</c:if>
	<c:if test="${ insideNo == 5 }">
		<script>
				injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				document.querySelector('#zochun').classList.add('bg-warning');
				document.querySelector('#pyosun').classList.add('bg-warning');
			
			</script>
	</c:if>
	<c:if test="${ insideNo == 6 }">
		<script>
				injeju.forEach((item) => {
					item.classList.remove("bg-warning");
				  });
				  inseogwipo.forEach((item) => {
				    item.classList.remove("bg-warning");
				  });
				document.querySelector('#guzwa').classList.add('bg-warning');
				document.querySelector('#sungsan').classList.add('bg-warning');
			</script>
	</c:if>


	</script>
	<script src="/hallo03talk/resources/js/placeList.js"></script>
</body>
</html>
