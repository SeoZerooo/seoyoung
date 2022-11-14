package com.h3.placeReviewReply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.h3.common.JDBCTemplate.*;

import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.placeReviewPhoto.vo.PlaceReviewPhotoVo;
import com.h3.placeReviewReply.vo.PlaceReviewReplyVo;

public class PlaceReviewReplyDao {

	public int addReply(Connection conn, PlaceReviewReplyVo prrv) {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "INSERT INTO PLACE_REVIEW_REPLY(NO,CONTENT,REVIEW_NO,BOSS_NO) VALUES(SEQ_PLACE_REVIEW_REPLY_NO.NEXTVAL,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prrv.getContent());
			pstmt.setString(2, prrv.getReviewNo());
			pstmt.setString(3, prrv.getBossNo());

			result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<PlaceReviewReplyVo> getReview(Connection conn, List<PlaceReviewVo> prvList) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlaceReviewReplyVo> prrvList = new ArrayList<PlaceReviewReplyVo>();
		String sql = "SELECT NO,CONTENT,REVIEW_NO,BOSS_NO,ENROLL_DATE FROM PLACE_REVIEW_REPLY WHERE STATUS='Y' AND REVIEW_NO=?";

		try {
			for (int i = 0; i < prvList.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, prvList.get(i).getNo());

				rs = pstmt.executeQuery();

				if (rs.next()) {
					PlaceReviewReplyVo prrv = new PlaceReviewReplyVo();
					prrv.setNo(rs.getString("NO"));
					prrv.setContent(rs.getString("CONTENT"));
					prrv.setReviewNo(rs.getString("REVIEW_NO"));
					prrv.setBossNo(rs.getString("BOSS_NO"));
					prrv.setEnrollDate(rs.getString("ENROLL_DATE"));

					prrvList.add(prrv);
				}

			}

			return prrvList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return prrvList;
	}

	public int replyDel(Connection conn, String replyNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE PLACE_REVIEW_REPLY SET STATUS='N' WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyNo);
			
			result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
