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

@WebServlet(urlPatterns = "/traveler/myPage")
public class MyPageController extends HttpServlet{

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		TravelerVo travelerLoginMember = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");
		
		if(travelerLoginMember != null) {
			req.getRequestDispatcher("/views/member/traveler/travelerInformationForm.jsp").forward(req, resp);
			
			// 유저 사진 불러오기 
			TravelerAttachmentVo tav = new TravelerService().getAttachment(travelerLoginMember.getNo());
			
			req.getSession().setAttribute("travelerAttachment", tav);
			
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 후 접근 가능합니다.");
			resp.sendRedirect(req.getContextPath());   
		}
	
	
	}
	
	
	/*
	 * 회원정보 변경
	 * 
	 */ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		
		String name = req.getParameter("travelerJoinName");
		String nick = req.getParameter("travelerJoinNick");
		String phone = req.getParameter("travelerJoinPhone");
		String email = req.getParameter("travelerJoinEmail");

		int no = ((TravelerVo)req.getSession().getAttribute("travelerLoginMember")).getNo();  // 세션의 로그인멤버의 no
	
		
		TravelerVo vo = new TravelerVo();

		vo.setNo(no);
		vo.setName(name);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		
		// 서비스 호출
	    TravelerVo updateVo = new TravelerService().edit(vo);
	    
	    
	    // 결과에 따라 화면 선택
	    if(updateVo != null) {
			// 성공 
			// 세션에있는 loginMember 정보를 업데이트 하기
			req.getSession().setAttribute("travelerLoginMember", updateVo);

			// alert 띄우기
			req.getSession().setAttribute("alertMsg", "회원 정보 변경 완료!");
			
			// 마이페이지로 이동시키기
			resp.sendRedirect("/hallo03talk/traveler/myPage");

		}else {
			// 실 
			// alert 띄우기
			req.getSession().setAttribute("alertMsg", "회원 정보 변경 실패!");
			
			// 마이페이지로 이동시키기
			resp.sendRedirect("/hallo03talk/traveler/myPage");
			
		}
	    
	    
	    
		
	}
	
	
	
}//class