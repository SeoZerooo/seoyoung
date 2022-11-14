package com.h3.with.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.with.service.WithService;
import com.h3.with.vo.WithVo;

@WebServlet(urlPatterns = "/with/detail")
public class WithDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		WithVo vo = new WithService().getOne(no);
		
		if(vo!=null) {		
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/with/with_detail.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "조회 실패");
			resp.sendRedirect("/hallo03talk/with/list");
		}
	}
}
