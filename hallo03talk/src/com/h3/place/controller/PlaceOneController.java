package com.h3.place.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossVo;
import com.h3.place.service.PlaceService;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;
import com.h3.placeReview.service.PlaceReviewService;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.placeReviewPhoto.vo.PlaceReviewPhotoVo;
import com.h3.placeReviewReply.service.PlaceReviewReplyService;
import com.h3.placeReviewReply.vo.PlaceReviewReplyVo;
import com.h3.reservation.service.ReservationService;
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.service.ZzimService;

@WebServlet("/place/one")
public class PlaceOneController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String placeNo = (String) req.getParameter("placeNo");
		
		PlaceVo pv = new PlaceService().placeOne(placeNo);
		int result = new PlaceService().getCnt(placeNo);
//		장소 사진 전부
		ArrayList<PlacePhotoVo> photoList = new PlaceService().photoOne(placeNo);
//		로그인한 사장님 정보
		BossVo bv = new BossService().selectOneByNo(Integer.parseInt(pv.getBossNo()));
//		후기 전부
		List<PlaceReviewVo> prvList = new PlaceReviewService().getReview(placeNo);
//		후기 사진 전부
		List<PlaceReviewPhotoVo> prpvList = new PlaceReviewService().getPhoto(prvList);
//		후기 댓글 전부
		List<PlaceReviewReplyVo> prrvList = new PlaceReviewReplyService().getReview(prvList);
//		찜 개수
		int zzimCnt = new ZzimService().getCnt(placeNo);
//		예약 여부
		if(req.getSession().getAttribute("travelerLoginMember") != null) {
			TravelerVo tv = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
			int resCheck = 0;
			
			if(new ReservationService().checkReservation(placeNo, tv.getNo()).getNo() != null) {
				resCheck = 1;
			}
			
			req.setAttribute("resCheck", resCheck);
		}
//		평균 별점
		int stars = new PlaceService().getStars(placeNo);
		
		req.setAttribute("placeVo", pv);
		req.setAttribute("photoList", photoList);
		req.setAttribute("bossVoForShow", bv);
		req.setAttribute("reviewList", prvList);
		req.setAttribute("reviewPhotoList", prpvList);
		req.setAttribute("reviewReplyList", prrvList);
		req.setAttribute("zzimCnt", zzimCnt);
		req.setAttribute("stars", stars);
		
		if (result==1 && pv != null && photoList != null) {
			// 성공
			req.getRequestDispatcher("/views/place/onePlace.jsp").forward(req, resp);
		} else {
			// 실패
			resp.sendRedirect("/hallo03talk/place/list?categoryNo=0&cityNo=0&insideNo=0");
		}

	}
}
