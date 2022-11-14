package com.h3.traveler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.MpgPostVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/travelerMpgPost/list")
public class MpgPostViewController extends HttpServlet{

	
	/*
	 * traveler - 내가 쓴 글 조회
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 꺼내기 - 생략
		// 데이터 뭉치기 - 생략
		
		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");
		
		// 서비스 호출
		ArrayList<MpgPostVo> voList = new TravelerService().selectList(loginTraveler.getNo());
		
		req.setAttribute("voList", voList);
		
		// 화면 보여주기 
		req.getRequestDispatcher("/views/member/traveler/travelerPostView.jsp").forward(req, resp);
	
	
	}//doGet
	
	
}//class
