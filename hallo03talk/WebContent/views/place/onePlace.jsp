<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="com.h3.placePhoto.vo.PlacePhotoVo"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link href="/hallo03talk/resources/css/onePhoto.css" rel="stylesheet"
	type="text/css" />
<link href="/hallo03talk/resources/css/reviewForm.css" rel="stylesheet"
	type="text/css" />
<link href="/hallo03talk/resources/css/star.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<main>
		<div id="container" class="container-xxl">
			<!-- 슬라이드 -->
			<div id="onePlacePhotos" class="carousel slide mt-3"
				data-bs-ride="true">
				<div class="carousel-inner">
					<c:forEach begin="0" end="${ fn:length(photoList)-1 }" step="1"
						varStatus="st">
						<c:if test="${ st.index == 0 }">
							<div class="carousel-item active">
								<img
									src="/hallo03talk/resources/upload/place/${ photoList.get(st.index).name }"
									class="d-block w-100" alt="..." height="500px" />
							</div>
						</c:if>
						<c:if test="${st.index != 0 }">
							<div class="carousel-item">
								<img
									src="/hallo03talk/resources/upload/place/${ photoList.get(st.index).name }"
									class="d-block w-100" alt="..." height="500px" />
							</div>
						</c:if>
					</c:forEach>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#onePlacePhotos" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#onePlacePhotos" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			<!-- 신고버튼 -->
			<!-- 사장님이 아닐때 -->

			<div class="row">
				<c:if test="${ BossLoginMember == null }">
					<div class="col"></div>
					<div class="col"><span class="stars"> ★★★★★ <span
						style="width: ${ stars * 10 }%;">★★★★★</span>
					</span></div>
					<div class="col text-end mt-3 mb-0">
						<c:if test="${ placeVo.zzim eq travelerLoginMember.no }">
							<!-- 찜 하기 -->
							<svg style="color: rgb(253, 195, 86); cursor: pointer;"
								xmlns="http://www.w3.org/2000/svg" width="32" height="34"
								fill="currentColor" class="bi bi-heart-fill zzimBtn"
								viewBox="0 0 16 16" onclick="delZzim(${placeVo.no})">
	                           									 <path fill-rule="evenodd"
									d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"
									fill="#fdc356"></path>
	                          					</svg>
						</c:if>
						<c:if test="${ placeVo.zzim ne travelerLoginMember.no }">
							<svg style="color: #f3da35; cursor: pointer;"
								xmlns="http://www.w3.org/2000/svg" width="32" height="32"
								fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16"
								onclick="addZzim(${placeVo.no})">
	                            					<path
									d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
									fill="#f3da35"></path>
	                         					</svg>
						</c:if>
						<label for="zzim">${ zzimCnt }</label>
					</div>
					<div class="col"></div>
					
				</c:if>
				<!-- 사장님만 보임 -->
				<c:if test="${ BossLoginMember.no eq placeVo.bossNo }">
					<div class="col text-end">
						<button class="btn btn-warning mt-3 mb-0"
							onclick="location.href='/hallo03talk/place/update?placeNo=${placeVo.no}'">장소
							수정</button>
					</div>
				</c:if>
			</div>

			<div class="place-info py-3">
				<div class="row border border-3">
					<!-- 장소사진 -->
					<c:set var="s" value="${ fn:length(photoList)-1 }"></c:set>
					<img
						src="/hallo03talk/resources/upload/place/${ photoList.get(s).name }"
						alt="" class="col-3" />
					<div class="col text-center py-5">
						<!-- 장소명 -->
						<label for="place-title" class="h1">${ placeVo.name }</label>
						<!-- 장소설명 -->
						<p class="h4 py-2 px-5">${ placeVo.content }</p>
						<c:if test="${!empty travelerLoginMember && resCheck == 0 }">
							<button class="btn btn-primary" data-bs-toggle="modal"
								data-bs-target="#reservation">예약하기</button>
						</c:if>
						<c:if test="${!empty travelerLoginMember && resCheck == 1 }">
							<button class="btn btn-danger"
								onclick="checkReservation(${placeVo.no});">예약취소</button>
							<button type="hidden" class="btn d-none" data-bs-toggle="modal"
								data-bs-target="#cancelModal" id="cancleModal"></button>
							<script>
								function checkReservation(placeNo) {
									$.ajax({
										method : "POST",
										url: "/hallo03talk/reservation/getReservation",
										data: {
											"placeNo" : placeNo
										},
										success: function (response) {
											const resVo = JSON.parse(response);
											showReservation(resVo);
											$('#cancleModal').trigger("click");
										}
									});
								}
								
								
							</script>
						</c:if>
					</div>
					<div
						class="d-flex flex-column col-2 justify-content-center align-items-center">
						<div>${ bossVoForShow.id }</div>
						<div>${ bossVoForShow.phone }</div>
						<div>${ bossVoForShow.email }</div>
					</div>
				</div>
				<!-- =============================================================================== -->
				<c:if test="${!empty travelerLoginMember}">
					<div class="text-end">
						<button class="btn btn-warning my-3" id="reviewFormBtn"
							onclick="reviewFormBtn();">후기 등록</button>
					</div>
					<!-- 후기 등록 -->
				</c:if>
				<form action="/hallo03talk/place/addReview" method="post"
					class="hideForm" id="reviewForm" enctype="multipart/form-data">
					<input type="hidden" value="${placeVo.no}" name="placeNo">
					<div class="row border border-2">
						<div
							class="d-flex col-2 justify-content-center align-items-center">
							<input type="file" class="form-control" name="reviewImg" required />
						</div>
						<div
							class="d-flex col-2 justify-content-center align-items-center">
							<input type="text" name="reviewTitle" class="form-control"
								placeholder="후기 제목" required />
						</div>
						<div
							class="d-flex col-4 justify-content-center align-items-center">
							<textarea name="reviewContent" cols="30" rows="10"
								class="form-control" style="resize: none" placeholder="후기 내용"
								required></textarea>
						</div>
						<div
							class="d-flex col-2 justify-content-center align-items-center">
							<span class="star"> ★★★★★ <span>★★★★★</span> <input
								type="range" oninput="drawStar(this)" value="1" step="1" min="0"
								max="10" name="star" />
							</span>
						</div>
						<div class="d-flex col justify-content-end align-items-center">
							<button class="btn btn-primary">작성</button>
							<button type="button" class="btn btn-danger"
								onclick="cancelReview();">취소</button>
						</div>
					</div>
				</form>

				<!-- 후기 목록 -->
				<c:if test="${!empty reviewList }">
					<c:forEach items="${reviewList}" var="r" varStatus="st">
						<div class="row py-1 my-1 border border-2">
							<div class="col-2">
								<img
									src="/hallo03talk/resources/upload/place/${ reviewPhotoList.get(st.index).name }"
									alt="" width="200px" height="200px" />
							</div>
							<div
								class="d-flex col-2 justify-content-center align-items-center">
								<label for="review" class="h2 justify-self-end">${ r.title }</label>
							</div>
							<div
								class="d-flex col-4 justify-content-center align-items-center">
								<p>${ r.content }</p>
							</div>
							<div
								class="d-flex col-2 justify-content-center align-items-center">
								<span class="star"> ★★★★★ <span
									style="width: ${ r.star * 10 }%;">★★★★★</span>
								</span>
							</div>
							<c:if test="${r.travelerNo eq travelerLoginMember.nick}">
								<div class="d-flex col justify-content-end align-items-center">
									<button class="btn btn-primary px-1" id="reviewForm"
										onclick="reviewDel(${travelerLoginMember.no},${r.no});">리뷰
										삭제</button>
								</div>
								<script>
									function reviewDel(tNo,rNo) {
										if(confirm('정말 삭제하시겠습니까?')) {
											$.ajax({
												method : "POST",
												url: "/hallo03talk/review/delOne",
												data: {
													"tNo" : tNo,
													"rNo" : rNo
												},
												success: function (response) {
													if(response == 1) {
														alert('삭제 성공')
														history.go(0);
													} else {
														alert('삭제 실패');
													}
												}
											});
										}
									}
								</script>
							</c:if>
							<!-- 사장님만 보임 -->
							<c:if test="${ r.checkReview=='N' || empty r.checkReview }">
								<c:if test="${ BossLoginMember.no eq bossVoForShow.no }">
									<div class="d-flex col justify-content-end align-items-center">${ r.travelerNo }</div>
									<div class="d-flex col justify-content-end align-items-center">
										<button class="btn btn-primary px-1" id="reviewForm"
											onclick="writeBtn();">답글 등록</button>
									</div>
								</c:if>
							</c:if>
							<c:if test="${ BossLoginMember.no ne bossVoForShow.no }">
								<div
									class="d-flex col-1 justify-content-center align-items-center">
									${ r.travelerNo }</div>
							</c:if>
							<!-- 답글 등록 폼 -->
							<form action="/hallo03talk/review/reply" method="post"
								class="hideForm" id="commentForm">
								<input type="hidden" value="${ r.no }" name="reviewNo" /> <input
									type="hidden" value="${ placeVo.no }" name="placeNo" />
								<div class="row border border-2">
									<div
										class="d-flex col-2 justify-content-center align-items-center"></div>
									<div
										class="d-flex col-6 justify-content-center align-items-center">
										<textarea name="replyContent" cols="30" rows="1"
											class="form-control" style="resize: none;"
											placeholder="답글 내용"></textarea>
									</div>
									<div
										class="d-flex col-2 justify-content-end align-items-center">
										<button class="btn btn-primary">작성</button>
										<button type="button" class="btn btn-danger"
											onclick="cancelBtn();">취소</button>
									</div>
								</div>
							</form>
							<c:if test="${!empty reviewReplyList }">
								<c:forEach items="${reviewReplyList}" var="rr">
									<div class="row">
										<div class="col-2 text-center">
											<h1>┗</h1>
										</div>
										<div
											class="d-flex col-2 justify-content-center align-items-center">
											<label for="review" class="h2">답글</label>
										</div>
										<div
											class="d-flex col-6 justify-content-center align-items-center">
											<p>${ rr.content }</p>
										</div>
										<c:if test="${ BossLoginMember.no eq bossVoForShow.no  }">
											<label class="col">${ bossVoForShow.id }</label>
											<div
												class="d-flex col justify-content-end align-items-center">
												<button class="btn btn-danger px-1" id="delReview"
													onclick="delBtn(${rr.no});">답글 삭제</button>
											</div>
										</c:if>
										<c:if test="${ BossLoginMember.no ne bossVoForShow.no  }">
											<div
												class="d-flex col justify-content-center align-items-center">
												${ bossVoForShow.id }</div>
										</c:if>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</main>
	<footer></footer>
	<!-- 모달 -->
	<!-- 예약하기 모달 -->
	<c:if test="${!empty travelerLoginMember }">
		<div class="modal" id="reservation">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">예약하기</h4>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="row">
							<div class="row">
								<div class="col text-center">날짜선택</div>
							</div>
							<div class="row">
								<div class="col text-center">
									<input type="date" class="col form-control" id="startDate"
										required /> <label for="" class="col">~</label> <input
										type="date" class="col form-control" id="endDate" required />
								</div>
							</div>
							<div class="row my-1">
								<div class="col text-center">이름</div>
							</div>
							<div class="row my-1">
								<input type="text" class="col text-center ms-4 form-control"
									value="${travelerLoginMember.name}" readonly />
							</div>
							<div class="row my-1">
								<div class="col text-center">전화번호</div>
							</div>
							<div class="row my-1">
								<input type="text" class="col text-center ms-4 form-control"
									value="${travelerLoginMember.phone}" readonly />
							</div>
							<div class="row my-1">
								<div class="col text-center">인원수</div>
							</div>
							<div class="row my-1">
								<div class="col"></div>
								<input type="number" class="col form-control" min="1" id="human"
									required>
								<div class="col"></div>
							</div>
							<div class="row my-1 mt-3">
								<button type="button" class="col btn btn-primary ms-4"
									onclick="addReservation(${placeVo.no})">확인</button>
								<button type="button" data-bs-dismiss="modal"
									class="col btn btn-danger ms-4">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
		document.querySelector('#startDate').addEventListener('change',() => {
			const start = document.querySelector('#startDate').value;
			const ydm = start.split('-');
			const resDate = parseInt(ydm[1]+ydm[2]);
			const today = parseInt((new Date().getMonth()+1).toString() + new Date().getDate().toString());
			if (resDate <= today) {
				alert('올바르게 입력해주세요');
				document.querySelector('#startDate').value="";
			}
		});

		document.querySelector('#endDate').addEventListener('change',() => {
			const end = document.querySelector('#endDate').value;
			const ydm = end.split('-');
			const resDate = parseInt(ydm[1]+ydm[2]);
			const startDates = document.querySelector('#startDate').value.split('-');
			const startDate = parseInt(startDates[1]+startDates[2]);
			if (resDate <= startDate) {
				alert('올바르게 입력해주세요');
				document.querySelector('#endDate').value="";
			}
		});
	</script>
		<script>
		function addReservation(placeNo){
		$.ajax({
			method: "POST",
			url: "/hallo03talk/reservation/add",
			data: {
				startDate : document.querySelector('#startDate').value,
				endDate : document.querySelector('#endDate').value,
				human : document.querySelector('#human').value,
				"placeNo" : placeNo
			},
			success: function (response) {
				if (response == 1) {
					alert('예약 완료');
					history.go(0);
				} else {
					alert('예약 실패');
				}
			}
		});
	}
	</script>
	</c:if>
	<script>
		function delZzim(x) {
			$.ajax({
				url : "/hallo03talk/zzim/del",
				method : "POST",
				data :  {
					 place : x
				},
				success : function (item) {
					refreshZzim();
				},
				error : function () {
					alert('찜하기 실패');
				}
			});
		}
	</script>
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
						refreshZzim();
					} else {
						alert('로그인 후 할 수 있습니다');
					}
				},
				error : function () {
					alert('찜하기 실패');
				}
			});
		}
	</script>
	<script>
		function refreshZzim() {
			history.go(0);
		}
	</script>
	<!-- 예약 취소 모달 -->
	<div class="modal" id="cancelModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">예약취소하기</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="row">
						<div class="row">
							<div class="col text-center">날짜선택</div>
						</div>
						<div class="row">
							<div class="col text-center">
								<input type="text" class="col form-control" id="cancelStartDate"
									readonly /> <label for="" class="col">~</label> <input
									type="text" class="col form-control" id="cancelEndDate"
									readonly />
							</div>
						</div>
						<div class="row my-1">
							<div class="col text-center">이름</div>
						</div>
						<div class="row my-1">
							<input type="text" class="col text-center ms-4 form-control"
								value="${travelerLoginMember.name}" readonly />
						</div>
						<div class="row my-1">
							<div class="col text-center">전화번호</div>
						</div>
						<div class="row my-1">
							<input type="text" class="col text-center ms-4 form-control"
								value="${travelerLoginMember.phone}" readonly />
						</div>
						<div class="row my-1">
							<div class="col text-center">인원수</div>
						</div>
						<div class="row my-1">
							<div class="col"></div>
							<input type="text" class="col form-control" id="cancelHuman"
								readonly>
							<div class="col"></div>
						</div>
						<div class="row my-1 mt-3">
							<button type="button" class="col btn btn-primary ms-4"
								onclick="cancelReservation(${placeVo.no})">확인</button>
							<button type="button" data-bs-dismiss="modal"
								class="col btn btn-danger ms-4">취소</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	function showReservation(resVo) {
		document.querySelector('#cancelStartDate').value = new Date(resVo.startDate).toISOString().split("T")[0];
		document.querySelector('#cancelEndDate').value = new Date(resVo.endDate).toISOString().split("T")[0];
		document.querySelector('#cancelHuman').value = resVo.human;
	}

	function cancelReservation(placeNo) {
		$.ajax({
			method:"POST",
			url: "/hallo03talk/reservation/cancel",
			data: {
				"placeNo" : placeNo
			},
			success: function (response) {
				if (response == 1) {
					alert('취소 성공');
					history.go(0);
				} else {
					alert('취소 실패');
				}
			}
		});
	}
</script>

</body>
<script src="/hallo03talk/resources/js/report.js"></script>
<script src="/hallo03talk/resources/js/onePhoto.js"></script>
<script src="/hallo03talk/resources/js/reviewForm.js"></script>
<script src="/hallo03talk/resources/js/updateReview.js"></script>
<script src="/hallo03talk/resources/js/star.js"></script>
</html>
