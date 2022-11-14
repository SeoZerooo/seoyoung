package com.h3.with.service;

import java.sql.Connection;

import static com.h3.common.JDBCTemplate.*;

import com.h3.with.dao.WithPostDao;
import com.h3.with.vo.WithVo;

public class WithPostService {

	public int post(WithVo vo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			result = new WithPostDao().post(conn, vo);
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		}
		
		return result;
	}

}
