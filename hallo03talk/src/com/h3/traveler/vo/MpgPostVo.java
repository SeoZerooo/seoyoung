package com.h3.traveler.vo;

public class MpgPostVo {

	// traveler - 마이페이지  
	
	// 기본생성자
	public MpgPostVo() {
		
	}
	
	// 매개변수 있는 생성자
	public MpgPostVo(String no, String title, String content, String writer, String enrollDate,  String board) {
		//super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.enrollDate = enrollDate;
		this.board = board;
		
	}
	
		private String no;
		private String title;
		private String content;
		private String writer;
		private String enrollDate;
		private String status;
		private String board;
		
		
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

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getEnrollDate() {
			return enrollDate;
		}

		public void setEnrollDate(String enrollDate) {
			this.enrollDate = enrollDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getBoard() {
			return board;
		}

		public void setBoard(String board) {
			this.board = board;
		}

		@Override
		public String toString() {
			return "MyPageVo [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
					+ ", enrollDate=" + enrollDate + ", status=" + status + ", board=" + board + "]";
		}
	
		
}
