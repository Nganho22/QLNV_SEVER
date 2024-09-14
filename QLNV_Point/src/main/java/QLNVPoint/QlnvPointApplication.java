package QLNVPoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "QLNVPointAPI.repository")
@EntityScan(basePackages = "QLNVPointAPI.model")
@ComponentScan(basePackages = {"QLNVPointAPI", "QLNVPointAPI.controller", "QLNVPointAPI.service"})
public class QlnvPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnvPointApplication.class, args);
	}

}
