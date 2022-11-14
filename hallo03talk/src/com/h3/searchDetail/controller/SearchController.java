package com.h3.searchDetail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.vo.CommVo;
import com.h3.place.vo.PlaceVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.searchDetail.repository.SearchDao;
import com.h3.searchDetail.service.SearchService;
import com.h3.with.vo.WithVo;



@WebServlet (urlPatterns = "/searchPlace/searchDetail")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String placeKeyword = req.getParameter("placeKeyword");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String cate3 = req.getParameter("cate3");
		System.out.println("==============================");
		
		//호출
		ArrayList<PlaceVo> pvoList = new SearchService().pselectList(placeKeyword, cate1, cate2, cate3);
		ArrayList<CommVo> cvoList = new SearchService().cselectList(placeKeyword, cate1, cate2, cate3);
		

		
		System.out.println(pvoList);
		System.out.println(cvoList);
//		System.out.println(placeKeyword);
//		System.out.println(cate1);
//		System.out.println(cate2);
//		System.out.println(cate3);
		System.out.println("==============================");
		
		
		//결과에 따라 화면 만들기
		req.setAttribute("pvoList", pvoList);
		req.setAttribute("cvoList", cvoList);
		req.getRequestDispatcher("/views/search/searchDetail.jsp").forward(req, resp);
		
		
		

		
		
	}
	

	
}


