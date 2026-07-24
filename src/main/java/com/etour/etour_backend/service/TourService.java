package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.Tour;
import com.etour.etour_backend.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    private final TourRepository repository;

    public TourService(TourRepository repository) {
        this.repository = repository;
    }

    public List<Tour> getAllTours() {
        return repository.findAll();
    }

    public Tour saveTour(Tour tour) {
        return repository.save(tour);
    }
}