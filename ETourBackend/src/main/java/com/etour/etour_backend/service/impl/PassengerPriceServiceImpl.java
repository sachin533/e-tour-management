package com.etour.etour_backend.service.impl;

import com.etour.etour_backend.entity.PassengerPrice;
import com.etour.etour_backend.entity.TourSchedule;
import com.etour.etour_backend.repository.PassengerPriceRepository;
import com.etour.etour_backend.repository.TourScheduleRepository;
import com.etour.etour_backend.service.PassengerPriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerPriceServiceImpl implements PassengerPriceService {

    private final PassengerPriceRepository passengerPriceRepository;
    private final TourScheduleRepository tourScheduleRepository;

    public PassengerPriceServiceImpl(PassengerPriceRepository passengerPriceRepository,
                                     TourScheduleRepository tourScheduleRepository) {
        this.passengerPriceRepository = passengerPriceRepository;
        this.tourScheduleRepository = tourScheduleRepository;
    }

    @Override
    public PassengerPrice savePassengerPrice(PassengerPrice passengerPrice) {

        Long scheduleId = passengerPrice.getTourSchedule().getId();

        TourSchedule schedule = tourScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Tour Schedule not found"));

        passengerPrice.setTourSchedule(schedule);

        return passengerPriceRepository.save(passengerPrice);
    }

    @Override
    public List<PassengerPrice> getAllPassengerPrices() {
        return passengerPriceRepository.findAll();
    }

    @Override
    public PassengerPrice getPassengerPriceById(Long id) {

        return passengerPriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger Price not found"));
    }

    @Override
    public PassengerPrice updatePassengerPrice(Long id, PassengerPrice passengerPrice) {

        PassengerPrice existing = passengerPriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger Price not found"));

        Long scheduleId = passengerPrice.getTourSchedule().getId();

        TourSchedule schedule = tourScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Tour Schedule not found"));

        existing.setPassengerType(passengerPrice.getPassengerType());
        existing.setPrice(passengerPrice.getPrice());
        existing.setTourSchedule(schedule);

        return passengerPriceRepository.save(existing);
    }

    @Override
    public void deletePassengerPrice(Long id) {

        PassengerPrice existing = passengerPriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger Price not found"));

        passengerPriceRepository.delete(existing);
    }

    @Override
    public List<PassengerPrice> getPassengerPricesByTourScheduleId(Long tourScheduleId) {

        return passengerPriceRepository.findByTourScheduleId(tourScheduleId);
    }
}