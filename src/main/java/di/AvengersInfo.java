package di;

public class AvengersInfo {

	//멤버변수 : 객체를 갖고있음
	private AvengersVO avengers;

	//인자생성자
	public AvengersInfo(AvengersVO avengers) {
		super();
		this.avengers = avengers;
	}

	public AvengersVO getAvengers() {
		return avengers;
	}
	public void setAvengers(AvengersVO avengers) {

		this.avengers = avengers;
	}
	
	
	//멤버메소드
	public String AvengersView() {
		String returnStr = "";
		
		if(avengers != null) {
			returnStr += String.format("본명:%s<br>",avengers.getName());
			returnStr += String.format("히어로명:%s<br>",avengers.getHereName());
			returnStr += String.format("능력:%s<br>",avengers.getAbillity());
			returnStr += String.format("나이:%s<br>",avengers.getAge());
		}
		return returnStr;
	}
}
