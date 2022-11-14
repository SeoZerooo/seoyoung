package com.h3.reportUser.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.report.service.ReportService;
import com.h3.reportUser.vo.ReportUserVo;

@WebServlet (urlPatterns = "/report/reportUser")
public class ReportUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String userNo = req.getParameter("userNo");
		
		String guilty = req.getParameter("guilty");
		String content = req.getParameter("content");
		String type = req.getParameter("type");
		String reportedTravelerNo = req.getParameter("reportedTravelerNo");
		
		
		ReportUserVo vo = new ReportUserVo();  
		
		vo.setGuilty(guilty);
		vo.setContent(content);
//		vo.setType(type);
		vo.setReportedTravelerNo(reportedTravelerNo);
		
		//객체 이용해서 신고 진행
		int result = new ReportService().ujoin(vo);
		
		//insert 결과를 가지고, 화면 선택
		if(result == 1) {
			//신고 성공
			// + 메세지 담기 //alert 창으로
			req.getSession().setAttribute("alertMsg", "신고가 완료되었습니다!");
			resp.sendRedirect("/hallo03talk");
		}else {
			//신고 실패 //이전 페이지로 옮기기
			req.getSession().setAttribute("alertMsg", "신고 실패..!");
			resp.sendRedirect("/hallo03talk/index.jsp");
		}


		
	}
	
}
