package com.h3.place.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.vo.BossVo;
import com.h3.place.service.PlaceService;
import com.h3.place.vo.PlaceVo;
import com.h3.placelList.service.PlaceListService;

@WebServlet("/place/list")
public class PlaceListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		////사장님만 로그인해서, 처음으로 장소 페이지 클릭했을 경우, 사장님 인증페이지로 이동. 인증했을 경우, 기존 장소페이지 이용 가능.
		//세션에서 사장정보 가져오기
//		BossVo bossVo = (BossVo)req.getSession().getAttribute("BossLoginMember");
//		
//		//DB에 register 테이블에 boss_no 외래키로 연결
//		// select count(*) from register where boss_no = ?
//		if(bossVo != null) {
//			int result = new PlaceListService().selectPlaceByBossNo(bossVo.getNo());
//			
//			if(result > 0 ) {
//				//
//				req.getRequestDispatcher("views/place/placeList.jsp").forward(req, resp);
//			}
//		}else {
//		
//		req.getRequestDispatcher("views/member/boss/register.jsp").forward(req, resp);}
		
		//사장님인증 여기까지!

		if (req.getParameter("categoryNo") != null && req.getParameter("cityNo") != null
				&& req.getParameter("insideNo") != null) {
			
			int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
			int cityNo = Integer.parseInt(req.getParameter("cityNo"));
			int insideNo = Integer.parseInt(req.getParameter("insideNo"));
			List<PlaceVo> placeList = new PlaceService().getList(categoryNo,cityNo,insideNo);

			req.setAttribute("categoryNo", categoryNo);
			req.setAttribute("cityNo", cityNo);
			req.setAttribute("insideNo", insideNo);
			req.setAttribute("placeList", placeList);
			
		} else {
			req.setAttribute("placeAlert", "변수 없음");
		}

		req.getRequestDispatcher("/views/place/placeList.jsp").forward(req, resp);
		
		
	}
}	


