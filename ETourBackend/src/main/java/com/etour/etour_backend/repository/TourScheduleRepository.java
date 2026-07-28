package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TourScheduleRepository extends JpaRepository<TourSchedule, Long> {

    List<TourSchedule> findByTourId(Long tourId);

    List<TourSchedule> findByDepartureDate(LocalDate departureDate);

}