package com.h3.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.h3.reservation.service.ReservationService;
import com.h3.reservation.vo.ReservationVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet("/reservation/getReservation")
public class ReservationCheckController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String placeNo = req.getParameter("placeNo");
		TravelerVo tv = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
		
		ReservationVo rv = new ReservationService().checkReservation(placeNo,tv.getNo());
		
		Gson g = new Gson();
		String result = g.toJson(rv);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(result);
	}
}
