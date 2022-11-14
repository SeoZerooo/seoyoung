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

@WebServlet("/zzim/del")
public class ZzimDelController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		TravelerVo tv = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
		String no = (String) req.getParameter("place");
		PlaceVo pv = new PlaceVo();
		pv.setNo(no);
		
		
		int result = new ZzimService().zzimDel(tv,pv);
		resp.getWriter().print(result);
		
	}
}
