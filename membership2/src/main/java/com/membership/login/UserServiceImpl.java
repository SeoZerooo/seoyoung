package com.membership.login;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itextpdf.styledxmlparser.jsoup.select.Evaluator.Matches;

@Service
public class UserServiceImpl implements UserService{
	

	private UserDao dao;
	private PasswordEncoder enc;
	
	
	@Autowired 
	public UserServiceImpl(UserDao dao, PasswordEncoder enc) {
		this.dao = dao;
		this.enc = enc; 
	}
	 

	//회원가입
	public int register(UserVo uvo) {
		
		uvo.encodePwd(enc);
		return dao.register(uvo);
	}

	//로그인
	@Override
	public UserVo login(UserVo uvo) {
		
		System.out.println("여기는 서비스impl" + uvo);
		UserVo dbUser = dao.selectOneBy(uvo);
		System.out.println("db유저 비밀번호 : " + dbUser.getUsPassword());
		System.out.println("uvo 비밀번호 : " + uvo.getUsPassword());
		
		if(dbUser == null) {
			return null;
		}
		
		if(enc.matches(uvo.getUsPassword(), dbUser.getUsPassword())) {
			System.out.println("인코딩 매칭까지 왔다" + dbUser);
			return dbUser;
		}else{
			return null;
		}
		
	}

	//아이디 중복 확인
	@Override
	public int idDup(String usId) {
		return dao.idDup(usId);
	}

	//닉네임 중복 확인
	@Override
	public int nickDup(String usName) {
		return dao.nickDup(usName);
	}

	//비밀번호 찾기 위한 정보 조회
	@Override
	public UserVo readMember(UserVo uvo) {
		System.out.println("여기는 서비스impl");
		return dao.readMember(uvo);
	}


	//아이디 찾기
	@Override
	public UserVo readMember2(UserVo uvo) {
		return dao.readMember2(uvo);
	}



	}

	
