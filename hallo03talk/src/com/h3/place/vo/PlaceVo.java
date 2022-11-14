package com.h3.place.vo;

public class PlaceVo {

	public PlaceVo() {
	}

	public PlaceVo(String no, String name, String content, String address, String bossNo, String categoryNo,
			String status, String enrollDate, int cnt, int zzim, String photoName) {
		this.no = no;
		this.name = name;
		this.content = content;
		this.address = address;
		this.bossNo = bossNo;
		this.categoryNo = categoryNo;
		this.status = status;
		this.enrollDate = enrollDate;
		this.cnt = cnt;
		this.zzim = zzim;
		this.photoName = photoName;
	}

	private String no;
	private String name;
	private String content;
	private String address;
	private String bossNo;
	private String categoryNo;
	private String status;
	private String enrollDate;
	private int cnt;
	private int zzim;
	private String photoName;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBossNo() {
		return bossNo;
	}

	public void setBossNo(String bossNo) {
		this.bossNo = bossNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getZzim() {
		return zzim;
	}

	public void setZzim(int zzim) {
		this.zzim = zzim;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}


	@Override
	public String toString() {
		return "PlaceVo [no=" + no + ", name=" + name + ", content=" + content + ", address=" + address + ", bossNo="
				+ bossNo + ", categoryNo=" + categoryNo + ", status=" + status + ", enrollDate=" + enrollDate + ", cnt="
				+ cnt + ", zzim=" + zzim + ", photoName=" + photoName + "]";
	}

}
