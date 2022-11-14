package com.h3.traveler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.vo.CommReplyVo;
import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns="/travelerMpgReply/list")
public class MpgReplyController extends HttpServlet{

	
	/*
	 * traveler - 내가 쓴 댓글 조회 - 커뮤니티 댓글
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");

		// 서비스 호출
	    ArrayList<CommReplyVo> voList = new TravelerService().selectReplyList(loginTraveler.getNo());
		
		
		req.setAttribute("voList", voList);
		
		// 화면 보여주기 
		req.getRequestDispatcher("/views/member/traveler/travelerReplyView.jsp").forward(req, resp);
	
	
	}//doGet
	
	
}
