package com.h3.searchDetail.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.searchDetail.repository.WithSearchDao;
import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class SearchWidthService {



		//장소
		public ArrayList<WithVo> wselectList(String widthKeyword, String cate4, String cate5, String startDate, String endDate){
			
			Connection conn = null;
			ArrayList<WithVo> wvoList = null;
			
			try {
				conn = getConnection();
				
				wvoList = new WithSearchDao().wselectList(conn, widthKeyword, cate4, cate5, startDate, endDate);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
			
			return wvoList;
		}

}
