package com.h3.party.service;
import java.sql.Connection;
import java.util.ArrayList;


import static com.h3.common.JDBCTemplate.*;
import com.h3.party.repository.PartyDao;
import com.h3.party.vo.PartyVo;

import oracle.net.aso.c;


public class PartyService {
	
	private PartyDao dao = new PartyDao();
	
		

		public ArrayList<PartyVo> getlist() {
			Connection conn = null;
			ArrayList<PartyVo> list = null;
			
			try {
				conn = getConnection();
				list = dao.getlist(conn);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn);
			}
			return list;
		}



		public int writeParty(PartyVo vo) {
			
			Connection conn = null;
			
			int result = 0;
			
			try {
				conn = getConnection();
				result = dao.writeParty(conn,vo);
				
				if(result==1) {
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



		public PartyVo detailParty(String num) {
			
			Connection conn = null;
			PartyVo pv = new PartyVo();
			
			try {
				conn =getConnection();
				
				dao.plusCnt(conn,num);
				pv = dao.detailParty(conn,num);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn);
			}
			
			return pv;
		}



		public int editParty(PartyVo pv) {
			
			Connection conn = null;
			int result = 0;
			
			try {
				conn = getConnection();
				
				result = dao.editParty(conn,pv);
				
				if(result == 1) {
					commit(conn);
				} else {
					rollback(conn);
				}
				
			} catch (Exception e) {
				rollback(conn);
				e.printStackTrace();
			} finally {
				close(conn);
			}
			
			return result;
		}



		public int delete(String num) {
			
			Connection conn = null;
			int result = 0;
			
			try {
				conn = getConnection();
				
				result = dao.delete(conn,num);
				
				if(result == 1) {
					commit(conn);
				} else {
					rollback(conn);
				}
				
			} catch (Exception e) {
				rollback(conn);
				e.printStackTrace();
			} finally {
				close(conn);
			}
			
			return result;
		}

		
	}

	

