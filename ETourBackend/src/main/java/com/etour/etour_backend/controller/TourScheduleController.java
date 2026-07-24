package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.TourSchedule;
import com.etour.etour_backend.service.TourScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class TourScheduleController {

    private final TourScheduleService service;

    public TourScheduleController(TourScheduleService service) {
        this.service = service;
    }

    @GetMapping
    public List<TourSchedule> getAllSchedules() {
        return service.getAllSchedules();
    }

    @PostMapping
    public TourSchedule createSchedule(@RequestBody TourSchedule schedule) {
        return service.saveSchedule(schedule);
    }
}