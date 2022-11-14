package com.h3.placePhoto.vo;

public class PlacePhotoVo {

	public PlacePhotoVo() {
		super();
	}

	public PlacePhotoVo(String no, String name, String path, String status, String enrollDate, String placeNo,
			String profile) {
		super();
		this.no = no;
		this.name = name;
		this.path = path;
		this.status = status;
		this.enrollDate = enrollDate;
		this.placeNo = placeNo;
		Profile = profile;
	}

	private String no;
	private String name;
	private String path;
	private String status;
	private String enrollDate;
	private String placeNo;
	private String Profile;

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

	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}

	public String getProfile() {
		return Profile;
	}

	public void setProfile(String profile) {
		Profile = profile;
	}

	@Override
	public String toString() {
		return "PlacePhotoVo [no=" + no + ", name=" + name + ", path=" + path + ", status=" + status + ", enrollDate="
				+ enrollDate + ", placeNo=" + placeNo + ", Profile=" + Profile + "]";
	}

}
