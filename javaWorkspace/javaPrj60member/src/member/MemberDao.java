package member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemberDao {

	//멤버변수 (== 필드) 추가
	private File file;
	
	//기본생성자
	public MemberDao() {
		String fileName = "D:\\dev\\hello.txt";
		file = new File(fileName);
	}
	
	//회원가입 (데이터 집어넣기)
	public boolean join(MemberData memberData) {
		//파라미터로 받은 데이터를 저장공간(컬렉션, RAM, 메모장, 엑셀 등등)에 담기
		
		//파일 객체(메모장에 담기위해서)
		
		//보내는 스트림
		FileWriter fw = null;       //finally에서도 fw 변수 사용하기 위해서 미리 선언
									// & 일단 뭐들어갈지 모르니까 null 넣어서 초기화까지 진행해야 fw.close 빨간줄 안뜬다!!!
		try {
			fw = new FileWriter(file);
			
			//데이터 가공     ID@PWD@NICK 형식으로 
			String dataStr 
			= memberData.getId() + "@" + memberData.getPwd() + "@" + memberData.getNick();
			
			//보내기 - 통로가 안정되게 만들어진게 확실해야 보내는게 맞아서 이 단계에서 보내기 진행해야함!!!
			       //만약에 위에 통로가 에러나면 여기까지 코드를 읽지도 못하고 에러처리되니까...
			fw.write(dataStr);
			
		}catch(IOException e){
			System.out.println("파일 객체 만드려다가,,, IO예외 발생함,,,");
			return false;    //finally 까지 실행되고 return 진행된다!!
		}finally{
			try {
				fw.close();        //통로를 열었으면 무조건 닫아줘야함!!!
			}catch(IOException e) {
				
			}
		}//finally
		
		
		//결과리턴(메소드 실행결과를 dao.join에서 확인할 수 있도록)
		return true;        //메소드를 boolean 타입으로 변경했으므로 
		
	}//join end
	
	
	//로그인 (데이터 꺼내오기)
	public boolean login(MemberData memberData) {
		//저장공간(메모장)에서 데이터 꺼내기
		
		
		//파일객체 필요
		
		//받는 스트림
		BufferedReader br = null;
		FileReader fr = null;
		boolean isSuccess = false;  //기본값을 true로 하면 예외발생해도 초기값 true로 로그인이 되므로 그걸 막기위해 false를 기본값으로 설정 
		try {
			fr = new FileReader(file);
		    br = new BufferedReader(fr);    //파일 더 잘 읽기 위해서 보조 스트림 추가한것 (무조건 메인스트림이 있어야 생성가능)
		   
		    //읽기
		    String str = br.readLine();
		    
		    //비교 (입력받은거랑 꺼낸데이터를 비교) 
		    String id = memberData.getId();
		    String pwd = memberData.getPwd();
		    
		    String memoId = str.substring(0, str.indexOf("@"));
		    
		    str = str.substring(str.indexOf("@")+1);  // 새로운 시작칸으로 str을 덮어씌우는 일
		    String memoPwd = str.substring(0, str.indexOf("@"));
		    
		    isSuccess = memoId.equals(id) && memoPwd.equals(pwd);
		    
		}catch(Exception e) {
			System.out.println("파일 못찾아서 예외 발생,,,");
		}finally {
			try{if(fr != null) {fr.close();} }catch(Exception e) {}
			//if 문은 이미 닫힌 통로를 또 닫을 수 없으니까 체크해주는 것이다!!
			//통로는 따로따로 닫아줘야 확실하다
			try{if(br != null) {br.close();}}catch(Exception e){}
		}//finally
		
		//결과리턴
		return isSuccess;
		
	}//login end
	
	
}//class
