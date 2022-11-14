<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
 <link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">
					<div class="board_wrap">
        <div class="board_title">
            <strong>이벤트 소식</strong>
            <P>제주도에서만 즐길 수 있는 축제 및 가게들의 행사를 안내해드립니다!</P>
        </div> 
        <div class="content_wrap">
            <div class="content">
                <div class="title">
                    ${ pv.title }
                   
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>${ pv.no }</dd>
                    </dl>
                    <dl>
                        <dt>작성자</dt>
                        <dd>${ pv.bossId }</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>${ pv.enrollDate }</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>${ pv.cnt }</dd>
                    </dl>
                </div>
                <div class="cont">
                    <p>
                      ${ pv.content }
                    </p>
                </div>
              </div>

            </div>
            <div class="bt_wrap">
                <a href="/hallo03talk/party/list" class="on">목록</a>
                <c:if test="${ BossLoginMember.id eq pv.bossId }">
                <a href="/hallo03talk/party/edit?num=${pv.no }">수정</a>
                <a href="/hallo03talk/party/del?num=${pv.no }">삭제</a>
                </c:if>
            </div>
        </div>			
      </div>
			</main>


	<footer></footer>


</body>
</html>