package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.Tour;
import com.etour.etour_backend.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tour> getAllTours() {
        return service.getAllTours();
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return service.saveTour(tour);
    }
}