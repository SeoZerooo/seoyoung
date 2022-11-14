package com.h3.reservation.service;


import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;

import com.h3.reservation.repository.ReservationDao;
import com.h3.reservation.vo.ReservationVo;

public class ReservationService {
	
	private ReservationDao dao = new ReservationDao();
	
	public int addReservation(ReservationVo rv) {
		
		Connection conn = null;
		
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.addReservation(conn,rv);
			
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

	public ReservationVo checkReservation(String placeNo, int no) {
		
		Connection conn = null;
		ReservationVo rv = new ReservationVo();
		
		try {
			conn = getConnection();
			
			rv = dao.checkReservation(conn, placeNo, no);
			
			return rv;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		
		return rv;
	}

	public int cancelReservation(String placeNo, int travelerNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.cancelReservation(conn, placeNo, travelerNo);
			
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
