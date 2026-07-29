package com.etour.etour_backend.service.impl;

import com.etour.etour_backend.entity.Tour;
import com.etour.etour_backend.entity.TourSchedule;
import com.etour.etour_backend.repository.TourRepository;
import com.etour.etour_backend.repository.TourScheduleRepository;
import com.etour.etour_backend.service.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {

    @Autowired
    private TourScheduleRepository tourScheduleRepository;

    @Autowired
    private TourRepository tourRepository;

    @Override
    public TourSchedule saveTourSchedule(TourSchedule tourSchedule) {

        Long tourId = tourSchedule.getTour().getId();

        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        tourSchedule.setTour(tour);

        return tourScheduleRepository.save(tourSchedule);
    }

    @Override
    public List<TourSchedule> getAllTourSchedules() {
        return tourScheduleRepository.findAll();
    }

    @Override
    public TourSchedule getTourScheduleById(Long id) {
        return tourScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour Schedule not found"));
    }

    @Override
    public TourSchedule updateTourSchedule(Long id, TourSchedule tourSchedule) {

        TourSchedule existingSchedule = getTourScheduleById(id);

        existingSchedule.setDepartureDate(tourSchedule.getDepartureDate());
        existingSchedule.setArrivalDate(tourSchedule.getArrivalDate());
        existingSchedule.setAvailableSeats(tourSchedule.getAvailableSeats());

        if (tourSchedule.getTour() != null) {

            Tour tour = tourRepository.findById(tourSchedule.getTour().getId())
                    .orElseThrow(() -> new RuntimeException("Tour not found"));

            existingSchedule.setTour(tour);
        }

        return tourScheduleRepository.save(existingSchedule);
    }

    @Override
    public void deleteTourSchedule(Long id) {

        TourSchedule schedule = getTourScheduleById(id);

        tourScheduleRepository.delete(schedule);
    }

    @Override
    public List<TourSchedule> getSchedulesByTourId(Long tourId) {

        return tourScheduleRepository.findByTourId(tourId);
    }

    @Override
    public List<TourSchedule> getSchedulesByDepartureDate(LocalDate departureDate) {

        return tourScheduleRepository.findByDepartureDate(departureDate);
    }
}