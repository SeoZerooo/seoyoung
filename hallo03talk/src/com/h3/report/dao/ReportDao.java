package com.h3.report.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.h3.common.JDBCTemplate.*;
import com.h3.reportBoard.vo.ReportBoardVo;
import com.h3.reportComment.vo.ReportCommentVo;
import com.h3.reportUser.vo.ReportUserVo;

public class ReportDao {
	
	/*
	 * 신고하기
	 */
	
	//사용자 신고
	public int ujoin(ReportUserVo uvo, Connection conn) throws Exception{
		
		//데이터 넣기
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO REPORT_USER (NO, GUILTY, CONTENT, PROCESS, REPORTED_TRAVELER_NO) VALUES ( SEQ_REPORT_USER_NO.NEXTVAL, ?, ?, DEFAULT, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uvo.getGuilty());
			pstmt.setString(2, uvo.getContent());
			pstmt.setString(3, uvo.getReportedTravelerNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) { 
			
			throw e;
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}
	
	//게시물 신고
	public int bjoin(ReportBoardVo bvo, Connection conn) throws Exception {
		
		//데이터 넣기
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO REPORT_CONTENT (NO, GUILTY, CONTENT, PROCESS, TYPE, BOARD_NO) VALUES ( SEQ_REPORT_CONTENT_NO.NEXTVAL, ?, ?, DEFAULT, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getGuilty());
			pstmt.setString(2, bvo.getContent());
			pstmt.setString(3, bvo.getType());
			pstmt.setString(4, bvo.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;

	}
	
	
	//댓글 신고
	public int cjoin(ReportCommentVo cvo, Connection conn) throws Exception {
		
		//데이터 넣기
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO REPORT_REPLY (NO, GUILTY, CONTENT, PROCESS, TYPE, REPLY_NO) VALUES ( SEQ_REPORT_REPLY_NO.NEXTVAL, ?, ?, DEFAULT, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getGuilty());
			pstmt.setString(2, cvo.getContent());
			pstmt.setString(3, cvo.getType());
			pstmt.setString(4, cvo.getReplyNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) { 
			
			throw e;
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;

	}

	
	

}
