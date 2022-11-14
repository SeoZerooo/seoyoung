package com.h3.zzim.vo;

public class ZzimVo {

	public ZzimVo() {
	}

	public ZzimVo(String travelerNo, String placeNo) {
		this.travelerNo = travelerNo;
		this.placeNo = placeNo;
	}

	private String travelerNo;
	private String placeNo;

	public String getTravelerNo() {
		return travelerNo;
	}

	public void setTravelerNo(String travelerNo) {
		this.travelerNo = travelerNo;
	}

	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}

	@Override
	public String toString() {
		return "ZzimVo [travelerNo=" + travelerNo + ", placeNo=" + placeNo + "]";
	}

}
