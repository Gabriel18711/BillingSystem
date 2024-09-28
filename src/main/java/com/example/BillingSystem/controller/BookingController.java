package com.example.BillingSystem.controller;

import com.example.BillingSystem.model.Booking;
import com.example.BillingSystem.service.PriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private PriceCalculatorService priceCalculatorService;

    @PostMapping("/calculate-price")
    public ResponseEntity<Double> calculatePrice(@RequestBody Booking booking) {
        Double totalPrice = priceCalculatorService.calculateTotalPrice(booking);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }
}

