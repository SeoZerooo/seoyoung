package com.h3.admin.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.admin.AdminPageVo;
import com.h3.admin.repository.AdminReportUserDao;
import com.h3.common.JDBCTemplate;
import com.h3.community.dao.CommDao;
import com.h3.community.dao.CommReplyDao;
import com.h3.reportBoard.vo.ReportBoardVo;
import com.h3.reportComment.vo.ReportCommentVo;
import com.h3.reportUser.vo.ReportUserVo;

public class AdminReportService {

	public ArrayList<ReportUserVo> selectListUser(AdminPageVo pageVo) {
		Connection conn = null;
		ArrayList<ReportUserVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectListUser(conn, pageVo);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

	

	public ArrayList<ReportCommentVo> selectListComment(AdminPageVo pageVo) {
		Connection conn = null;
		ArrayList<ReportCommentVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectListComment(conn, pageVo);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

	public ArrayList<ReportBoardVo> selectListBoard(AdminPageVo pageVo) {
		Connection conn = null;
		ArrayList<ReportBoardVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectListBoard(conn, pageVo);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}
	
	
	public int deleteUser(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteUser(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}

	public int deleteContent(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteContent(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public int deleteReply(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteReply(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public int deleteContentReal(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			
			for(int i:dNum ) {
				ReportBoardVo vo = new AdminReportUserDao().selectBoard(conn, Integer.toString(i));
				new CommDao().delete(conn, vo.getBoardNo());
			}
			
			JDBCTemplate.commit(conn);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public int deleteReplyReal(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			for(int i : dNum) {
				ReportCommentVo vo = new AdminReportUserDao().selectReply(conn, Integer.toString(i));
				int result1 = new CommReplyDao().delete(conn, vo.getReplyNo());
				System.out.println(i);
			}
			
				JDBCTemplate.commit(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public ReportBoardVo selectBoard(String num) {
		// TODO Auto-generated method stub
				ReportBoardVo vo = null;
				Connection conn = null;
				try {
					conn = JDBCTemplate.getConnection();
					vo =	new AdminReportUserDao().selectBoard(conn, num);
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					close(conn);
				}
				return vo;
	}



	public ReportCommentVo selectReply(String num) {
		// TODO Auto-generated method stub
		ReportCommentVo vo = null;
		Connection conn = null;
		try {
			conn = JDBCTemplate.getConnection();
			vo =	new AdminReportUserDao().selectReply(conn, num);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return vo;
	}



	public ReportUserVo selectUser(String num) {
		// TODO Auto-generated method stub
		ReportUserVo vo = null;
		Connection conn = null;
		try {
			conn = JDBCTemplate.getConnection();
			vo =	new AdminReportUserDao().selectUser(conn, num);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return vo;
	}



	public int getCount() {
	//데이터 검사
		
		//dao 호출
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
		
	    result = AdminReportUserDao.getCount(conn);
	
	    return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
			
		}
		return result;
	}



	public int getCountBoard() {
		//dao 호출
				Connection conn = null;
				int result = 0;
				
				try {
					conn = getConnection();
				
			    result = AdminReportUserDao.getCountBoard(conn);
			
			    return result;
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					close(conn);
					
				}
				return result;
	}



	public int getCountReply() {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
		
	    result = AdminReportUserDao.getCountReply(conn);
	
	    return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
			
		}
		return result;
	}



	public int getCountPlace() {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
		
	    result = AdminReportUserDao.getCountPlace(conn);
	
	    return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
			
		}
		return result;
	}

}
