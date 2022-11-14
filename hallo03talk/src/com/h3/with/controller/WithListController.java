package com.h3.with.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.with.service.WithService;
import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

@WebServlet(urlPatterns = "/with/list")
public class WithListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sort = req.getParameter("s");
		
		int listCount = 0;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new WithService().getCount(sort);
		
		if(req.getParameter("p") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(req.getParameter("p"));
		}

		pageLimit = 5;
		boardLimit = 8;
		
		maxPage = (int)Math.ceil(((double)listCount / boardLimit));
		startPage = (currentPage-1)	/ pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pageVo = new PageVo();
		pageVo.setBoardLimit(boardLimit);
		pageVo.setCurrentPage(currentPage);
		pageVo.setEndPage(endPage);
		pageVo.setListCount(listCount);
		pageVo.setMaxPage(maxPage);
		pageVo.setPageLimit(pageLimit);
		pageVo.setStartPage(startPage);
		
		
		ArrayList<WithVo> voList = new WithService().getList(pageVo, sort);
		
		req.setAttribute("sort", sort);
		req.setAttribute("voList", voList);
		req.setAttribute("pageVo", pageVo);
		
		req.getRequestDispatcher("/views/with/with_list.jsp").forward(req, resp);
	}
}
