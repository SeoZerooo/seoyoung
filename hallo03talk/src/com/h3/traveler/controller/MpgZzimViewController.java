package com.h3.traveler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.MpgZzimVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/travelerMpgZzim/list")
public class MpgZzimViewController extends HttpServlet{

	
	/*
	 * traveler - 찜 목록 조회
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");

		
		// 서비스 호출
		ArrayList<MpgZzimVo> voList = new TravelerService().selectZzimList(loginTraveler.getNo());

		req.setAttribute("voList", voList);

		// 화면 보여주기 
		req.getRequestDispatcher("/views/member/traveler/travelerZzimView.jsp").forward(req, resp);

		
		
	}
	
	
}
