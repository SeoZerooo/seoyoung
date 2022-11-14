package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;

@WebServlet(urlPatterns = "/traveler/pwdFind")
public class PwdFindController extends HttpServlet{
	
	/*
	 * traveler - 비밀번호 찾기
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8"); 

		String travelerJoinId = req.getParameter("travelerJoinId");
		String travelerJoinPhone = req.getParameter("travelerJoinPhone");
		 
		// 서비스 호출
		String pwdFind = new TravelerService().pwdFind(travelerJoinId, travelerJoinPhone);

		
		if(pwdFind != null) {
			// 비밀번호 찾기 성공
			req.getSession().setAttribute("pwdFind", pwdFind);
			
			req.getSession().setAttribute("alertMsg", pwdFind);   

			req.getSession().setAttribute("alertMsg", "당신의 비밀번호는 " + pwdFind + " 입니다.");   

			req.getRequestDispatcher("/views/common/loginForm.jsp").forward(req, resp);
		}else {
			System.out.println("실패...pwdFind 가 null입니다");
			
			req.getSession().setAttribute("alertMsg", "일치하는 비밀번호가 없습니다.");   

			req.getRequestDispatcher("/views/common/loginForm.jsp").forward(req, resp);

		}
		
	
	}//doPost
	
}//class
