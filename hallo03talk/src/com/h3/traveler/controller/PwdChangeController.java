package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;

@WebServlet(urlPatterns = "/traveler/pwd")
public class PwdChangeController extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		// 인코딩 하기
		req.setCharacterEncoding("UTF-8");   
	
		String travelerJoinId = req.getParameter("travelerJoinId");
		String travelerJoinPwd = req.getParameter("travelerJoinPwd");
		String travelerJoinPwdNew = req.getParameter("travelerJoinPwdNew");
		String travelerJoinPwdNew2 = req.getParameter("travelerJoinPwdNew2");
		
		// 서비스 호출
		int result = new TravelerService().changePwd(travelerJoinId, travelerJoinPwd, travelerJoinPwdNew, travelerJoinPwdNew2);

		// 실행결과에 따라 화면 선택
		if(result == 1) {
			// 성공
			// alert 띄우기
			req.getSession().setAttribute("alertMsg", "비밀번호 변경 성공!");

			// 마이페이지로 이동
			resp.sendRedirect("/hallo03talk/traveler/myPage");
			
		}else {
			// 실패
			req.getSession().setAttribute("alertMsg", "비밀번호 변경 실패!");

			// 마이페이지로 이동
			resp.sendRedirect("/hallo03talk/traveler/myPage");
		}
		

	}
	
	
}//class
