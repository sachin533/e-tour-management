package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.TourSchedule;

import java.time.LocalDate;
import java.util.List;

public interface TourScheduleService {

    TourSchedule saveTourSchedule(TourSchedule tourSchedule);

    List<TourSchedule> getAllTourSchedules();

    TourSchedule getTourScheduleById(Long id);

    TourSchedule updateTourSchedule(Long id, TourSchedule tourSchedule);

    void deleteTourSchedule(Long id);

    List<TourSchedule> getSchedulesByTourId(Long tourId);

    List<TourSchedule> getSchedulesByDepartureDate(LocalDate departureDate);
}