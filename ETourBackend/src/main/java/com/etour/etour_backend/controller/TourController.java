package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.Tour;
import com.etour.etour_backend.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @PostMapping
    public Tour saveTour(@RequestBody Tour tour) {
        return tourService.saveTour(tour);
    }

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable("id") Long id) {
        return tourService.getTourById(id);
    }

    @PutMapping("/{id}")
    public Tour updateTour(@PathVariable("id") Long id,
                           @RequestBody Tour tour) {
        return tourService.updateTour(id, tour);
    }

    @DeleteMapping("/{id}")
    public String deleteTour(@PathVariable("id") Long id) {

        tourService.deleteTour(id);

        return "Tour deleted successfully.";
    }
}