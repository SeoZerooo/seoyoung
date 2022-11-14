<%@page import="com.h3.reportBoard.vo.ReportBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
    <%
    
    ReportBoardVo vo = (ReportBoardVo)request.getAttribute("vo");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
* {
    margin: 0;
}



ul, li {
    list-style: none;
}

a {
    text-decoration: none;

    color: inherit;

}

.board_wrap {
    margin-left: auto;
    margin-right: auto;
    margin-top:50px;
    width: 85%;
    padding: 1rem;
}


.board_title strong {
    font-family: 'Somi';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff') format('woff');
    font-weight: normal;
    font-style: normal;     
margin-bottom: 30;    
    font-size: 4rem;    
}

.board_title p {
    margin-top: 5px;
    font-size: 1.4rem;
}

.bt_wrap {
    margin-top: 30px;
    text-align: center;
    font-size: 0;
}

.bt_wrap a {
    display: inline-block;
    min-width: 80px;
    margin-left: 10px;
    padding: 10px;
    border : 1px solid #000;
    border-radius: 2px;
    font-size: 1.4rem;
}

.bt_wrap a.on {
    border-color: orange;
    background: orange;
    color: #fff;
    text-decoration:none;
}

.bt_wrap a:first-child {
    margin-left: 0;
}

.board_list {
    width: 100;
    border-top: 2px solid #000;
}

.board_list > div {
    border-bottom: 1px solid #ddd;
    margin-right: 10;
    font-size: 0;
}

.board_list > div.top {
    border-bottom:1px solid #999;
}

.board_list > div:last-child {
    border-bottom: 2px solid #000;
}

.board_list > div > div {
    display: inline-block;
    padding: 15px 0;
    text-align: center;
    font-size: 20px;
}


.board_list > div.top > div {
    font-weight: 600%;
}

.board_list .num {
    width: 10%;
}

.board_list .title {
    width: 80%;
    text-align: left;
}

.board_list .top .title {
    text-align: center;
}

.board_list .writer {
    width: 10%;
    text-align: left;

}

.board_list .date {
    width: 10%;
    text-align: center;
}

.board_list .count {
    width: 10%;
}

.board_page {
    margin-top: 30pt;
    text-align: center;
    font-size: 0;
}

.board_page a {
    display: inline-block;
    width: 32px;
    height: 32px;
    border: 1px solid #ddd;
    box-sizing: border-box;
    border-left: 0;
    vertical-align: middle;
    line-height: 100%;
}

.board_page a.bt {
    padding-top: 4px;
    font-size: 1.1rem;
    letter-spacing: -1px;
}

.board_page a.num.on {
    border-color: #ddd;
    background: #ffc107;
    color: #fff;
}


.board_page a.num {
    padding-top: 5px;
    font-size: 1.1rem;
}

.board_page a:first-child {
    border-left: 1px solid #ddd;
}

.content {
    width: 100%;
    border-top: 2px solid #000;
    font-size: 1.4rem;
}

.content .title {
    padding: 20px 15px;
    border-bottom: 1px dashed #ddd;
    font-size: 2rem;
}

.content .info {
    padding: 15px;
    border-bottom: 1px solid #999;
    font-size: 0;
}

.content .info dl {
    display: inline-block;
    position: relative;
    padding: 0 20px;
    

}

.content .info dl:first-child {
    padding-left: 0;
}

.content .info dl::before {
    content: "";
    display: block;
    position: absolute;
    top: 1px;
    left: 0;
    width: 1px;
    height: 13px;
    background: #fff;

}

.content .info dl:first-child:before {
    display: none;
}


.content .info dl dt {
	margin-bottom: 0;
    display: inline-block;
    font-size: 1.2rem;
}

.content .info dl dd {
	margin-bottom: 0;
    display: inline-block;
    font-size: 1.2rem;
    margin-left: 10px;
    color: #777;    
}

.content .cont {
    padding: 15px;
    border-bottom: 2px solid #000;
    line-height: 100%;
    font-size: 1.4rem;
}

.write .catag {
	border-top: 2px solid #000;
}

.write .catag,
.write .title {
	padding: 15px;
}

.write .title {
	border-top: 1px dashed #ddd;
	border-bottom: 1px solid #000;
}

.write .cont {
	border-bottom: 2px solid #000;
}

.write .catag dt, .write .catag dd,
.write .title dt, .write .title dd {
	display: inline-block;
	vertical-align: middle;
	test-size: 1.4rem;
}

.write .catag dt {
	width: 100px;
}

.write .title dt {
	width: 100px;
}

.write .cont textarea {
	display: block;
	width: 100%;
	height: 300px;
	padding: 15px;
	box-sizing: border-box;
	border: 0;
	resize: vertical;
}

.registerBox {
    width: 360px;
    height: 620px;
    margin: auto;
    background-color: #fff;
    border-radius: 3px;
}

.registerBox h1 {
    text-align: center;
    padding-top: 15px;
}

.registerBox h4 {
    text-align: center;
}

.registerBox form {
    width: 300px;
    margin-left: 20px;
}

.registerBox form label{
    display: flex;
    margin-top: 20px;
    font-size: 18px;
}

.registerBox form input {
    width: 100%;
    padding: 7px;
    border: none;
    border: 1px solid #777;
    border-radius: 6px;
    outline: none;
}

.registerBox input[type="button"] {
    width: 320px;
    height: 35px;
    margin-top: 20px;
    border: none;
    background-color: aquamarine;
    color: #fff;
    font-size: 18px;
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
		<div class="board_wrap">
        <div class="board_title">
            <h6><strong>신고내용</strong></h6>
           
        </div> 
        <div class="content_wrap">
            <div class="content">
                <div class="title" style="text-overflow: ellipsis;">
                   <%=vo.getGuilty() %>
                   
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd style="text-overflow: ellipsis;"><%=vo.getNo() %></dd>
                    </dl>
                    <dl>
                      
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd style="text-overflow: ellipsis;"><%=vo.getEnrollDate() %></dd>
                    </dl>
                    <dl>
                      
                    </dl>
                </div>
                <div class="cont">
                    <p >
                      <%=vo.getContent()%>
                    </p>
                </div>
              </div>

            </div>
            <div class="bt_wrap">
                <a  onclick="location.href='/hallo03talk/admin/reportContent?p=1'" href="#" class="on">목록으로 돌아가기</a>
               
            </div>
        </div>			
					</div>
			</main>


	<footer></footer>

</body>
</html>