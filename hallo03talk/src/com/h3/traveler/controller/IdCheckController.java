package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;


@WebServlet(urlPatterns = "/traveler/idCheck")
public class IdCheckController extends HttpServlet{

	/*
	 * traveler - 아이디 중복 체크
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩 하기
		req.setCharacterEncoding("UTF-8");
	
		String userId = (String)req.getParameter("userId");
		System.out.println(userId);

		// 서비스 호출
		int idCheck = new TravelerService().idCheck(userId);
		
		// 인코딩 하기
		resp.getWriter().write(String.valueOf(idCheck));
	
	}
	
	
	
}
