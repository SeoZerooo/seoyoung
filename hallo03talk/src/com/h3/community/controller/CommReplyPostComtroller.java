package com.h3.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommReplyService;
import com.h3.community.vo.CommReplyVo;

@WebServlet(urlPatterns = "/comm/reply/post")
public class CommReplyPostComtroller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String travelerNo = req.getParameter("travelerNo");
		String communityNo = req.getParameter("communityNo");
		String content = req.getParameter("content");
		
		CommReplyVo vo = new CommReplyVo();
		
		vo.setTravelerNo(travelerNo);
		vo.setContent(content);
		vo.setCommunityNo(communityNo);
		
		int result = new CommReplyService().post(vo);
		
		if(result == 1) {
			resp.sendRedirect("/hallo03talk/comm/detail?no="+communityNo);
		}else {
			resp.sendRedirect("/hallo03talk/comm/detail?no="+communityNo);
		}
	}
}
