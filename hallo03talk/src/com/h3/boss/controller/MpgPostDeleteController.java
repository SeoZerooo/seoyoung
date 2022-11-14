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

@WebServlet(urlPatterns = "/bossMpgPost/delete")
public class MpgPostDeleteController extends HttpServlet {

	/*
	 * boss - 내가 쓴 글 삭제
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		BossVo loginBoss = (BossVo)req.getSession().getAttribute("BossLoginMember");

		// request에 담긴 값 확인
		Enumeration params = req.getParameterNames();
		
		System.out.println("----------------------------");
		
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			System.out.println(name + " : " + req.getParameter(name));
		}
		
		System.out.println("----------------------------");

		
		// jsp에 표시한 값은 한글이므로 변수 boardKr로 받음
		String boardKr = (String) req.getParameter("board");

		// 쿼리문에서 쓰이기 때문에 실제 테이블명으로 바꿔서 할당
		String board = boardKr.equals("이벤트 등록") ? "party" : "place";

		String no = (String) req.getParameter("no");

		// 서비스 호출
		new BossService().deletePost(no, board);

	
	}//doPost
	
}//class
