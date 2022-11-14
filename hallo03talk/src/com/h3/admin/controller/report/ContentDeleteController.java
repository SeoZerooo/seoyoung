package com.h3.admin.controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
@WebServlet(urlPatterns = "/admin/ContentDelete")
public class ContentDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] num =req.getParameterValues("num");
		
		int[] dNum = new int [num.length];
		for(int i = 0; i< num.length; i ++) {
			
			
			dNum[i] = Integer.parseInt(num[i]);
			System.out.println("@@@@@@@@@값은 바로 : :" + dNum[i]);
		
		
		}
			int result = new AdminReportService().deleteContentReal(dNum);
		
			
				
			
		
			
			req.getRequestDispatcher("/admin/reportContent?p=1").forward(req, resp);
			
			
		
		
	}

}
