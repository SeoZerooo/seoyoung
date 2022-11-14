package com.h3.zzim.service;

import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.h3.place.vo.PlaceVo;
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.repository.ZzimDao;
import com.h3.zzim.vo.ZzimVo;

public class ZzimService {
	
	private ZzimDao dao = new ZzimDao();
	
	public int zzimAdd(TravelerVo tv, PlaceVo pv) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.zzimAdd(conn, tv, pv);
			
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

	public List<ZzimVo> getZzim(TravelerVo tv, List<PlaceVo> placeList) {
		
		Connection conn = null;
		List<ZzimVo> zzimList = new ArrayList<ZzimVo>();
		
		try {
			conn = getConnection();
			zzimList = dao.getZzim(conn,tv, placeList);
			return zzimList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return zzimList;
	}

	public int zzimDel(TravelerVo tv, PlaceVo pv) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.zzimDel(conn, tv, pv);
			
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

	public int getCnt(String placeNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.getCnt(conn,placeNo);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

}
