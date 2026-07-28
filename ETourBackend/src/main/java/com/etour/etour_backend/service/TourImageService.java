package com.etour.etour_backend.service;

import com.etour.etour_backend.entity.TourImage;

import java.util.List;

public interface TourImageService {

    TourImage saveTourImage(TourImage tourImage);

    List<TourImage> getAllTourImages();

    TourImage getTourImageById(Long id);

    TourImage updateTourImage(Long id, TourImage tourImage);

    void deleteTourImage(Long id);

    List<TourImage> getTourImagesByTourId(Long tourId);
}