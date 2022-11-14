package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.party.service.PartyService;
import com.h3.party.vo.PartyVo;

@WebServlet(urlPatterns = "/party/edit")
public class PartyEditController extends HttpServlet {
	
	/*
	 * 공지사항 수정하는 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		PartyVo pv = new PartyService().detailParty(num);
		
		req.setAttribute("pv", pv);
		
		req.getRequestDispatcher("/views/party/Edit.jsp").forward(req, resp);
		
	}//method
	
	
	/*
	 * 공지사항 수정하기
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pno = req.getParameter("pNo");
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		PartyVo pv = new PartyVo();
		pv.setNo(Integer.parseInt(pno));
		pv.setCategoryName(category);
		pv.setTitle(title);
		pv.setContent(content);
		
		int result = new PartyService().editParty(pv);
		

		if (result == 1) {
			resp.sendRedirect("/hallo03talk/party/detail?num="+pno);
		} else {
			
		}
	}

}//class















