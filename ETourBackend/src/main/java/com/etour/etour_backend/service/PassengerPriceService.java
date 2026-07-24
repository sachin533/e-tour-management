package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.PassengerPrice;
import com.etour.etour_backend.repository.PassengerPriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerPriceService {

    private final PassengerPriceRepository repository;

    public PassengerPriceService(PassengerPriceRepository repository) {
        this.repository = repository;
    }

    public List<PassengerPrice> getAllPassengerPrices() {
        return repository.findAll();
    }

    public PassengerPrice savePassengerPrice(PassengerPrice passengerPrice) {
        return repository.save(passengerPrice);
    }
}