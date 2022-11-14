package com.h3.admin.controller.place;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminPlaceService;
@WebServlet(urlPatterns = "/admin/placeDelete")
public class AdminPlaceDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] num =req.getParameterValues("num");
		
		int[] dNum = new int [num.length];
		for(int i = 0; i< num.length; i ++) {
			
			
			dNum[i] = Integer.parseInt(num[i]);
			System.out.println("@@@@@@@@@값은 바로 : :" + dNum[i]);
		
		
		}
			int result = new AdminPlaceService().deletePlace(dNum);
		
			
				
			
		
			
			req.getRequestDispatcher("/admin/placeAdmin?p=1").forward(req, resp);
	}
	
		
		
	
	
}
	
	
	

