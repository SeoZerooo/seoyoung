package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PartypageController {
	

@WebServlet(urlPatterns="/party/page")
public class PartyListController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
//		listCount = new PartyPageService().getCount();
		
		//테스트
//		System.out.println(listCount);
		
		//이벤트 게시판 목록
		req.getRequestDispatcher("/views/party/list.jsp").forward(req,resp);
	}
}
}	
