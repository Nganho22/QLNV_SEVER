package QLNVActivity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration
public class appConfig {

	@Bean
	@Primary
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public RestTemplate loadBalancedRestTemplate() {
	    return new RestTemplate();
	}

}
