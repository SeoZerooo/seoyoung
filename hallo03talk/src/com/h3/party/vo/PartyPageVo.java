package com.h3.party.vo;

import java.sql.Timestamp;

public class PartyPageVo {
	
	public PartyPageVo(int no, String title, String content, int cnt, Timestamp enroll_date, String status,
			int party_category, int boss_no) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.cnt = cnt;
		this.enrollDate = enroll_date;
		this.status = status;
		this.partyCategory = party_category;
		this.boss_no = boss_no;
		
	}
	
	private int no;
	private String title;
	private String content;
	private int cnt;
	private Timestamp enrollDate;
	private String status;
	private int partyCategory;
	private int boss_no;
	
	
	
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
	public Timestamp getEnroll_date() {
		return enrollDate;
	}
	public void setEnroll_date(Timestamp enroll_date) {
		this.enrollDate = enroll_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getParty_category() {
		return partyCategory;
	}
	public void setParty_category(int party_category) {
		this.partyCategory = party_category;
	}
	public int getBoss_no() {
		return boss_no;
	}
	public void setBoss_no(int boss_no) {
		this.boss_no = boss_no;
	}
	
	
	
	@Override
	public String toString() {
		return "PartyPageVo [no=" + no + ", title=" + title + ", content=" + content + ", cnt=" + cnt + ", enroll_date="
				+ enrollDate + ", status=" + status + ", party_category=" + partyCategory + ", boss_no=" + boss_no
				+ ", modify_date=" +  "]";
	}
	

}
