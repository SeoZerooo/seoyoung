


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
BossVo bv = (BossVo)session.getAttribute("BossLoginMember");
request.setAttribute("bv", bv);

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
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<main>
		<form id="container" class="container-xxl"
			action="/hallo03talk/place/add" method="post"
			enctype="multipart/form-data">
			<input type="hidden" value="${BossLoginMember.no }" name="no">
			<input type="hidden" value="${BossLoginMember.id }" name="id">
			<input type="hidden" value="${BossLoginMember.pwd }" name="pwd">
			
			<!-- 슬라이드 -->
			<div
				class="d-flex w-100 border border-2 justify-content-center align-items-center mt-3"
				style="height: 500px">
				<input type="file" name="slideImgs" multiple class="w-100 h-100 form-control" required />
			</div>

			<div class="place-info py-3">
				<div class="row border border-3">
					<!-- 장소사진 -->
					<div
						class="d-flex col-3 justify-content-center align-items-center border border-2">
						<input type="file" name="placeImg" class="form-control" required/>
					</div>
					<div class="col text-center py-5">
						<select name="category_no" class="form-control text-center my-3">
							<option value="1">카페</option>
							<option value="2" selected>숙소</option>
							<option value="3">식당</option>
						</select>
						<!-- 장소명 -->
						<input type="text" placeholder="장소명" class="h2 form-control" name="placeName" required/>
						<!-- 장소설명 -->
						<p class="py-2 px-5">
							<textarea name="placeContent" class="h5 form-control" cols="50" rows="7"
								placeholder="장소 설명" required></textarea>
						</p>
						<p class="py-2 px-5 row">
							<input type="text" name="placeAddr" id="placeAddr" class="col text-center form-control"
								readonly placeholder="주소" required/>
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
			<div class="text-center">
				<button type="button" class="btn btn-warning my-3" onclick="checkPlaceAdd()">장소 등록</button>
			</div>
			<input type="hidden" value="${ BossLoginMember.no }" name="bossNo">
		</form>
	</main>

	<footer></footer>
	<c:if test="${ empty BossLoginMember }">
		<script>
			alert('사장님만 등록가능합니다');
			location.href = "/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0";
		</script>
	</c:if>

</body>
<script>
	function checkPlaceAdd() {
		const placeAddr = document.querySelector('#placeAddr').value.replace(/ /g,"");
		if (placeAddr == "") {
			alert('주소를 추가해주세요');
		} else if(!document.querySelector('[name="placeName"]').value) {
			alert('장소명을 추가해주세요');
		} else if(!document.querySelector('[name="placeContent"]').value) {
			alert('부가 설명을 추가해주세요');
		}   else if(!document.querySelector('[name="slideImgs"]').value) {
			alert('사진을 추가해주세요');
		} else if(!document.querySelector('[name="placeImg"]').value) {
			alert('사진을 추가해주세요');
		} else if(placeAddr.includes('제주')) {
			document.querySelector('main #container').submit();
		} else {
			alert('제주도만 등록가능합니다.');
		}
	}
</script>
<script src="/hallo03talk/resources/js/jusoPopUp.js"></script>
</html>
