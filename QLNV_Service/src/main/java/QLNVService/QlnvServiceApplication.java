package QLNVService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableMongoRepositories(basePackages ="QLNVServiceAPI.repository")
@ComponentScan(basePackages = {"QLNVServiceAPI","QLNVServiceAPI.controller","QLNVServiceAPI.model","QLNVServiceAPI.repository"})

public class QlnvServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnvServiceApplication.class, args);
	}

}
