package com.example.BillingSystem.controller;


import com.example.BillingSystem.model.AirtelPaymentRequest;
import com.example.BillingSystem.model.AirtelPaymentResponse;
import com.example.BillingSystem.service.AirtelPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentWebhookController {

    @Autowired
    private AirtelPaymentService airtelPaymentService;

    @PostMapping("/airtel/initiate")
    public ResponseEntity<AirtelPaymentResponse> initiatePayment(@RequestBody AirtelPaymentRequest request) {
        AirtelPaymentResponse response = airtelPaymentService.initiatePayment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/airtel/callback")
    public ResponseEntity<Void> handlePaymentCallback(@RequestBody String callbackData) {
        // Handle callback from Airtel
        System.out.println("Callback received: " + callbackData);
        return ResponseEntity.ok().build();
    }
}
