// 선택시 색 변경, 읍면동 변경, 동행/장소 카테고리 변경
const place = document.querySelector("#place");
const together = document.querySelector("#together");


const hotel = document.querySelector("#hotel");
const food = document.querySelector("#food");
const cafe = document.querySelector("#cafe");


const jeju = document.querySelector("#jeju");
const seogwipo = document.querySelector("#seogwipo");
const injeju = document.querySelectorAll(".in-jeju");
const inseogwipo = document.querySelectorAll(".in-seogwipo");

const jejuu = document.querySelector("#jejuu");
const seogwipoo = document.querySelector("#seogwipoo");
const injejuu = document.querySelectorAll(".in-jejuu");
const inseogwipoo = document.querySelectorAll(".in-seogwipoo");


//탭 바뀌는것
//toggle for form & badge
$(".js-switch").click(function() {
  $(".main-content").toggleClass("as-card");
});


//code for image preview
var reader = new FileReader();
reader.onload = function(e) {
  $("#imager").attr("src", e.target.result);
};

function readURL(input) {
  if (input.files && input.files[0]) {
    $("#imager").css("visibility",'visible');
    reader.readAsDataURL(input.files[0]);
  }
}

$("#image-input").change(function() {
  readURL(this);
});

  