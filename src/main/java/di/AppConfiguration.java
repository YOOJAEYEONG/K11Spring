package di;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/*
@Configuration
	: 해당 클래스를 스프링 설정파일로 사용하겠다는 선언으로 XML설정파일을 사용하는대신 해당 
	java파일을 설정 파일로 사용한다.
 */
@Configuration
public class AppConfiguration {

	
	/*
	@Bean
		:해당 설정파일에서 빈을 생성할때 선언한다. 해당 빈은 컨트롤러로
		getBean()메소드를 통해 주입된다.
	*/
	
	@Bean
	public BMIInfoView member1() {
		
		//BMI지수 계산을 위한 객체(빈) 생성
		BMICalResult bm = new BMICalResult();
		bm.setLowWeight(18.5);
		bm.setNormal(23);
		bm.setObesity(25);
		bm.setOverWeight(30);
		
		
		
		ArrayList<String> hobbys = 
				new ArrayList<String>();
		
		hobbys.add("삽질하기");
		hobbys.add("멍때리기");
		
		BMIInfoView mem1 = new BMIInfoView();
		mem1.setName("홍길동");
		mem1.setHobbys(hobbys);
		mem1.setHeight(190);
		mem1.setWeight(89);
		//위에서 생성한 bm객체를 통해 멤버변수 초기화
		mem1.setBmiCalResult(bm);
		
		return mem1;
	}
	@Bean
	public BMIInfoView member2() {
		
		ArrayList<String> hobbys = 
				new ArrayList<String>();
		
		hobbys.add("물놀이");
		hobbys.add("레고");
		hobbys.add("어벤저스놀이");
		
		BMIInfoView mem2 = new BMIInfoView();
		mem2.setName("성유겸");
		mem2.setHobbys(hobbys);
		mem2.setHeight(115);
		mem2.setWeight(20);
		
		return mem2;
	}
}
