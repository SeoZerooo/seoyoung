package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommReplyService;

@WebServlet(urlPatterns = "/comm/reply/delete")
public class CommReplyDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commNo = req.getParameter("comm");
		String replyNo = req.getParameter("reply");
		
		int result = new CommReplyService().delete(commNo, replyNo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "댓글이 삭제되었습니다");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+commNo);
		}else {
			req.getSession().setAttribute("alertMsg", "먼가 잘못됨");
			resp.sendRedirect("/hallo03talk/comm/detail?no="+commNo);
		}
	}
}
