package com.h3.traveler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.MpgPostVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/travelerMpgPost/delete")
public class MpgPostDeleteController extends HttpServlet {

	/*
	 * traveler - 내가 쓴 글 삭제
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TravelerVo loginTraveler = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");

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
		String board = boardKr.equals("커뮤니티") ? "community" : (boardKr.equals("장소 리뷰") ? "place_review" : "with_");

		String no = (String) req.getParameter("no");

		// 서비스 호출
		new TravelerService().deletePost(no, board);

	}

}// class
