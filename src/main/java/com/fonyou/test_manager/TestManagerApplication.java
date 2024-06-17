package com.fonyou.test_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fonyou.test_manager.repository")
public class TestManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestManagerApplication.class, args);
	}

}
