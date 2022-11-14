package com.h3.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminService;
import com.h3.admin.vo.AdminVo;
@WebServlet(urlPatterns = "/admin/login")
public class AdminLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminId = req.getParameter("adminId");
		String adminPwd = req.getParameter("adminPwd");
		
		//데이터 뭉치기
		AdminVo vo = new AdminVo();
		vo.setId(adminId);
		vo.setPwd(adminPwd);
		
		//서비스 로직 실행
	AdminVo loginAdmin = new AdminService().login(vo);
	
	//결과에 따라 화면 선택
	if (loginAdmin != null) {
		//로그인 성공 // 세션에 로그인 유저정보 담기
		req.getSession().setAttribute("loginAdmin", loginAdmin);	
		req.getSession().setAttribute("alertMsg", "관리자 로그인 성공");
		
//		req.getRequestDispatcher("/semi").forward(req, resp);
		resp.sendRedirect("/hallo03talk/views/member/admin/adminPage.jsp");
		
	}else{
		//로그인실패
		req.getSession().setAttribute("alertMsg", "관리자 로그인 실패");
		
		resp.sendRedirect("/hallo03talk/views/member/admin/adminPage.jsp");
		
	}
	}
	}
	


