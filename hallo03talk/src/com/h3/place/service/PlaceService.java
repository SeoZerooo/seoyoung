package com.h3.place.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.commit;
import static com.h3.common.JDBCTemplate.getConnection;
import static com.h3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.h3.place.repository.PlaceDao;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

public class PlaceService {

	private PlaceDao dao = new PlaceDao();

	public int placeAdd(PlaceVo placeVo, ArrayList<PlacePhotoVo> photoVoList) {

		Connection conn = null;
		int result = 0;
		int result2 = 0;

		try {
			conn = getConnection();

			result = dao.placeAdd(conn, placeVo);

			if (result == 1) {
				result2 = dao.placePhotoAdd(conn, photoVoList);
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

		return result * result2;
	}

	public List<PlaceVo> getList() {

		Connection conn = null;
		List<PlaceVo> voList = null;

		try {
			conn = getConnection();
			voList = dao.getList(conn);
			return voList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return voList;
	}
	
	public PlaceVo placeOne(String placeNo) {
		Connection conn = null;
		PlaceVo pv = new PlaceVo();
		
		try {
			conn = getConnection();
			pv = dao.placeOne(conn,placeNo);
			
			return pv;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return pv;
	}

	public ArrayList<PlacePhotoVo> photoOne(String placeNo) {
		Connection conn = null;
		ArrayList<PlacePhotoVo> photoList = new ArrayList<PlacePhotoVo>();
		
		try {
			conn = getConnection();
			photoList = dao.photoOne(conn,placeNo);
			
			return photoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return photoList;
	}

	public int getCnt(String placeNo) {
		
		Connection conn = null;
		int cnt = 0;
		int result = 0;
		try {
			conn = getConnection();
			cnt = dao.getCnt(conn, placeNo);
			cnt += 1;
			PlaceVo pv = new PlaceVo();
			pv.setNo(placeNo);
			pv.setCnt(cnt);
			result = dao.plusCnt(conn,pv);
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

	public int placeUpdate(PlaceVo placeVo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = dao.placeUpdate(conn, placeVo);
			
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

	public int placeDel(String placeNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = dao.placeDel(conn,placeNo);
			dao.placePhotodel(conn, placeNo);
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

	public List<PlaceVo> getList(int categoryNo, int cityNo, int insideNo ) {
		Connection conn = null;
		List<PlaceVo> voList = null;
		
		try {
			conn = getConnection();
			String cityName = "";
			String insideName = "";
			if( cityNo == 1 ) {
				cityName = "제주시";
				if(insideNo == 1) {
					insideName = "시내";
				} else if(insideNo == 2) {
					insideName = "애월";
				} else if(insideNo == 3) {
					insideName = "한림";
				} else if(insideNo == 4) {
					insideName = "한경";
				} else if(insideNo == 5) {
					insideName = "조천";
				} else if(insideNo == 6) {
					insideName = "구좌";
				} else {
					insideName = "모두";
				}
				
			} else if ( cityNo == 2 ) {
				cityName = "서귀포";
				if(insideNo == 1) {
					insideName = "시내";
				} else if(insideNo == 2) {
					insideName = "남원";
				} else if(insideNo == 3) {
					insideName = "안덕";
				} else if(insideNo == 4) {
					insideName = "대정";
				} else if(insideNo == 5) {
					insideName = "표선";
				} else if(insideNo == 6) {
					insideName = "성산";
				} else {
					insideName = "모두";
				}
			}
//			카테고리 모두
			if(categoryNo == 0) {voList = dao.getList(conn,cityName,insideName);}
//			도시 모두
			else if(cityNo == 0) {voList = dao.getList(conn, categoryNo);}
//			읍 모두
			else if(insideNo == 0) {voList = dao.getList(conn,cityName, categoryNo);}
//			전부 보기
			else if (categoryNo == 0 && cityNo == 0 && insideNo == 0){ voList = dao.getList(conn); }
//			다 다른경우
			else { voList = dao.getList(conn,cityName,insideName, categoryNo); };
			
			return voList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return voList;
	}

	public int getStars(String placeNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn =getConnection();
			
			result= dao.getStars(conn,placeNo);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
		return result;
	}


}
