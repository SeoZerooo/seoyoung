package com.h3.admin.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.admin.AdminPageVo;
import com.h3.admin.repository.AdminPlaceDao;
import com.h3.common.JDBCTemplate;
import com.h3.place.vo.PlaceVo;

public class AdminPlaceService {

	public ArrayList<PlaceVo> selectListPlace(AdminPageVo pageVo) {
		Connection conn = null;
		ArrayList<PlaceVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminPlaceDao().selectListPlace(conn, pageVo);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

	public int deletePlace(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminPlaceDao().deletePlace(conn,dNum);
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

}
