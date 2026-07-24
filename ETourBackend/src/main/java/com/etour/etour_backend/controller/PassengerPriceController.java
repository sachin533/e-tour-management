package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.PassengerPrice;
import com.etour.etour_backend.service.PassengerPriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger-prices")
public class PassengerPriceController {

    private final PassengerPriceService service;

    public PassengerPriceController(PassengerPriceService service) {
        this.service = service;
    }

    @GetMapping
    public List<PassengerPrice> getAllPassengerPrices() {
        return service.getAllPassengerPrices();
    }

    @PostMapping
    public PassengerPrice createPassengerPrice(@RequestBody PassengerPrice passengerPrice) {
        return service.savePassengerPrice(passengerPrice);
    }
}