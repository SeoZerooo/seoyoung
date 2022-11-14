package com.h3.traveler.vo;

public class MpgReservationVo {

	// traveler - 예약 내역 조회 vo
	
	// 기본생성자
	public MpgReservationVo() {
		
	}
	
	
	// 매개변수 있는 생성자
	public MpgReservationVo(String no, String startDate, String endDate, String human, String placeNo,
			String travelerNo, String status, String cancel, String name, String address) {
		//super();
		this.no = no;
		this.startDate = startDate;
		this.endDate = endDate;
		this.human = human;
		this.placeNo = placeNo;
		this.travelerNo = travelerNo;
		this.status = status;
		this.cancel = cancel;
		this.name = name;
		this.address = address;
	}
	
	

	private String no;				// 예약 번호
	private String startDate;		// 예약 날짜
	private String endDate;			// 예약 만료
	private String human;			// 인원수
	private String placeNo;			// 장소번호
	private String travelerNo;    	// 회원번호
	private String status;			// 삭제여부(상태)
	private String cancel;  		// 취소여부(상태)
	private String name;  		  	// 장소명
	private String address;  		// 장소주소
	
	
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getHuman() {
		return human;
	}


	public void setHuman(String human) {
		this.human = human;
	}


	public String getPlaceNo() {
		return placeNo;
	}


	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}


	public String getTravelerNo() {
		return travelerNo;
	}


	public void setTravelerNo(String travelerNo) {
		this.travelerNo = travelerNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCancel() {
		return cancel;
	}


	public void setCancel(String cancel) {
		this.cancel = cancel;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "MpgReservationVo [no=" + no + ", startDate=" + startDate + ", endDate=" + endDate + ", human=" + human
				+ ", placeNo=" + placeNo + ", travelerNo=" + travelerNo + ", status=" + status + ", cancel=" + cancel
				+ ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}
