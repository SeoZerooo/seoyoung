package com.h3.community.service;

import java.sql.Connection;

import com.h3.community.dao.CommReplyDao;
import com.h3.community.vo.CommReplyVo;

import static com.h3.common.JDBCTemplate.*;

public class CommReplyService {

	public int delete(String commNo, String replyNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			result = new CommReplyDao().delete(conn,commNo, replyNo);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

	public int post(CommReplyVo vo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			result = new CommReplyDao().post(conn, vo);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

}
