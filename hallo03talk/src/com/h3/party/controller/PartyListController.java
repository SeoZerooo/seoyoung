package com.h3.party.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.party.service.PartyService;
import com.h3.party.vo.PartyVo;


@WebServlet(urlPatterns="/party/list")
public class PartyListController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<PartyVo> list = new PartyService().getlist();
		req.setAttribute("PartyList", list);
		//이벤트 게시판 목록
		req.getRequestDispatcher("/views/party/list.jsp").forward(req,resp);
	

	}
}
