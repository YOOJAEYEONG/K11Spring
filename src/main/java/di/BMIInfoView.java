package di;

import java.util.ArrayList;

public class BMIInfoView {

	private String name;				//이름 - 문자열(객체)
	private double height;				//신장 - 더블형(기본자료형)
	private double weight;				//무게
	private ArrayList<String> hobbys;	//취미 - 컬렉션
	private BMICalResult bmiCalResult;	//체질량지수 계산결과 - 사용자 정의객체
	
	//BMI지수를 계산하는 멤버변수 객체의 함수를 호출함
	public String bmiCalculation() {
		//몸무게와 신장을 매개변수로 전달, BMI지수 계산결과를 반환받음
		/*
		xml파일을통해서 객체를 생성하는 것이 아니라 어노테이션을 통해서 생성했기 때문에 
		BMICalResult bmiCalResult 객체는 생성되지 않은 상태이므로 null 인 상태이다.
		따라서 정상작동하려면 AppConfiguration.java 파일에서 BMIInfoView의 빈 생성을 하기전에
		BMICalResult객체도 생성하고 초기화해 줘야한다.
		*/
		System.out.println("bmiCalculation():진입");
		System.out.println(weight+"\n"+height);
		String bmiResult =
				bmiCalResult.bmiCalculation(weight, height);
		return bmiResult;
	}
	
	public String getInfo() {
		return String.format("이름:%s<br>"
				+ "키:%s<br>"
				+ "몸무게:%s<br>"
				+ "취미:%s<br>%s",
				name, height,weight,hobbys, bmiCalculation());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public BMICalResult getBmiCalResult() {
		return bmiCalResult;
	}

	public void setBmiCalResult(BMICalResult bmiCalResult) {
		this.bmiCalResult = bmiCalResult;
	}
	
	
	
}
