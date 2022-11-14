package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;
import com.h3.community.vo.CommVo;

@WebServlet(urlPatterns = "/comm/notice/edit")
public class CommNoticeEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		CommVo vo = new CommService().getOne(no);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/community/comm_notice_edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		CommVo vo = new CommVo();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setCategory("notice");
		
		int result = new CommService().edit(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "공지사항 수정이 완료되었습니다.");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+vo.getNo());
		}else {
			req.getSession().setAttribute("alertMsg", "공지사항 수정 실패");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+vo.getNo());
		}
		
	}
}
