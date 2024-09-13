package QLNVUrbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000); // Thay đổi giá trị này tùy theo nhu cầu
        factory.setReadTimeout(10000); // Thay đổi giá trị này tùy theo nhu cầu
        return new RestTemplate(factory);
    }

}
