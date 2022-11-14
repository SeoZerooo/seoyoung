package com.h3.searchDetail.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class WithSearchDao {
	
	//동행 검색
	public ArrayList<WithVo> wselectList(Connection conn, String widthKeyword, String cate4, String cate5, String startDate, String endDate){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WithVo> wlist = new ArrayList<WithVo>();
		String sql = "SELECT NO, TITLE, CONTENT, START_DATE, END_DATE FROM WITH_ WHERE (TITLE LIKE '%' || ? ||'%'  OR CONTENT LIKE '%' || ? ||'%') AND (START_DATE LIKE '%' || ? ||'%' OR END_DATE LIKE '%' || ? ||'%') AND (PLACE LIKE '%' || ? ||'%' OR PLACE LIKE '%' || ? ||'%')";

		try {
			
			String sd = startDate.replace("-", "/").substring(2);
			String ed = endDate.replace("-", "/").substring(2);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, widthKeyword);
			pstmt.setString(2, widthKeyword);
			pstmt.setString(3, sd);
			pstmt.setString(4, ed);
			pstmt.setString(5, cate4);
			pstmt.setString(6, cate5);

			System.out.println(widthKeyword);
			System.out.println(sd);
			System.out.println(ed);
			System.out.println(cate4);
			System.out.println(cate5);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("test");
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date DbStartDate = rs.getDate("START_DATE");
				Date DbEndDate = rs.getDate("END_DATE");
				
				WithVo wvo = new WithVo();
				wvo.setNo(no);
				wvo.setTitle(title);
				wvo.setContent(content);
				wvo.setStart_date(DbStartDate);
				wvo.setEnd_date(DbEndDate);
				

				wlist.add(wvo);
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return wlist;
		
	}

}
