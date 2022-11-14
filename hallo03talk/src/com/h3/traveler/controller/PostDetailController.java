package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/travelerPostDetail")
public class PostDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		String num = req.getParameter("num");
		
		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");

		// 서비스 호출
		//MpgPostVo pvo = new TravelerService().PostDetail(loginTraveler.getNo(), num);
		
		//req.getSession().setAttribute("pvo", pvo);	
		
		// 화면 보여주기
		req.getRequestDispatcher("/views/member/traveler/travelerPostDetail.jsp").forward(req, resp);

	
	
	}
	
	
}//class
