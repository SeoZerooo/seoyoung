package com.h3.community.service;

import java.sql.Connection;

import static com.h3.common.JDBCTemplate.*;

import com.h3.community.dao.CommNoticePostDao;
import com.h3.community.vo.CommVo;

public class CommNoticePostService {

	public int post(CommVo vo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			result = new CommNoticePostDao().post(conn, vo);
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
