package com.etour.etour_backend.service.impl;

import com.etour.etour_backend.entity.Category;
import com.etour.etour_backend.entity.Tour;
import com.etour.etour_backend.repository.CategoryRepository;
import com.etour.etour_backend.repository.TourRepository;
import com.etour.etour_backend.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Tour saveTour(Tour tour) {

        Category category = categoryRepository.findById(tour.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        tour.setCategory(category);

        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
    }

    @Override
    public Tour updateTour(Long id, Tour tour) {

        Tour existingTour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        existingTour.setTourName(tour.getTourName());
        existingTour.setDestination(tour.getDestination());
        existingTour.setPrice(tour.getPrice());

        Category category = categoryRepository.findById(tour.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingTour.setCategory(category);

        return tourRepository.save(existingTour);
    }

    @Override
    public void deleteTour(Long id) {

        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        tourRepository.delete(tour);
    }
}