<%@page import="java.util.ArrayList"%>
<%@page import="com.h3.boss.vo.BossMyPageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
        ArrayList<BossMyPageVo> voList = (ArrayList<BossMyPageVo>)request.getAttribute("voList");
 %> 
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <style>
      /*할로영삼talk 폰트*/
      @font-face {
            font-family: 'Somi';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff') format('woff');
            font-weight: normal;
            font-style: normal;     
      }
      #MyPageText{
        font-family: 'Somi';
        font-size: 50px;
        margin-top:-20px;
      }
      .content{
        padding: 150px;
      }
     
/* --------네비게이션 바------------------------------------------------------------------- */
  
.navbar{
  margin-top: 60px;  
}
/* ----삭제버튼------------------------ */
.deleteCheck{
    margin-top: 60px;
}
.deleteButton{
  border: 1px solid gray;
  border-radius: 2px;
}
/* ------내가 쓴 글----------------------------------------------------------------------------- */
#writeTable{
    margin-top: 30px;
}
</style>


</head>
<body>


	 <%@ include file="/views/common/header.jsp"%>
	 
	 <main>
        <!--하얀색-->
      <div id="container" class="container-xxl">

          <!-- 내가 작성 한 부분 -->     
          
          <div class="content">
              <div align="center" id="MyPageText">My Page</div> 

              <!-- 네비게이션 바 -->
              <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">      
                      <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">
                              <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/boss/myPage">내 정보</a>
                              </li>
                              <li class="nav-item" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/bossMpgPost/list">내가 쓴 글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/bossMpgReply/list">내가 쓴 답글</a>
                              </li>
                            </ul>
                      </div>
                </div>
              </nav>

            <!-- -------삭제 버튼-------------- -->
     
            <div class="deleteCheck">
              <button class="deleteButtonAll btn btn-warning">전체 선택</button>
              <button class="deleteButton btn btn-primary" style="margin-left: 10px;">삭제</button> 
            </div>

            <!-- ------내가 쓴 글-------------------------------------------------------- -->
              
          <table class="table table-hover" id="writeTable">
              <thead>
                <tr>
                  <th scope="col" style="width: 5%;"></th>
                  <th scope="col" style="width: 5%;">#</th>
                  <th scope="col" class="text-center" style="width: 20%;">게시판</th>
                  <th scope="col" class="text-center" style="width: 50%;">내용</th>
                  <th scope="col" class="text-center" style="width: 20%;">작성일</th>
                </tr>
              </thead>

              <tbody>
                <%for(int i=0; i < voList.size(); i++){ %> 
	                <tr>
		                  <th scope="row">
		                    <input type="checkbox" name="ckNo" value="<%= voList.get(i).getBoard().concat(",").concat(voList.get(i).getNo()) %>">
		                  </th>
		                 	<th scope="row"><%=voList.get(i).getNo() %></th>                   
		                  	<td><%=voList.get(i).getBoard() %></td>  	
		                  	<td onclick="goboard('<%=voList.get(i).getBoard() %>', '<%=voList.get(i).getNo()%>');"><%=voList.get(i).getContent() %></td>  	
		                  	<td class="text-center"><%=voList.get(i).getEnrollDate() %></td>	
	                </tr>
                <%}%>
              </tbody>
<!-- -------------------------------------------------------------- -->
            </table>

    

<!-- -------------------------------------------------------- -->
        </div>
    </main>
	 
	      <!-- --------행 클릭하면 해당 내용 보이기------------------------------ -->
   
	<script>
		function goboard(board, no){
			
			if(board=='장소 등록'){
				location.href = '/hallo03talk/place/one?placeNo=' + no;
			}else{
				location.href = '/hallo03talk/party/list?o=' + no;

			}
			
		}
			 
		</script>
	
	
	<!-- ------------------------------------------------------------------ -->
	 
	 
	 <footer></footer> 


<!-- ------선택 삭제------------------------------------------------------- -->

 <input id="ajaxResult" type="hidden" value='0'>
   
   <script>
   
   $(".deleteButtonAll").click(function(e) {
      $('input:checkbox[name="ckNo"]').each(function() {
         this.checked = true;

      })
   });
   
   
   // 삭제 체크 박스 
   $(".deleteButton").click(function(e) {
      
        var ans = confirm("선택하신 댓글을 삭제하시겠습니까?");
          if(!ans) return false;
          
          var result = -1;
          
         var checkBoxArr = []; 
      
      $('input:checkbox[name=ckNo]').each(function (index) {
          
            //var data;
         
         // 체크된 엘리먼트 
         if($(this).is(":checked")==true){
             console.log($(this).val());
                //checkBoxArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
               
               
             // query에 엘리먼트의 밸류 할당("게시판이름, 게시판번호")
             var query = $(this).val()
             // data array에 게시판이름, 게시판 번호를 할당
             var data = query.split(",") 
             
                data = {
                   "board" : data[0],
                   "no" : data[1]
                } 
                
             checkBoxArr.push(data)

             for(i=0; i< checkBoxArr.length; i++){ 
                   var value = checkBoxArr[i] 
                   
             var url = "${pageContext.request.contextPath}/bossMpgPost/delete"
                      
                       $.ajax({
                         url  : url,
                         type : "post",
                           data : value,
                         success : function(data) {
                            console.log("ajax 성공");
                              $('#ajaxResult').val(1);
                         }, 
                         error : function(data) {
                               //alert("글이 삭제되지 않았습니다.");
                         }
                          
                   });  
             
            }//for
         }//if
       })//each
       
   
       
          
       window.setTimeout(function(){
            if($('#ajaxResult').val() > 0){
                 alert("댓글이 삭제 되었습니다.");
             }else{
                   alert("댓글이 삭제되지 않았습니다.");   
             }
             location.reload();
         }, 500)
         
      })//click

   </script>
   
   <!-- ------선택 삭제-------------------------------------------------------- -->

</body>
</html>