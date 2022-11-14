package com.h3.with.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/with/imgUpload")
public class WithImgUploadController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String img = req.getParameter("img").replace("data:image/jpeg;base64,", "");
		
		byte[] byteImg = Base64.getDecoder().decode(img);
		
		String realPath = req.getServletContext().getRealPath("/resources/upload/with/");
		String fileName = UUID.randomUUID().toString() + ".jpg";
		
		String savePath = realPath + fileName;
		
		System.out.println(savePath);
		
		
		File f = new File(savePath);
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		bos.write(byteImg);
		
		bos.flush();
		bos.close();
		
		savePath = "/hallo03talk/resources/upload/with/" + fileName;
		
		resp.getWriter().write(savePath);
	}
}
