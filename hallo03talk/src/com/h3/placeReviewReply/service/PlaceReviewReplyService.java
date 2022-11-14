package com.h3.placeReviewReply.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.commit;
import static com.h3.common.JDBCTemplate.getConnection;
import static com.h3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.placeReviewPhoto.vo.PlaceReviewPhotoVo;
import com.h3.placeReviewReply.dao.PlaceReviewReplyDao;
import com.h3.placeReviewReply.vo.PlaceReviewReplyVo;

public class PlaceReviewReplyService {
	
	private PlaceReviewReplyDao dao = new PlaceReviewReplyDao();
	
	public int addReply(PlaceReviewReplyVo prrv) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.addReply(conn,prrv);
			
			if (result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			return result;
			
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	public List<PlaceReviewReplyVo> getReview(List<PlaceReviewVo> prvList) {
		
		Connection conn = null;
		List<PlaceReviewReplyVo> prrvList = new ArrayList<PlaceReviewReplyVo>();
		
		try {
			conn = getConnection();
			
			prrvList = dao.getReview(conn , prvList);
			
			return prrvList;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		
		return prrvList;
	}

	public int replyDel(String replyNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = dao.replyDel(conn,replyNo);
			
			if(result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			return result;
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
		
	}

}
