package com.h3.traveler.vo;

public class MpgZzimVo {

	
	// 기본생성자
	public MpgZzimVo() {
		
	}
	
	public MpgZzimVo(String no, String travelerNo, String placeNo, String name, String content, String board) {
		super();
		this.no = no;
		this.travelerNo = travelerNo;
		this.placeNo = placeNo;
		this.name = name;
		this.content = content;
		this.board = board;
	}

	private String no;
	private String travelerNo;    	// 회원번호
	private String placeNo;			// 장소번호
	private String name;  		  	// 장소명
	private String content;  		// 내용
	private String board;			// 게시판 타입
	
	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	
	
	@Override
	public String toString() {
		return "MpgZzimVo [no=" + no + ", travelerNo=" + travelerNo + ", placeNo=" + placeNo + ", name=" + name + ", content="
				+ content + ", board=" + board + "]";
	}
	
	
	
}
