function goPopup() {
  var pop = window.open("/hallo03talk/views/place/jusoPopup.jsp", "pop", "width=570,height=420, scrollbars=yes, resizable=yes");
}
function jusoCallBack(
  roadFullAddr,
  roadAddrPart1,
  addrDetail,
  roadAddrPart2,
  engAddr,
  jibunAddr,
  zipNo,
  admCd,
  rnMgtSn,
  bdMgtSn,
  detBdNmList,
  bdNm,
  bdKdcd,
  siNm,
  sggNm,
  emdNm,
  liNm,
  rn,
  udrtYn,
  buldMnnm,
  buldSlno,
  mtYn,
  lnbrMnnm,
  lnbrSlno,
  emdNo
) {
  if (!roadFullAddr.includes('제주')) {
    alert('제주도만 등록 가능합니다');
    document.querySelector("[name='placeAddr']").value = "";
  } else {
    document.querySelector("[name='placeAddr']").value = roadFullAddr;
  }
}
