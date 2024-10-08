package QLNVActivity;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableMongoRepositories(basePackages ="QLNVActivityAPI.repository")
@ComponentScan(basePackages = {"QLNVActivityAPI","QLNVActivityAPI.controller","QLNVActivityAPI.model","QLNVActivityAPI.repository","QLNVActivity.config"})

public class QlnvActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnvActivityApplication.class, args);
	}

}

