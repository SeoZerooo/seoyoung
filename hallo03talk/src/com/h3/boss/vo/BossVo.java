package com.h3.boss.vo;

import java.sql.Timestamp;

public class BossVo {

	// 기본생성자
	public BossVo() {
		
	}
		


	// 매개변수 있는 생성자
	public BossVo(int no, String id, String pwd, String pwd2, String phone, String email, Timestamp enrollDate,
			Timestamp modifyDate, String status) {
		//super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.phone = phone;
		this.email = email;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
		
		
	
	// 회원가입 시 사용되는 생성자
	public BossVo(String bossJoinId, String bossJoinPwd, String bossJoinPwd2, String bossJoinPhone,
			String bossJoinEmail) {

		 this.id = bossJoinId;
		 this.pwd = bossJoinPwd;
		 this.pwd2 = bossJoinPwd2;
		 this.phone = bossJoinPhone;
		 this.email = bossJoinEmail;

	}
		
		

		private int no;
		private String id;
		private String pwd;
		private String pwd2;
		private String phone;
		private String email;
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
			return "BossVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", phone=" + phone
					+ ", email=" + email + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
					+ status + "]";
		}
		
		
		

		
		
		
}
