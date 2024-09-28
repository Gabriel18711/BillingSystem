package com.example.BillingSystem.service;

import com.example.BillingSystem.config.AirtelApiConfig;
import com.example.BillingSystem.model.AirtelPaymentRequest;
import com.example.BillingSystem.model.AirtelPaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class AirtelPaymentService {

    private final AirtelApiConfig airtelApiConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public AirtelPaymentService(AirtelApiConfig airtelApiConfig, RestTemplate restTemplate) {
        this.airtelApiConfig = airtelApiConfig;
        this.restTemplate = restTemplate;
    }

    public String getAccessToken() {
        String url = airtelApiConfig.getBaseUrl() + "/auth/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(
                (airtelApiConfig.getClientId() + ":" + airtelApiConfig.getClientSecret()).getBytes()));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        // Extract and return the token from the response
        return response.getBody(); // handle token extraction
    }

    public AirtelPaymentResponse initiatePayment(AirtelPaymentRequest request) {
        String token = getAccessToken();
        String url = airtelApiConfig.getBaseUrl() + "/merchant/v1/payments/";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<AirtelPaymentRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<AirtelPaymentResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, AirtelPaymentResponse.class);
        return response.getBody(); // Handle and return payment response
    }
}
