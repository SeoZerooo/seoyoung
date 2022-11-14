package com.h3.common;

import java.util.UUID;

public class RandomName {
	
//	랜덤 이름 만들기
	public static String changeName(String originName) {
		int dot = originName.lastIndexOf(".");
		String ext = originName.substring(dot);

		String random = UUID.randomUUID().toString().replace("-", "_");

		String changeName = random + ext;

		return changeName;
	}
}
