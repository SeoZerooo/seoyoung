package com.h3.boss.controller;

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

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossAttachmentVo;
import com.h3.boss.vo.BossVo;

@WebServlet(urlPatterns = "/boss/ajax")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
public class BossAjaxUploadController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

try {
			
			BossVo BossLoginMember = (BossVo)req.getSession().getAttribute("BossLoginMember");

			String no = Integer.toString(BossLoginMember.getNo());
			
			Part file = req.getPart("file");

			String originName = file.getSubmittedFileName();

			System.out.println(originName);

			// 서비스 호출
			String changeName = new BossService().createChangeName(originName);

			// 인풋 스트림 준비
			InputStream is = file.getInputStream();

			BufferedInputStream bis = new BufferedInputStream(is);

			String realPath = req.getServletContext().getRealPath("/resources/upload/boss_profile");
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

			BossAttachmentVo bav = new BossAttachmentVo();
			bav.setOriginName(originName);
			bav.setChangeName(changeName);
			bav.setFilePath(realPath);
			bav.setBossNo(no);
			
			new BossService().uploadProfilePic(bav);
			
			req.getSession().setAttribute("bossAttachment", bav);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}//doPost
	
	
	
}//class
