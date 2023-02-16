package com.membership.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSession sst;
	
	//회원가입
	@Override
	public int register(UserVo uvo) {
		System.out.println("매퍼 들어가기 일보직전 " + uvo);
		return sst.insert("userMapper.register", uvo);
}

	//로그인
	@Override
	public UserVo selectOneBy(UserVo uvo) {
		System.out.println("매퍼 들어가기 일보직전 " + uvo);
		return sst.selectOne("userMapper.login", uvo);
	}

	//아이디 중복확인
	@Override
	public int idDup(String usId) {
		return sst.selectOne("userMapper.idDup", usId);
	}

	//닉네임 중복 확인
	@Override
	public int nickDup(String usName) {
		return sst.selectOne("userMapper.nickDup", usName);
	}	
	
	//비밀번호 찾기 위한 정보 조회
	@Override
	public UserVo readMember(UserVo uvo) {
		System.out.println("매퍼들어가기 일보직전");
		return sst.selectOne("userMapper.readMember", uvo);
	}

	//아이디 찾기 위한 정보 조회
	@Override
	public UserVo readMember2(UserVo uvo) {
		return sst.selectOne("userMapper.readMember2", uvo);
	}
	

}
