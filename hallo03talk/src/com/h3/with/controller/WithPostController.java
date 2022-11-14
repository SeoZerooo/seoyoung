package com.h3.with.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.traveler.vo.TravelerVo;
import com.h3.with.service.WithPostService;
import com.h3.with.vo.WithVo;

@WebServlet(urlPatterns = "/with/post")
public class WithPostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/with/with_post.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TravelerVo writerVo = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
		String writer = Integer.toString(writerVo.getNo());
		
		String title =  req.getParameter("title");
		String content=  req.getParameter("content");
		System.out.println(content);
		String[] tag =  req.getParameter("tag").split(",");
		String startDate =  req.getParameter("startDate");
		String endDate =  req.getParameter("endDate");
		String place =  req.getParameter("place");
		String insta = req.getParameter("insta");
		
        Date startdate_ = Date.valueOf(startDate);
        Date enddate_ = Date.valueOf(endDate);
		
		WithVo vo = new WithVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setTag(tag);
		vo.setStart_date(startdate_);
		vo.setEnd_date(enddate_);
		vo.setPlace(place);
		vo.setTraveler_no(writer);
		vo.setInsta(insta);
		
		int result = new WithPostService().post(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "글이 등록되었습니다.");
			resp.sendRedirect(req.getContextPath() + "/with/list");
		}else {
			req.getSession().setAttribute("alertMsg", "등록 실패");
			resp.sendRedirect(req.getContextPath() + "/with/list");
		}
	}
}
