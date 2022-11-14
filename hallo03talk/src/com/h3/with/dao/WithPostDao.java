package com.h3.with.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.h3.common.JDBCTemplate;
import com.h3.with.vo.WithVo;

public class WithPostDao {

	public int post(Connection conn, WithVo vo) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO WITH_ VALUES(SEQ_WITH_NO.NEXTVAL, ?, ?, ?, default, default, ?, ?, ?, ?, default, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			String tag = String.join(",", vo.getTag());
			pstmt.setString(3, tag);
			pstmt.setDate(4, vo.getStart_date());
			pstmt.setDate(5, vo.getEnd_date());
			pstmt.setString(6, vo.getInsta());
			
			pstmt.setString(7, vo.getTraveler_no());
			pstmt.setString(8, vo.getPlace());
			
			result = pstmt.executeUpdate();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
