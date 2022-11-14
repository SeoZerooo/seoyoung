package com.h3.searchDetail.service;

import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.community.vo.CommVo;
import com.h3.place.vo.PlaceVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.searchDetail.repository.SearchDao;

public class SearchService {
	

	//장소
	public ArrayList<PlaceVo> pselectList(String placeKeyword, String cate1, String cate2, String cate3){
		
		Connection conn = null;
		ArrayList<PlaceVo> pvoList = null;
		
		try {
			conn = getConnection();
			
			pvoList = new SearchDao().pselectList(conn, placeKeyword, cate1, cate2, cate3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return pvoList;
	}
	
	//커뮤니티
	public ArrayList<CommVo> cselectList(String placeKeyword, String cate1, String cate2, String cate3){
		
		Connection conn = null;
		ArrayList<CommVo> cvoList = null;
		
		try {
			conn = getConnection();
			
			cvoList = new SearchDao().cselectList(conn, placeKeyword, cate1, cate2, cate3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return cvoList;
	}

	


}
