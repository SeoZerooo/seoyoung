package com.h3.reportComment.vo;

import java.sql.Timestamp;

public class ReportCommentVo {
	
	public ReportCommentVo() {
		
	}
	
	private String no;
	private String guilty;
	private String content;
	private String process;
	private String type;
	private String replyNo;
	private String reportUserId;
	private Timestamp enrollDate;
	
	public ReportCommentVo(String no, String guilty, String content, String process, String type, String replyNo,
			String reportUserId, Timestamp enrollDate) {
		super();
		this.no = no;
		this.guilty = guilty;
		this.content = content;
		this.process = process;
		this.type = type;
		this.replyNo = replyNo;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
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
		return "ReportCommentVo [no=" + no + ", guilty=" + guilty + ", content=" + content + ", process=" + process
				+ ", type=" + type + ", replyNo=" + replyNo + ", reportUserId=" + reportUserId + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
	
	
	
	
	
}
	
	
	