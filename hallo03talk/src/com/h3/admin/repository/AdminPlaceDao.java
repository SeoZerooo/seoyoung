package com.h3.admin.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.h3.admin.AdminPageVo;
import com.h3.common.JDBCTemplate;
import com.h3.place.vo.PlaceVo;

public class AdminPlaceDao {

	public ArrayList<PlaceVo> selectListPlace(Connection conn, AdminPageVo pageVo) {
		

		PreparedStatement pstmt = null;
		ArrayList<PlaceVo> voList = new ArrayList<PlaceVo>();
		ResultSet rs = null;

		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM,T.* FROM (SELECT P.NO, P.NAME,  P.ADDRESS ,PP.NAME AS PNAME FROM PLACE P JOIN PLACE_PHOTO PP ON PP.PLACE_NO= P.NO WHERE P.STATUS='Y' AND PP.PHOTO_PROFILE = 'Y' ) T )WHERE RNUM BETWEEN ? AND ?";
		int tno = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)* pageVo.getBoardLimit() +1;
			int end = start+pageVo.getBoardLimit() -1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			

			while (rs.next()) {
				PlaceVo pv = new PlaceVo();
				pv.setNo(rs.getString("NO"));
				pv.setName(rs.getString("NAME"));
				pv.setAddress(rs.getString("ADDRESS"));
				pv.setPhotoName(rs.getString("PNAME"));
				
				

				voList.add(pv);
			}
			return voList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return voList;
		
		
		
		
//		String sql="SELECT P.NO, P.NAME, P.CONTENT, P.ADDRESS, P.BOSS_NO, P.CATEGORY_NO, P.STATUS, P.ENROLL_DATE, P.CNT ,PP.PATH AS PHOTO FROM PLACE P JOIN PLACE_PHOTO PP ON P.NO = PP.PLACE_NO WHERE P.CATEGORY_NO = 1";
//		conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<PlaceVo> list = new ArrayList<PlaceVo>();
//		
//		try {
//			conn=JDBCTemplate.getConnection();
//			pstmt=conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				
//				String no = rs.getString("NO");
//				String name = rs.getString("NAME");
//				String content = rs.getString("CONTENT");
//				String address = rs.getString("ADDRESS");
//				String bossNo = rs.getString("BOSS_NO");
//				String categoryNo = rs.getString("CATEGORY_NO");
//				String status = 	rs.getString("STATUS");
//			    String enrollDate = rs.getString("ENROLL_DATE");
//				int cnt = rs.getInt("CNT");
//			//	int zzim = rs.getInt("ZZIM");
//				String photoName = rs.getString("PHOTO");
//				
//			 	PlaceVo vo = new PlaceVo();
//			 	vo.setNo(no);
//			 	vo.setName(name);
//			 	vo.setContent(content);
//			 	vo.setAddress(address);
//			 	vo.setBossNo(bossNo);
//			 	vo.setCategoryNo(categoryNo);
//			 	vo.setStatus(status);
//			 	vo.setEnrollDate(enrollDate);
//			 	vo.setCnt(cnt);
//			 	vo.setPhotoName(photoName);
//			 	
//			 	list.add(vo);
//				
//			}
//			
//			
//			
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(rs);
//		}
//		//겨과 리턴
//		return list;
//		
	
	
	}

	public int deletePlace(Connection conn, int[] dNum) {
		String sql = "UPDATE PLACE SET STATUS = 'N' WHERE NO= ?";
		   
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dNum.length; i ++) {
				pstmt.setInt(1, dNum[i]);
				result += pstmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
