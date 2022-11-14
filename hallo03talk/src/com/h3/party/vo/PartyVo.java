package com.h3.party.vo;

import java.sql.Timestamp;

public class PartyVo {

	public PartyVo() {

	}

	public PartyVo(int no, String title, String content, int cnt, Timestamp enrollDate, String status, int bossNo,
			String categoryName, String bossId) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.cnt = cnt;
		this.enrollDate = enrollDate;
		this.status = status;
		this.bossNo = bossNo;
		this.categoryName = categoryName;
		this.bossId = bossId;
	}

	private int no;
	private String title;
	private String content;
	private int cnt;
	private Timestamp enrollDate;
	private String status;
	private int bossNo;
	private String categoryName;
	private String bossId;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBossNo() {
		return bossNo;
	}

	public void setBossNo(int bossNo) {
		this.bossNo = bossNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBossId() {
		return bossId;
	}

	public void setBossId(String bossId) {
		this.bossId = bossId;
	}

	@Override
	public String toString() {
		return "PartyVo [no=" + no + ", title=" + title + ", content=" + content + ", cnt=" + cnt + ", enrollDate="
				+ enrollDate + ", status=" + status + ", bossNo=" + bossNo + ", categoryName=" + categoryName
				+ ", bossId=" + bossId + "]";
	}

}
