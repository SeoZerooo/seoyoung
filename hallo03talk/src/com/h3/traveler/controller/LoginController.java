package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerAttachmentVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/login")
public class LoginController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		req.getRequestDispatcher("/views/common/loginForm.jsp").forward(req, resp);

	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String travelerJoinId = req.getParameter("travelerJoinId");
		String travelerJoinPwd = req.getParameter("travelerJoinPwd");

		//데이터 뭉치기
		TravelerVo vo = new TravelerVo();
		vo.setId(travelerJoinId);
		vo.setPwd(travelerJoinPwd);
			
		//서비스 호출
		TravelerVo travelerLoginMember = new TravelerService().login(vo);
		
		//결과에 따라 화면 선택
		if(travelerLoginMember != null) {
			//로그인 성공 
			req.getSession().setAttribute("travelerLoginMember", travelerLoginMember);
			
			TravelerAttachmentVo tav =  new TravelerService().getAttachment(travelerLoginMember.getNo());
			req.getSession().setAttribute("travelerAttachment", tav);
			
			req.getSession().setAttribute("alertMsg", "일반회원 로그인 성공!");   

			// 메인페이지 보여주기
			resp.sendRedirect("/hallo03talk");
			
		}else {
			//로그인 실패
			// alertMsg 띄우기
			req.getSession().setAttribute("alertMsg", "일반회원 로그인 실패!"); 
			// 메인페이지로 이동
			resp.sendRedirect("/hallo03talk");

		}
	
	
	}
	
	
	
	
	
}//class
