//더보기 
$(function(){
    $("div").slice(0, 3).show(); // 최초 3개 선택
    $("#load").click(function(e){ // Load More를 위한 클릭 이벤트e
    e.preventDefault();
    $("div:hidden").slice(0, 10).show(); // 숨김 설정된 다음 10개를 선택하여 표시
    if($("div:hidden").length == 0){ // 숨겨진 DIV가 있는지 체크
    alert("더 이상 항목이 없습니다"); // 더 이상 로드할 항목이 없는 경우 경고
    }
    });
    });
    
//card 클릭하면 해당 게시글 들어가지는
$(function(){
	$('.card').click(function(){
		//div class = card 클릭 되었을 때, 동작할 내용
		
		//글 번호 가져오기
		const num = $(this).children().eq(0).text();
		//해당 번호 이용해서 요청 보내기
		location.href='/hallo03talk/place/searchDetail?num=' + num;
	});
})