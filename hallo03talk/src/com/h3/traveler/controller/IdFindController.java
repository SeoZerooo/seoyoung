package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/idFind")
public class IdFindController extends HttpServlet{

	/*
	 * traveler - 아이디 찾기
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8"); 

		String travelerJoinPhone = req.getParameter("travelerJoinPhone");
		String travelerJoinEmail = req.getParameter("travelerJoinEmail");
 
	     
	     
		// 데이터 뭉치기 
//		TravelerVo vo = new TravelerVo();
//		vo.setPhone(travelerJoinPhone);
//		vo.setEmail(travelerJoinEmail);

	
		// 서비스 호출
		//TravelerVo idFind = new TravelerService().idFind(vo);
		String idFind = new TravelerService().idFind(travelerJoinPhone, travelerJoinEmail);


		if(idFind != null) {
			// 아이디 찾기 성공
			req.getSession().setAttribute("idFind", idFind);

			req.getSession().setAttribute("alertMsg", idFind);   
			
			req.getSession().setAttribute("alertMsg", "당신의 아이디는 " + idFind + " 입니다.");   

			req.getRequestDispatcher("/views/common/loginForm.jsp").forward(req, resp);

		}else {
			
			System.out.println("실패...idFind 가 null입니다");
			
			req.getSession().setAttribute("alertMsg", "일치하는 아이디가 없습니다.");   

			req.getRequestDispatcher("/views/common/loginForm.jsp").forward(req, resp);
		}

	
	
	}
	
	
	
	
	
}//class
