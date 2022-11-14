package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;

@WebServlet(urlPatterns="/traveler/quit")
public class QuitController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 인코딩 하기
		req.setCharacterEncoding("UTF-8");   

		String travelerJoinId = req.getParameter("travelerJoinId");
		String travelerJoinPwd = req.getParameter("travelerJoinPwd");
		String travelerJoinPwd2 = req.getParameter("travelerJoinPwd2");
		
		
		int result = new TravelerService().quit(travelerJoinId, travelerJoinPwd, travelerJoinPwd2);

		// 결과에 따라 화면 선택
		if(result == 1) {
			// 성공
			req.getSession().invalidate(); 
			req.getSession().setAttribute("alertMsg", "회원탈퇴 성공!");

			resp.sendRedirect("/hallo03talk");
		}else {
			// 실패
			req.getSession().setAttribute("alertMsg", "회원탈퇴 실패!");
			resp.sendRedirect("/hallo03talk/traveler/myPage");
		}
				
		
	}//doPost
	
}
