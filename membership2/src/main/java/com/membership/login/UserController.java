package com.membership.login;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	private JavaMailSenderImpl mailSender;
	private UserService us;
	private UserDao dao;
	private PasswordEncoder enc;
	
	@Autowired 
	public UserController(JavaMailSenderImpl mailSender, UserService us, UserDao dao, PasswordEncoder enc) {
		this.mailSender = mailSender;
		this.us = us;
		this.dao = dao;
		this.enc = enc; 
	}
	
 	
 	//회원가입 화면
 	@RequestMapping( value = "/user/register", method = RequestMethod.GET )
 	public ModelAndView registerpage() {
 		
 		ModelAndView model = new ModelAndView("member/register");
 		
 		return model;
 	}
 	
 	//회원가입
 	@RequestMapping( value = "/user/register.do", method = RequestMethod.POST)
 	public String register(UserVo uvo, Model model, HttpSession session) {
 		
 		System.out.println("여기 회원가입 컨트롤러임");
 		System.out.println(uvo);
 		int result = us.register(uvo);
 		
 		//화면 선택
 		if(result == 1) {
 			session.setAttribute("alertMsg", "회원가입완료");
 			return "redirect:/user/login";
 		}else {
 			session.setAttribute("alertMsg", "회원가입실패");
 			return "redirect:/user/login";
 		}
 		
 	}
 	
 	//로그인 화면
 	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
 	public ModelAndView loginpage() {
 		
 		ModelAndView model = new ModelAndView("member/login");
 		
 		return model;
 	}
 	
 	//로그인
 	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
 	public String login(UserVo uvo, HttpSession session) {
 		
 		System.out.println(uvo);
 		
 		UserVo loginVo = us.login(uvo);
 		if( loginVo != null) {
 			session.setAttribute("loginVo", loginVo);
 			System.out.println("성공했음");
 			return "member/home";
 		}else {
 			session.setAttribute("errorMsg", "아이디 혹은 비밀번호를 확인해주세요");
 			System.out.println(loginVo);
 			System.out.println("실패했음");
 			return "member/login";
 		}
 	}
 	
 	
 	//아이디 찾기 화면
 	@RequestMapping(value = "/user/findId", method = RequestMethod.GET)
 	public ModelAndView findIdpage() {
 		
 		ModelAndView model = new ModelAndView("member/findId");
 		
 		return model;
 	}
 	
 	
 	//비밀번호 찾기 화면
 	@RequestMapping(value = "/user/findPwd", method = RequestMethod.GET)
 	public ModelAndView findPwddpage() {
 		
 		ModelAndView model = new ModelAndView("member/findPwd");
 		
 		return model;
 	}
 	
	// 아이디 중복
 	@RequestMapping ( value = "/user/idDup", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> idDup(@RequestBody String usId) {
 		
 		System.out.println(usId);
 		
 		int count = 0;
 		Map<Object, Object> map = new HashMap<Object, Object>();
 		
 		count = us.idDup(usId);
 		map.put("cnt", count);
 		
 		return map;
		
	}//idDup
 	
 	
 	//닉네임 중복
 	@RequestMapping ( value = "/user/nickDup", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> nickDup(@RequestBody String usName) {
 		
 		int count = 0;
 		Map<Object, Object> map = new HashMap<Object, Object>();
 		
 		count = us.nickDup(usName);
 		map.put("cnt", count);
 		
 		return map;
		
	}
 	
 	
 	//이메일 인증 전송
 	@RequestMapping(value = "/user/mailCheck", method = RequestMethod.GET)
 	@ResponseBody
 	public String mailCheck(@RequestParam("usEmail") String usEmail) throws Exception{
 	    int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
 	    
 	    
 	    String from = mailSender.getUsername();//보내는 이 메일주소
 	    String to = usEmail;
 	    String title = "회원가입시 필요한 인증번호 입니다.";
 	    String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
 	    String num = Integer.toString(serti);
 	    
 	    try {
 	    	System.out.println(serti);
 	    	MimeMessage mail = mailSender.createMimeMessage();
 	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
 	        
 	        mailHelper.setFrom(from);
 	        mailHelper.setTo(to);
 	        mailHelper.setSubject(title);
 	        mailHelper.setText(content, true);   
 	        
 	        mailSender.send(mail);
 	        num = Integer.toString(serti);
 	        
 	    } catch(Exception e) {
 	    	e.printStackTrace();
 	        num = "error";
 	    }
 	    
 	    return num;
 	}
 	
 	
// 	//아이디 분실 전송
 	@RequestMapping(value = "/user/findid")
 	@ResponseBody
 	public String findId(HttpServletResponse response, UserVo uvo) throws Exception{
 	   
 		System.out.println(uvo);
 		
 	   UserVo ck = us.readMember2(uvo);
 	   
 	   System.out.println("서비스 다녀온 vo : " + uvo);
 	   System.out.println("왜 서비스에 갔다가 나오지를 못하니");
 	    
 	    String from = mailSender.getUsername();//보내는 이 메일주소
 	    String to = uvo.getUsEmail();
 	    String title = "아이디 입니다.";
 	    String content = "[아이디] "+ uvo.getUsId() +" 입니다. <br/> 로그인 확인을 해주십시오.";
 	    String num = uvo.getUsId();
 	    
 	    try {
 	    	MimeMessage mail = mailSender.createMimeMessage();
 	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
 	        
 	        mailHelper.setFrom(from);
 	        mailHelper.setTo(to);
 	        mailHelper.setSubject(title);
 	        mailHelper.setText(content, true);  
 	       
 	       System.out.println("컨트롤러에서 보여주는 아이디 : " + uvo.getUsId());
 	       System.out.println("메일 보내기 일보직전");
 	        
 	        mailSender.send(mail);
 	        num = uvo.getUsId();
 	        
 	    } catch(Exception e) {
 	    	e.printStackTrace();
 	        num = "error";
 	    }
 	    
 	    return num;
 	}

 	


 	//비밀번호 찾기
 	@RequestMapping(value = "/user/findpw")
 	@ResponseBody
 	public String findPw(HttpServletResponse response, UserVo uvo) throws Exception{
 	   int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
 	   
 	   System.out.println("비번찾기 컨트롤러");
 	   System.out.println(serti);
 	   uvo.setPw(serti, enc);
 	   System.out.println("setPwd 바로 다음 : " + uvo.getUsPassword());
 	    
 	   UserVo ck = us.readMember(uvo);
 	   
 	   System.out.println("왜 서비스에 갔다가 나오지를 못하니");
 	    
 	    String from = mailSender.getUsername();//보내는 이 메일주소
 	    String to = uvo.getUsEmail();
 	    String title = "임시 비밀번호 입니다.";
 	    String content = "[임시 비밀번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
 	    String num = Integer.toString(serti);
 	    
 	    try {
 	    	MimeMessage mail = mailSender.createMimeMessage();
 	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
 	        
 	        mailHelper.setFrom(from);
 	        mailHelper.setTo(to);
 	        mailHelper.setSubject(title);
 	        mailHelper.setText(content, true);  
 	       
 	       System.out.println("컨트롤러에서 보여주는 " + uvo.getUsPassword());
 	       System.out.println("메일 보내기 일보직전");
 	        
 	        mailSender.send(mail);
 	        num = Integer.toString(serti);
 	        
 	    } catch(Exception e) {
 	    	e.printStackTrace();
 	        num = "error";
 	    }
 	    
 	    return num;
 	}

 	

}
