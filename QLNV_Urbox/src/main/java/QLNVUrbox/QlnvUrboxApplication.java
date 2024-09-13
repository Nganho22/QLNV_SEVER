package QLNVUrbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "QLNVUrbox.repository")
@EntityScan(basePackages = "QLNVUrbox.model")
@ComponentScan(basePackages = {"QLNVUrbox", "QLNVUrbox.controller", "QLNVUrbox.service","QLNVUrbox.config"})
public class QlnvUrboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnvUrboxApplication.class, args);
	}

}
