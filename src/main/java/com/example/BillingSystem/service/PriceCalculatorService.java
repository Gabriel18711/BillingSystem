package com.example.BillingSystem.service;


import com.example.BillingSystem.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorService {

    public Double calculateTotalPrice(Booking booking) {
        return booking.calculatePrice();
    }
}
