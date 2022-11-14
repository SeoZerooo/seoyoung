package com.h3.with.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class WithVo {
	private String no;
	private String title;
	private String content;
	private String[] tag;
	private Timestamp enroll_date;
	private String status;
	private Date start_date;
	private Date end_date;
	private String insta;
	private String traveler_no;
	private String cnt;
	private String place;
	
	public WithVo() {
		super();
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public String[] getTag() {
		return tag;
	}
	public void setTag(String[] tag) {
		this.tag = tag;
	}
	public Timestamp getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Timestamp enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getInsta() {
		return insta;
	}
	public void setInsta(String insta) {
		this.insta = insta;
	}
	public String getTraveler_no() {
		return traveler_no;
	}
	public void setTraveler_no(String traveler_no) {
		this.traveler_no = traveler_no;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "WithVo [no=" + no + ", title=" + title + ", content=" + content + ", tag=" + tag + ", enroll_date="
				+ enroll_date + ", status=" + status + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", insta=" + insta + ", traveler_no=" + traveler_no + ", cnt=" + cnt + "]";
	}
	
	
}
