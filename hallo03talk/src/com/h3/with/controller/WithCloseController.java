package com.h3.with.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.with.service.WithService;

@WebServlet(urlPatterns = "/with/close")
public class WithCloseController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		int result = new WithService().close_(no);
		
		req.getSession().setAttribute("alertMsg", "마감되었습니다.");
		resp.sendRedirect("/hallo03talk/with/list");
	}
}
