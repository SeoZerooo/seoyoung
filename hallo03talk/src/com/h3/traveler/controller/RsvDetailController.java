package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.MpgReservationVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/rsvDetail")
public class RsvDetailController extends HttpServlet{

	
	/*
	 * traveler - 예약내역 상세조회 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String num = req.getParameter("num");
		
		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");

		// 서비스 호출
		MpgReservationVo rvo = new TravelerService().rsvDetail(loginTraveler.getNo(), num);
		
		req.getSession().setAttribute("rvo", rvo);

		
		//req.setAttribute("rvo", rvo);
		
		
		// 화면 보여주기
		req.getRequestDispatcher("/views/member/traveler/travelerRsvDetail.jsp").forward(req, resp);

		
		
		
	}
	
	
	
	
}
