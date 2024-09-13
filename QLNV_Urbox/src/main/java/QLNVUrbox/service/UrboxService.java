package QLNVUrbox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import QLNVUrbox.model.Voucher;
@Service
public class UrboxService {

    @Value("${urbox.api.url}")
    private String apiUrl;

    @Value("${urbox.api.access_key}")
    private String accessKey;

    private final RestTemplate restTemplate;

    public UrboxService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Lấy danh sách toàn bộ voucher từ UrBox API
    public Voucher[] getAllVouchers() {
        String url = apiUrl + "/gift/getlist";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("access_key", accessKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Voucher[]> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, Voucher[].class);

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return new Voucher[0];
        }
    }
}
