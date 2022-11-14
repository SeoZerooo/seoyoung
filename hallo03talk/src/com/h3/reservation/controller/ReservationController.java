package com.h3.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.reservation.service.ReservationService;
import com.h3.reservation.vo.ReservationVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet("/reservation/add")
public class ReservationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TravelerVo tv = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String human = req.getParameter("human");
		String placeNo = req.getParameter("placeNo");
		
		ReservationVo rv = new ReservationVo();
		rv.setTravelerNo(Integer.toString(tv.getNo()));
		rv.setStartDate(startDate);
		rv.setEndDate(endDate);
		rv.setHuman(human);
		rv.setPlaceNo(placeNo);
		
		
		int result = new ReservationService().addReservation(rv);
		
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().print(result);
	}
}
