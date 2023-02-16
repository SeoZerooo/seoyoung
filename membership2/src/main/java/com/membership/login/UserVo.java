package com.membership.login;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserVo {
	
	  private String usSeq;
	  private String usId;
	  private String usPassword;
	  private String usName;
	  private String usEmail;
	  private String usStatus;
	  private String usCreatdate;
	  private String usPhoneNum;
	  
	  public UserVo() {
		super();
	}

	public UserVo(String usSeq, String usId, String usPassword, String usName, String usEmail, String usStatus,
			String usCreatdate, String usPhoneNum) {
		super();
		this.usSeq = usSeq;
		this.usId = usId;
		this.usPassword = usPassword;
		this.usName = usName;
		this.usEmail = usEmail;
		this.usStatus = usStatus;
		this.usCreatdate = usCreatdate;
		this.usPhoneNum = usPhoneNum;
	}

	 @Override
	public String toString() {
		return "UserVo [usSeq=" + usSeq + ", usId=" + usId + ", usPassword=" + usPassword + ", usName=" + usName
				+ ", usEmail=" + usEmail + ", usStatus=" + usStatus + ", usCreatdate=" + usCreatdate + ", usPhoneNum="
				+ usPhoneNum + "]";
	}
	 

	public String getUsSeq() {
		return usSeq;
	}

	public void setUsSeq(String usSeq) {
		this.usSeq = usSeq;
	}

	public String getUsId() {
		return usId;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public String getUsPassword() {
		return usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsEmail() {
		return usEmail;
	}

	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}

	public String getUsStatus() {
		return usStatus;
	}

	public void setUsStatus(String usStatus) {
		this.usStatus = usStatus;
	}

	public String getUsCreatdate() {
		return usCreatdate;
	}

	public void setUsCreatdate(String usCreatdate) {
		this.usCreatdate = usCreatdate;
	}

	public String getUsPhoneNum() {
		return usPhoneNum;
	}

	public void setUsPhoneNum(String usPhoneNum) {
		this.usPhoneNum = usPhoneNum;
	}

	public void encodePwd(PasswordEncoder pwdEnc) {
		System.out.println(usPassword);
		this.usPassword = pwdEnc.encode(usPassword);
		System.out.println(pwdEnc.encode(usPassword));
		
	}

	public void setPw(int serti, PasswordEncoder pwdEnc) {
		this.usPassword = pwdEnc.encode(Integer.toString(serti));
	}

}
