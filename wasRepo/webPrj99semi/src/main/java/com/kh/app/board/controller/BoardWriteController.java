package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{

	// 게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	
	}
	
	//게시글 작성 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 인코딩 //필터에서 코딩 처리해줘서 주석처리함
//			req.setCharacterEncoding("UFT-8");   // try 밖에 작성하면 나중에 예외처리가 안될 가능성때문에 여기 적는게 좋다. 
			
			HttpSession session = req.getSession();
			
			// data
			String category = req.getParameter("category");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new Exception("로그인 안했음");
			}
			
			BoardVo vo = new BoardVo();
			vo.setCategoryNo(category);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(loginMember.getNo());
			
			//service
			BoardService bs = new BoardService();
			int result = bs.write(vo);
			
			// result == view
			
			if(result != 1) {
				throw new Exception("result 가 1이 아님 ...");
			}
			
			// 기본적으로 성공에 대한 알람띄고, 게시글 목록으로 보내기
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공 !!!");
			resp.sendRedirect("/app99/board/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002] 게시글 작성 실패 ...");
			e.printStackTrace();
			req.setAttribute("errMsg", "게시글 작성 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
}//class
