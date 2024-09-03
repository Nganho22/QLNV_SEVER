package QLNVProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "QLNVProfileAPI.repository")
@EntityScan(basePackages = "QLNVProfileAPI.model")
@ComponentScan(basePackages = {"QLNVProfileAPI", "QLNVProfileAPI.controller", "QLNVProfileAPI.service"})
public class QlnvProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlnvProfileApplication.class, args);
    }

}
