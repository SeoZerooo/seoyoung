package com.h3.boss.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossMyPageVo;
import com.h3.boss.vo.BossVo;


@WebServlet(urlPatterns = "/bossMpgPost/list")
public class MpgPostViewController extends HttpServlet{

	
	/*
	 * boss - 내가 쓴 글 조회
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BossVo loginBoss = (BossVo)req.getSession().getAttribute("BossLoginMember");

		// 서비스 호출
		ArrayList<BossMyPageVo> voList = new BossService().selectList(loginBoss.getNo());
	
		req.setAttribute("voList", voList);

		// 화면 보여주기 
		req.getRequestDispatcher("/views/member/boss/bossPostView.jsp").forward(req, resp);

		
	}
	
	
}//class
