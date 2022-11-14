package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;

@WebServlet(urlPatterns = "/comm/delete")
public class CommDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		int result = new CommService().delete(no);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "게시물이 삭제되었습니다.");
			resp.sendRedirect("/hallo03talk/comm/list");
		}else {
			req.getSession().setAttribute("alertMsg", "게시물 삭제 실패.");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+no);
		}
	}
}
