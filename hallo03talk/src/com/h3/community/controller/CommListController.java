package com.h3.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;
import com.h3.community.vo.CommVo;
import com.h3.with.vo.PageVo;

@WebServlet(urlPatterns = "/comm/list")
public class CommListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = req.getParameter("view");
		String sort = req.getParameter("s");
		
		int listCount = 0;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new CommService().getCount(view);
		
		if(req.getParameter("p") == null || "".equals(req.getParameter("p"))) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(req.getParameter("p"));
		}

		pageLimit = 5;
		boardLimit = 15;
		
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
		
		ArrayList<CommVo> voList = new CommService().getList(pageVo, sort, view);
		
		req.setAttribute("view", view);
		req.setAttribute("sort", sort);
		req.setAttribute("pageVo", pageVo);
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/community/comm_list.jsp").forward(req, resp);
	}
}
