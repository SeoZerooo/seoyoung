package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/join")
public class JoinController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.getRequestDispatcher("/views/common/joinForm.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");   // 한글깨짐 방지

		//데이터 꺼내기
		String travelerJoinId = req.getParameter("travelerJoinId");
		String travelerJoinPwd = req.getParameter("travelerJoinPwd");
		String travelerJoinPwd2 = req.getParameter("travelerJoinPwd2");
		String travelerJoinName = req.getParameter("travelerJoinName");
		String travelerJoinNick = req.getParameter("travelerJoinNick");
		String[] travelerJoinGender = req.getParameterValues("travelerJoinGender");
		String travelerJoinPhone = req.getParameter("travelerJoinPhone");   
		String travelerJoinEmail = req.getParameter("travelerJoinEmail");  

		
		// 성별 체크 안 했을 경우 방어코드 
		String gender = "";
		
		if(travelerJoinGender != null) {
			gender = String.join(",", travelerJoinGender);
		}
				
				
		// 데이터 뭉치기
		TravelerVo vo = new TravelerVo(
				travelerJoinId, 
				travelerJoinPwd,
				travelerJoinPwd2,
				travelerJoinName,
				travelerJoinNick,
				gender,
				travelerJoinPhone,
				travelerJoinEmail
	    );
		
		
		//서비스 호출
		int result = new TravelerService().join(vo);
		
		//결과에 따라 화면 선택
		if(result == 1) {
			//회원가입 성공
			// + 메세지 담기
			req.getSession().setAttribute("alertMsg", "일반회원_회원가입 성공ㅎㅎ!"); 
			resp.sendRedirect("/hallo03talk");  
		}else {
			//회원가입 실패
			System.out.println("[ERROR-CODE:" + result + "] 회원가입 실패 !");
			
			req.getSession().setAttribute("alertMsg", "일반회원_회원가입 실패ㅠ!"); 
			resp.sendRedirect("/hallo03talk");
			
		}
		
		
		
	}
	
	
	
}
