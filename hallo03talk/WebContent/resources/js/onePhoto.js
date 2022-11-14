// 슬라이드에 있는 이미지 전부 가져옴
const imgs = document.querySelectorAll(".carousel-item img");

// 각자에 부여
imgs.forEach((item) => {
  // 드래그 금시
  item.draggable = "none";
  // 손가락 표시
  item.style.cursor = "pointer";
  // 클릭했을때
  item.addEventListener("click", () => {
    // 클릭한 이미지 복사
    const img = item.cloneNode();
    // 전에 있던 속성값, 클래스명 제거
    img.removeAttribute("height");
    img.classList.remove("d-block");
    img.classList.remove("w-100");

    // 이미지 넣어줄 div 태그 생성
    const popupDiv = document.createElement("div");
    // css 적용
    popupDiv.classList.add("popupImg");
    // img 자식으로 추가
    popupDiv.appendChild(img);
    // body 에 추가
    document.body.append(popupDiv);
    // 이미지 크게 보여줄때 스크롤 막기
    document.body.classList.add("noScroll");

    // 커진 이미지 클릭시 닫기
    popupDiv.addEventListener("click", () => {
      popupDiv.style.display = "none";
      document.body.removeChild(popupDiv);
      document.body.classList.remove("noScroll");
    });
  });
});
