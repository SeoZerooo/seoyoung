package com.h3.boss.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.boss.vo.BossAttachmentVo;
import com.h3.boss.vo.BossMyPageVo;
import com.h3.boss.vo.BossVo;
import com.h3.community.vo.CommReplyVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.traveler.vo.MpgPostVo;
import com.h3.traveler.vo.TravelerAttachmentVo;

public class BossDao {

	/*
	 * 회원가입
	 */
	public int join(BossVo vo, Connection conn) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			// 커넥션준비 - 생략
			
			//SQL 준비
			String sql = "INSERT INTO BOSS (NO , ID , PWD , PHONE , EMAIL) VALUES(SEQ_BOSS_NO.NEXTVAL, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
		} finally {
			close(pstmt);
		}
		
		return result;
	
	
	
	
	
	}//join

	
	
	/*
	 * 로그인
	 */
	public BossVo login(Connection conn, BossVo vo) throws SQLException {

		BossVo BossLoginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOSS WHERE ID = ? AND PWD = ? AND STATUS ='Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int BossNo = rs.getInt("NO");
				String BossId = rs.getString("ID");
				String BossPhone = rs.getString("PHONE");
				String BossEmail = rs.getString("EMAIL");
				Timestamp BossEnrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp BossModifyDate = rs.getTimestamp("MODIFY_DATE");

				BossLoginMember = new BossVo();
				BossLoginMember.setNo(BossNo);
				BossLoginMember.setId(BossId);
				BossLoginMember.setPhone(BossPhone);
				BossLoginMember.setEmail(BossEmail);
				BossLoginMember.setEnrollDate(BossEnrollDate);
				BossLoginMember.setModifyDate(BossModifyDate);

			}
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}
		
		// SQL 실행결과 리턴
		return BossLoginMember;
	
	
	}//login



	/*
	 * 마이페이지 - 회원정보 변경
	 * 
	 */
	public int edit(Connection conn, BossVo vo) {

		String sql = "UPDATE BOSS SET  PHONE = ? , EMAIL = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(2, vo.getEmail());
			pstmt.setInt(3, vo.getNo());

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}
		
		//SQL 실행결과 리턴
		return result;
	
	
	
	
	}//edit


	
	/*
	 * 다시한번 회원 정보 조회(회원번호): 정보 변경 된 것을 조회
	 */
	public BossVo selectOneByNo(Connection conn, int num) {

	
		// sql 준비
		String sql = "SELECT * FROM BOSS WHERE NO = ? AND STATUS ='Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BossVo vo = null;
		
		try {
			// sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			// 물음표 채우기
			pstmt.setInt(1, num);

			
			// sql 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				
				vo = new BossVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}

		return vo;
	}



	/*
	 * 비밀번호 변경
	 */
	public int changePwd(Connection conn, String bossJoinId, String bossJoinPwd, String bossJoinPwdNew,
			String bossJoinPwdNew2) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE BOSS SET PWD = ? WHERE ID = ? AND PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossJoinPwdNew);
			pstmt.setString(2, bossJoinId);
			pstmt.setString(3, bossJoinPwd);

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}//changePwd



	/*
	 * 회원 탈퇴
	 */
	public int quit(Connection conn, String bossJoinId, String bossJoinPwd, String bossJoinPwd2) {

		String sql = "UPDATE BOSS SET STATUS = 'N' , MODIFY_DATE = SYSDATE WHERE ID = ? AND PWD = ? ";
		
		PreparedStatement pstmt = null;
		int result = 0;
		

		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossJoinId);
			pstmt.setString(2, bossJoinPwd);
	
			
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);

		}
		
		return result;
	
	}//quit




	/*
	 * boss - 내가 쓴 글 조회
	 */
	public ArrayList<BossMyPageVo> selectList(Connection conn,  int userNo) {

		String sql = " (SELECT "
				+ "        R.BOSS_NO AS WRITER,"
				+ "        R.NO, "
				+ "        R.CONTENT, "
				+ "        TO_CHAR(R.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLLDATE, "
				+ "        '이벤트 등록' AS BOARD "
				+ "     FROM PARTY R "
				+ "     WHERE R.BOSS_NO = ? "
				+ "     AND R.STATUS = 'Y')  "
				+ "     UNION  "
				+ "     (SELECT "
				+ "        P.BOSS_NO AS WRITER,   "
				+ "        P.NO,  "
				+ "        P.CONTENT,  "
				+ "        TO_CHAR(P.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLLDATE, "
				+ "        '장소 등록' AS BOARD  "
				+ "    FROM PLACE P     "
				+ "    WHERE P.BOSS_NO = ?   "
				+ "    AND P.STATUS = 'Y')   "
				+ "    ORDER BY ENROLLDATE DESC";
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList <BossMyPageVo> list = new ArrayList<BossMyPageVo>();
		

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("no");
				//String title = rs.getString("title");
				String enrollDate = rs.getString("enrollDate");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String board = rs.getString("board");

				BossMyPageVo vo = new BossMyPageVo();
				vo.setNo(no);
				//vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setWriter(writer);
				vo.setBoard(board);

				list.add(vo);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return list;

	
	}//selectList



	
	/*
	 * boss - 내가 쓴 댓글 조회 - 커뮤니티 댓글
	 */
	public ArrayList<PlaceReviewVo> selectReplyList(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceReviewVo> list = new ArrayList<PlaceReviewVo>();

		String sql = "SELECT PR.PLACE_NO AS NO, R.CONTENT , TO_CHAR(R.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLL_DATE FROM PLACE_REVIEW_REPLY R JOIN BOSS B ON R.BOSS_NO = B.NO JOIN PLACE_REVIEW PR ON PR.NO = R.REVIEW_NO WHERE R.BOSS_NO = ? ORDER BY ENROLL_DATE DESC";
				
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");


				PlaceReviewVo vo = new PlaceReviewVo();
				vo.setNo(no);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);

				list.add(vo);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	
	}//selectReplyList



	/*
	 * boss - 아이디 찾기
	 */
	public String idFind(Connection conn, String bossJoinPhone, String bossJoinEmail) {
	
	
	
		PreparedStatement pstmt = null;
		String idFind = null;
		ResultSet rs = null;

	    String sql ="SELECT ID FROM BOSS WHERE PHONE = ? AND EMAIL = ? AND STATUS ='Y'";
	    try {
	    	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossJoinPhone);
			pstmt.setString(2, bossJoinEmail);
			
			System.out.println("====================");
			System.out.println("입력받은 번호 : " + bossJoinPhone);
			System.out.println("입력받은 이메일 : " + bossJoinEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("rs 통과 ");
				
				idFind = rs.getString("ID");
				System.out.println(idFind);
				
				
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
	 * boss - 비밀번호 찾기
	 */
	public String pwdFind(Connection conn, String bossJoinId, String bossJoinPhone) {

		PreparedStatement pstmt = null;
		String pwdFind = null;
		ResultSet rs = null;

	    String sql ="SELECT PWD FROM BOSS WHERE ID = ? AND PHONE = ? AND STATUS ='Y'";
	    try {
	    	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossJoinId);
			pstmt.setString(2, bossJoinPhone);
			
			System.out.println("====================");
			System.out.println("입력받은 아이디 : " + bossJoinId);
			System.out.println("입력받은 전화번호 : " + bossJoinPhone);
			
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
	 * boss - 아이디 중복 체크
	 */
	public int idCheck(Connection conn, String bossId) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idCheck = 0;
		
		String sql = "SELECT * FROM BOSS WHERE ID= ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossId);
			
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
	
	}



	/*
	 * boss - 내가 쓴 답글 삭제
	 */
	public void deleteReply(Connection conn, int userNo, int replyNo) {
		
		
		// SQL 준비
					String sql = "delete from PLACE_REVIEW_REPLY where NO = ?";

					
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
	 * boss - 내가 쓴 글 삭제
	 */
	public void deletePost(Connection conn, String no, String board) {
		
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


	// 사진 업로드 (BOSS_MYPAGE_PHOTO에 데이터 저장)
			public void createBossAttachment(Connection conn, BossAttachmentVo bav) {
				String sql = "insert into BOSS_MYPAGE_PHOTO "
						+ " (NO, ORIGN_NAME, CHANGE_NAME, FILE_PATH, BOSS_NO) " 
						+ " values (SEQ_BOSS_MYPAGE_PHOTO_NO.NEXTVAL, ?, ?, ?, ?)"
						;

				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bav.getOriginName());
					pstmt.setString(2, bav.getChangeName());
					pstmt.setString(3, bav.getFilePath());
					pstmt.setString(4, bav.getBossNo());
					
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
			public BossAttachmentVo getAttachment(Connection conn, int userNo) {
				String sql = "select * from (select no, orign_name as originName, "
						+ "change_name as changeName, file_path as filePath, "
						+ "upload_date as uploadDate, status, boss_no as bossNo "
						+ "from BOSS_MYPAGE_PHOTO where boss_no = ? "
						+ "order by upload_date desc) where rownum = 1 ";
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;		
				BossAttachmentVo bav = new BossAttachmentVo();
				
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
						String bossNo = rs.getString("bossNo");   
						
						bav.setNo(no);
						bav.setOriginName(originName);
						bav.setChangeName(changeName);
						bav.setFilePath(filePath);
						bav.setStatus(status);
						bav.setBossNo(bossNo);
						bav.setUploaDate(uploadDate);

					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rs);
				}
				
				return bav;
			}

	
}//class
