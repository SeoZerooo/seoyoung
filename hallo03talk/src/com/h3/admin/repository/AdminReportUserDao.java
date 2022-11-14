package com.h3.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.admin.AdminPageVo;
import com.h3.common.JDBCTemplate;
import com.h3.reportBoard.vo.ReportBoardVo;
import com.h3.reportComment.vo.ReportCommentVo;
import com.h3.reportUser.vo.ReportUserVo;

public class AdminReportUserDao {

	public ArrayList<ReportUserVo> selectListUser(Connection conn, AdminPageVo pageVo) {
		String sql="SELECT * FROM (SELECT ROWNUM AS RNUM,T.* FROM (SELECT R.NO, R.GUILTY, R.CONTENT, R.PROCESS, R.REPORTED_TRAVELER_NO,R.ENROLL_DATE,T.ID AS REPORT_USER_ID FROM REPORT_USER R JOIN TRAVELER T ON R.REPORTED_TRAVELER_NO = T.NO WHERE R.PROCESS='N' ORDER BY NO DESC ) T )WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportUserVo> list = new ArrayList<ReportUserVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			int start = (pageVo.getCurrentPage()-1)* pageVo.getBoardLimit() +1;
			int end = start+pageVo.getBoardLimit() -1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String reportedTravelerNo =	rs.getString("REPORTED_TRAVELER_NO");
				String reportUserId =	rs.getString("REPORT_USER_ID");
				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				ReportUserVo vo = new ReportUserVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setReportedTravelerNo(reportedTravelerNo);
				vo.setReportUserId(reportUserId);
				vo.setEnrollDate(enrollDate);
				
				
				list.add(vo);
				}
				
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		return list;
	}
	
	public ArrayList<ReportCommentVo> selectListComment(Connection conn, AdminPageVo pageVo) {
		String sql="SELECT * FROM (SELECT ROWNUM AS RNUM,T.* FROM (SELECT NO, GUILTY, CONTENT, PROCESS, TYPE, REPLY_NO, ENROLL_DATE FROM REPORT_REPLY WHERE PROCESS='N' ORDER BY NO DESC ) T )WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportCommentVo> list = new ArrayList<ReportCommentVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			int start = (pageVo.getCurrentPage()-1)* pageVo.getBoardLimit() +1;
			int end = start+pageVo.getBoardLimit() -1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String type =	rs.getString("TYPE");
				String replyNo  =	rs.getString("REPLY_NO");
				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				ReportCommentVo vo = new ReportCommentVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setType(type);
				vo.setReplyNo(replyNo);
				vo.setEnrollDate(enrollDate);
				
				
				list.add(vo);
				}
				
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		return list;
	}
	
	



	public ArrayList<ReportBoardVo> selectListBoard(Connection conn, AdminPageVo pageVo) {
		String sql="SELECT * FROM (SELECT ROWNUM AS RNUM,T.* FROM (SELECT NO, GUILTY, CONTENT, PROCESS, TYPE, BOARD_NO,ENROLL_DATE FROM REPORT_CONTENT WHERE PROCESS='N' ORDER BY NO DESC ) T )WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportBoardVo> list = new ArrayList<ReportBoardVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			int start = (pageVo.getCurrentPage()-1)* pageVo.getBoardLimit() +1;
			int end = start+pageVo.getBoardLimit() -1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String type =	rs.getString("TYPE");
				String boardNo =	rs.getString("BOARD_NO");
				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				ReportBoardVo vo = new ReportBoardVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setType(type);
				vo.setBoardNo(boardNo);
				vo.setEnrollDate(enrollDate);
				
				
				list.add(vo);
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rs);
			}
			
			
			return list;
		}
	
	
	public int deleteUser(Connection conn, int[] dNum) {
		String sql = "UPDATE REPORT_USER SET PROCESS = 'Y' WHERE NO= ?";
			   
				
				PreparedStatement pstmt = null;
				int result = 0;
				
				try {
					
					pstmt = conn.prepareStatement(sql);
					for(int i=0; i<dNum.length; i ++) {
						pstmt.setInt(1, dNum[i]);
						result += pstmt.executeUpdate();
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				return result;

			}
	

	public int deleteContent(Connection conn, int[] dNum) {
		String sql = "UPDATE REPORT_CONTENT SET PROCESS = 'Y' WHERE NO= ?";
		   
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dNum.length; i ++) {
				pstmt.setInt(1, dNum[i]);
				result += pstmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public int deleteReply(Connection conn, int[] dNum) {
String sql = "UPDATE REPORT_REPLY SET PROCESS = 'Y' WHERE NO= ?";
		   
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dNum.length; i ++) {
				pstmt.setInt(1, dNum[i]);
				result += pstmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteContentReal(Connection conn, int[] dNum) {
String sql = "UPDATE COMMUNITY SET STATUS = 'N' WHERE CATEGORY_NO =(SELECT TYPE FROM REPORT_CONTENT WHERE NO =? ) AND NO = (SELECT BOARD_NO FROM REPORT_CONTENT WHERE NO = ?)";
		   
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dNum.length; i ++) {
				pstmt.setInt(1, dNum[i]);
				pstmt.setInt(2, dNum[i]);
				result += pstmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReplyReal(Connection conn, int[] dNum) {
		
		String sql = "DELETE REPLY WHERE COMMUNITY_NO =(SELECT TYPE FROM REPORT_REPLY WHERE NO = ?) AND NO = (SELECT REPLY_NO FROM REPORT_REPLY WHERE NO = ?)";
		   
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dNum.length; i ++) {
				pstmt.setInt(1, dNum[i]);
				pstmt.setInt(2, dNum[i]);
				result += pstmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ReportBoardVo selectBoard(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ReportBoardVo vo = null;
		String sql="SELECT NO, GUILTY, CONTENT, PROCESS, TYPE, BOARD_NO,ENROLL_DATE FROM REPORT_CONTENT WHERE PROCESS='N' AND NO = ? ORDER BY NO DESC";
		try {
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  num);
		
		rs =pstmt.executeQuery();
		if(rs.next()) {
			String no =	rs.getString("NO");
			String guilty =	rs.getString("GUILTY");
			String content =	rs.getString("CONTENT");
			String process =	rs.getString("PROCESS");
			String type =	rs.getString("TYPE");
			String boardNo =	rs.getString("BOARD_NO");
			Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
			
			vo = new ReportBoardVo();
			vo.setNo(no);
			vo.setGuilty(guilty);
			vo.setContent(content);
			vo.setProcess(process);
			vo.setType(type);
			vo.setBoardNo(boardNo);
			vo.setEnrollDate(enrollDate);
			
			
			
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}

	public ReportCommentVo selectReply(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ReportCommentVo vo = null;
		String sql="SELECT NO, GUILTY, CONTENT, PROCESS, TYPE, REPLY_NO,ENROLL_DATE FROM REPORT_REPLY WHERE PROCESS='N' AND NO = ? ORDER BY NO DESC";
		try {
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  num);
		
		rs =pstmt.executeQuery();
		if(rs.next()) {
			String no =	rs.getString("NO");
			String guilty =	rs.getString("GUILTY");
			String content =	rs.getString("CONTENT");
			String process =	rs.getString("PROCESS");
			String type =	rs.getString("TYPE");
			String replyNo =	rs.getString("REPLY_NO");
			Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
			
			vo = new ReportCommentVo();
			vo.setNo(no);
			vo.setGuilty(guilty);
			vo.setContent(content);
			vo.setProcess(process);
			vo.setType(type);
			vo.setReplyNo(replyNo);
			vo.setEnrollDate(enrollDate);
			
			
			
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}

	public ReportUserVo selectUser(Connection conn, String num) {
		String sql="SELECT R.NO, R.GUILTY, R.CONTENT, R.PROCESS, R.REPORTED_TRAVELER_NO,R.ENROLL_DATE,T.ID AS REPORT_USER_ID FROM REPORT_USER R JOIN TRAVELER T ON R.REPORTED_TRAVELER_NO = T.NO WHERE R.PROCESS='N' ORDER BY NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ReportUserVo vo = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String reportedTravelerNo =	rs.getString("REPORTED_TRAVELER_NO");
				String reportUserId =	rs.getString("REPORT_USER_ID");
				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				vo = new ReportUserVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setReportedTravelerNo(reportedTravelerNo);
				vo.setReportUserId(reportUserId);
				vo.setEnrollDate(enrollDate);
				
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}

	public static int getCount(Connection conn) {
		// TODO Auto-generated method stub
				//Connection 준비
				
				//SQL 준비
				String sql = "SELECT COUNT(NO) AS COUNT FROM REPORT_USER WHERE PROCESS = 'N'";
				PreparedStatement pstmt  =null;
				ResultSet rs = null;
				int count = 0;
				
				try {
					pstmt = conn.prepareStatement(sql);
					//SQL 을 객체에 담기 및 SQL 완성
					
					//SQL 실행 및 결과 저장
					rs = pstmt.executeQuery();
					//실행결과 - > 자바 데이터
					if(rs.next()) {
						count = rs.getInt("COUNT");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
					JDBCTemplate.close(rs);
					
				}
				
			
				

				//실행결과 리턴
				return count;
				
	}

	public static int getCountBoard(Connection conn) {
		// TODO Auto-generated method stub
		//Connection 준비
		
		//SQL 준비
		String sql = "SELECT COUNT(NO) AS COUNT FROM REPORT_CONTENT WHERE PROCESS = 'N'";
		PreparedStatement pstmt  =null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//SQL 을 객체에 담기 및 SQL 완성
			
			//SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();
			//실행결과 - > 자바 데이터
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
		}
		
	
		

		//실행결과 리턴
		return count;
	}

	public static int getCountReply(Connection conn) {

		//SQL 준비
		String sql = "SELECT COUNT(NO) AS COUNT FROM REPORT_REPLY";
		PreparedStatement pstmt  =null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//SQL 을 객체에 담기 및 SQL 완성
			
			//SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();
			//실행결과 - > 자바 데이터
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
		}
		
	
		

		//실행결과 리턴
		return count;
	}

	public static int getCountPlace(Connection conn) {
		//SQL 준비
				String sql = "SELECT COUNT(NO) AS COUNT FROM PLACE";
				PreparedStatement pstmt  =null;
				ResultSet rs = null;
				int count = 0;
				
				try {
					pstmt = conn.prepareStatement(sql);
					//SQL 을 객체에 담기 및 SQL 완성
					
					//SQL 실행 및 결과 저장
					rs = pstmt.executeQuery();
					//실행결과 - > 자바 데이터
					if(rs.next()) {
						count = rs.getInt("COUNT");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
					JDBCTemplate.close(rs);
					
				}
				
			
				

				//실행결과 리턴
				return count;
	}
		
	}
	
	



	




