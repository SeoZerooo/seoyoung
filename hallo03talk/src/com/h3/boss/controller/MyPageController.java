package com.h3.boss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossAttachmentVo;
import com.h3.boss.vo.BossVo;


@WebServlet(urlPatterns = "/boss/myPage")
public class MyPageController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BossVo BossLoginMember = (BossVo)req.getSession().getAttribute("BossLoginMember");

		if(BossLoginMember != null) {
			req.getRequestDispatcher("/views/member/boss/bossInformationForm.jsp").forward(req, resp);
		

			// 유저 사진 불러오기 
			BossAttachmentVo bav = new BossService().getAttachment(BossLoginMember.getNo());
			
			req.getSession().setAttribute("bossAttachment", bav);
		
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

		String phone = req.getParameter("bossJoinPhone");
		String email = req.getParameter("BossJoinEmail");

		int no = ((BossVo)req.getSession().getAttribute("BossLoginMember")).getNo(); 
	
		
		BossVo vo = new BossVo();

		vo.setNo(no);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		
		// 서비스 호출
		BossVo updateVo = new BossService().edit(vo);
	    
	    
	    // 결과에 따라 화면 선택
	    if(updateVo != null) {
			// 성공 
			req.getSession().setAttribute("BossLoginMember", updateVo);

			// alert 띄우기
			req.getSession().setAttribute("alertMsg", "회원 정보 변경 완료!");
			
			// 마이페이지로 이동시키기
			resp.sendRedirect("/hallo03talk/boss/myPage");

		}else {
			// 실 
			// alert 띄우기
			req.getSession().setAttribute("alertMsg", "회원 정보 변경 실패!");
			
			// 마이페이지로 이동시키기
			resp.sendRedirect("/hallo03talk/boss/myPage");
			
		}
	    
	
	}
	
	
}//class
