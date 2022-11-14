package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;
import com.h3.community.vo.CommVo;

@WebServlet(urlPatterns = "/comm/post")
public class CommPostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/community/comm_post.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommVo vo = new CommVo();
		vo.setCategory(req.getParameter("category"));
		vo.setTitle(req.getParameter("title"));
		vo.setContent(req.getParameter("content"));
		vo.setWriter(req.getParameter("writer"));
		
		int result = new CommService().post(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "등록되었습니다.");
			resp.sendRedirect("/hallo03talk/comm/list");
		}else {
			req.getSession().setAttribute("alertMsg", "등록실패");
			resp.sendRedirect("/hallo03talk/comm/list");
		}
	}
}
