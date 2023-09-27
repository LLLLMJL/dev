package member;

public class MemberData {

	//기본 생성자
//	public MemberData() {
//	}

	//id, pwd 만 있는 생성자
	public MemberData(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	//모든 필드채우는 생성자
	public MemberData(String id, String pwd, String nick) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	//필드 == 멤버변수
	private String id;
	private String pwd;
	private String nick;
	
	//getter/setter
//	public void setId(String id) {
//		this.id = id;
//	}
	public String getId() {
		return id;
	}
	
//	public void setPwd(String pwd) {
//		this.pwd =pwd;
//	}
	public String getPwd() {
		return pwd;
	}
	
//	public void setNick(String nick) {
//		this.nick = nick;
//	}
	public String getNick() {
		return nick;
	}
	
	//toString(형식 자유롭게)
	 @Override
	 public String toString() {
		 return "클래스명: MemberData,  아이디: " + id + ", 비밀번호: " + pwd + ", 닉네임: " + nick;
	 }
	 
	
}
