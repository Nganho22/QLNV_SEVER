package QLNVStrava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class StravaService {

    private final WebClient webClient;

    public StravaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.strava.com/api/v3").build();
    }

    public Mono<String> createActivity(String accessToken, String name, double distance, int elapsedTime) {
        String startDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        return webClient.post()
                .uri("/activities")
                .header("Authorization", "Bearer " + accessToken)
                .bodyValue(
                        Map.of(
                            "name", name,
                            "type", "Run",
                            "start_date_local", startDate,
                            "elapsed_time", elapsedTime,
                            "distance", distance
                        ))
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.error(new RuntimeException("Failed to create activity", e)));
    }
    
    public Mono<String> getActivities(String accessToken) {
        return webClient.get()
                .uri("/activities") // Adjust URI if needed based on Strava API documentation
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.error(new RuntimeException("Failed to retrieve activities", e)));
    }
}