package com.h3.reservation.vo;

public class ReservationVo {

	public ReservationVo() {
	}

	public ReservationVo(String no, String startDate, String endDate, String human, String placeNo, String travelerNo,
			String status, String cancel) {
		this.no = no;
		this.startDate = startDate;
		this.endDate = endDate;
		this.human = human;
		this.placeNo = placeNo;
		this.travelerNo = travelerNo;
		this.status = status;
		this.cancel = cancel;
	}

	private String no;
	private String startDate;
	private String endDate;
	private String human;
	private String placeNo;
	private String travelerNo;
	private String status;
	private String cancel;

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

	@Override
	public String toString() {
		return "ReservationVo [no=" + no + ", startDate=" + startDate + ", endDate=" + endDate + ", human=" + human
				+ ", placeNo=" + placeNo + ", travelerNo=" + travelerNo + ", status=" + status + ", cancel=" + cancel
				+ "]";
	}

}
