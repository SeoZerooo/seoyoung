<%@page import="com.h3.traveler.vo.MpgReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%

  	MpgReservationVo rvo = (MpgReservationVo)session.getAttribute("rvo");

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
/* ------예약내역----------------------------------------------------------------------------- */
#reservationTable{
    margin-top: 30px;
}

.middle{
  border: 1px solid gray;
  height: 400px;

}
/* --------------------------------------------------------------------------- */

.form-wrap {
            /* width: 380px; */
            width: 500px;
            height: 580px;
            position: relative;
            margin: auto;
            margin-top: 120px;
            /* margin-bottom: 120px; */
            border-radius: 25px;
            padding: 5px;
            overflow: hidden;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        
        .button-wrap {
            width: 290px;
            margin: 35px auto;
            padding: 10px;
            position: relative;
			border-radius: 6px;
			background-color: rgb(233, 187, 100);
            top: 60px;
            color: white;
            
        }
    
    	.button-wrap:hover{
    	 	background-color: skyblue;
    	}
    	
        .input-group {
            top: 80px;
            height: 0px;
            transition: .5s;
            margin-left: 50px;
        }
        
        .input-field {
            width: 100%;
            padding: 10px 0;
            margin: 5px 0;
            border: none;
            border-bottom: 1px solid #999;
            outline: none;
            background: transparent;
        }
        
   
        #gender_table{
            margin-top: 13px;
        }
        
        #login {
            left: 50px;
        }
        
        #register {
            left: 450px;
        } 
        #travelerIdCheck, #travelerNickCheck, #bossIdCheck{
            border: 0;
            border-radius: 6px;
            width: 80px;
            background-color: rgb(233, 187, 100);
            color: white;
        }
        #travelerIdCheck:hover, #travelerNickCheck:hover, #bossIdCheck:hover, .join:hover{
          background-color: skyblue;
        }
        
     .ggg{
        /* border: 2px solid red; */
        width: 300px;
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
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/traveler/myPage">내 정보</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/travelerMpgPost/list">내가 쓴 글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgReply/list">내가 쓴 댓글</a>
                              </li>
                              <li class="nav-item" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;">
                                <a class="nav-link" href="/hallo03talk/travelerMpgRsv/list">예약 내역</a>
                              </li>
                              
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgZzim/list">찜 목록</a>
                              </li>
                             
                              
                            </ul>
                      </div>
                </div>
              </nav>

     
              <!-- ------예약 내역-------------------------------------------------------- -->
                
            
    
     			<div class="form-wrap">
	                
	                <div class="button-wrap" align="center"> 예약 내역
	                </div>
	                
	              
	                    <div id="login" action="" class="input-group">
	                        <div class="ggg">
	                        
								[예약 번호] : <%=rvo.getNo() %>
								<br><br>
								[예약 날짜] : <%=rvo.getStartDate() %>
								<br><br>
								[예약 만료] : <%=rvo.getEndDate() %>
								<br><br>
								[장소명] : <%=rvo.getName() %>
								<br><br>
								[주소] : <%=rvo.getAddress() %>
								<br><br>
								[인원수] : <%=rvo.getHuman() %>명
						
	                        </div>
	        
	                    </div>
					</div>
<!-- -------------------------------------------------------- -->
        </div>
    </main>
			
			
			<footer></footer>
	


</body>
</html>



