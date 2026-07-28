package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.PassengerPrice;
import com.etour.etour_backend.service.PassengerPriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger-prices")
public class PassengerPriceController {

    private final PassengerPriceService passengerPriceService;

    public PassengerPriceController(PassengerPriceService passengerPriceService) {
        this.passengerPriceService = passengerPriceService;
    }

    @PostMapping
    public PassengerPrice savePassengerPrice(@RequestBody PassengerPrice passengerPrice) {
        return passengerPriceService.savePassengerPrice(passengerPrice);
    }

    @GetMapping
    public List<PassengerPrice> getAllPassengerPrices() {
        return passengerPriceService.getAllPassengerPrices();
    }

    @GetMapping("/{id}")
    public PassengerPrice getPassengerPriceById(@PathVariable("id") Long id) {
        return passengerPriceService.getPassengerPriceById(id);
    }

    @PutMapping("/{id}")
    public PassengerPrice updatePassengerPrice(@PathVariable("id") Long id,
                                               @RequestBody PassengerPrice passengerPrice) {
        return passengerPriceService.updatePassengerPrice(id, passengerPrice);
    }

    @DeleteMapping("/{id}")
    public String deletePassengerPrice(@PathVariable("id") Long id) {

        passengerPriceService.deletePassengerPrice(id);

        return "Passenger Price deleted successfully.";
    }

    @GetMapping("/schedule/{tourScheduleId}")
    public List<PassengerPrice> getPassengerPricesByTourScheduleId(
            @PathVariable("tourScheduleId") Long tourScheduleId) {

        return passengerPriceService.getPassengerPricesByTourScheduleId(tourScheduleId);
    }
}