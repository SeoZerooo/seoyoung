package com.h3.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.h3.community.vo.CommReplyVo;

import static com.h3.common.JDBCTemplate.*;

public class CommReplyDao {

	public int delete(Connection conn, String commNo, String replyNo) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM REPLY WHERE NO = ? AND COMMUNITY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyNo);
			pstmt.setString(2, commNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int post(Connection conn, CommReplyVo vo) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL,? , ?, ?, SYSDATE)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getTravelerNo());
			pstmt.setString(3, vo.getCommunityNo());
			
			result = pstmt.executeUpdate(); 
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int delete(Connection conn, String no) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM REPLY WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
