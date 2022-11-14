package com.h3.zzim.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.place.vo.PlaceVo;
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.service.ZzimService;

@WebServlet("/zzim/add")
public class ZzimAddController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (req.getSession().getAttribute("travelerLoginMember") == null) {
			resp.getWriter().print(2);
		} else {
			TravelerVo tv = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
			String no =  req.getParameter("place");
			PlaceVo pv = new PlaceVo();
			pv.setNo(no);
			
			int result = new ZzimService().zzimAdd(tv, pv);
			resp.getWriter().print(result);
		}

	}
}
