package main;

import boardData.BoardController;

public class MainBoardDataPractice {

	public static void main(String[] args) {

		System.out.println("===== 게시글 관리 =====");
		
		BoardController bc = new BoardController();
		
		//게시글 작성
//		bc.write();
		
		//게시글 조회(제목,작성자만 있으면 됨)
		bc.find();
		
	}//main

}//class
