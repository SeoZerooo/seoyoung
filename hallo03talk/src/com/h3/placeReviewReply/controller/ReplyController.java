package com.h3.placeReviewReply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.vo.BossVo;
import com.h3.placeReviewReply.service.PlaceReviewReplyService;
import com.h3.placeReviewReply.vo.PlaceReviewReplyVo;

@WebServlet("/review/reply")
public class ReplyController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		BossVo bv = (BossVo) req.getSession().getAttribute("BossLoginMember");
		String reviewNo = req.getParameter("reviewNo");
		String content = req.getParameter("replyContent");
		String placeNo = req.getParameter("placeNo");
		
		PlaceReviewReplyVo prrv = new PlaceReviewReplyVo();
		prrv.setBossNo(Integer.toString(bv.getNo()));
		prrv.setReviewNo(reviewNo);
		prrv.setContent(content);
		
		int result = new PlaceReviewReplyService().addReply(prrv);
		
		if (result == 1) {
			resp.sendRedirect("/hallo03talk/place/one?placeNo="+placeNo);
		} else {
			
		}
		
	}
}
