package com.h3.reportBoard.vo;

import java.sql.Timestamp;

public class ReportBoardVo {
	
	public ReportBoardVo() {
		
	}
	
	private String no;
	private String guilty;
	private String content;
	private String process;
	private String type;
	private String boardNo;
	private String reportUserId;
	private Timestamp enrollDate;
	
	public ReportBoardVo(String no, String guilty, String content, String process, String type, String boardNo,
			String reportUserId, Timestamp enrollDate) {
		super();
		this.no = no;
		this.guilty = guilty;
		this.content = content;
		this.process = process;
		this.type = type;
		this.boardNo = boardNo;
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

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
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
		return "ReportBoardVo [no=" + no + ", guilty=" + guilty + ", content=" + content + ", process=" + process
				+ ", type=" + type + ", boardNo=" + boardNo + ", reportUserId=" + reportUserId + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
		
	
	
	
	
}