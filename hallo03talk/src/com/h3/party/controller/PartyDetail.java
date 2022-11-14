package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.party.service.PartyService;
import com.h3.party.vo.PartyVo;

@WebServlet(urlPatterns = "/party/detail")
public class PartyDetail extends HttpServlet {
	
	
	/*
	 * 공지사항 상세조회 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		
		PartyVo pv = new PartyService().detailParty(num);
		
		
		
		req.setAttribute("pv", pv);
		
		req.getRequestDispatcher("/views/party/content.jsp").forward(req, resp);
		
		
	}

}//class

























