package QLNVUrbox.service;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import QLNVUrbox.model.Voucher;

import java.util.Arrays;
import java.util.List;
import QLNVUrbox.config.AppConfig;
@Service
public class UrboxService {

    @Value("${urbox.api.url}")
    private String apiUrl;

    @Value("${urbox.api.access_key}")
    private String accessKey;

    private final RestTemplate restTemplate;

    public UrboxService() {
        // Configure HttpClient with timeouts
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(50);
        connectionManager.setDefaultMaxPerRoute(5);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)    // Connection timeout
                .setSocketTimeout(5000)     // Socket timeout
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        this.restTemplate = new RestTemplate(factory);
    }

    public List<Voucher> getVoucherFromUrbox() {
        String url = "https://devapi.urbox.vn/2.0/gift/getlist";
        HttpHeaders headers = new HttpHeaders();
        headers.set("access_urbox", accessKey);
        headers.set("agent_site", "10");
        headers.set("coupon", "APICODE");
        headers.set("brand_id", "999999");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Voucher[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Voucher[].class);
            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            // Handle error
            System.err.println("Error fetching vouchers: " + e.getMessage());
            e.printStackTrace();
            return Arrays.asList(); // Return empty list or handle it accordingly
        }
    }
}
