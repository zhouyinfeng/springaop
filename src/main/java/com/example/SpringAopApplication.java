package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringAopApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}
}

/*@RestController
class TestController {

	class User {
		private String username;
		private String age;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public User(String username, String age) {
			this.username = username;
			this.age = age;
		}
	}
	@GetMapping("hello")
	public User user() {
		return new User("java", "11");
	}

}*/


