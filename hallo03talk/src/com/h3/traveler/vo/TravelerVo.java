package com.h3.traveler.vo;

import java.sql.Timestamp;

public class TravelerVo {

	
	// 기본생성자
	public TravelerVo() {
		
	}
	
	
	// 매개변수 있는 생성자
	public TravelerVo(int no, String id, String pwd, String name, String nick, String phone, String email,
			String gender, Timestamp enrollDate, Timestamp modifyDate, String status) {
		//super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nick = nick;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	
	// 회원가입 시 사용되는 생성자
	public TravelerVo(String travelerJoinId, String travelerJoinPwd, String travelerJoinPwd2, String travelerJoinName,String travelerJoinNick, String travelerJoinGender, String travelerJoinPhone,
			String travelerJoinEmail) {

		 this.id = travelerJoinId;
		 this.pwd = travelerJoinPwd;
		 this.pwd2 = travelerJoinPwd2;
		 this.name = travelerJoinName;
		 this.nick = travelerJoinNick;
		 this.gender = travelerJoinGender;
		 this.phone = travelerJoinPhone;
		 this.email = travelerJoinEmail;

	}
	
	
	
	
		private int no;
		private String id;
		private String pwd;
		private String pwd2;
		private String name;
		private String nick;
		private String phone;
		private String email;
		private String gender;
		private Timestamp enrollDate;
		private Timestamp modifyDate;
		private String status;
		
		
		public int getNo() {
			return no;
		}

		
		public void setNo(int no) {
			this.no = no;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getPwd2() {
			return pwd2;
		}

		public void setPwd2(String pwd2) {
			this.pwd2 = pwd2;
		}
		
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Timestamp getEnrollDate() {
			return enrollDate;
		}

		public void setEnrollDate(Timestamp enrollDate) {
			this.enrollDate = enrollDate;
		}

		public Timestamp getModifyDate() {
			return modifyDate;
		}

		public void setModifyDate(Timestamp modifyDate) {
			this.modifyDate = modifyDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		
		@Override
		public String toString() {
			return "TravelerVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ",name=" + name + ", nick=" + nick
					+ ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", enrollDate=" + enrollDate
					+ ", modifyDate=" + modifyDate + ", status=" + status + "]";
		}
		
		
	
			
}
