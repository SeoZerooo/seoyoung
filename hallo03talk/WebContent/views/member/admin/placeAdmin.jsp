<%@page import="com.h3.admin.AdminPageVo"%>
<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    ArrayList<PlaceVo> voList = (ArrayList<PlaceVo>)request.getAttribute("voList");
    
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
      width: 80%;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      margin: auto	;
      
    }

    .board {
      width:100%;
      height:100%;
    }

    .report-board-table {
      width:100%;
    }

    .report-board-table th {
      text-align: center!important;
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
    margin-top: -180px;
    text-align: center;
   
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
margin:0;
padding:0;
-ms-transform: scale(2); /* IE */

-moz-transform: scale(2); /* FF */

-webkit-transform: scale(2); /* Safari and Chrome */
margin-left:10px;
margin-top:10px;





}
thead tr:nth:child(2):hover{
opacity:0.5;
}
.right-nav {
      width:80%;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      margin:auto;
     
    }

    .board {
      width:100%;
      height:100%;
    }

    .acc-board-table {
      width:100%;
    }

    .acc-data {
      width:250px;
      height:300px;
      border:1px solid darkgray;
      float:left;
      margin-right:15px;
    }

    .acc-image-area {
      width:249px;
      height:170px;
    }

    .acc-img {
      width:100%;
      height:100%;
    }

    .acc-info {
      width:100%;
      height:80px;
      margin-top:30px;
    }

    .acc-title,.acc-sub-data  {
      width:100%;
      height:50%;
    }

    .acc-col{
      width:100%;
      height:50%;
      float:left;
    }
	.acc-col img{
	margin-left: 5px;
	margin-right: 5px;
	margin-bottom:5px;
	width: 20px;
	height: 20px;
	}
</style>

</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">

					
		<ul>
	<li id="reportImg"><img src="<%=request.getContextPath()%>/resources/img/house.png" alt="" />숙소관리</li>
</ul>			
<hr />
<div class="right-nav">
  <div class="board">
    <div class="acc-board-table">
     
     
      <%
		for(int i = 0; i<voList.size(); i++){
			voList.get(i).getName();
		%>
		
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" name="num" value="<%=voList.get(i).getNo()%>" />
         <img class="acc-img" src="<%=request.getContextPath()%>/resources/upload/place/<%=voList.get(i).getPhotoName()%>"/>
        </div>
        <div class="acc-info">
          <div class="acc-title"><%=voList.get(i).getName()%></div>
          <div class="acc-sub-data">
            <div class="acc-col"><%=voList.get(i).getAddress()%></div>
           
          </div>
        </div>
      </div>
     <%} %>
     
     
     
     
     
    </div>
    
  </div>
</div>
 <div id="page">
   <%if(currentPage !=1) {%>
			<a href="<%=request.getContextPath() %>/admin/placeAdmin?p=<%=currentPage-1%>"> &lt; </a>
			<%} %>
			
			<%for(int i = startPage; i<= endPage; ++i) {%>
				<%if(i ==currentPage){ %>
				
				<a style ="background-color:orange; color:#fff"><%=i%></a>
				<%} else{ %>
					<a  href="<%=request.getContextPath() %>/admin/placeAdmin?p=<%=i%>"><%=i%></a>
				<%} %>
				
			
			<%} %>
			<%if(currentPage !=MaxPage) {%>
			<a  href="<%=request.getContextPath() %>/admin/placeAdmin?p=<%=currentPage+1%>">&gt;</a>
			<%} %>
               <div class="btn-area">
                <span onclick="f01();"> 숙소 삭제</span>
                
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
		
		
		location.href='/hallo03talk/admin/placeDelete?'+ str;
		}else{
			alert("취소 하셨습니다");
		}
	}
	</script>
</body>
</html>