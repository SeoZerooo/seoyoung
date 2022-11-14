package com.h3.community.vo;

import java.sql.Timestamp;

public class CommVo {
	private String no;
	private String title;
	private String content;
	private Timestamp enroll_date;
	private Timestamp modify_date;
	private int cnt;
	private String writer;
	private String status;
	private String category;
	
	public CommVo() {
		super();
	}

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

	public Timestamp getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Timestamp enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Timestamp getModify_date() {
		return modify_date;
	}

	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CommVo [no=" + no + ", title=" + title + ", content=" + content + ", enroll_date=" + enroll_date
				+ ", modify_date=" + modify_date + ", cnt=" + cnt + ", writer=" + writer + ", status=" + status
				+ ", category=" + category + "]";
	}
}
