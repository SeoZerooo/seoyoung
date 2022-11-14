package com.h3.admin.controller.place;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.AdminPageVo;
import com.h3.admin.service.AdminPlaceService;
import com.h3.admin.service.AdminReportService;
import com.h3.place.vo.PlaceVo;
@WebServlet(urlPatterns = "/admin/placeAdmin")
public class AdminPlaceController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int listCount;   //현재 총 게시글 갯수
		int currentPage; 	//현재 페이지(==사용자가 요청한)
		int pageLimit;	 //페이지 하단에 보여질 페이지 버튼의 최대 개수
		int boardLimit;	//한 페이지 내 보여질 게시글 최대 개수
		//위의  4개를 이용해서 아래 3개 값 구하기
		
		int maxPage;		//가장 마지막 페이지
		int startPage;		//페이징바의 시작		
		int endPage;		//페이징바의 끝
		
		//listCount 값 구하기
		listCount = new AdminReportService().getCountPlace();//DB에 가서, board 테이블의 총 게시글 갯수
		currentPage = Integer.parseInt(req.getParameter("p"));
		
		pageLimit = 10;
		
		boardLimit = 10;
		
		
		//maxPage : 제일 마지막 페이지 (총 페이지 수)
		//listCount
		maxPage = (int)Math.ceil(((double)listCount / boardLimit));
		
		//startPage :페이징바의 시작
		
		//pageLimit(페이지 하단에 보여질 페이지 버튼의 최대 개수), currentPage(현재페이지)
		//위 2개값 이용해서 구할수 있다.
		//currentPage 	startPage
		//    1             1
		//    5             1
		//    10            1
		//    11            11
		//    15            11
		//    20            11
		//ex) 페이징바의 목록이 10개 단위라는 가정하에,
		
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
//		endPage : 페이징 바의 끝
//		start Page, pageLimit , (+maxPage)
//		위 3개의 영향을 받음
//		
//		ex) pageLimit 이 10 이라는 가정하에,
//
//		startPage : 1 = > 10
//		startPage : 11 = > 20
//		startPage : 21 = > 30
		
		endPage = startPage + pageLimit - 1 ;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		//vo 에 페이지 관련 변수 담기
		AdminPageVo pageVo = new AdminPageVo();
		pageVo.setBoardLimit(boardLimit);
		pageVo.setCurrentPage(currentPage);
		pageVo.setEndPage(endPage);
		pageVo.setListCount(listCount);
		pageVo.setMaxPage(maxPage);
		pageVo.setPageLimit(pageLimit);
		pageVo.setStartPage(startPage);
		
		
		
		ArrayList<PlaceVo> voList  =	new AdminPlaceService().selectListPlace(pageVo);
		
		//결과에 따라 화면 선택
		System.out.println(voList.size());
		
		req.setAttribute("pv", pageVo);
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/member/admin/placeAdmin.jsp").forward(req, resp);
		
	}

}
