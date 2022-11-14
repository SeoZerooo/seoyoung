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
import com.h3.traveler.service.TravelerService;


@WebServlet(urlPatterns = "/boss/login")
public class LoginController  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		req.getRequestDispatcher("/views/common/loginForm.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String bossJoinId = req.getParameter("bossJoinId");
		String bossJoinPwd = req.getParameter("bossJoinPwd");

		//데이터 뭉치기
		BossVo vo = new BossVo();
		vo.setId(bossJoinId);
		vo.setPwd(bossJoinPwd);
			
		//서비스 호출
		BossVo BossLoginMember = new BossService().login(vo);
				
	
		//결과에 따라 화면 선택
		if(BossLoginMember != null) {
			//로그인 성공 
			req.getSession().setAttribute("BossLoginMember", BossLoginMember);
			
			
			BossAttachmentVo bav =  new BossService().getAttachment(BossLoginMember.getNo());
			req.getSession().setAttribute("bossAttachment", bav);
			
			
			req.getSession().setAttribute("alertMsg", "사장님 로그인 성공!");   

			// 메인페이지 보여주기
			resp.sendRedirect("/hallo03talk");
			
		}else {
			//로그인 실패
			// alertMsg 띄우기
			req.getSession().setAttribute("alertMsg", "사장님 로그인 실패!"); 
			// 메인페이지로 이동
			resp.sendRedirect("/hallo03talk");

		}
				
	
	}
	
}//class
