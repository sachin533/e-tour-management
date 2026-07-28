package com.etour.etour_backend.service.impl;

import com.etour.etour_backend.entity.Tour;
import com.etour.etour_backend.entity.TourImage;
import com.etour.etour_backend.repository.TourImageRepository;
import com.etour.etour_backend.repository.TourRepository;
import com.etour.etour_backend.service.TourImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourImageServiceImpl implements TourImageService {

    private final TourImageRepository tourImageRepository;
    private final TourRepository tourRepository;

    public TourImageServiceImpl(TourImageRepository tourImageRepository,
                                TourRepository tourRepository) {
        this.tourImageRepository = tourImageRepository;
        this.tourRepository = tourRepository;
    }

    @Override
    public TourImage saveTourImage(TourImage tourImage) {

        Long tourId = tourImage.getTour().getId();

        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        tourImage.setTour(tour);

        return tourImageRepository.save(tourImage);
    }

    @Override
    public List<TourImage> getAllTourImages() {
        return tourImageRepository.findAll();
    }

    @Override
    public TourImage getTourImageById(Long id) {

        return tourImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour Image not found"));
    }

    @Override
    public TourImage updateTourImage(Long id, TourImage tourImage) {

        TourImage existing = tourImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour Image not found"));

        Long tourId = tourImage.getTour().getId();

        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        existing.setImageUrl(tourImage.getImageUrl());
        existing.setTour(tour);

        return tourImageRepository.save(existing);
    }

    @Override
    public void deleteTourImage(Long id) {

        TourImage existing = tourImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour Image not found"));

        tourImageRepository.delete(existing);
    }

    @Override
    public List<TourImage> getTourImagesByTourId(Long tourId) {
        return tourImageRepository.findByTourId(tourId);
    }
}