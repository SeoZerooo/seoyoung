package com.h3.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/admin/logout")
public class AdminLogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		req.getSession().setAttribute("alertMsg", "관리자 로그아웃 성공!");
		resp.sendRedirect("/hallo03talk/views/member/admin/adminPage.jsp");
	}

}
