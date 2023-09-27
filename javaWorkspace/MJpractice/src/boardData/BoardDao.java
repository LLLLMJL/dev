package boardData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class BoardDao {
	
	//필드 == 멤버변수
	private File file;
	
	//생성자
	public BoardDao() {
		file = new File("D:\\dev\\practice.txt");
	}
	
	//게시글 작성 //파라미터로 전달받은 데이터 저장공간에 넣기
	public boolean write(BoardData boardData) throws Exception {
		
		//할일
		FileWriter fw = new FileWriter(file);
		
		String str = boardData.getTitle() + "//" + boardData.getContent() + "//"+ boardData.getWriter();
		fw.write(str);
		fw.close();
		
		//결과 리턴
		return true;
	}//write end
	
	public boolean find(BoardData boardData) throws Exception{
		//할일
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String memoStr = br.readLine();
		String memoTitle = memoStr.substring( 0, memoStr.indexOf("//"));
//		System.out.println(memoStr.substring( 0, memoStr.indexOf("aa")));
//		System.out.println(memoStr.indexOf("aa"));
		String memoWriter = memoStr.substring(memoStr.lastIndexOf("//")+2);
		
		boolean titleOk = memoTitle.equals(boardData.getTitle());
		boolean writerOk = memoWriter.equals(boardData.getWriter());
		
		boolean findOk = titleOk && writerOk;
		
		//결과 리턴
		return findOk;
		
		
	}//find end
	

}//class
