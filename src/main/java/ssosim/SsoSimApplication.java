package ssosim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SsoSimApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoSimApplication.class, args);
	}


}
