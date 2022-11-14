package com.h3.boss.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossVo;
import com.h3.placeReview.vo.PlaceReviewVo;

@WebServlet(urlPatterns="/bossMpgReply/list")
public class MpgReplyController extends HttpServlet{
	
	
	/*
	 * boss - 내가 쓴 답글 조회 - 장소 후기 답글
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		
		BossVo loginBoss = (BossVo)req.getSession().getAttribute("BossLoginMember");

		// 서비스 호출
	    ArrayList<PlaceReviewVo> voList = new BossService().selectReplyList(loginBoss.getNo());

		
		req.setAttribute("voList", voList);
		
		// 화면 보여주기 
		req.getRequestDispatcher("/views/member/boss/bossReplyView.jsp").forward(req, resp);
	
	}
	
	
}//class
