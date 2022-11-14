package com.h3.placeReview.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.placeReviewPhoto.vo.PlaceReviewPhotoVo;

public class PlaceReviewDao {

	public int addReview(Connection conn, PlaceReviewVo prv) {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "INSERT INTO PLACE_REVIEW(NO,TITLE,CONTENT,STAR,PLACE_NO,TRAVELER_NO) VALUES(SEQ_PLACE_REVIEW_NO.NEXTVAL,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prv.getTitle());
			pstmt.setString(2, prv.getContent());
			pstmt.setInt(3, prv.getStar());
			pstmt.setString(4, prv.getPlaceNo());
			pstmt.setString(5, prv.getTravelerNo());

			result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int addReviewPhoto(Connection conn, PlaceReviewPhotoVo prpv) {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "INSERT INTO PLACE_REVIEW_PHOTO(NO,NAME,PATH,REVIEW_NO) VALUES(SEQ_PLACE_PHOTO_NO.NEXTVAL,?,?,SEQ_PLACE_REVIEW_NO.CURRVAL)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prpv.getName());
			pstmt.setString(2, prpv.getPath());
			
			result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<PlaceReviewVo> getReview(Connection conn, String placeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlaceReviewVo> prvList = new ArrayList<PlaceReviewVo>();
		
		String sql = "SELECT PR.NO NO,PR.TITLE TITLE,PR.CONTENT CONTENT, PR.STAR STAR, PR.PLACE_NO PLACE_NO, PR.TRAVELER_NO TRAVELER_NO, PR.ENROLL_DATE ENROLL_DATE, RR.NO REVIEW_NO, RR.STATUS STATUS, T.NICK NICK FROM PLACE_REVIEW PR LEFT OUTER JOIN PLACE_REVIEW_REPLY RR ON PR.NO = RR.REVIEW_NO JOIN TRAVELER T ON PR.TRAVELER_NO = T.NO WHERE PR.STATUS='Y' AND PLACE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PlaceReviewVo prv = new PlaceReviewVo();
				prv.setNo(rs.getString("NO"));
				prv.setTitle(rs.getString("TITLE"));
				prv.setContent(rs.getString("CONTENT"));
				prv.setStar(rs.getInt("STAR"));
				prv.setPlaceNo(rs.getString("PLACE_NO"));
				prv.setTravelerNo(rs.getString("NICK"));
				prv.setEnrollDate(rs.getString("ENROLL_DATE"));
				prv.setCheckReview(rs.getString("STATUS"));
				prvList.add(prv);
			}
			
			return prvList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
	
		
		return prvList;
	}

	public List<PlaceReviewPhotoVo> getPhoto(Connection conn, List<PlaceReviewVo> prvList) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlaceReviewPhotoVo> prpvList = new ArrayList<PlaceReviewPhotoVo>();
		
		String sql = "SELECT NO,NAME,PATH,ENROLL_DATE,REVIEW_NO FROM PLACE_REVIEW_PHOTO WHERE STATUS='Y' AND REVIEW_NO=?";
		
		try {
			
			for(int i=0; i<prvList.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, prvList.get(i).getNo());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					PlaceReviewPhotoVo prpv = new PlaceReviewPhotoVo();
					prpv.setNo(rs.getString("NO"));
					prpv.setName(rs.getString("NAME"));
					prpv.setPath(rs.getString("PATH"));
					prpv.setEnrollDate(rs.getString("ENROLL_DATE"));
					prpv.setReviewNo(rs.getString("REVIEW_NO"));
					
					prpvList.add(prpv);
				}
			}
			
			return prpvList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
	
		
		return prpvList;
	}

	public int delReview(Connection conn, String placeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE PLACE_REVIEW SET STATUS='N' WHERE PLACE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			
			result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int delOneReview(Connection conn, PlaceReviewVo prv) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE PLACE_REVIEW SET STATUS='N' WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prv.getNo());
			
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
