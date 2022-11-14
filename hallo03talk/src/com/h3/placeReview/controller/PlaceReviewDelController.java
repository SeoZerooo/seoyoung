package com.h3.placeReview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.placeReview.service.PlaceReviewService;
import com.h3.placeReview.vo.PlaceReviewVo;

@WebServlet("/review/delOne")
public class PlaceReviewDelController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tNo = req.getParameter("tNo");
		String rNo = req.getParameter("rNo");
		
		PlaceReviewVo prv = new PlaceReviewVo();
		prv.setNo(rNo);
		prv.setTravelerNo(tNo);
		
		int result = new PlaceReviewService().delOneReview(prv);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(result);
	}
}
