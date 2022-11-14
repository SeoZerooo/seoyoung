package com.h3.placeReviewPhoto.vo;

public class PlaceReviewPhotoVo {

	public PlaceReviewPhotoVo() {
	}

	public PlaceReviewPhotoVo(String no, String name, String path, String status, String enrollDate, String reviewNo) {
		this.no = no;
		this.name = name;
		this.path = path;
		this.status = status;
		this.enrollDate = enrollDate;
		this.reviewNo = reviewNo;
	}

	private String no;
	private String name;
	private String path;
	private String status;
	private String enrollDate;
	private String reviewNo;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	@Override
	public String toString() {
		return "PlaceReviewPhotoVo [no=" + no + ", name=" + name + ", path=" + path + ", status=" + status
				+ ", enrollDate=" + enrollDate + ", reviewNo=" + reviewNo + "]";
	}

}
