package com.h3.reportUser.vo;

import java.sql.Timestamp;

public class ReportUserVo {
	
	public ReportUserVo() {
		
	}
	
	
	private String no;
	private String guilty;
	private String content;
	private String process;
	private String reportedTravelerNo;
	private String reportUserId;
	private Timestamp enrollDate;
	
	
	public ReportUserVo(String no, String guilty, String content, String process, String reportedTravelerNo,
			String reportUserId, Timestamp enrollDate) {
		super();
		this.no = no;
		this.guilty = guilty;
		this.content = content;
		this.process = process;
		this.reportedTravelerNo = reportedTravelerNo;
		this.reportUserId = reportUserId;
		this.enrollDate = enrollDate;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getGuilty() {
		return guilty;
	}


	public void setGuilty(String guilty) {
		this.guilty = guilty;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getProcess() {
		return process;
	}


	public void setProcess(String process) {
		this.process = process;
	}


	public String getReportedTravelerNo() {
		return reportedTravelerNo;
	}


	public void setReportedTravelerNo(String reportedTravelerNo) {
		this.reportedTravelerNo = reportedTravelerNo;
	}


	public String getReportUserId() {
		return reportUserId;
	}


	public void setReportUserId(String reportUserId) {
		this.reportUserId = reportUserId;
	}


	public Timestamp getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}


	@Override
	public String toString() {
		return "ReportUserVo [no=" + no + ", guilty=" + guilty + ", content=" + content + ", process=" + process
				+ ", reportedTravelerNo=" + reportedTravelerNo + ", reportUserId=" + reportUserId + ", enrollDate="
				+ enrollDate + "]";
	}



	
	
	
	
	
	


	
	
	
	
	
	
	
	

	

	
	

	
	
	
	

}
