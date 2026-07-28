package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.TourImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourImageRepository extends JpaRepository<TourImage, Long> {

    List<TourImage> findByTourId(Long tourId);

}