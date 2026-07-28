package com.etour.etour_backend.controller;

import com.etour.etour_backend.entity.TourImage;
import com.etour.etour_backend.service.TourImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour-images")
public class TourImageController {

    private final TourImageService tourImageService;

    public TourImageController(TourImageService tourImageService) {
        this.tourImageService = tourImageService;
    }

    @PostMapping
    public TourImage saveTourImage(@RequestBody TourImage tourImage) {
        return tourImageService.saveTourImage(tourImage);
    }

    @GetMapping
    public List<TourImage> getAllTourImages() {
        return tourImageService.getAllTourImages();
    }

    @GetMapping("/{id}")
    public TourImage getTourImageById(@PathVariable("id") Long id) {
        return tourImageService.getTourImageById(id);
    }

    @PutMapping("/{id}")
    public TourImage updateTourImage(@PathVariable("id") Long id,
                                     @RequestBody TourImage tourImage) {
        return tourImageService.updateTourImage(id, tourImage);
    }

    @DeleteMapping("/{id}")
    public String deleteTourImage(@PathVariable("id") Long id) {

        tourImageService.deleteTourImage(id);

        return "Tour Image deleted successfully.";
    }

    @GetMapping("/tour/{tourId}")
    public List<TourImage> getTourImagesByTourId(@PathVariable("tourId") Long tourId) {
        return tourImageService.getTourImagesByTourId(tourId);
    }
}