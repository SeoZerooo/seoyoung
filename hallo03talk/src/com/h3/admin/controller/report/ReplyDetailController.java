package com.h3.admin.controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
import com.h3.reportComment.vo.ReportCommentVo;
@WebServlet(urlPatterns = "/admin/replyDetail")
public class ReplyDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		
		
		 
		
		 //디비 가서 특정 정보 조회
		 ReportCommentVo vo =new AdminReportService().selectReply(num);
		 
		
			 req.setAttribute("vo", vo);
			 req.getRequestDispatcher("/views/member/admin/detail/reportReplyDetail.jsp").forward(req, resp);
		
	
	}

}
