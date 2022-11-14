package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;
import com.h3.community.vo.CommVo;

@WebServlet(urlPatterns = "/comm/edit")
public class CommEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		CommVo vo = new CommService().getOne(no);
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/community/comm_edit.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "잘못된 접근");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+no);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommVo vo = new CommVo();
		vo.setNo(req.getParameter("no"));
		vo.setCategory(req.getParameter("category"));
		vo.setTitle(req.getParameter("title"));
		vo.setContent(req.getParameter("content"));
		vo.setWriter(req.getParameter("writer"));
		
		int result = new CommService().edit(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "수정되었습니다.");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+vo.getNo());
		}else {
			req.getSession().setAttribute("alertMsg", "수정실패");
			resp.sendRedirect("/hallo03talk/comm/list");
		}
	}
}
