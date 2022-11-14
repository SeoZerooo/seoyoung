package com.h3.placeReviewReply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.placeReviewReply.service.PlaceReviewReplyService;

@WebServlet("/review/replyDel")
public class ReplyDelController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		String replyNo = req.getParameter("replyNo");
		int result = new PlaceReviewReplyService().replyDel(replyNo);
		
		resp.getWriter().print(result);
	}
}
