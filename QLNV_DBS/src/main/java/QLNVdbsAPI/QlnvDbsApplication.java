package QLNVdbsAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableMongoRepositories(basePackages ="QLNVdbsAPI.repository")
@ComponentScan(basePackages = {"QLNVdbsAPI","QLNVdbsAPI.controller","QLNVdbsAPI.model","QLNVdbsAPI.repository"})
public class QlnvDbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnvDbsApplication.class, args);
	}

}
