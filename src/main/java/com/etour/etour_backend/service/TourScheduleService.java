package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.TourSchedule;
import com.etour.etour_backend.repository.TourScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourScheduleService {

    private final TourScheduleRepository repository;

    public TourScheduleService(TourScheduleRepository repository) {
        this.repository = repository;
    }

    public List<TourSchedule> getAllSchedules() {
        return repository.findAll();
    }

    public TourSchedule saveSchedule(TourSchedule schedule) {
        return repository.save(schedule);
    }
}