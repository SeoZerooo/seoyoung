package com.h3.traveler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.reportUser.vo.ReportUserVo;
import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/getReport")
public class MpgGetReportController extends HttpServlet{

	
	/*
	 * traveler - 신고 받은 내역
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	

		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");

		// 서비스 호출
		ArrayList<ReportUserVo> voList = new TravelerService().selectGetReportList(loginTraveler.getNo());
	
		req.setAttribute("voList", voList);

		System.out.println("@@@voList@@: " + voList);
		
		
		
		if(voList != null) {
			
			req.setAttribute("voList", voList);

			req.getRequestDispatcher("/views/member/traveler/travelerGetReportView.jsp").forward(req, resp);

		}else {
			System.out.println("실패 ! voList가 null 입니다.");
		}
	
	}//doGet
	
	
}//class
