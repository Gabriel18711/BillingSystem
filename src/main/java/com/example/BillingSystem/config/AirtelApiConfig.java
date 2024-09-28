package com.example.BillingSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced; // Optional: if using load balancing

@Configuration
public class AirtelApiConfig {

    @Value("${airtel.api.base-url}")
    private String baseUrl;

    @Value("${airtel.api.client-id}")
    private String clientId;

    @Value("${airtel.api.client-secret}")
    private String clientSecret;

    @Value("${airtel.api.api-key}")
    private String apiKey;

    // Getters for configuration properties
    public String getBaseUrl() {
        return baseUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    // RestTemplate bean definition
    @Bean
    @LoadBalanced  // Optional: only if using service discovery/load balancing
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
