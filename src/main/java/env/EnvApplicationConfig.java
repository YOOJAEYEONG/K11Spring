package env;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
XML설정파일의 역할을 대신하는 클래스로 선언함
*/
@Configuration
public class EnvApplicationConfig {
	
	
	/*
	@Value : 멤버변수 초기값을 어노테이션으로 정의한다.
	*/
	@Value("${board1.user}")
	private String board_user;
	
	@Value("${board1.pass}")
	private String board_pass;
	
	@Value("${board2.driver}")
	private String board_driver;
	
	@Value("${board2.url}")
	private String board_url;
	

	/*
	외부파일의 경로설정 및 읽어오기
	application 실행시 static 메소드가 가장 먼저 실행되므로 
	EnvBoard1.properties 의 위치를 읽어온다.
	그 다음 멤버변수를 초기화 할수 있게된다.
	static이 아니면 출력되는 값이 없다.
	*/
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		
		//1.프로퍼티 파일을 읽어오기위한 객체생성
		PropertySourcesPlaceholderConfigurer config = 
				new PropertySourcesPlaceholderConfigurer();
		
		
		//2.프로퍼티 파일의 위치를 설정하기위한 Resource타입의 객체배열 생성
		Resource[] locations = new Resource[2];
		
		// "classpath:설정파일.xml"과 동일한 설정임.
		locations[0] = new ClassPathResource("EnvBoard1.properties");
		locations[1] = new ClassPathResource("EnvBoard2.properties");
		
		
		/*
		3.설정된 위치의 config 참조변수의 매개변수로 파일을 읽어옴
		*/
		config.setLocations(locations);
		
		return config;
	}
	
	
	
	/*
	프로퍼티 소스를 통해 읽어온 값으로 빈을 생성함
	*/
	@Bean
	public BoardConnection boardConfig() {
		System.out.println("board_driver:   "+board_driver);
		//DTO객체를 생성하고 setter()를 통해 초기값을 설정함
		BoardConnection bconn = new BoardConnection();
		bconn.setUser(board_user);
		bconn.setPass(board_pass);
		bconn.setDriver(board_driver);
		bconn.setUrl(board_url);
		
		return bconn;
	}
}






















