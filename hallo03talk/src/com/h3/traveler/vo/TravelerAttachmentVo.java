package com.h3.traveler.vo;

public class TravelerAttachmentVo {

	// traveler - 마이페이지 - 사진 첨부vo
	
	
	// 기본 생성자
	public TravelerAttachmentVo() {
		
	}
	
	// 매개변수 있는 생성자
	public TravelerAttachmentVo(String no, String originName, String changeName, String filePath, String uploaDate,
			String status, String travelerNo) {
		//super();
		this.no = no;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploaDate = uploaDate;
		this.status = status;
		this.travelerNo = travelerNo;
	}

	
	private String no;
	private String originName;
	private String changeName;
	private String filePath;
	private String uploaDate;
	private String status;
	private String travelerNo;
	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUploaDate() {
		return uploaDate;
	}

	public void setUploaDate(String uploaDate) {
		this.uploaDate = uploaDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTravelerNo() {
		return travelerNo;
	}

	public void setTravelerNo(String travelerNo) {
		this.travelerNo = travelerNo;
	}

	@Override
	public String toString() {
		return "TravelerAttachmentVo [no=" + no + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploaDate=" + uploaDate + ", status=" + status + ", travelerNo="
				+ travelerNo + "]";
	}
	
	
	
	
}
