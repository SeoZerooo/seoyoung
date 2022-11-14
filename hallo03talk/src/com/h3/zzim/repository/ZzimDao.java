package com.h3.zzim.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.h3.place.vo.PlaceVo;
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.vo.ZzimVo;

public class ZzimDao {

//	찜하기
	public int zzimAdd(Connection conn, TravelerVo tv, PlaceVo pv) {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "INSERT INTO ZZIM (NO, TRAVELER_NO, PLACE_NO) VALUES(SEQ_ZZIM_NO.NEXTVAL,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tv.getNo());
			pstmt.setString(2, pv.getNo());

			result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

//	찜 목록 가져오기
	public List<ZzimVo> getZzim(Connection conn, TravelerVo tv, List<PlaceVo> placeList) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ZzimVo> zzimList = new ArrayList<ZzimVo>();
		String sql = "SELECT PLACE_NO, TRAVELER_NO FROM ZZIM Z JOIN PLACE P ON Z.PLACE_NO = P.NO WHERE TRAVELER_NO=? AND PLACE_NO=?";

		try {
			for (int i = 0; i < placeList.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, tv.getNo());
				pstmt.setString(2, placeList.get(i).getNo());
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					ZzimVo zv = new ZzimVo();
					zv.setPlaceNo(rs.getString("PLACE_NO"));
					zv.setTravelerNo(rs.getString("TRAVELER_NO"));
					zzimList.add(zv);
				} else {
					zzimList.add(null);
				}
			}

			return zzimList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return zzimList;
	}

//	찜 삭제
	public int zzimDel(Connection conn, TravelerVo tv, PlaceVo pv) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "DELETE ZZIM WHERE TRAVELER_NO=? AND PLACE_NO=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tv.getNo());
			pstmt.setString(2, pv.getNo());

			result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

//	찜 개수 가져오기
	public int getCnt(Connection conn, String placeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "SELECT COUNT(PLACE_NO) FROM ZZIM WHERE PLACE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				result = 0;
			}
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

}
