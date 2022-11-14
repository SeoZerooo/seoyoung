<%@page import="com.h3.admin.AdminPageVo"%>
<%@page import="com.h3.reportBoard.vo.ReportBoardVo"%>
<%@page import="com.h3.reportComment.vo.ReportCommentVo"%>
<%@page import="com.h3.reportUser.vo.ReportUserVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<ReportBoardVo> voList = (ArrayList<ReportBoardVo>)request.getAttribute("voList");
   
	AdminPageVo pv = (AdminPageVo)request.getAttribute("pv");
    
   	int currentPage = pv.getCurrentPage();
   	int startPage = pv.getStartPage();
   	int endPage = pv.getEndPage();
   	int MaxPage = pv.getMaxPage();
    %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 @font-face {
        font-family: "Somi";
        src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff")
          format("woff");
        font-weight: normal;
        font-style: normal;
      }
    .right-nav {
      width: 1270px;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      margin: auto	;
      
    }

    .board {
     
      height:100%;
      border-radius:20%;
    }

    .report-board-table {
    border : 5px dashed orange;
    
    border-radius: 20%;
     
    }

    .report-board-table th {
      text-align: center!important;
      width: 310px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    thead {
      background:white;
    }

    thead > tr {
      height:55px;
    }

    tbody > tr {
      background:sandybrown;
      border-bottom: 3px solid white;
      height:35px;
      color:white;
      cursor:pointer;
    }
    
    tbody > tr:hover{
    opacity:0.6;
    }
    
    li{
    list-style:none;
    }
    #reportImg img{
    	width: 40px;
    	height: 40px;
    }
     #reportImg {
    	 font-family: "Somi";
    	 margin-left:500px;
    	 font-size:40px;
    }
    #page a{
    display:inline-block;
    width: 27px;
    border-radius:5px;
    border:1px solid orange;
    text-decoration:none;
    text-align:center;
     color:orange;
    }
    #page{
    margin-top:60px;
    text-align:center;
   
    }
    .btn-area{
    float:right;}
    .btn-area span{
    border:1px solid orange;
    border-radius:5px;
    display:inline-block;
    height:30px;
    cursor:pointer;
    color:#fff;
    background-color: #ff9f40;
    }
    .check{
    margin-right:20px;
    width: 20px;
    }
   input[type=checkbox] {

-ms-transform: scale(2); /* IE */

-moz-transform: scale(2); /* FF */

-webkit-transform: scale(2); /* Safari and Chrome */

-o-transform: scale(2); /* Opera */

padding: 10px;

}

.btn-area span:hover{
opacity:0.6;
}

thead tr:nth:child(2):hover{
opacity:0.5;
}
</style>

</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">

					
		<ul>
	<li id="reportImg"><img src="<%=request.getContextPath()%>/resources/img/report.png" alt="" /> 신고 게시글 관리</li>
</ul>			
<hr />
<div class="right-nav">
	
  <div class="board">
    <table class="report-board-table">
      <thead>
      <tr>
       <th width="15">신고번호</th>
        <th width="30">신고유저</th>
        <th width="30">신고제목</th>
        <th width="25">신고날짜</th>
      </tr>
      </thead>
      <tbody>
     
      
       
        <%
		for(int i = 0; i<voList.size(); i++){
		%>
		<tr>
			<th><input class="check"type="checkbox" name="num" value="<%=voList.get(i).getNo()%>" /><%=voList.get(i).getNo()%></th>
			
			<th onclick="location.href='/hallo03talk/admin/contentDetail?num=<%=voList.get(i).getNo()%>'"><%=voList.get(i).getGuilty()%></th>
			<th onclick="location.href='/hallo03talk/admin/contentDetail?num=<%=voList.get(i).getNo()%>'"><%=voList.get(i).getContent()%></th>
			<th onclick="location.href='/hallo03talk/admin/contentDetail?num=<%=voList.get(i).getNo()%>'"><%=voList.get(i).getEnrollDate()%><th>
			
			
		</tr>
	
		<%} %>
      
      
      </tbody>
    </table>
    <div id="page">
    <%if(currentPage !=1) {%>
			<a href="<%=request.getContextPath() %>/admin/reportContent?p=<%=currentPage-1%>"> &lt; </a>
			<%} %>
			
			<%for(int i = startPage; i<= endPage; ++i) {%>
				<%if(i ==currentPage){ %>
				
				<a style ="background-color:orange; color:#fff"><%=i%></a>
				<%} else{ %>
					<a  href="<%=request.getContextPath() %>/admin/reportContent?p=<%=i%>"><%=i%></a>
				<%} %>
				
			
			<%} %>
			<%if(currentPage !=MaxPage) {%>
			<a  href="<%=request.getContextPath() %>/admin/reportContent?p=<%=currentPage+1%>">&gt;</a>
			<%} %>
               <div class="btn-area">
                 <span onclick="f01();">
                신고목록 삭제</span>
                <span onclick="f02();">신고 게시글 삭제</span>
                
               
               </div>
              
     </div>
    
   <br />
    <br />
    <hr />
  </div>
 
    
</div>
					

					</div>
			</main>


	<footer></footer>

<script>
	function f01(){
		
	
		
		if(confirm("삭제 하시겟습니까?")){
		alert("삭제 완료");
		
		const elemArr = $('input[name=num]');
		const numArr = [];
		
		for(let i = 0; i < elemArr.length; ++i){
			 if( elemArr[i].checked == true ) {
				 numArr.push(elemArr[i].value);
	            }
	
		//	numArr.push(elemArr[i].value);
		}
		
		console.log(numArr);
		
		let str = '';
		
		for(let i = 0; i < numArr.length; ++i){
			str += 'num=' + numArr[i];
			str += '&';	
			
		
		}
		
		
		location.href='/hallo03talk/admin/reportContentDelete?' + str;
		}else{
			alert("취소 하셨습니다");
		}
	}
	
function f02(){
		
	
		
		if(confirm("신고된 게시글을 삭제 하시겟습니까?")){
		alert("게시글 삭제 완료");
		
		const elemArr = $('input[name=num]');
		const numArr = [];
		
		for(let i = 0; i < elemArr.length; ++i){
			 if( elemArr[i].checked == true ) {
				 numArr.push(elemArr[i].value);
	            }
	
		//	numArr.push(elemArr[i].value);
		}
		
		console.log(numArr);
		
		let str = '';
		
		for(let i = 0; i < numArr.length; ++i){
			str += 'num=' + numArr[i];
			str += '&';	
			
		
		}
		
		
		location.href='/hallo03talk/admin/ContentDelete?' + str;
		}else{
			alert("취소 하셨습니다");
		}
	}



	
</script>
</body>
</html>
