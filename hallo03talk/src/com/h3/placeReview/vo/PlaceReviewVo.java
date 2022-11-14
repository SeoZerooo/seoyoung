package com.h3.placeReview.vo;

public class PlaceReviewVo {

	public PlaceReviewVo() {
	}

	public PlaceReviewVo(String no, String title, String content, int star, String status, String placeNo,
			String travelerNo, String enrollDate, String checkReview) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.star = star;
		this.status = status;
		this.placeNo = placeNo;
		this.travelerNo = travelerNo;
		this.enrollDate = enrollDate;
		this.checkReview = checkReview;
	}

	private String no;
	private String title;
	private String content;
	private int star;
	private String status;
	private String placeNo;
	private String travelerNo;
	private String enrollDate;
	private String checkReview;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}

	public String getTravelerNo() {
		return travelerNo;
	}

	public void setTravelerNo(String travelerNo) {
		this.travelerNo = travelerNo;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getCheckReview() {
		return checkReview;
	}

	public void setCheckReview(String checkReview) {
		this.checkReview = checkReview;
	}

	@Override
	public String toString() {
		return "PlaceReviewVo [no=" + no + ", title=" + title + ", content=" + content + ", star=" + star + ", status="
				+ status + ", placeNo=" + placeNo + ", travelerNo=" + travelerNo + ", enrollDate=" + enrollDate
				+ ", checkReview=" + checkReview + "]";
	}

}
