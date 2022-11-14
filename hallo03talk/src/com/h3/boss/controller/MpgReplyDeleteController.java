package com.h3.boss.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossVo;
@WebServlet(urlPatterns = "/bossMpgReply/delete")

public class MpgReplyDeleteController extends HttpServlet{

	
	/*
	 * boss - 내가 쓴 답글 삭제
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BossVo BossLoginMember = (BossVo)req.getSession().getAttribute("BossLoginMember");

	
		// request에 담긴 값 확인
		Enumeration params = req.getParameterNames();
		
		System.out.println("----------------------------");
		
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    System.out.println(name + " : " +req.getParameter(name));
		}
		
		System.out.println("----------------------------");
		 
		
		
		int data = Integer.parseInt((String)req.getParameter("data"));

		System.out.println(data);
		
		 
		 // 서비스 호출
		new BossService().deleteReply(BossLoginMember.getNo(), data);
	
	
	}//doPost
	
	
}//class
