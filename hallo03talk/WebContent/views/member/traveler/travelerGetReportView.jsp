<%@page import="com.h3.reportUser.vo.ReportUserVo"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
         ArrayList<ReportUserVo> voList = (ArrayList<ReportUserVo>)request.getAttribute("voList");
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
/* ------신고 테이블----------------------------------------------------------------------------- */
#getTable{
    margin-top: 30px;
}
/* ----------------------------------------------------------- */
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
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/traveler/myPage">내 정보</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/travelerMpgPost/list">내가 쓴 글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgReply/list">내가 쓴 댓글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgRsv/list">예약 내역</a>
                              </li>
                              
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgZzim/list">찜 목록</a>
                              </li>
                              <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  신고
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                  <li><a class="dropdown-item" href="/hallo03talk/traveler/getReport">신고 받은 내역</a></li>
                                </ul>
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

              <!-- ------신고 받은 내역-------------------------------------------------------- -->
                
            <table class="table table-hover" id="getTable">
                <thead>
                  <tr>
                    <th scope="col" style="width: 5%;"></th>
                    <th scope="col" style="width: 5%;">#</th>
                    <th scope="col" style="width: 20%;">혐의</th>
                    <th scope="col"  class="text-center" style="width: 50%;">내용</th>
                  <th scope="col" class="text-center" style="width: 20%;">날짜</th>
                  </tr>
                </thead>

<!-- ---------------------------------------------------------------------------------------- -->
                <tbody>
                    <%for(int i=0; i < voList.size(); i++){ %> 
                   
                       <tr>
                           <th scope="row">
                               <input type="checkbox" name="ckNo" value="<%= voList.get(i).getNo()%>">
                           </th>
                           <th scope="row"><%=voList.get(i).getNo() %></th>
                           <td ><%=voList.get(i).getGuilty() %></td>
                           <td><%=voList.get(i).getContent() %></td>
                           <td class="text-center"><%=voList.get(i).getEnrollDate() %></td>
                       </tr>
                   <%}%>
                </tbody>
<!-- -------------------------------------------------------------- -->
              </table>
          

        </div>
        
        
    </main>
    
   
    <footer></footer> 
    
   
<!-- ------선택 삭제------------------------------------------------------- -->

    <input id="ajaxResult" type="hidden" value='0'>
   
   <script>
   
   $(".deleteButtonAll").click(function(e) {
      $('input:checkbox[name="ckNo"]').each(function() {
         this.checked = true;

      })
   });
   
   
   $(".deleteButton").click(function(e) {
	   
	   var ans = confirm("선택하신 댓글을 삭제하시겠습니까?");
       if(!ans) return false;
       
       var result = -1;
	   
      $('input:checkbox[name=ckNo]').each(function (index) {

         var checkBoxArr = []; 
         var data;
          
         if($(this).is(":checked")==true){
             checkBoxArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
             
            data = $(this).val();
            console.log(data);
           
           var url = "${pageContext.request.contextPath}/travelerMpgReport/delete"
           
             $.ajax({
               url  : url,
               type : "post",
               data : {data} ,
               success : function(data) {
            	   console.log("ajax 성공");
            	   $('#ajaxResult').val(1);
                   //alert("댓글이 삭제 되었습니다.");
                   //location.reload();
               },
               error : function(data) {
                   //alert("댓글이 삭제되지 않았습니다.");
               }
           });  
           
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