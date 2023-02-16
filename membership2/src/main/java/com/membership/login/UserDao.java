package com.membership.login;

import org.apache.ibatis.session.SqlSession;

public interface UserDao {

	//회원가입
	int register(UserVo uvo);

	//로그인
	UserVo selectOneBy(UserVo uvo);

	//아이디 중복확인
	int idDup(String usId);

	//닉네임 중복 확인
	int nickDup(String usName);

	//비밀번호 찾기 위한 정보 조회
	UserVo readMember(UserVo uvo);

	//아이디 찾기 위한 정보 조회
	UserVo readMember2(UserVo uvo);


}
