package com.h3.boss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;

@WebServlet(urlPatterns = "/boss/pwd")
public class PwdChangeController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩 하기
		req.setCharacterEncoding("UTF-8");   
	
		String bossJoinId = req.getParameter("bossJoinId");
		String bossJoinPwd = req.getParameter("bossJoinPwd");
		String bossJoinPwdNew = req.getParameter("bossJoinPwdNew");
		String bossJoinPwdNew2 = req.getParameter("bossJoinPwdNew2");
		
		// 서비스 호출
		int result = new BossService().changePwd(bossJoinId, bossJoinPwd, bossJoinPwdNew, bossJoinPwdNew2);

		// 실행결과에 따라 화면 선택
		if(result == 1) {
			// 성공
			// alert 띄우기
			req.getSession().setAttribute("alertMsg", "비밀번호 변경 성공!");

			// 마이페이지로 이동
			resp.sendRedirect("/hallo03talk/boss/myPage");
			
		}else {
			// 실패
			req.getSession().setAttribute("alertMsg", "비밀번호 변경 실패!");

			// 마이페이지로 이동
			resp.sendRedirect("/hallo03talk/boss/myPage");
		}
		
	
	
	
	}
	
}
