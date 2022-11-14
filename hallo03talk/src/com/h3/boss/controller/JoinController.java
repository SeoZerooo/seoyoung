package com.h3.boss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossVo;

@WebServlet(urlPatterns = "/boss/join")
public class JoinController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/common/joinForm.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");   // 한글깨짐 방지

		//데이터 꺼내기
		String bossJoinId = req.getParameter("bossJoinId");
		String bossJoinPwd = req.getParameter("bossJoinPwd");
		String bossJoinPwd2 = req.getParameter("bossJoinPwd2");
		String bossJoinPhone = req.getParameter("bossJoinPhone");
		String bossJoinEmail = req.getParameter("bossJoinEmail");

		
				
		// 데이터 뭉치기
		BossVo vo = new BossVo(
				bossJoinId, 
				bossJoinPwd,
				bossJoinPwd2,
				bossJoinPhone,
				bossJoinEmail
	    );
		
		
		//서비스 호출
		int result = new BossService().join(vo);
		
		//결과에 따라 화면 선택
		if(result == 1) {
			//회원가입 성공
			// + 메세지 담기
			req.getSession().setAttribute("alertMsg", "사장님_회원가입 성공ㅎㅎ!"); 
			resp.sendRedirect("/hallo03talk");  
		}else {
			//회원가입 실패
			System.out.println("[ERROR-CODE:" + result + "] 회원가입 실패 !");
			
			req.getSession().setAttribute("alertMsg", "사장님_회원가입 실패ㅠ!"); 
			resp.sendRedirect("/hallo03talk");
			
		}
	
	}
	
}//class
