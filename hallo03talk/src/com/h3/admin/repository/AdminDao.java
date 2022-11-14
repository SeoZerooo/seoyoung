package com.h3.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.h3.admin.vo.AdminVo;
import com.h3.common.JDBCTemplate;

public class AdminDao {

	public AdminVo login(Connection conn, AdminVo vo) {
		AdminVo loginAdmin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//SQL 준비
		String sql = "SELECT * FROM ADMIN WHERE ID = ? AND PWD = ?";
		
		try {
			//SQL 객체에 담고, 물음표 채우기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();
			
			//rs 에서 데이터 꺼내서 객체로 만들기
			if(rs.next()) {
			
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				
				
				loginAdmin = new AdminVo();
				
				loginAdmin.setId(id);
				loginAdmin.setName(name);
				
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		finally {
			//자원 반납
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		//만들어진 객체 리턴
		return loginAdmin;

}
}
