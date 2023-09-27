package boardData;

import java.util.Scanner;

public class BoardController {

	//필드
	private Scanner sc;
	private BoardDao dao;
	
	//기본 생성자(초기값 셋팅)
	public BoardController() {
		sc = new Scanner(System.in);
		dao = new BoardDao();
	}
	
	
	//게시글 작성
	public void write() {
		System.out.println("----- 게시글 작성 -----");
		
		//데이터 입력받기
		System.out.print("제목: ");
		String title = sc.nextLine();
		System.out.print("내용: ");
		String content = sc.nextLine();
		System.out.print("작성자: ");
		String writer = sc.nextLine();
		
		//데이터 뭉치기
		BoardData boardData = new BoardData(title, content, writer);
		
		//할일//저장공간(메모장)에 저장
		boolean result;
		try{
			result = dao.write(boardData);
		}catch(Exception e) {
			result = false;
		}
		
		//결과출력
		if(result) {
			System.out.println("게시글 작성 완료!!!");
		}else {
			System.out.println("게시글 작성 실패...");
		}
	}//write end
	
	
	//게시글 조회
	public void find() {
		
		//데이터 입력받기
		System.out.print("제목: ");
		String title = sc.nextLine();
		System.out.print("작성자: ");
		String writer = sc.nextLine();
		
		//데이터 뭉치기
		BoardData boardData = new BoardData(title, writer);
		
		//할일
		boolean result;
		try {
			result = dao.find(boardData);
		}catch(Exception e) {
			result = false;
		}
		
		if(result) {
			System.out.println("일치하는 게시글 존재!!!");
		}else {
			System.out.println("일치하는 게시글 없음...");
		}
		
	}//find end
	
	
	
}//class
