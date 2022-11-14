package com.h3.traveler.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerAttachmentVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/ajax")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
public class TravelerAjaxUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			TravelerVo loginTraveler = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
			
			String no = Integer.toString(loginTraveler.getNo());
			
			Part file = req.getPart("file");

			String originName = file.getSubmittedFileName();

			System.out.println(originName);

			// 서비스 호출
			String changeName = new TravelerService().createChangeName(originName);

			// 인풋 스트림 준비
			InputStream is = file.getInputStream();

			BufferedInputStream bis = new BufferedInputStream(is);

			String realPath = req.getServletContext().getRealPath("/resources/upload/traveler_profile");
			String savePath = realPath + File.separator + changeName;
			FileOutputStream os = new FileOutputStream(savePath); 
			BufferedOutputStream bos = new BufferedOutputStream(os); 

			byte[] buf = new byte[1024];
			int size = 0; // 사이즈 초기값 설정

			while ((size = bis.read(buf)) != -1) { 
													
				bos.write(buf, 0, size); 
			}

			bos.flush();
			bis.close();
			bos.close();

			TravelerAttachmentVo tav = new TravelerAttachmentVo();
			tav.setOriginName(originName);
			tav.setChangeName(changeName);
			tav.setFilePath(realPath);
			tav.setTravelerNo(no);
			
			new TravelerService().uploadProfilePic(tav);
			
			req.getSession().setAttribute("travelerAttachment", tav);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
