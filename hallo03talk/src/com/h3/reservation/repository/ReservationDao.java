package com.h3.reservation.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.h3.reservation.vo.ReservationVo;

public class ReservationDao {

	public int addReservation(Connection conn, ReservationVo rv) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO RESERVATION(NO,START_DATE,END_DATE,HUMAN,PLACE_NO,TRAVELER_NO) VALUES(SEQ_RESERVATION_NO.NEXTVAL,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rv.getStartDate());
			pstmt.setString(2, rv.getEndDate());
			pstmt.setString(3, rv.getHuman());
			pstmt.setString(4, rv.getPlaceNo());
			pstmt.setString(5, rv.getTravelerNo());
			
			result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ReservationVo checkReservation(Connection conn, String placeNo, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		ReservationVo rv = new ReservationVo();
		
		String sql = "SELECT NO, START_DATE,END_DATE,HUMAN,PLACE_NO,TRAVELER_NO, CANCEL FROM RESERVATION WHERE STATUS='Y' AND CANCEL='N' AND PLACE_NO=? AND TRAVELER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			pstmt.setInt(2, no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				rv.setNo(rs.getString("NO"));
				rv.setStartDate(rs.getString("START_DATE"));
				rv.setEndDate(rs.getString("END_DATE"));
				rv.setHuman(rs.getString("HUMAN"));
				rv.setPlaceNo(rs.getString("PLACE_NO"));
				rv.setTravelerNo(rs.getString("TRAVELER_NO"));
			}
			
			return rv;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return rv;
	}

	public int cancelReservation(Connection conn, String placeNo, int travelerNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE RESERVATION SET CANCEL='N' WHERE PLACE_NO=? AND TRAVELER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			pstmt.setInt(2, travelerNo);
			
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
