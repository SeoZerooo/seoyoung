package com.h3.searchDetail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.searchDetail.service.SearchWidthService;
import com.h3.with.vo.WithVo;

@WebServlet (urlPatterns = "/searchWidth/searchWidthDetail")
public class SearchWidthController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String widthKeyword = req.getParameter("widthKeyword");
		String cate4 = req.getParameter("cate4");
		String cate5 = req.getParameter("cate5");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		ArrayList<WithVo> wvoList = new SearchWidthService().wselectList( widthKeyword, cate4, cate5, startDate, endDate);
		
		System.out.println(wvoList);
		
		
		//결과에 따라 화면 만들기
		req.setAttribute("wvoList", wvoList);
		req.getRequestDispatcher("/views/search/searchWidthDetail.jsp").forward(req, resp);
		
	}
	

}
