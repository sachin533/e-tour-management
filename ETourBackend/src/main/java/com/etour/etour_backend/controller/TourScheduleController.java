package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.TourSchedule;
import com.etour.etour_backend.service.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tour-schedules")
public class TourScheduleController {

    @Autowired
    private TourScheduleService tourScheduleService;

    @PostMapping
    public TourSchedule saveTourSchedule(@RequestBody TourSchedule tourSchedule) {

        return tourScheduleService.saveTourSchedule(tourSchedule);
    }

    @GetMapping
    public List<TourSchedule> getAllTourSchedules() {

        return tourScheduleService.getAllTourSchedules();
    }

    @GetMapping("/{id}")
    public TourSchedule getTourScheduleById(@PathVariable("id") Long id) {

        return tourScheduleService.getTourScheduleById(id);
    }

    @PutMapping("/{id}")
    public TourSchedule updateTourSchedule(
            @PathVariable("id") Long id,
            @RequestBody TourSchedule tourSchedule) {

        return tourScheduleService.updateTourSchedule(id, tourSchedule);
    }

    @DeleteMapping("/{id}")
    public String deleteTourSchedule(@PathVariable("id") Long id) {

        tourScheduleService.deleteTourSchedule(id);

        return "Tour Schedule deleted successfully.";
    }

    @GetMapping("/tour/{tourId}")
    public List<TourSchedule> getSchedulesByTourId(
            @PathVariable("tourId") Long tourId) {

        return tourScheduleService.getSchedulesByTourId(tourId);
    }

    @GetMapping("/departure")
    public List<TourSchedule> getSchedulesByDepartureDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate departureDate) {

        return tourScheduleService.getSchedulesByDepartureDate(departureDate);
    }
}