package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.PassengerPrice;

import java.util.List;

public interface PassengerPriceService {

    PassengerPrice savePassengerPrice(PassengerPrice passengerPrice);

    List<PassengerPrice> getAllPassengerPrices();

    PassengerPrice getPassengerPriceById(Long id);

    PassengerPrice updatePassengerPrice(Long id, PassengerPrice passengerPrice);

    void deletePassengerPrice(Long id);

    List<PassengerPrice> getPassengerPricesByTourScheduleId(Long tourScheduleId);
}