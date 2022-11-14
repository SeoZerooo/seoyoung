package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;

@WebServlet(urlPatterns = "/traveler/nickCheck")
public class NickCheckController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * traveler - 닉네임 중복 체크
		 */
		
		// 인코딩 하기
		req.setCharacterEncoding("UTF-8");

		String userNick = (String)req.getParameter("userNick");
		System.out.println(userNick);

		// 서비스 호출
		int nickCheck = new TravelerService().nickCheck(userNick);
		
		// 인코딩 하기
		resp.getWriter().write(String.valueOf(nickCheck));
	
	
	}

	
}//class
