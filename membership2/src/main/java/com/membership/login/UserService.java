package com.membership.login;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

public interface UserService {

	//회원가입
	int register(UserVo uvo);

	static void register(UserDao dao) {
		
	}

	//로그인
	UserVo login(UserVo uvo);

	//아이디 중복 확인
	int idDup(String usId);

	//닉네임 중복 확인
	int nickDup(String usName);

	//비밀번호 찾기 위한 조회
	UserVo readMember(UserVo uvo);

	//아이디 찾기 위한 조회
	UserVo readMember2(UserVo uvo);
	


}
