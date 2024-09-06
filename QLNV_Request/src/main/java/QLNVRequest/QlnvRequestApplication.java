package QLNVRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "QLNVRequestAPI.repository")
@EntityScan(basePackages = "QLNVRequestAPI.model")
@ComponentScan(basePackages = {"QLNVRequestAPI", "QLNVRequestAPI.controller", "QLNVRequestAPI.service"})
public class QlnvRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnvRequestApplication.class, args);
	}

}