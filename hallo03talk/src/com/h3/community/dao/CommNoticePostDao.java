package com.h3.community.dao;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.h3.community.vo.CommVo;

public class CommNoticePostDao {

	public int post(Connection conn, CommVo vo) throws SQLException, Exception {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO COMMUNITY VALUES(SEQ_COMMUNITY_NO.NEXTVAL, ?,?,SYSDATE, SYSDATE,DEFAULT, ?, DEFAULT, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, new CommDao().getCategoryNumber(conn, vo.getCategory()));
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;		
	}

}
