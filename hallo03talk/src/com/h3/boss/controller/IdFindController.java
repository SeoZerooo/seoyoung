package com.h3.boss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;

@WebServlet(urlPatterns = "/boss/idFind")
public class IdFindController extends HttpServlet{

	
	/*
	 * boss - 아이디 찾기
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bossJoinPhone = req.getParameter("bossJoinPhone");
		String bossJoinEmail = req.getParameter("bossJoinEmail");

		String idFind = new BossService().idFind(bossJoinPhone, bossJoinEmail);

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
	
	
	}//doPost
	
	
}//class
