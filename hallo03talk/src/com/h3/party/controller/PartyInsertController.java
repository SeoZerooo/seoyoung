package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.party.service.PartyService;
import com.h3.party.vo.PartyVo;



@WebServlet(urlPatterns = "/party/write")
public class PartyInsertController extends HttpServlet {
	
	/*
	 * 공지사항 작성 페이지 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/party/Write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		//꺼낸데이터 뭉치기
		//3개 (작성자번호, 제목, 내용)
		String category = req.getParameter("category");
		String bossNo = req.getParameter("bossNo");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		PartyVo vo = new PartyVo();
		vo.setBossNo(Integer.parseInt(bossNo));
		vo.setTitle(title);
		vo.setContent(content);
		vo.setCategoryName(category);
		
		int result = new PartyService().writeParty(vo);
		
		if (result == 1) {
			resp.sendRedirect("/hallo03talk/party/list");
		} else {
			resp.sendRedirect("/hallo03talk/party/list");
		}
		
	}
	

}//class













