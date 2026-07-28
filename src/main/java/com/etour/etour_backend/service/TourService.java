package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.Tour;

import java.util.List;

public interface TourService {

    Tour saveTour(Tour tour);

    List<Tour> getAllTours();

    Tour getTourById(Long id);

    Tour updateTour(Long id, Tour tour);

    void deleteTour(Long id);
}