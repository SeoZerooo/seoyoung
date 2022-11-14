package com.h3.traveler.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.community.vo.CommReplyVo;
import com.h3.reportUser.vo.ReportUserVo;
import com.h3.traveler.vo.MpgPostVo;
import com.h3.traveler.vo.MpgReservationVo;
import com.h3.traveler.vo.MpgZzimVo;
import com.h3.traveler.vo.TravelerAttachmentVo;
import com.h3.traveler.vo.TravelerVo;

public class TravelerDao {

	/*
	 * 회원가입
	 */
	public int join(TravelerVo vo, Connection conn) {

		PreparedStatement pstmt = null;
		int result = 0;

		try {

			// 커넥션준비 - 생략

			// SQL 준비
			String sql = " INSERT INTO TRAVELER (NO , ID , PWD , NAME , NICK , GENDER , PHONE , EMAIL) VALUES(SEQ_TRAVELER_NO.NEXTVAL, ?, ?, ?, ? ,? , ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getEmail());

			// SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			close(pstmt);
		}

		return result;

	}// join

	/*
	 * 로그인
	 */
	public TravelerVo login(Connection conn, TravelerVo vo) throws SQLException {

		TravelerVo travelerLoginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// sql 준비 - try 안, 밖 아무때나 위치시켜도 됨
		String sql = "SELECT * FROM TRAVELER WHERE ID = ? AND PWD = ? AND STATUS ='Y'";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());

			// SQL 실행 및 결과저장
			rs = pstmt.executeQuery();

			if (rs.next()) {

				int travelerNo = rs.getInt("NO");
				String travelerId = rs.getString("ID");
				String travelerName = rs.getString("NAME");
				String travelerNick = rs.getString("NICK");
				String travelerPhone = rs.getString("PHONE");
				String travelerEmail = rs.getString("EMAIL");
				String travelerGender = rs.getString("GENDER");
				Timestamp travelerEnrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp travelerModifyDate = rs.getTimestamp("MODIFY_DATE");

				travelerLoginMember = new TravelerVo();
				travelerLoginMember.setNo(travelerNo);
				travelerLoginMember.setId(travelerId);
				travelerLoginMember.setName(travelerName);
				travelerLoginMember.setNick(travelerNick);
				travelerLoginMember.setPhone(travelerPhone);
				travelerLoginMember.setEmail(travelerEmail);
				travelerLoginMember.setGender(travelerGender);
				travelerLoginMember.setEnrollDate(travelerEnrollDate);
				travelerLoginMember.setModifyDate(travelerModifyDate);

			}

		} finally {
			// 자원 반납
			close(pstmt);
			close(rs);
		}

		// SQL 실행결과 리턴
		return travelerLoginMember;

	}// login

	/*
	 * 마이페이지 - 정보 변경
	 */
	public int edit(Connection conn, TravelerVo vo) {

		String sql = "UPDATE TRAVELER SET NAME = ? , NICK = ? , PHONE = ? , EMAIL = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setInt(5, vo.getNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		// SQL 실행결과 리턴
		return result;

	}

	/*
	 * 다시한번 회원 정보 조회(회원번호): 정보 변경 된 것을 조회
	 */
	public TravelerVo selectOneByNo(Connection conn, int num) {

		// sql 준비
		String sql = "SELECT * FROM TRAVELER WHERE NO = ? AND STATUS ='Y'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TravelerVo vo = null;

		try {
			// sql 객체에 담기
			pstmt = conn.prepareStatement(sql);

			// 물음표 채우기
			pstmt.setInt(1, num);

			// sql 실행 및 결과 저장
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String gender = rs.getString("GENDER");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");

				vo = new TravelerVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setName(name);
				vo.setNick(nick);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setGender(gender);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return vo;

	}

	/*
	 * 비밀번호 변경
	 */
	public int changePwd(Connection conn, String travelerJoinId, String travelerJoinPwd, String travelerJoinPwdNew,
			String travelerJoinPwdNew2) {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "UPDATE TRAVELER SET PWD = ? WHERE ID = ? AND PWD = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, travelerJoinPwdNew);
			pstmt.setString(2, travelerJoinId);
			pstmt.setString(3, travelerJoinPwd);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	/*
	 * 회원 탈퇴
	 */
	public int quit(Connection conn, String travelerJoinId, String travelerJoinPwd, String travelerJoinPwd2) {

		String sql = "UPDATE TRAVELER SET STATUS = 'N' , MODIFY_DATE = SYSDATE WHERE ID = ? AND PWD = ? ";

		PreparedStatement pstmt = null;
		int result = 0;

		// AND PWD = ?

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, travelerJoinId);
			pstmt.setString(2, travelerJoinPwd);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);

		}

		return result;

	}// quit

	/*
	 * traveler - 내가 쓴 글 조회
	 */
	public ArrayList<MpgPostVo> selectList(Connection conn, int userNo) {

		String sql = "(SELECT T.NO AS WRITER, C.NO, C.TITLE, C.CONTENT, TO_CHAR(C.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLLDATE, '커뮤니티' AS BOARD "
				+ "	FROM TRAVELER T "
				+ "	LEFT JOIN COMMUNITY C ON T.NO = C.WRITER WHERE T.NO = ? AND C.STATUS = 'Y') " + "	UNION "
				+ "	(SELECT W.TRAVELER_NO AS WRITER, W.NO, W.TITLE, W.CONTENT, TO_CHAR(W.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLLDATE, '동행자 게시판' AS BOARD "
				+ "	FROM WITH_ W WHERE W.TRAVELER_NO = ? AND W.STATUS = 'Y') " + "	UNION "
				+ "	(SELECT R.TRAVELER_NO AS WRITER, R.PLACE_NO AS NO, R.TITLE, R.CONTENT, TO_CHAR(R.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLLDATE, '장소 리뷰' AS BOARD "
				+ "	FROM PLACE_REVIEW R WHERE R.TRAVELER_NO = ? AND R.STATUS = 'Y') " + "	ORDER BY ENROLLDATE DESC"; 
																														
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MpgPostVo> list = new ArrayList<MpgPostVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, userNo);

			// SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String enrollDate = rs.getString("enrollDate");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String board = rs.getString("board");

				MpgPostVo vo = new MpgPostVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setWriter(writer);
				vo.setBoard(board);

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		// 실행 결과 리턴
		return list;

	}

	/*
	 * traveler - 내가 쓴 댓글 조회 - 커뮤니티 댓글
	 */
	public ArrayList<CommReplyVo> selectReplyList(Connection conn, int userNo) {

		// SQL 준비
		String sql ="SELECT R.COMMUNITY_NO AS NO , R.CONTENT , TO_CHAR(R.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLL_DATE FROM REPLY R JOIN TRAVELER T ON R.TRAVELER_NO = T.NO WHERE R.TRAVELER_NO = ? ORDER BY ENROLL_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommReplyVo> list = new ArrayList<CommReplyVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			// SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");


				CommReplyVo vo = new CommReplyVo();
				vo.setNo(no);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		// 결과 리턴
		return list;

	}

	

	/*
	 * traveler - 내가 쓴 글 삭제
	 */
	public void deletePost(Connection conn, String no, String board) {
		// SQL 준비
		String sql = "delete from " + board+ " where no = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			// SQL 실행
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
	}//deletePost

	
	
	/*
	 * traveler - 아이디 중복 체크
	 */
	public int idCheck(Connection conn, String userId) {

		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idCheck = 0;
		
		String sql = "SELECT * FROM TRAVELER WHERE ID= ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				idCheck = 1;      // 이미 존재하는 경우, 생성 불가
			}else {
				idCheck = 0;	 // 존재하지 않는 경우, 생성 가능
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return idCheck;
		
	}//deletePost

	
	

	/*
	 * traveler - 아이디 찾기
	 */
	public String idFind(Connection conn, String travelerJoinPhone, String travelerJoinEmail) {

		PreparedStatement pstmt = null;
		String idFind = null;
		ResultSet rs = null;

	    String sql ="SELECT ID FROM TRAVELER WHERE PHONE = ? AND EMAIL = ? AND STATUS ='Y'";
//		String sql ="SELECT ID FROM TRAVELER";
	    try {
	    	
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(travelerJoinPhone));
			pstmt.setString(1, travelerJoinPhone);
			pstmt.setString(2, travelerJoinEmail);
			
			System.out.println("====================");
			System.out.println("입력받은 번호 : " + travelerJoinPhone);
			System.out.println("입력받은 이메일 : " + travelerJoinEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("rs 통과 ");//swy
				
				idFind = rs.getString("ID");
				System.out.println(idFind);//swy
				
				//idFind = new TravelerVo();
				//idFind.setId(travelerId);
				
			}
			
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	
	    }finally {
	    	close(pstmt);
			close(rs);

	    }
	    
	    System.out.println("dao ::: " + idFind);
	    
	    return idFind;
	
	
	
	}//idFind

	


		/*
		 * traveler - 찜 목록 조회
		 */
		public ArrayList<MpgZzimVo> selectZzimList(Connection conn, int userNo) {

			
			String sql = "SELECT  Z.NO, Z.TRAVELER_NO, Z.PLACE_NO, P.NAME, P.CONTENT, '장소 게시판' AS BOARD FROM ZZIM Z JOIN PLACE P ON Z.PLACE_NO = P.NO WHERE TRAVELER_NO = ?";
		
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			ArrayList<MpgZzimVo> list = new ArrayList<MpgZzimVo>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);


				rs = pstmt.executeQuery();

				while(rs.next()) {

					String no = rs.getString("no");
					String travelerNo = rs.getString("TRAVELER_NO");  	 // 회원
					String placeNo = rs.getString("PLACE_NO");   			 // 장소번호
					String name = rs.getString("NAME");    	 	 // 장소명
					String content = rs.getString("CONTENT");    // 내용
					String board = rs.getString("board");    	 // 게시판 타입
					
					MpgZzimVo vo = new MpgZzimVo();
					vo.setNo(no);
					vo.setTravelerNo(travelerNo);
					vo.setPlaceNo(placeNo);
					vo.setName(name);
					vo.setContent(content);
					vo.setBoard(board);

					list.add(vo);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return list;
			
		}//selectZzimList

		
		
		/*
		 * traveler - 비밀번호 찾기
		 */
		public String pwdFind(Connection conn, String travelerJoinId, String travelerJoinPhone) {

			PreparedStatement pstmt = null;
			String pwdFind = null;
			ResultSet rs = null;

		    String sql ="SELECT PWD FROM TRAVELER WHERE ID = ? AND PHONE = ? AND STATUS ='Y'";
		    try {
		    	
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, travelerJoinId);
				pstmt.setString(2, travelerJoinPhone);
				
				System.out.println("====================");
				System.out.println("입력받은 아이디 : " + travelerJoinId);
				System.out.println("입력받은 전화번호 : " + travelerJoinPhone);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					System.out.println("rs 통과 ");
					
					pwdFind = rs.getString("PWD");
					System.out.println(pwdFind);
					
					
				}
				
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	
		    }finally {
		    	close(pstmt);
				close(rs);

		    }
		    
		    System.out.println("dao ::: " + pwdFind);
		    
		    return pwdFind;
		
		}//pwdFind

		
		
		/*
		 * traveler - 닉네임 중복 체크
		 */
		public int nickCheck(Connection conn, String userNick) {

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int nickCheck = 0;
			
			String sql = "SELECT * FROM TRAVELER WHERE NICK= ? ";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userNick);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					nickCheck = 1;      // 이미 존재하는 경우, 생성 불가
				}else {
					nickCheck = 0;	 // 존재하지 않는 경우, 생성 가능
				}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return nickCheck;
		
		}//nickCheck

		
		
		/*
		 * traveler - 예약 내역 조회
		 */
		public ArrayList<MpgReservationVo> selectRsvList(Connection conn, int userNo) {

			String sql = "SELECT R.NO, R.TRAVELER_NO, R.PLACE_NO, P.NAME, TO_CHAR(R.START_DATE, 'YY/MM/DD') AS START_DATE FROM RESERVATION R JOIN PLACE P ON R.PLACE_NO = P.NO WHERE TRAVELER_NO=? AND CANCEL = 'N'";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			ArrayList<MpgReservationVo> list = new ArrayList<MpgReservationVo>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);


				rs = pstmt.executeQuery();

				while(rs.next()) {

					String no = rs.getString("NO");  	 	 // 예약번호
					String travelerNo = rs.getString("TRAVELER_NO");  	 	 // 회원번호
					String placeNo = rs.getString("PLACE_NO");   			 // 장소번호
					String name = rs.getString("NAME");    	 			 	 // 장소명
					String startDate = rs.getString("START_DATE");   			 // 예약날짜
					
					MpgReservationVo vo = new MpgReservationVo();
					vo.setNo(no);
					vo.setTravelerNo(travelerNo);
					vo.setPlaceNo(placeNo);
					vo.setName(name);
					vo.setStartDate(startDate);

					list.add(vo);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return list;
		
		
		}//selectRsvList

		
		
		/*
		 * traveler - 예약내역 상세조회 화면 보여주기
		 */
		public MpgReservationVo rsvDetail(Connection conn, int userNo, String num) {

	String sql = "SELECT R.NO, R.TRAVELER_NO, R.PLACE_NO, P.ADDRESS, P.NAME, R.HUMAN, TO_CHAR(R.START_DATE, 'YY/MM/DD') AS START_DATE, TO_CHAR(R.END_DATE, 'YY/MM/DD') AS END_DATE FROM RESERVATION R JOIN PLACE P ON R.PLACE_NO = P.NO WHERE TRAVELER_NO=? AND R.NO = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			MpgReservationVo rvo = new MpgReservationVo();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				pstmt.setString(2, num);


				rs = pstmt.executeQuery();

				while(rs.next()) {

					String no = rs.getString("NO");  	 	 				 // 예약번호
					String travelerNo = rs.getString("TRAVELER_NO");  	 	 // 회원번호
					String placeNo = rs.getString("PLACE_NO");   			 // 장소번호
					String name = rs.getString("NAME");    	 			 	 // 장소명
					String human = rs.getString("HUMAN");    	 			 // 인원수
					String startDate = rs.getString("START_DATE");   		 // 예약날짜
					String endDate = rs.getString("END_DATE");   			 // 예약날짜
					String address = rs.getString("ADDRESS");   			 // 주소

					rvo = new MpgReservationVo();
					rvo.setNo(no);
					rvo.setTravelerNo(travelerNo);
					rvo.setPlaceNo(placeNo);
					rvo.setName(name);
					rvo.setHuman(human);
					rvo.setStartDate(startDate);
					rvo.setEndDate(endDate);
					rvo.setAddress(address);
					

				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return rvo;
		
		}//rsvDetail

		
		

		/*
		 * traveler - 신고 받은 내역 조회
		 */
		public ArrayList<ReportUserVo> selectGetReportList(Connection conn, int userNo) {

		
			String sql = "SELECT R.NO, R.GUILTY, R.CONTENT, R.PROCESS, R.REPORTED_TRAVELER_NO, R.ENROLL_DATE, T.ID AS REPORT_USER_ID FROM REPORT_USER R JOIN TRAVELER T ON R.REPORTED_TRAVELER_NO = T.NO WHERE T.STATUS = 'Y' AND REPORTED_TRAVELER_NO = ? ORDER BY NO DESC";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			ArrayList<ReportUserVo> list = new ArrayList<ReportUserVo>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);

				System.out.println("userNo::: " + userNo);
				
				
				rs = pstmt.executeQuery();

				while(rs.next()) {
					System.out.println("@@@@@@@---rs통과---@@@@@@@@@");
					
					String no = rs.getString("NO");
					String guilty =	rs.getString("GUILTY");
					String content = rs.getString("CONTENT");
					String process = rs.getString("PROCESS");
					String reportedTravelerNo =	rs.getString("REPORTED_TRAVELER_NO");
					Timestamp enrollDate =	rs.getTimestamp("ENROLL_DATE");
					String reportUserId =	rs.getString("REPORT_USER_ID");

					ReportUserVo vo = new ReportUserVo();
					vo.setNo(no);
					vo.setGuilty(guilty);
					vo.setContent(content);
					vo.setProcess(process);
					vo.setEnrollDate(enrollDate);
					vo.setReportedTravelerNo(reportedTravelerNo);
					vo.setReportUserId(reportUserId);
					
					System.out.println(no);
					System.out.println(guilty);
					System.out.println(content);
					System.out.println(process);
					System.out.println(reportedTravelerNo);
					System.out.println(reportUserId);


					list.add(vo);
					System.out.println("vo::: " + vo);

				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return list;
			
			
		
		}//selectGetReportList

		
		
		/*
		 * traveler - 내가 쓴 댓글 삭제
		 */
		public void deleteReply(Connection conn, int userNo, int replyNo) {
			
			// SQL 준비
			String sql = "delete from reply where NO = ?";

			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, replyNo);
				
				// SQL 실행
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			
			
			
		}//deleteReply

		
		
		
		/*
		 * traveler - 예약 내역 삭제
		 */
		public void deleteRsv(Connection conn, int no, int rsvNo) {

			// SQL 준비
			String sql = "delete from RESERVATION where NO = ?";

			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rsvNo);
				
				// SQL 실행
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		
		
		
		}//deleteRsv

		
		
		/*
		 * traveler - 찜 목록 삭제
		 */
		public void deleteZzim(Connection conn, int no, int zzimNo) {

			String sql = "delete from ZZIM where NO = ?";

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, zzimNo);
				
				// SQL 실행
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			
		}//deleteZzim

		
		
		/*
		 * traveler - 신고 받은 내역 삭제
		 */
		public void deleteReport(Connection conn, int no, int reportNo) {
			
			String sql = "delete from REPORT_USER where NO = ?";

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, reportNo);
				
				// SQL 실행
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			
		}//deleteReport

		
		
		// 사진 업로드 (TRAVELER_MYPAGE_PHOTO에 데이터 저장)
		public void createTravelerAttachment(Connection conn, TravelerAttachmentVo tav) {
			String sql = "insert into TRAVELER_MYPAGE_PHOTO "
					+ " (NO, ORIGN_NAME, CHANGE_NAME, FILE_PATH, TRAVELER_NO) " 
					+ " values (SEQ_TRAVELER_MYPAGE_PHOTO_NO.NEXTVAL, ?, ?, ?, ?)"
					;

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, tav.getOriginName());
				pstmt.setString(2, tav.getChangeName());
				pstmt.setString(3, tav.getFilePath());
				pstmt.setString(4, tav.getTravelerNo());
				
				// SQL 실행
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		} // createTravelerAttachment

		
		// 사진 가져오기
		public TravelerAttachmentVo getAttachment(Connection conn, int userNo) {
			String sql = "select * from (select no, orign_name as originName, "
					+ "change_name as changeName, file_path as filePath, "
					+ "upload_date as uploadDate, status, traveler_no as travelerNo "
					+ "from TRAVELER_MYPAGE_PHOTO where traveler_no = ? "
					+ "order by upload_date desc) where rownum = 1 ";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			TravelerAttachmentVo tav = new TravelerAttachmentVo();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);

				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String no = rs.getString("no");  	 	 				 
					String originName = rs.getString("originName");  	 	 
					String changeName = rs.getString("changeName");   		
					String filePath = rs.getString("filePath");    	 			 
					String uploadDate = rs.getString("uploadDate");    	 	
					String status = rs.getString("status");   		 
					String travelerNo = rs.getString("travelerNo");   
					
					tav.setNo(no);
					tav.setOriginName(originName);
					tav.setChangeName(changeName);
					tav.setFilePath(filePath);
					tav.setStatus(status);
					tav.setTravelerNo(travelerNo);
					tav.setUploaDate(uploadDate);

				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return tav;
		}

		

}// class


