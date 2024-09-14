package QLNVStrava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/activity")
public class StravaController {

    @Autowired
    private StravaService stravaService;

    @PostMapping("/create")
    public Mono<String> createActivity(
            @RequestParam String name,
            @RequestParam double distance,
            @RequestParam int elapsedTime,
            OAuth2AuthenticationToken authenticationToken) {

        // Lấy access token từ authentication
        String accessToken = authenticationToken.getPrincipal()
                .getAttribute("access_token").toString();

        // Gọi service để tạo hoạt động
        return stravaService.createActivity(accessToken, name, distance, elapsedTime);
    }
    
    @GetMapping("/list")
    public Mono<String> getActivities(OAuth2AuthenticationToken authenticationToken) {
        // Lấy access token từ authentication
        String accessToken = authenticationToken.getPrincipal()
                .getAttribute("access_token").toString();

        // Gọi service để lấy danh sách hoạt động
        return stravaService.getActivities(accessToken);
    }
}
