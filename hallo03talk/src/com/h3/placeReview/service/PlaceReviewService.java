package com.h3.placeReview.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.commit;
import static com.h3.common.JDBCTemplate.getConnection;
import static com.h3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.h3.placeReview.repository.PlaceReviewDao;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.placeReviewPhoto.vo.PlaceReviewPhotoVo;

public class PlaceReviewService {
	
	private PlaceReviewDao dao = new PlaceReviewDao();
	
	public int addReview(PlaceReviewVo prv, PlaceReviewPhotoVo prpv) {
		
		Connection conn = null;
		int result = 0;
		int result2 = 0;
		try {
			conn = getConnection();
			result = dao.addReview(conn, prv);
			
			if (result == 1) {
				result2 = dao.addReviewPhoto(conn, prpv);
			} else {
				rollback(conn);
			}
			
			if (result * result2 == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			return result*result2;
			
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		
		return result*result2;
	}

	public List<PlaceReviewVo> getReview(String placeNo) {
		
		Connection conn = null;
		List<PlaceReviewVo> prvList = new ArrayList<PlaceReviewVo>();
		
		try {
			conn = getConnection();
			
			prvList = dao.getReview(conn,placeNo);
			
			return prvList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return prvList;
	}

	public List<PlaceReviewPhotoVo> getPhoto(List<PlaceReviewVo> prvList) {
		Connection conn = null;
		List<PlaceReviewPhotoVo>prpvList = new ArrayList<PlaceReviewPhotoVo>();
		
		try {
			conn = getConnection();
			
			prpvList = dao.getPhoto(conn,prvList);
			
			return prpvList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return prpvList;
	}

	public int delReview(String placeNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result =dao.delReview(conn,placeNo);
			
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

	public int delOneReview(PlaceReviewVo prv) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = dao.delOneReview(conn, prv);
			
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

}
