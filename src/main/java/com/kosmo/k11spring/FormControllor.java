package com.kosmo.k11spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.MemberDTO;
/***************
사용자의 요청을 제일 먼저 받는 DispatcherServlet은 기본패키지로 지정된
com.kosmo.k11spring을 스캔하여 컨트롤러 클래스를 찾는다. 그리고 해당 요청명에
매핑되는 메소드를 찾아 요청을 전달하고 비즈니스 로직을 수행한다.




@Controller
	: 해당 클래스를 컨트롤러로 사용하고 싶을때 클래스명 앞에 선언한다.
	패키지를 스캔할때 해당 어노테이션이 있는 클래스를 찾아서 요청을 전달한다.
	
@RequestMapping
	: 요청명을 매핑한다. 요청명은 서블릿과 마찬가지로 컨택스트루트를 제외한
	나머지 경로명으로 이루어진다. 요청명의 매핑정보로 메소드를 호출하게 되므로
	메소드명은 큰 의미가 없다. 개발자가 구분하기 좋은 정도의 메소드명으로 설정하면된다.

*/






@Controller
public class FormControllor {

	
	
	
	/*
	폼값받기1] 파라미터로 전달된 값을 HttpServletRequest객체를 
		통해서 받는다. JSP나 Servlet에 사용한 방법과 동일하다
	*/
	@RequestMapping("/form/servletRequest")
	public String loginMember(HttpServletRequest req, Model model) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		/*
		View영역에서 전송할 데이터를 Model객체(영역)에 저장한다.
		JSP에서 사용하는 영역과 동일하다 생각하면 된다.
		*/
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("message", "로그인 정보가 전달되었습니다");
		
		
		
		/*
	 	View페이지명을 반환한다. 아래처럼 문자열 형태로 경로를 반환하면
	 	ViewResolver가 경로를 조립하여 해당 View를
	 	웹브라우저에 출력하게 된다.
	 	(설정파일: servlet-context.xml)
		*/
		return "01Form/servletRequest";
	}
	
	/*
	폼값받기2] @RequestParam 어노테이션으로 폼값받기
		파라미터 형식으로 아래와 같이 사용한다. 이와 같이 하면
		해당 메소드내에서 변수명을 그대로 사용할 수 있다.
	*/
	@RequestMapping("/form/requestParam.do")
	public String joinMember(Model model, 
			@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("email") String email
			) {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setEmail(email);
		memberDTO.setName(name);
		
		model.addAttribute("memberDTO", memberDTO);
		
		return "01Form/requestParam";
	}
	
	
	
	/*
	폼값받기3]커멘드객체를 이용해서 폼값 한번에 받기
	조건1) 쿼리스트링으로 전달되는 파라미터의 갯수와 폼값을 저장할 객체(DTO또는 VO의 멤버변수의
	갯수가 ㅏ동일할때 사용가능함
	조건2) 커멘드객체를 사용할때는 클래스명 앞글자를 소문자로 바꾼 형태의 매개변수를
	사용해야한다.(규칙이다
	조건3\ 커맨드객체를 만들때 파라미터의 갯수는 달라도 상관없으나 파라미터의 이름과 멤버변수의 미름을 반드시 동일
	학 해야하고 이에 해당하는 getter/ setter 가 생서되어야 한다. 
	
	***커맨드객체의 이름을 변경해서 View로 전달하고 싶다면 
	*@ModelAttribute 어노테이션을 사용하면된다. (뒤에서 학습예정)
	 
 
	command객체를 사용할때는 참조변수명에 규칙이있는데 
	이름을 똑같이 하되 앞글자만 소문자로 하는 커멜케이스 형식으로 한다.
	예)MemberDTO memberDTO
	 */
	@RequestMapping("/form/commandObjGet.do")
	public String commandObjGet(MemberDTO memberDTO) {
		
		
		return "01Form/commandObjGet";
	}
	
	
	/*
	폼값받기4] PathVariable 어노테이션으로 폼값받기
		요청명 ./form 뒤에 붙은 값이 메소드에서 사용가능한 파라미터가 된다.
		아래의 경우 2개의 ㅓ파라미터를 받아서 사용하게 된다.
		단 웹브라우저는 요청명을 경로로 인식하므로 리소스(이미지 등)를 
		사용할 때는 경로에 주의해야한다.
		파라미터의 객수가 틀릴경우 404에러가 뜬다.
		
		
		컨테스트루트 바로하위에 resources폴더가 있다라고 가정을하면 이해하기 슆다
	 */
	
	@RequestMapping("/form/{memberId}/{memberName}")
	public String pathVariable(Model model,
			@PathVariable String memberId,
			@PathVariable String memberName) {
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberName", memberName);
		
		return "01Form/pathVariable";
	}
	
	
	
}




















