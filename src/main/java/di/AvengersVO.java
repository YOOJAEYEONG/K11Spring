package di;


//VO는 DTO와 같은 의미이다
public class AvengersVO {

	private String name;
	private String hereName;
	private String abillity;
	private String age;
	
	
	
	public AvengersVO(String name, String hereName, String abillity,
			String age) {
		super();
		this.name = name;
		this.hereName = hereName;
		this.abillity = abillity;
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public String getHereName() {
		return hereName;
	}



	public String getAbillity() {
		return abillity;
	}



	public String getAge() {
		return age;
	}
	
	
	
}
