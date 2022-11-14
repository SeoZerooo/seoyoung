package com.h3.place.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.place.service.PlaceService;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

@WebServlet("/place/update")
public class PlaceUpdateController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String placeNo = (String)req.getParameter("placeNo");
		PlaceVo pv = new PlaceService().placeOne(placeNo);
		ArrayList<PlacePhotoVo> photoList = new PlaceService().photoOne(placeNo);
		
		req.setAttribute("placeVo", pv);
		req.setAttribute("photoList", photoList);
		
		req.getRequestDispatcher("/views/place/placeUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String placeNo = (String) req.getParameter("placeNo");
		String name = (String)req.getParameter("placeName");
		String content = (String)req.getParameter("placeContent");
		String address = (String)req.getParameter("placeAddr");
		String bossNo = "1";
		String categoryNo = (String)req.getParameter("category_no");
		
		
		
		PlaceVo placeVo = new PlaceVo();
		placeVo.setNo(placeNo);
		placeVo.setName(name);
		placeVo.setContent(content);
		placeVo.setAddress(address);
		placeVo.setBossNo(bossNo);
		placeVo.setCategoryNo(categoryNo);
		
		int result = new PlaceService().placeUpdate(placeVo);
		
		
		if (result == 1) {
			resp.sendRedirect("/hallo03talk/place/one?placeNo="+placeVo.getNo());
		} else {
			
		}
	}
}
