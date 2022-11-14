package com.h3.boss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;



@WebServlet(urlPatterns = "/boss/idCheck")
public class IdCheckController extends HttpServlet{

	
	/*
	 * boss - 아이디 중복 체크
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩 하기
		req.setCharacterEncoding("UTF-8");
	
		String bossId = (String)req.getParameter("bossId");
		System.out.println(bossId);

		// 서비스 호출
		int idCheck = new BossService().idCheck(bossId);
		
		// 인코딩 하기
		resp.getWriter().write(String.valueOf(idCheck));
			
	
	}//doPost
	
	
}//class
