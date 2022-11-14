package com.h3.traveler.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.commit;
import static com.h3.common.JDBCTemplate.getConnection;
import static com.h3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

import com.h3.community.vo.CommReplyVo;
import com.h3.reportUser.vo.ReportUserVo;
import com.h3.traveler.repository.TravelerDao;
import com.h3.traveler.vo.MpgPostVo;
import com.h3.traveler.vo.MpgReservationVo;
import com.h3.traveler.vo.MpgZzimVo;
import com.h3.traveler.vo.TravelerAttachmentVo;
import com.h3.traveler.vo.TravelerVo;

public class TravelerService {

	private final TravelerDao dao = new TravelerDao();

	/*
	 * 회원가입
	 */
	public int join(TravelerVo vo) {
		
		// 비밀번호 일치 검사
		if(vo.getPwd().equals(vo.getPwd2()) == false) {
			return -1;
		}

		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();

			// dao 호출
			result = dao.join(vo, conn);

			//트랜잭션 처리 (commit || rollback)
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return result;
		
		
	}

	
	/*
	 * 로그인
	 */
	public TravelerVo login(TravelerVo vo) {

	
		Connection conn = null;
		TravelerVo travelerLoginMember = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			travelerLoginMember = dao.login(conn, vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		//실행결과 리턴
		return travelerLoginMember;
	
	
	}//login

	

	/*
	 *마이페이지 - 정보 변경 
	 */
	public TravelerVo edit(TravelerVo vo) {

	
		Connection conn = null;
		int result = 0;
		TravelerVo updateVo = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			result = new TravelerDao().edit(conn, vo);
			
			//트랜잭션 처리 (commit || rollback)
			if(result == 1) {
				commit(conn);
				// 다시한번 회원정보 조회 (회원번호)  // 서비스의 selectOneByNo 메소드 호출하기
				updateVo = selectOneByNo(vo.getNo());
			}else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		 //실행결과 리턴
		return updateVo;
		
	
	}


	/*
	 * 다시한번 회원 정보 조회(회원번호): 정보 변경 된 것을 조회
	 */
	public TravelerVo selectOneByNo(int no) {

		Connection conn = null;
		TravelerVo vo = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			vo = new TravelerDao().selectOneByNo(conn, no);
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		 //실행결과 리턴
		return vo;
	
	}


	/*
	 * 비밀번호 변경
	 */
	public int changePwd(String travelerJoinId, String travelerJoinPwd, String travelerJoinPwdNew,
			String travelerJoinPwdNew2) {

		// 비지니스 로직 검사
		if(travelerJoinPwdNew.equals(travelerJoinPwdNew2) == false) {
			System.out.println("신규 비밀번호가 일치하지 않습니다.");
			return -1;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try{
			conn = getConnection();
			
			// dao 호출
			result = new TravelerDao().changePwd(conn, travelerJoinId, travelerJoinPwd, travelerJoinPwdNew, travelerJoinPwdNew2);
			
			// 트랜잭션 처리
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	
	
	
	}//changePwd


	/*
	 * 회원 탈퇴
	 */
	public int quit(String travelerJoinId, String travelerJoinPwd, String travelerJoinPwd2) {
		
		if(travelerJoinPwd.equals(travelerJoinPwd2) == false) {
			System.out.println("탈퇴-비밀번호가 서로 일치하지 않음");
			return -1;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();

			// dao 호출
			result = new TravelerDao().quit(conn, travelerJoinId, travelerJoinPwd, travelerJoinPwd2);
			
			
			// 트랜잭션 처리
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
		
		
	}//hallo03talk


	
	/*
	 * traveler - 내가 쓴 글 조회
	 */
	public ArrayList<MpgPostVo> selectList(int no) {

	
		Connection conn = null;
		ArrayList<MpgPostVo> voList = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			voList = dao.selectList(conn, no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return voList;
	
	
	
	}
	
	

	/*
	 * traveler - 내가 쓴 댓글 조회 - 커뮤니티 댓글
	 */
	public ArrayList<CommReplyVo> selectReplyList(int no) {

		Connection conn = null;
		ArrayList<CommReplyVo> voList = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			voList = dao.selectReplyList(conn, no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return voList;
		
	
	}


	/*
	 * traveler - 내가 쓴 글 삭제
	 */
	public void deletePost(String no, String board) {
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			dao.deletePost(conn, no, board);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
	}


	/*
	 * traveler - 아이디 중복 체크
	 */
	public int idCheck(String userId) {
		
		int idCheck = 0;
		
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			idCheck = dao.idCheck(conn, userId);
			//System.out.println("sss : " + idCheck);//swy
			
			if(idCheck == 1) {
				System.out.println("이미 존재하는 아이디입니다.");
			}else {
				System.out.println("사용 가능한 아이디입니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return idCheck;
		
		
	}//idCheck


	
	/*
	 * traveler - 아이디 찾기
	 */
	public String idFind(String travelerJoinPhone, String travelerJoinEmail) {

		Connection conn = null;
		String idFind = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			idFind = dao.idFind(conn, travelerJoinPhone, travelerJoinEmail);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(conn);
		}

		System.out.println("service ::: " + idFind);
		return idFind;
		
	
	}//idFind


	
	/*
	 * traveler - 찜 목록 조회
	 */
	public ArrayList<MpgZzimVo> selectZzimList(int no) {

		Connection conn = null;
		ArrayList<MpgZzimVo> voList = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			voList = dao.selectZzimList(conn, no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return voList;
	
	}//selectZzimList


	
	/*
	 * traveler - 비밀번호 찾기
	 */
	public String pwdFind(String travelerJoinId, String travelerJoinPhone) {
	
	
		Connection conn = null;
		String pwdFind = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			pwdFind = dao.pwdFind(conn, travelerJoinId, travelerJoinPhone);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(conn);
		}

		System.out.println("service ::: " + pwdFind);
		return pwdFind;
		
	
	
	}//pwdFind


	/*
	 * traveler - 닉네임 중복 체크
	 */
	public int nickCheck(String userNick) {
		
		int nickCheck = 0;
		
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			nickCheck = dao.nickCheck(conn, userNick);

			if(nickCheck == 1) {
				System.out.println("이미 존재하는 닉네임 입니다.");
			}else {
				System.out.println("사용 가능한 닉네임 입니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return nickCheck;
		
	}//nickCheck


	
	/*
	 * traveler - 예약 내역 조회
	 */
	public ArrayList<MpgReservationVo> selectRsvList(int no) {
	
	
		Connection conn = null;
		ArrayList<MpgReservationVo> voList = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			voList = dao.selectRsvList(conn, no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return voList;
	
	
	
	}//selectRsvList


	

	/*
	 * traveler - 예약내역 상세조회 화면 보여주기
	 */
	public MpgReservationVo rsvDetail(int no, String num) {

		Connection conn = null;
		MpgReservationVo rvo = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			rvo = dao.rsvDetail(conn, no, num);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return rvo;
	
	
	}//rsvDetail


	
	/*
	 * traveler - 신고 받은 내역 조회
	 */
	public ArrayList<ReportUserVo> selectGetReportList(int no) {

		Connection conn = null;
		ArrayList<ReportUserVo> voList = null;
		
		try {
			
			conn = getConnection();
			
			// dao 호출
			voList = dao.selectGetReportList(conn, no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return voList;
	
	
	
	}

	
	
	/*
	 * traveler - 내가 쓴 댓글 삭제
	 */
	public void deleteReply(int no, int replyNo) {
		
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			dao.deleteReply(conn, no, replyNo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
	}//deleteReply


	
	/*
	 * traveler - 예약 내역 삭제
	 */
	public void deleteRsv(int no, int rsvNo) {
		
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			dao.deleteRsv(conn, no, rsvNo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
	}//deleteRsv


	/*
	 * traveler - 찜 목록 삭제
	 */
	public void deleteZzim(int no, int zzimNo) {

		Connection conn = null;
		try {
			
			conn = getConnection();
			
			dao.deleteZzim(conn, no, zzimNo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
	}//deleteZzim


	/*
	 * traveler - 신고 받은 내역 삭제
	 */
	public void deleteReport(int no, int reportNo) {
		
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			dao.deleteReport(conn, no, reportNo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
	}//deleteReport

	
	
	// 트래블러 사진 저장
	public void uploadProfilePic(TravelerAttachmentVo tav) {
		Connection conn = null;
		try {
			
			conn = getConnection();
			
			dao.createTravelerAttachment(conn, tav);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
	} // uploadProfilePic
	

	/*
	 * 원본 파일명을 중복되지 않을 이름으로 변경
	 */
	public String createChangeName(String originName) {
		
		// 원래 이름에서 확장자 가져오기
		int dotIdx = originName.lastIndexOf('.');    		
		String ext = originName.substring(dotIdx);			
		
		String fileName= originName.substring(0, dotIdx);
		
		
	    // 현재 날짜 구하기        
		LocalDate now = LocalDate.now();         
		// 포맷 정의        
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");         
		// 포맷 적용        
		String formatedNow = now.format(formatter);
	
		// 원본파일이름(확장자x) + 현재날짜(ex 220824) + 확장자
		String changeName = fileName + "_" + formatedNow + ext;   
		
		return changeName;
		
	}

	// 트래블러 사진 가져오기
	public TravelerAttachmentVo getAttachment(int no) {
		
		Connection conn = null;
		
		TravelerAttachmentVo tav = new TravelerAttachmentVo();
		try {
			
			conn = getConnection();
			
			// dao 호출
			tav = dao.getAttachment(conn, no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return tav;
	
	}



	
	

}//class
