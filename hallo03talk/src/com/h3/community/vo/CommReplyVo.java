package com.h3.community.vo;

public class CommReplyVo {

	// 커뮤니티 댓글 Vo
	
	
	// 기본생성자
	public CommReplyVo() {
		
		
		
	}
	
	
	// 매개변수 있는 생성자
	public CommReplyVo(String no, String content, String travelerNo, String communityNo, String enrollDate) {
		//super();
		this.no = no;
		this.content = content;
		this.travelerNo = travelerNo;
		this.communityNo = communityNo;
		this.enrollDate = enrollDate;
	}
	
	

	private String no;
	private String content;
	private String travelerNo;
	private String communityNo;
	private String enrollDate;
	
	
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTravelerNo() {
		return travelerNo;
	}


	public void setTravelerNo(String travelerNo) {
		this.travelerNo = travelerNo;
	}


	public String getCommunityNo() {
		return communityNo;
	}


	public void setCommunityNo(String communityNo) {
		this.communityNo = communityNo;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	@Override
	public String toString() {
		return "CommunityReplyVo [no=" + no + ", content=" + content + ", travelerNo=" + travelerNo + ", communityNo="
				+ communityNo + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
	
	
}//class
