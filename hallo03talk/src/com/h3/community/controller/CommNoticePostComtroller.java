package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommNoticePostService;
import com.h3.community.vo.CommVo;

@WebServlet(urlPatterns = "/comm/notice/post")
public class CommNoticePostComtroller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/community/comm_notice_post.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		CommVo vo = new CommVo();
		vo.setCategory(category);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		int result = new CommNoticePostService().post(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "공지사항이 등록되었습니다.");
			resp.sendRedirect("/hallo03talk/comm/list");
		}else {
			req.getSession().setAttribute("alertMsg", "공지사항 등록 실패");
			resp.sendRedirect("/hallo03talk/comm/list");
		}
	}
}
