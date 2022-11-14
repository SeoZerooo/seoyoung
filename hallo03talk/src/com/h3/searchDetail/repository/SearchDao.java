package com.h3.searchDetail.repository;

import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.community.vo.CommVo;
import com.h3.place.vo.PlaceVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class SearchDao {
	
	//장소 검색
	public ArrayList<PlaceVo> pselectList(Connection conn, String placeKeyword, String cate1, String cate2, String cate3){
		
		String sql = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS, B.NAME, C.NAME AS PNAME FROM PLACE A JOIN PLACE_CATEGORY B ON A.CATEGORY_NO = B.NO JOIN PLACE_PHOTO C ON C.PLACE_NO = A.NO WHERE ( A.NAME LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%') AND C.PHOTO_PROFILE = 'Y' AND A.STATUS = 'Y' AND A.ADDRESS LIKE '%' || ? ||'%' AND B.NAME = ? ";
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		
		ArrayList<PlaceVo> plist = new ArrayList<PlaceVo>();
		
		try {
			
			//main.jsp에서 받아온 cate1, cate2, cate3 값은 어떻게 처리...??
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeKeyword);
			pstmt.setString(2, placeKeyword);
			pstmt.setString(3, cate3); 
			pstmt.setString(4, cate1);
			
			System.out.println(placeKeyword);
			System.out.println(cate3);
			System.out.println(cate1);

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				String address = rs.getString("ADDRESS");
				String pName = rs.getString("PNAME");
				
				PlaceVo pvo = new PlaceVo();
				pvo.setNo(no);
				pvo.setName(name);
				pvo.setContent(content);
				pvo.setAddress(address);
				pvo.setPhotoName(pName);
				
				plist.add(pvo);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return plist;
		
	}//plist

	//커뮤니티 검색
	public ArrayList<CommVo> cselectList(Connection conn, String placeKeyword, String cate1, String cate2, String cate3){
		
		String sql = "SELECT A.NO, A.TITLE, A.ENROLL_DATE, B.NICK AS WRITER FROM COMMUNITY A JOIN TRAVELER B ON A.WRITER = B.NO WHERE (A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%') AND A.STATUS = 'Y' ";

		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommVo> clist = new ArrayList<CommVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeKeyword);
			pstmt.setString(2, placeKeyword);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				String writer = rs.getString("WRITER");
				
				CommVo cvo = new CommVo();
				cvo.setNo(no);
				cvo.setTitle(title);
				cvo.setEnroll_date(enrollDate);
				cvo.setWriter(writer);
				
				clist.add(cvo);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return clist;
		
	}//clist
	
}



