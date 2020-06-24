package com.kosmo.k11spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import di.AppConfiguration;
import di.AvengersInfo;
import di.AvengersVO;
import di.BMIInfoView;
import di.CalculatorDTO;

@Controller
public class DIController {

	
	//DI를 이용한 간단한 사칙연산 계산기 만들기
	@RequestMapping("/di/myCalculator")
	public String myCal(Model model) {
		
		/*
		ApplicationContext 파일의 위치를 문자열에 저장한다.
		물리적 경로는 아래와 같다
		/K11Spring/src/main/resources/DIAppCtxCalculator.xml
		***webapp 하위의 resources 디렉토리는 이미지나 JS파일등 리소스를
		저장하는 곳이므로 혼동하지 않도록 주의
		
		
		classpath: 라는 키워드를 통해 배포시 생기는 classes  위치에 접근할수있게 된다.
		 */
		String configLocation = 
				"classpath:DIAppCtxCalculator.xml";
		
		
		/*
		스프링 컨테이너 생성 : xml파일을 파싱하여 파싱된 내용을 기반으로 
		ctx 참조변수를 생성한다. 
		 */
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		
		/*
		xml설정파일에서 생성한 빈(bean)을 getBean()을 통해 주입받아 참조변수에 할당한다.
		new 연산자를 통해 생성한것과 동일하지만 외부 설정파일에서
		미리 생성한것을 주입(Injection)받은것임에 유의 할것.
		getBean(String name, Class<?>)
		*/
		CalculatorDTO myCal = 
				ctx.getBean("myCal", CalculatorDTO.class);
		
		/*
		주입받은 빈을 통해 사칙연산을 진행하고, 결과 값을 model객체에
		저장한다. 해당결과는 view로 전송한다.
		 */
		model.addAttribute("addResult", myCal.add());
		model.addAttribute("subResult", myCal.sub());
		model.addAttribute("mulResult", myCal.mul());
		model.addAttribute("divResult", myCal.div());
		
		return "04DI/myCalculator";
	}
	
	//체질량지수 계산하기
	@RequestMapping("/di/myBMICal")
	public String bmiCal(Model model) {
		
		//applicationContext파일 생성 및 경로 설정
		String configLoc = "classpath:DIAppCtxBMICal.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLoc);
		
		//위에서 생성된 객체를 통해 Bean을 주입받는다.
		/*
		사용법 : getBean("빈의 참조변수명", 빈생성시 사용된 클래스명.class);
		*/
		BMIInfoView myInfo = 
				ctx.getBean("myInfo", BMIInfoView.class);
		
		//지원해제는 안해도 크게 상관은 없다고 함
		ctx.close();
		
		//주입받은 빈을 통해 멤버메소드 호출 및 model 객체에 저장
		String myBMIResult = myInfo.getInfo();
		model.addAttribute("myBMIResult", myBMIResult);
		
		return "04DI/myBMICal";
	}

	
	//어벤저스
	@RequestMapping("/di/myAvengers")
	public ModelAndView myAvengers() {
		
		/*
		오브젝트(객체또는 빈)의 생성을 책임지는 오브젝트 팩토리에
		대응하는 것이 ApplicationContext이다. 다른 말로는
		IoC컨테이너, 스프링 컨테이너, BeanFactory로 부르기도 한다.
		즉, 빈에 대한 생성을 개발자가 하지 않고 Spring이 대신 해준다는 뜻이다.
		
		classpath 키워드는 Build Path 메뉴에서 확인 가능하다
		*/
		String configLocation = "classpath:DIAppCtxAvengers.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		
		
		
		
		
		
		AvengersInfo avengersInfo = null;
		
		//캡틴 빈을 주입받은 후 정보출력을 위해 문자열을 저장함
		avengersInfo = ctx.getBean("AvengersInfo1", AvengersInfo.class);
		String captainAmerica = avengersInfo.AvengersView();
		
		
		//아이언맨 빈을 주입받은 후 정보출력을 위해 setter를 호출함
		AvengersVO avengers = ctx.getBean("hero2", AvengersVO.class);
		avengersInfo.setAvengers(avengers);
		String ironMan = avengersInfo.AvengersView();
		
		//모델객체에 정보저장과 뷰에 대한 설정을 진행
		ModelAndView mv = new ModelAndView();
		mv.setViewName("04DI/myAvengers");
		mv.addObject("captainAmerica", captainAmerica);
		mv.addObject("ironMan", ironMan);

		ctx.close();
		
		return mv;
	}
	
	
	@RequestMapping("/di/myAnnotation")
	public ModelAndView myAnnotation() {
		
		
		
		/*
		
		 */
		//빈을 생성할 JAVA파일을 가져와서 스프링 컨테이너를 생성함
		AnnotationConfigApplicationContext aCtx = 
				new AnnotationConfigApplicationContext(
						AppConfiguration.class);
		
		//빈을 주입받음
		BMIInfoView mem1 = aCtx.getBean("member1", BMIInfoView.class);
		String str1 = "이름:"+mem1.getName()+"<br>";
		str1 += "취미:"+mem1.getHobbys()+"<br>";
		str1 += "신장:"+mem1.getHeight()+"<br>";
		str1 += "몸무게:"+mem1.getWeight()+"<br>";
		str1 += "BMI결과:"+mem1.bmiCalculation(); 
		/*
		xml파일을통해서 객체를 생성하는 것이 아니라 어노테이션을 통해서 생성했기 때문에 
		해당 클래스로 들어가보면...
		*/
		
		BMIInfoView mem2 = aCtx.getBean("member2", BMIInfoView.class);
		
		String str2 = "이름:"+mem2.getName()+"<br>";
		str2 += "취미:"+mem2.getHobbys()+"<br>";
		str2 += "신장:"+mem2.getHeight()+"<br>";
		str2 += "몸무게:"+mem2.getWeight()+"<br>";
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("04DI/myAnnotation");
		mv.addObject("memberInfo1", str1);
		mv.addObject("memberInfo2", str2);
		
		
		return mv;
	}
	
	
}





























