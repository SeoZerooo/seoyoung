package com.h3.placeReviewReply.vo;

public class PlaceReviewReplyVo {

	public PlaceReviewReplyVo() {
	}

	public PlaceReviewReplyVo(String no, String content, String status, String reviewNo, String bossNo,
			String enrollDate) {
		this.no = no;
		this.content = content;
		this.status = status;
		this.reviewNo = reviewNo;
		this.bossNo = bossNo;
		this.enrollDate = enrollDate;
	}

	private String no;
	private String content;
	private String status;
	private String reviewNo;
	private String bossNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getBossNo() {
		return bossNo;
	}

	public void setBossNo(String bossNo) {
		this.bossNo = bossNo;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "PlaceReviewReplyVo [no=" + no + ", content=" + content + ", status=" + status + ", reviewNo=" + reviewNo
				+ ", bossNo=" + bossNo + ", enrollDate=" + enrollDate + "]";
	}

}
