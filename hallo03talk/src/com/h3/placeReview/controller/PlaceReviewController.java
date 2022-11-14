package com.h3.placeReview.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h3.common.RandomName;
import com.h3.placeReview.service.PlaceReviewService;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.placeReviewPhoto.vo.PlaceReviewPhotoVo;
import com.h3.traveler.vo.TravelerVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 100,
		maxRequestSize = 1024 * 1024 * 100 * 1
)
@WebServlet("/place/addReview")
public class PlaceReviewController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Part f = req.getPart("reviewImg");
		String placeNo = (String) req.getParameter("placeNo");
		String title = (String) req.getParameter("reviewTitle");
		String content = (String) req.getParameter("reviewContent");
		String star = (String) req.getParameter("star");
		TravelerVo travelerVo = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");
		
		PlaceReviewVo prv = new PlaceReviewVo();
		prv.setPlaceNo(placeNo);
		prv.setTitle(title);
		prv.setContent(content);
		prv.setStar(Integer.parseInt(star));
		prv.setTravelerNo(Integer.toString(travelerVo.getNo()));
		
		String originName = f.getSubmittedFileName();
		String photoName= RandomName.changeName(originName);
		String realPath = req.getServletContext().getRealPath("/resources/upload/place");
		
		InputStream is = f.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		FileOutputStream os = new FileOutputStream(realPath + File.separator + photoName);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		byte [] buf = new byte[1024];
		int size = 0;
		while((size=bis.read(buf)) != -1) {
			bos.write(buf,0,size);
		}
		
		bos.flush();
		bis.close();
		bos.close();
		
		PlaceReviewPhotoVo prpv = new PlaceReviewPhotoVo();
		prpv.setName(photoName);
		prpv.setPath(realPath);
		
		int result = new PlaceReviewService().addReview(prv,prpv);
		
		if (result == 1) {
			// 성공
			resp.sendRedirect("/hallo03talk/place/one?placeNo="+placeNo);
		} else {
			// 실패 
			new File(realPath + File.separator + photoName).delete();
		}
		
	}
}
