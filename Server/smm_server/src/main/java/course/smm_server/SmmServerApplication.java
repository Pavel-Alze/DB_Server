package course.smm_server;

import course.smm_server.models.User;
import course.smm_server.service.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmmServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmmServerApplication.class, args);
		Integer integer = 1;
		System.out.println("TEST_SERVER"+integer);

	}

}
