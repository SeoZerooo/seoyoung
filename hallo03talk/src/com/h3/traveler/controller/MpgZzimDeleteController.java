package com.h3.traveler.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/travelerMpgZzim/delete")
public class MpgZzimDeleteController extends HttpServlet{

	
	/*
	 * traveler - 찜 목록 삭제
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");

		// request에 담긴 값 확인
		Enumeration params = req.getParameterNames();
		
		System.out.println("----------------------------");
		
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    System.out.println(name + " : " +req.getParameter(name));
		}
		
		System.out.println("----------------------------");
		 
		
		
		int data = Integer.parseInt((String)req.getParameter("data"));

		System.out.println(data);
		
		 
		 // 서비스 호출
		new TravelerService().deleteZzim(loginTraveler.getNo(), data);
	
	
	
	}//doPost
	
	
}//class
