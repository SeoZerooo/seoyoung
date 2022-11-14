package com.h3.bossRegister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h3.common.JDBCTemplate;

//회원으로 로그인한 상태에서 장소 클릭했을 때, 장소 목록이 보여지지만, 사장님이 장소를 클릭헀을 경우, 사장님 인증 페이지로 넘어가게 해야함.

@WebServlet(urlPatterns = "/bossRegister")
public class BossRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection conn = null;
		try {
			// 사장님 인증받기

			// 입력한 데이터 받기
			// 사업자등록번호(숫자)
			req.setCharacterEncoding("UTF-8");
			int busNum = Integer.parseInt(req.getParameter("busNum"));
			// 업태?
			String busStatus = req.getParameter("busStatus");
			// 상호명
			String busName = req.getParameter("busName");
			// 대표자명
			String busBoss = req.getParameter("busBoss");
			// 생년월일
			int busBirth = Integer.parseInt(req.getParameter("busBirth"));
			// 주소
			String busAddress = req.getParameter("busAddress");

			// DB 가져오기
			conn = JDBCTemplate.getConnection();

			// 입력된 정보(jsp화면) -> sql에 넣기
			String sql = "INSERT INTO REGISTER (NO, NUM, STATUS, NAME, BOSSNAME, BIRTH, ADDRESS) VALUES (SEQ_REGISTER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, busNum);
			pstmt.setString(2, busStatus);
			pstmt.setString(3, busName);
			pstmt.setString(4, busBoss);
			pstmt.setInt(5, busBirth);
			pstmt.setString(6, busAddress);

			int result = pstmt.executeUpdate();

			if (result == 1) {// 인증 입력 시, 넘어가는 곳
				HttpSession reg = req.getSession();
				reg.setAttribute("registerOk", "인증되었습니다. <br> 다시 로그인해주세요.");
				resp.sendRedirect("views/common/loginForm.jsp");
			} else {// 잘못 입력 시, null값이 있을 시
				HttpSession reg = req.getSession();
				reg.setAttribute("registerFail", "입력이 잘못되었습니다. 다시 인증해주세요.");
				resp.sendRedirect("/hallo03talk");
			}

		} catch (Exception e) {
			System.out.println("인증 실패");
			e.printStackTrace();
			HttpSession reg = req.getSession();
			reg.setAttribute("registerFail", "입력이 잘못되었습니다. 다시 인증해주세요.");
			resp.sendRedirect("/hallo03talk");
		}

	}

}
