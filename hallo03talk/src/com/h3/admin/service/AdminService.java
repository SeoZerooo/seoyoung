package com.h3.admin.service;

import java.sql.Connection;

import com.h3.admin.repository.AdminDao;
import com.h3.admin.vo.AdminVo;
import com.h3.common.JDBCTemplate;

public class AdminService {

	public AdminVo login(AdminVo vo) {
		//SQL 실행을 위해서 Connection 준비
				Connection conn = null;
				AdminVo loginAdmin = null;
				try {
					conn = JDBCTemplate.getConnection();
					
					//SQL 실행결과 리턴
					loginAdmin = new AdminDao().login(conn, vo);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return loginAdmin;
	}

}
