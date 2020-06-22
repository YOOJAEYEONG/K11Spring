package common;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String email;
	
	
	
	
	//기본생성자는 디폴트로 삽입
	/*
	만약 해당 DTO객체를 커맨드객체로 사용하려면 반드시 기본생성자가
	존재해야한다. 그러므로 인자생성자를 만들어야한다면 기본생성자를 추가해줘야한다. 
	 */
	
	
	public MemberDTO() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
