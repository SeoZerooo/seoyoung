package com.h3.party.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.party.vo.PartyVo;

import static com.h3.common.JDBCTemplate.*;


public class PartyDao {

	public ArrayList<PartyVo> getlist(Connection conn) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs= null;
		
		ArrayList<PartyVo> list = new ArrayList<PartyVo>();
		
		String sql = "SELECT P.NO, P.TITLE, P.CONTENT, P.CNT, P.ENROLL_DATE, PC.NAME CATEGORY_NAME, B.ID BOSS_ID FROM PARTY P JOIN PARTY_CATEGORY PC ON P.PARTY_CATEGORY = PC.NO JOIN BOSS B ON B.NO = P.BOSS_NO WHERE P.STATUS = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PartyVo vo = new PartyVo();
				vo.setNo(rs.getInt("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setCnt(rs.getInt("CNT"));
				vo.setEnrollDate(rs.getTimestamp("ENROLL_DATE"));
				vo.setCategoryName(rs.getString("CATEGORY_NAME"));
				vo.setBossId(rs.getString("BOSS_ID"));
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}//class

	public int writeParty(Connection conn, PartyVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "insert into party(no,title,content,party_category,boss_no) values(SEQ_PARTY_NO.NEXTVAL,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getCategoryName());
			pstmt.setInt(4, vo.getBossNo());
			
			result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public PartyVo detailParty(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PartyVo pv = new PartyVo();
		
		String sql = "SELECT p.no,p.title,p.content,P.CNT, P.ENROLL_DATE, p.party_category,B.ID BID FROM PARTY P JOIN BOSS B ON B.NO = P.BOSS_NO WHERE P.NO=? AND P.STATUS='Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pv.setNo(rs.getInt("NO"));
				pv.setTitle(rs.getString("TITLE"));
				pv.setContent(rs.getString("CONTENT"));
				pv.setCnt(rs.getInt("CNT"));
				pv.setEnrollDate(rs.getTimestamp("ENROLL_DATE"));
				pv.setCategoryName(rs.getString("PARTY_CATEGORY"));
				pv.setBossId(rs.getString("BID"));
			}
			
			return pv;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return pv;
	}

	public void plusCnt(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE PARTY SET CNT = CNT+1 WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
	}

	public int editParty(Connection conn, PartyVo pv) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE PARTY SET TITLE=? , CONTENT=?, PARTY_CATEGORY=? WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pv.getTitle());
			pstmt.setString(2, pv.getContent());
			pstmt.setString(3, pv.getCategoryName());
			pstmt.setInt(4, pv.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int delete(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE PARTY SET STATUS='N' WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
}	