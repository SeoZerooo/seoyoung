<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
request.setCharacterEncoding("UTF-8"); //한글깨지면 주석제거
//request.setCharacterEncoding("EUC-KR"); //해당시스템의 인코딩타입이 EUC-KR일경우에 String inputYn =
request.getParameter("inputYn");
String roadFullAddr = request.getParameter("roadFullAddr");
String roadAddrPart1 = request.getParameter("roadAddrPart1");
String roadAddrPart2 = request.getParameter("roadAddrPart2");
String engAddr = request.getParameter("engAddr");
String jibunAddr = request.getParameter("jibunAddr");
String zipNo = request.getParameter("zipNo");
String addrDetail = request.getParameter("addrDetail");
String admCd = request.getParameter("admCd");
String rnMgtSn = request.getParameter("rnMgtSn");
String bdMgtSn = request.getParameter("bdMgtSn");
/** API 서비스 제공항목 확대 (2017.02) **/
String detBdNmList = request.getParameter("detBdNmList");
String bdNm = request.getParameter("bdNm");
String bdKdcd = request.getParameter("bdKdcd");
String siNm = request.getParameter("siNm");
String sggNm = request.getParameter("sggNm");
String emdNm = request.getParameter("emdNm");
String liNm = request.getParameter("liNm");
String rn = request.getParameter("rn");
String udrtYn = request.getParameter("udrtYn");
String buldMnnm = request.getParameter("buldMnnm");
String buldSlno = request.getParameter("buldSlno");
String mtYn = request.getParameter("mtYn");
String lnbrMnnm = request.getParameter("lnbrMnnm");
String lnbrSlno = request.getParameter("lnbrSlno");
String emdNo = request.getParameter("emdNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<main>
		<form id="container" class="container-xxl" action="/hallo03talk/place/update" method="post">
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
			<div class="place-info py-3">
				<div class="row border border-3">
					<!-- 장소사진 -->
					<c:set var="s" value="${ fn:length(photoList)-1 }"></c:set>
					<img
						src="/hallo03talk/resources/upload/place/${ photoList.get(s).name }"
						alt="" class="col-3" />
					<div class="col text-center py-5">
						<select name="category_no">
							<option value="1">카페</option>
							<option value="2" selected>숙소</option>
							<option value="3">식당</option>
						</select>
						<!-- 장소명 -->
						<input type="text" placeholder="장소명" class="h2" name="placeName"
							value="${ placeVo.name }" />
						<!-- 장소설명 -->
						<p class="h4 py-2 px-5">
							<textarea name="placeContent" class="h5" cols="50" rows="7"
								placeholder="장소 설명">${ placeVo.content }</textarea>
						</p>
						<p class="py-2 px-5 row">
							<input type="text" name="placeAddr" class="col text-center"
								readonly placeholder="주소" required />
						</p>
						<button type="button" class="btn btn-primary col"
							onclick="goPopup();">주소 검색</button>
					</div>
					<div
						class="d-flex flex-column col-2 justify-content-center align-items-center">
						<div>${ BossLoginMember.id }</div>
						<div>${ BossLoginMember.phone }</div>
						<div>${ BossLoginMember.email }</div>
					</div>
				</div>
			</div>
			<input type="hidden" value="${ BossLoginMember.no }" name="bossNo" />
			<input type="hidden" value="${ placeVo.no }" name="placeNo" />
			<div class="text-center">
				<button class="btn btn-warning my-3" >장소 수정</button>
				<button type="button" class="btn btn-danger" onclick="placeDel(${placeVo.no});">장소 삭제</button>
			</div>
		</form>
	</main>
	<footer></footer>

	<c:if test="${ BossLoginMember.no ne placeVo.bossNo }">
		<script>
			alert('해당 가게의 사장님만 수정가능합니다');
			location.href = "/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0";
		</script>
	</c:if>

	<script>
		function placeDel(placeNo) {
			if (confirm('정말로 삭제하시겠습니까?')) {
				$.ajax({
					method : "POST",
					url: "/hallo03talk/place/del",
					data: {
						"placeNo" : placeNo
					},
					success: function (response) {
							alert('삭제 완료');
							location.href='/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0'
					}
				});
			} else {
			}
		}
	</script>
</body>
<script src="/hallo03talk/resources/js/jusoPopUp.js"></script>
</html>